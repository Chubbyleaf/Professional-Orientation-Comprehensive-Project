<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">5/6：贝斯</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Rhythm & Sound - “Never Tell You”</h1>
      <a
        href="https://www.kuwo.cn/play_detail/25052460"
        target="_blank"
        class="title5"
        >Never Tell You</a
      >

      <h2 class="title3">贝斯的音色是什么？</h2>
      <h2 class="title2">
        与Daft Punk类似， Rhythm &
        Sound从未对外分享过他们所用的设备和音乐创作过程。敢肯定的是这段音乐中的贝斯音色来自于某种合成器。
      </h2>

      <h2 class="title3">贝斯旋律是如何创作的？</h2>
      <h2 class="title2">
        贝斯对于这首dub techno音乐来说或许是最重要的元素了。
        音乐中使用了一些和弦但是相当适度，和弦在这里更多作为背景而存在。
        （顺便说一下，这种和弦演奏在弱拍上的方式"skank"你已在之前科普 里学到过。
        这种风格的节奏在雷鬼，dub或相关类型的音乐中很常见。）
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Oblivion” ></el-button
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
        path: "/onlineTeach/bass/UnderMiSlengTeng",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/bass/Oblivion",
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