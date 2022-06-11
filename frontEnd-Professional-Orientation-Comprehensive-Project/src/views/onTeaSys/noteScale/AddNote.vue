<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">3/3：音符和音阶</h1>
    </el-row>
    <el-row>
      <h1 class="title1">添加更多音符</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        让我们将音符集合扩展到12个音。下面列出的是所有常用音符（外加一个高八度C）：
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C# Db"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D# Eb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F# Gb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G# Ab"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A# Bb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="B"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="2"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">这是另外一种音阶，称为半音音阶。</h2>
      <h2 class="title2">
        钢琴键盘上的黑键同时也可以用♯（升号）符号来表示。"A♯/B♭"读作“升A”或“降B”。
      </h2>
      <h2 class="title2">
        尝试用12个音创作一些旋律（注意半音音阶没有调性概念，因此没有音符会被标记出来）：
      </h2>
      <h2 class="title2">
        当使用这12个音创作时，可能会发现你很容易写出不那么常规或者“错误”的旋律。大多数音乐仅使用到这12个音符中的一小部分（比如大调或小调音阶中的七个音），而且我们的耳朵更习惯于听音高数量较低的音乐。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：三和弦 ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AudioPlayerWhite from "../../component/AudioPlayWhite.vue";
import AudioPlayerBlack from "../../component/AudioPlayBlack.vue";
export default {
  components: { AudioPlayerWhite, AudioPlayerBlack },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
    };
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/noteScale/harmonicScale",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/chord/triad",
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
.button-play-white {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.35);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  border-color: rgb(0, 0, 0);
}
.button-play-black {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.2);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  border-color: rgb(155, 154, 154);
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