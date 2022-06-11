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

    <div style="padding-top: 230px; border-radius: 10px">
      <el-card class="to-do">
        <div style="text-align: center; font-size: 20px; font-weight: 600">
          消息列表
        </div>
      </el-card>

      <el-card class="my-page">
        <el-tabs v-model="message" @tab-click="handleClick">
          <el-tab-pane
            :label="`未读消息(${messageList.unread.length})`"
            name="first"
          >
            <el-table
              :data="
                messageList.unread.slice(
                  (currentPageFirst - 1) * pagesize,
                  currentPageFirst * pagesize
                )
              "
              :show-header="false"
              style="width: 100%"
            >
              <el-table-column>
                <template #default="scope">
                  <span class="message-title"
                    >【{{ scope.row.title }}】 {{ scope.row.content }}</span
                  >
                </template>
              </el-table-column>
              <el-table-column prop="date" width="180"></el-table-column>
              <el-table-column width="120">
                <template #default="scope">
                  <el-button size="small" @click="handleRead(scope.row)"
                    >标为已读</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </el-tab-pane>
          <el-pagination
            v-if="name == 'first'"
            layout="total, prev, pager, next, jumper"
            :total="messageList.unread.length"
            class="pig"
            @current-change="handleCurrentChangeFirst"
            :current-page="currentPageFirst"
            float="buttom"
          >
          </el-pagination>
          <el-tab-pane
            :label="`已读消息(${messageList.read.length})`"
            name="second"
          >
            <el-table
              :data="
                messageList.read.slice(
                  (currentPageSecond - 1) * pagesize,
                  currentPageSecond * pagesize
                )
              "
              :show-header="false"
              style="width: 100%"
            >
              <el-table-column>
                <template #default="scope">
                  <span class="message-title"
                    >【{{ scope.row.title }}】 {{ scope.row.content }}</span
                  >
                </template>
              </el-table-column>
              <el-table-column prop="date" width="150"></el-table-column>
              <el-table-column width="120">
                <template #default="scope">
                  <el-button type="danger" @click="handleToRecycle(scope.row)"
                    >删除</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </el-tab-pane>
          <el-pagination
            v-if="name == 'second'"
            layout="total, prev, pager, next, jumper"
            :total="messageList.read.length"
            class="pig"
            @current-change="handleCurrentChangeSecond"
            float="buttom"
          >
          </el-pagination>
          <el-tab-pane
            :label="`回收站(${messageList.recycle.length})`"
            name="third"
          >
            <el-table
              :data="
                messageList.recycle.slice(
                  (currentPageThird - 1) * pagesize,
                  currentPageThird * pagesize
                )
              "
              :show-header="false"
              style="width: 100%"
            >
              <el-table-column>
                <template #default="scope">
                  <span class="message-title"
                    >【{{ scope.row.title }}】 {{ scope.row.content }}</span
                  >
                </template>
              </el-table-column>
              <el-table-column prop="date" width="150"></el-table-column>
              <el-table-column width="240">
                <template #default="scope">
                  <el-button @click="handleRestore(scope.row)">还原</el-button>
                  <el-button type="danger" @click="handleToDel(scope.row)"
                    >彻底删除</el-button
                  >
                </template>
              </el-table-column>
            </el-table>
          </el-tab-pane>
          <el-pagination
            v-if="name == 'third'"
            layout="total, prev, pager, next, jumper"
            :total="messageList.recycle.length"
            class="pig"
            @current-change="handleCurrentChangeThird"
            float="buttom"
          >
          </el-pagination>
        </el-tabs>
      </el-card>
    </div>
  </div>
</template>

<script>
import axios from "axios";

