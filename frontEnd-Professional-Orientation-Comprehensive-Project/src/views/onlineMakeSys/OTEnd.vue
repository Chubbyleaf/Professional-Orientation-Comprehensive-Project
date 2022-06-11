<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">创作结束</h1>
    </el-row>
    <el-row>
      <b class="title2">恭喜你成功的创作出属于自己的音乐!!！</b>
    </el-row>

    <el-row>
      <b class="title1">从现在开始做一个快乐的音乐家吧~~~</b>
    </el-row>
    <el-button class="button-next" @click="toLast">上一个 ></el-button>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineMake/taptap/index",
      });
    },
  },
  mounted() {},
};
</script>

<style lang="scss" scoped>
.index-font {
  font-size: 25px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  // margin-bottom: 5%;
}
.title1 {
  font-size: 35px;
  float: left;
  color: #fff;
  margin-top: 5%;
  text-align: left;
}
.title2 {
  font-size: 26px;
  float: left;
  color: #fff;
  margin-right: 50%;
  margin-top: 5%;
  text-align: left;
}

.button-intro {
  width: 100px;
  height: 100px;
  background: rgba(255, 255, 255, 0.7);
  font-size: 50px;
  font-family: "Microsoft JhengHei";
}
.button-next {
  margin-top: 3%;
  width: 100%;
  height: 100px;
  background: rgba(255, 255, 255, 0.3);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: white;
}
</style>