<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">3/5：节奏</h1>
    </el-row>
    <el-row>
      <h1 class="title1">速度和曲风</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        一段音乐的曲风（genre）是由许多因素所决定的。这其中包括声音的类型，节奏模式，和速度。
        基于你音乐聆听的经验，当你听到一段音乐时也许已经对音乐的风格有了一定判断。下面列举的是一些“典型”的风格和相对应的曲速：
      </h2>

      <li class="title4">Dub: 60-90 bpm</li>
      <li class="title4">Hip-hop: 60-100 bpm</li>
      <li class="title4">House: 115-130 bpm</li>
      <li class="title4">Techno/trance: 120-140 bpm</li>
      <li class="title4">Dubstep: 135-145 bpm</li>
      <li class="title4">Drum and bass: 160-180 bpm</li>

      <h2 class="title2">
        试着在播放这段节奏时调整不同的速度。你可以感受到，即使是完全相同的节奏，速度的改变使得音乐性格产生了变化。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：小节 ></el-button
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
        path: "/onlineTeach/rhythm/beatTempo",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/rhythm/bar",
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
.title4 {
  font-size: 26px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 60%;
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