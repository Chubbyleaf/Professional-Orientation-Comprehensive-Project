<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">7/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">19平均律</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        半音音阶是通过将一个八度划分成12个相等的部分而建立的。当然这并不表示一个八度不能以其它方式划分。
      </h2>
      <h2 class="title2">
        一些音乐家尝试过将八度平分出19个音符，并且还运用这种19音音阶作曲。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="1"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="2"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="3"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="4"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="5"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="6"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="7"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="8"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="9"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="10"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="11"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="12"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="13"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="14"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="15"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="16"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="17"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="18"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="19"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="1"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="1"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">
        标记为1的音符与传统半音音阶中的C相同，并且恰好相隔八度。
        而所有其他音符都是夹在半音之间的缝隙音。
      </h2>
      <h2 class="title3">不仅如此</h2>
      <h2 class="title2">
        音阶是一种抽象的音乐形式。
        这种有序的音符集合就如同一个音符调色板供音乐家去选择。
        这些科普中的音阶示例仅代表了大量不同音阶中的一小部分。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：七和弦 ></el-button
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
        path: "/onlineTeach/advancedTopic/IndonesianScale",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/seventh",
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