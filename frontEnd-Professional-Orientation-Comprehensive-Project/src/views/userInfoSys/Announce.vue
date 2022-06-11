<template>
  <div class="back">
    <vue-particles
      class="user-bg"
      color="#fff"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#fff"
      :linesWidth="2"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="2"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    ></vue-particles>

    <div
      style="
        padding-top: 100px;
        padding-left: 20px;
        padding-right: 20px;
        border-radius: 10px;
      "
    >
      <div
        style="
          text-align: left;
          padding-left: 20px;
          font-size: 36px;
          font-weight: 600;
        "
      >
        全站公告
      </div>
      <el-divider></el-divider>

      <el-card class="my-page">
        <el-collapse
          class="my-page1"
          v-model="activeName"
          v-for="item in AnnList.slice(
            (currentPage - 1) * pagesize,
            currentPage * pagesize
          )"
          :key="item.announceId"
          accordion
        >
          <el-collapse-item :name="item.id">
            <template slot="title">
              <div style="text-align: center; font-size: 16px">
                {{ item.createTime }}
              </div>

              <div
                style="text-align: center; font-size: 16px; margin-left: 20%"
              >
                {{ item.title }}
              </div>
            </template>
            <div>
              {{ item.content }}
            </div>
          </el-collapse-item>
        </el-collapse>

        <el-pagination
          layout="total, prev, pager, next, jumper"
          :total="AnnList.length"
          class="pig"
          @current-change="handleCurrentChange"
          float="buttom"
        >
        </el-pagination>
      </el-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      activeName: "0",

      AnnList: [
        {
          announceId: 0,
          createTime: "2022-02-01",
          title: "hi",

          content: "hiiii",
        },
        {
          announceId: 1,
          createTime: "2022-02-01",
          title: "hi2",
          content: "hiiii",
        },
      ],

      pagesize: 8,
      currentPage: 1,

      user: {
        userName: "熊祯琪",
        userId: 1,
      },
    };
  },

  methods: {
    handleCurrentChange: function (currentPage) {
      this.currentPage = currentPage;
    },
    isRead() {},
    getAnnList() {
      axios
        .get("http://localhost:9001/announce/getAnnList", {
          params: {},
          crossDomain: true,
        })
        .then((response) => {
          console.log("getAnnList", response);
          this.AnnList = response.data;
          for (var i = 0; i < this.AnnList.length; i++) {
            this.AnnList[i].createTime = this.AnnList[i].createTime.slice(
              0,
              this.AnnList[i].createTime.indexOf(".")
            );
            this.AnnList[i].createTime = this.AnnList[i].createTime.replace(
              "T",
              " "
            );
          }
        })
        .catch(function () {});
    },
  },
  mounted() {
    this.user.userId = sessionStorage.getItem("userId");
    this.getAnnList();
  },
};
</script>

<style scoped>
.back {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
}
.user-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
  background: url("../../assets/bg.jpeg");
}
.divider {
  position: relative;
  margin: 10px auto;
  width: auto;
  height: 1px;
  background-color: #d4d4d4;
  text-align: center;
  font-size: 16px;
  color: #475669;
}

.album-slide {
  float: left;
  width: 100%;
  text-align: center;
}

.to-do {
  margin-top: -125px;
  margin-left: 20px;
  margin-right: 20px;
  background: rgba(255, 255, 255, 0);
}

.my-page {
  margin-top: 10px;
  margin-left: 20px;
  margin-right: 20px;
  border: 10px solid rgba(255, 250, 250, 0);
  background: rgb(255, 250, 250, 0.5);
}
.my-page1 {
  margin-left: 20px;
  margin-right: 20px;
  border: 10px solid rgba(255, 250, 250, 0);
  background: rgb(255, 250, 250, 0.5);
}

.dialog {
  border: 5px solid rgba(255, 250, 250, 0);
}
</style>
