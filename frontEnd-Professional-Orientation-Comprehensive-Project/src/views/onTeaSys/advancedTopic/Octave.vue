<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">5/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">八度音阶（减音阶）</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        八度音阶或减音阶是在八度内使用“全-半”或者“半-全”分隔的八音音阶。此音阶常用在爵士音乐中。
      </h2>
      <h2 class="title2">这是从半音程开始的：</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C# Db"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D# Eb"
        ></AudioPlayerBlack
      ></el-col>

      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F# Gb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A# Bb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">这是从全音程开始的：</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C# Db"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D# Eb"
        ></AudioPlayerBlack
      ></el-col>

      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F# Gb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A# Bb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">与全音阶类似，八度音阶没有特定的中心音高。</h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：印尼音阶 ></el-button
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
        path: "/onlineTeach/advancedTopic/diatonicScale",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/IndonesianScale",
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