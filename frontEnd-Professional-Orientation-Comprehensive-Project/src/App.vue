<template>
  <div id="app">
    <div id="nav">
      <el-row class="Header">
        <el-col :span="3">
          <img
            class="logo"
            height="60px"
            width="auto"
            src="./assets/logo.png"
          />
        </el-col>

        <el-menu
          mode="horizontal"
          :router="true"
          background-color="#2c465f"
          text-color="white"
          active-text-color="yellow"
          style="float: left; margin-left: 3%"
        >
          <el-menu-item index="/">首页</el-menu-item>
          <el-menu-item index="/hall">音乐大厅</el-menu-item>
          <el-menu-item index="/onlineTeach/index">乐曲科普</el-menu-item>
          <el-menu-item index="/onlineMake/index">在线创作</el-menu-item>
          <el-menu-item index="/announce">公告</el-menu-item>
        </el-menu>

        <el-col :span="6" style="padding: 10px">
          <el-input
            placeholder="请输入内容"
            type="text"
            v-model="search"
            style="width: 60%; margin-right: 10px"
            clearable
          ></el-input>

          <el-button icon="el-icon-search" @click="toSearch">搜索</el-button>
        </el-col>
        <el-menu
          mode="horizontal"
          :router="true"
          background-color="#2c465f"
          text-color="white"
          active-text-color="yellow"
          style="float: right; margin-right: 3%"
        >
          <el-menu-item index="/login" v-if="!this.$store.state.isSignIn"
            >登录丨注册</el-menu-item
          >
          <el-submenu index="/user" v-else>
            <template #title>个人中心</template>
            <el-menu-item index="/user">个人主页</el-menu-item>
            <el-menu-item index="/message">消息中心</el-menu-item>

            <el-menu-item @click="Logout">注销</el-menu-item>
          </el-submenu>
        </el-menu>
      </el-row>
    </div>
    <router-view />
  </div>
</template>

<style lang="scss">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c465f;
}

/*html,
body,
#app {
  margin: 0;
  padding: 0;
  height: fit-content;
  min-height: 800px;
  height: fit-content;
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  background-size: 100% 100%;
  background: url("./assets/7.jpg") repeat-y;
}*/

#nav {
  //padding: 30px;
  //margin-bottom: 5%;

  a {
    font-weight: bold;
    color: #2c465f;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}
.el-main {
  width: 100%;
  height: 100%;
  text-align: center;
  //background-color: rgba(251, 252, 252, 1);
  margin-top: 3.5%;
  padding: 0; //这里要再添加 padding，页面才能生效
}
.Header {
  background-color: #2c465f;
  opacity: 0.9;
}
</style>
<script>
export default {
  name: "App",
  data: () => ({
    search: "",
    isLogin: false,
    userId: sessionStorage.getItem("userId"),
  }),
  methods: {
    toSearch() {
      this.$router.push({ path: "/search", query: { keywords: this.search } });
    },
    toUser() {
      //console.log(this.userId);
      this.$router.push({
        path: "/user",
        query: { userId: this.userId },
      });
    },
    Logout() {
      sessionStorage.removeItem("userId");
      sessionStorage.setItem("isSignIn", false);
      this.$store.state.isSignIn = false;
      this.isLogin = false;
      this.$message({
        message: "注销成功！跳转中...",
        type: "success",
      });
      this.$router.go(0);
    },
    isLog() {
      if (sessionStorage.getItem("userId")) this.isLogin = true;
      else this.isLogin = false;
    },
  },
  created() {
    this.isLog();
  },
};
</script>