export default {
  data() {
    return {
      pagesize: 10,
      currentPageFirst: 1,
      currentPageSecond: 1,
      currentPageThird: 1,
      name: "first",
      title: "",
      content: "",
      dialogVisible: false,
      message: "first",
      user: {
        userName: "熊祯琪",
        userId: 1,
      },
      messageList: {
        unread: [
          {
            id: 1,
            title: "科普即将中期考核",
            content: "大家注意时间",
            createTime: "2020-12-01",
          },
          {
            id: 2,
            title: "科普即将期末考核",
            content: "大家注意时间！！",
            createTime: "2020-12-01",
          },
        ],
        read: [
          {
            id: 3,
            title: "【系统通知】该系统将于今晚凌晨2点到5点进行升级维护",
            content: "大家注意时间",
            createTime: "2020-12-01",
          },
        ],
        recycle: [
          {
            id: 4,
            title: "【系统通知】该系统将于今晚凌晨3点到5点进行升级维护",
            content: "晚安",
            createTime: "2020-12-01",
          },
        ],
      },
    };
  },

  methods: {
    handleCurrentChangeFirst: function (currentPage) {
      this.currentPageFirst = currentPage;
    },
    handleClick(tab, event) {
      console.log("handleClick");
      console.log(tab.name, event);
      this.name = tab.name;
    },
    handleTitle(data) {
      this.dialogVisible = true;
      this.title = data.title;
      this.content = data.content;
    },

    getMessage() {
      axios
        .get("http://localhost:9001/message/myMessageList", {
          params: { userId: sessionStorage.getItem("userId") },
          crossDomain: true,
        })
        .then((response) => {
          console.log("getMessage", response);
          this.messageList.unread = [];
          this.messageList.read = [];
          this.messageList.recycle = [];
          var list = response.data.data;

          for (let i = 0; i < list.length; i++) {
            list[i].createTime = list[i].createTime.slice(
              0,
              list[i].createTime.indexOf(".")
            );
            list[i].createTime = list[i].createTime.replace("T", " ");

            if (list[i].isRead == "0") {
              //未读消息
              this.messageList.unread.push(list[i]);
            } else if (list[i].isRead == "1") {
              //已读消息
              this.messageList.read.push(list[i]);
            } else if (list[i].isRead == "-1") {
              //回收站
              this.messageList.recycle.push(list[i]);
            }
          }
        })
        .catch(function () {});
      //console.log("this.messageList", this.messageList);
    },
    //标为已读
    handleRead(row) {
      //const item = this.messageList.unread.splice(index, 1);
      console.log("handleRead", row);
      axios
        .get("http://localhost:9001/message/changeMsgState", {
          params: { msgId: row.messageId, state: 1 },
          crossDomain: true,
        })
        .then((response) => {
          console.log("handleRead", response);
          if (response.data.code == 200) this.getMessage();
          else this.$message.warning(response.data.message);
        })
        .catch(function () {});
    },
    handleToRecycle(item) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.toRecycle(item);
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消删除操作",
          });
        });
    },
    toRecycle(row) {
      //const item = this.messageList.unread.splice(index, 1);
      console.log("handleRead", row);
      axios
        .get("http://localhost:9001/message/changeMsgState", {
          params: { msgId: row.messageId, state: -1 },
          crossDomain: true,
        })
        .then((response) => {
          console.log("toRecycle", response);
          if (response.data.code == 200) this.getMessage();
          else this.$message.warning(response.data.message);
        })
        .catch(function () {});
    },
    handleRestore(row) {
      //const item = this.messageList.unread.splice(index, 1);
      console.log("handleRead", row);
      axios
        .get("http://localhost:9001/message/changeMsgState", {
          params: { msgId: row.messageId, state: 1 },
          crossDomain: true,
        })
        .then((response) => {
          console.log("handleRestore", response);
          if (response.data.code == 200) this.getMessage();
          else this.$message.warning(response.data.message);
        })
        .catch(function () {});
    },
    handleToDel(item) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.toDel(item);
          this.$message.success("删除成功");
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消删除操作",
          });
        });
    },
    toDel(row) {
      //const item = this.messageList.unread.splice(index, 1);
      console.log("handleRead", row);
      axios
        .get("http://localhost:9001/message/deleteMsg", {
          params: { msgId: row.messageId },
          crossDomain: true,
        })
        .then((response) => {
          console.log("handleRestore", response);
          if (response.data.code == 200) this.getMessage();
          else this.$message.warning(response.data.message);
        })
        .catch(function () {});
    },
  },
  mounted() {
    this.user.userId = sessionStorage.getItem("userId");
    this.getMessage();
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
  border: 5px solid rgba(255, 250, 250, 0);
  background: rgb(255, 250, 250, 0.5);
}

.dialog {
  border: 5px solid rgba(255, 250, 250, 0);
}
</style>
