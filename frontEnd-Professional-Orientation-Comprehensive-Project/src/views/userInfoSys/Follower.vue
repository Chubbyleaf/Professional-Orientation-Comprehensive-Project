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
    <el-container class="user-info">
      <el-main>
        <div
          style="
            padding-top: 200px;
            background-color: rgba(237, 240, 243, 0.37);
            border-radius: 10px;
          "
        >
          <el-col class="album-slide">
            <el-row>
              <el-col class="album-img" :span="12">
                <img
                  :src="this.user.avatarUrl"
                  style="cursor: pointer; width: 100%"
                />
              </el-col>
              <el-col :span="6">
                <el-card class="to-do">
                  <div
                    style="
                      text-align: center;
                      font-size: 20px;
                      font-weight: 600;
                    "
                  >
                    {{ this.user.userName }}的粉丝
                  </div>
                </el-card>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="24">
                <el-card class="my-page">
                  <el-row>
                    <el-col
                      :span="6"
                      v-for="item in myFollower"
                      :key="item.myFollowerId"
                      style="margin: 1.5%"
                    >
                      <el-card color="#385F73" dark>
                        <el-container>
                          <el-aside width="40%">
                            <el-link :underline="false">
                              <img
                                :src="item.myFollowerAvatar"
                                class="card-image"
                                @click="toUser(item)"
                            /></el-link>
                          </el-aside>
                          <el-main>
                            <div>
                              <el-link @click="toUser(item)" class="title-font"
                                >{{ item.myFollowerName }}
                              </el-link>

                              <div>
                                <br />
                                <br />
                                <el-row>
                                  <el-col :span="12"
                                    ><time
                                      >歌单：{{
                                        item.myFollowerCollectionNum
                                      }}</time
                                    > </el-col
                                  ><el-col :span="12"
                                    ><time
                                      >粉丝：{{
                                        item.myFollowerFollowerNum
                                      }}</time
                                    ></el-col
                                  >
                                </el-row>
                              </div>
                            </div>
                          </el-main>
                        </el-container>
                      </el-card>
                    </el-col>
                  </el-row>
                </el-card>
              </el-col>
            </el-row>
          </el-col>
        </div>
      </el-main>
    </el-container>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      isOneself: false,
      formLabelWidth: "80px",

      user: {
        userName: "熊祯琪",
        userId: 1,
        avatarUrl: require("../../assets/avatar.jpg"),
      },
      myFollower: [
        {
          myFollowerId: 1,
          myFollowerAvatar: require("../../assets/1.jpg"),
          myFollowerName: "name",
        },
        {
          myFollowerId: 2,
          myFollowerAvatar: require("../../assets/1.jpg"),
          myFollowerName: "name",
        },
        {
          myFollowerId: 3,
          myFollowerAvatar: require("../../assets/1.jpg"),
          myFollowerName: "name",
        },
      ],
    };
  },

  methods: {
    getParams: function () {
      this.user.userName = this.$route.query.name;
      this.user.userId = this.$route.query.id;
      this.user.avatarUrl = this.$route.query.url;
    },
    toUser(row) {
      this.$router.push({
        path: "/user",
        query: {
          userId: row.myFollowerId,
        },
      });
    },
    getFollower() {
      //获取关注或粉丝
      axios
        .get("/api/user/myFollower", {
          params: { userId: this.user.userId },
          crossDomain: true,
        })
        .then((response) => {
          console.log("getFollower", response);
          this.myFollower = response.data;
        })
        .catch(function () {});
    },
  },
  mounted() {
    this.getParams();
    this.getFollower();
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
}

.album-img {
  height: 200px;
  width: 200px;
  display: inline-block;
  position: relative;
  top: -150px;
  margin-left: 30px;
  border-radius: 50%;
  overflow: hidden;
  border: 5px solid white;
}

.user-info {
  background: rgba(255, 255, 255, 0);
  text-align: center;
  margin: 10px;
  padding: 10px;
  border-radius: 8px;
}

.to-do {
  margin: -150px 20px 20px;
  background: rgba(255, 255, 255, 0);
}

.my-page {
  margin-top: -125px;
  border: 5px solid rgba(255, 250, 250, 0);
  background: rgba(255, 250, 250, 0);
}

.my-info {
  background: rgba(255, 250, 250, 0.5);
  margin-top: -125px;
  margin-left: 20px;
  padding: 10px;
}

.tableText {
  text-align: left;
  font-weight: bold;
  font-size: 15px;
}

::v-deep.el-upload el-upload--picture-card {
  alignment: center;
}

.time-font {
  font-size: 13px;
  color: #999;
}

.title-font {
  font-size: 20px;
  color: black;
}

.card-image {
  margin-top: 22%;
  height: 120px;
  width: 120px;
  border-radius: 50%;
  box-shadow: 0px 0px 3px #888888;
}
</style>
