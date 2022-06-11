<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">介绍</h1>
    </el-row>
    <el-row>
      <h1 class="title1">开始音乐创作之旅</h1>
      <b class="title2">你将在这里尽情施展才华，创造独一无二的音乐。</b>
    </el-row>
    <el-button class="button-next" @click="toNext"
      >下一个：简谱音乐创作 ></el-button
    >
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },

  methods: {
    toNext() {
      this.$router.push({
        path: "/onlineMake/notation/index",
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
  margin-right: 45%;
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
  background: rgba(255, 255, 255, 0.158);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: white;
}
</style>