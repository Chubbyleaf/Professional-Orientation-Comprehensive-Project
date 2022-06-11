<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">6/6：贝斯</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Grimes - “Oblivion”</h1>
      <a
        href="https://www.bilibili.com/video/av54958609/"
        target="_blank"
        class="title5"
        >Grimes - “Oblivion” 官方MV</a
      >

      <h2 class="title3">贝斯的音色是什么？</h2>
      <h2 class="title2">
        整首歌的所有乐器都由合成器完成。除了人声部分，贝斯是最突出的一层。
      </h2>

      <h2 class="title3">贝斯旋律是如何创作的？</h2>
      <h2 class="title2">
        贝斯的乐句有八个小节，但可以进一步将其细分为两组四个小节的旋律。
      </h2>
      <h2 class="title2">
        前两个小节的乐句由D小三和弦中的音符组成。两小节的乐句重复两次。
      </h2>
      <h2 class="title2">
        在后四个小节中，相同的模式向下移调到B小三和弦。同样也是两小节乐句重复两次。
      </h2>
      <h2 class="title2">
        一串和弦音以特定节奏排列依次连续奏出称为琶音，这是创作贝斯旋律的常用手法。
        许多合成器具有琶音 功能，当你按下和弦音符时它便可以自动演奏琶音旋律。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：旋律创作 ></el-button
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
        path: "/onlineTeach/bass/NeverTellYou",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/melody/melodyCreate",
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