<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">科普结束</h1>
    </el-row>
    <el-row>
      <h1 class="title1">科普结束</h1>
    </el-row>
    <el-row>
      <b class="title2">恭喜你完成了所有的科普！</b>
      <b class="title2">
        无论是从科普中学到的，还是你平时的练习和积累，你已经掌握了很多有关音乐创作的基础知识。</b
      >
      <b class="title2">
        从这里开始，你会找到更多学习音乐创作的方法。但我们认为最好的学习方式便是随时随地创作更多的音乐。</b
      >
      <b class="title2">
        最后，我们希望听到你的意见关于使用科普时遇到的任何问题（或成功的好消息），以及你想要学习到的其他内容。
        更多的，我们想听到你的音乐！</b
      >
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
        path: "/onlineTeach/advancedTopic/MommyWhatIsARecord",
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
  font-size: 45px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
}
.title2 {
  font-size: 26px;
  font-family: "Microsoft JhengHei";
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
.music-font {
  font-size: 25px;
  font-family: "Microsoft JhengHei";
  color: rgba(255, 255, 255, 0.76);
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