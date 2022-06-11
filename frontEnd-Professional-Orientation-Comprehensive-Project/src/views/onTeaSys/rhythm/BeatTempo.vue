<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">2/5：节奏</h1>
    </el-row>
    <el-row>
      <h1 class="title1">节拍和速度</h1>
    </el-row>
    <el-row>
      <h2 class="title3">什么是节拍？</h2>
      <h2 class="title2">
        人们通常用“节拍「beat」”这个词来指代“一段由鼓演奏的乐句（或者节奏「rhythm」）”。这节课中你将创作的鼓点便是一个“beat”。
      </h2>
      <h2 class="title2">
        但使人困惑的是，“beat”有另外一个含义。它是指一种“循环规律的，随着音乐重复跳动的脉冲。”
        人们有时跟着这个“beat”用脚来打拍子。
      </h2>
      <h1 class="title3">速度</h1>
      <h2 class="title2">
        音乐播放的速度称为tempo。 Tempo是通过每分钟多少节拍 或 BPM 来计算的。
        因此我们经常所说的一首歌是“120BPM”，意思是指每分钟有120下的节拍（脉冲）”。
      </h2>
      <h2 class="title2">
        一些音乐有非常清楚的规律节拍，而有些音乐的节拍则没有那么容易辨认。
        要想听到一个稳定的节拍，在Kick一行中1，5，9和13的格子里添加音符。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：速度和曲风 ></el-button
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
        path: "/onlineTeach/rhythm/whatSound",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/rhythm/tempoGenre",
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
  text-align: left;
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
  background: rgba(255, 255, 255, 0.7);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
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