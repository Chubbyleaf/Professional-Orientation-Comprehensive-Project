<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">2/5：旋律</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Joy Division - “Love Will Tear Us Apart”</h1>
      <a
        href="https://www.iqiyi.com/v_19rrifm7py.html"
        target="_blank"
        class="title5"
        >Joy Division - Love Will Tear Us Apart</a
      >
      <h2 class="title3">这是什么声音？</h2>
      <h2 class="title2">
        这首经典歌曲的主要旋律是由合成器和贝斯共同演奏的。只不过它们的音高范围不同，节奏略有区别。
        并且在特定的段落主唱也会来演唱这条主旋律，这个特定的段落称作chorus。
      </h2>
      <h2 class="title3">旋律是如何形成的？</h2>
      <h2 class="title2">
        这段旋律只使用了D大调中的音。但旋律从一个很长的E音开始，为整首歌铺垫了一种与主调相矛盾的紧张感。
      </h2>
      <h2 class="title2">
        仔细观察一条旋律的形状或 contour（轮廓）。
        在最一开始，旋律在音阶中的相邻音间起伏下落。
        到结尾，旋律从B向上跳到D又向下跳到A。这样的级进 与跳进
        的进行模式会产生强烈对比使得旋律有很强的表现力，容易让人记住。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Tour de France” ></el-button
        >
      </el-col>
    </el-row>
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
        path: "/onlineTeach/melody/melodyCreate",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/melody/TourDeFrance",
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
  margin-right: 50%;
}
.title2 {
  font-size: 26px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 50%;
  margin-top: 3.5%;
  text-align: left;
}
.title3 {
  font-size: 34px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 60%;
  margin-top: 5%;
}
.title4 {
  font-size: 26px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 60%;
}
.title5 {
  font-size: 20px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 50%;
  margin-top: 2%;
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
.button-play1 {
  width: 30%;
  height: 50px;
  background: rgba(255, 255, 255, 0.7);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  float: left;
}
.button-play2 {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.35);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
}
.button-next {
  margin-top: 3%;
  width: 100%;
  height: 100px;
  background: rgba(255, 255, 255, 0.158);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: #fff;
}
.button-last {
  margin-top: 3%;
  width: 100%;
  height: 100px;
  background: rgba(255, 255, 255, 0);
  font-size: 30px;
  font-family: "Microsoft JhengHei";
  color: #fff;
  border: 5px solid rgba(255, 255, 255, 0);
}
.image {
  position: relative;
  left: 10px;
}
</style>