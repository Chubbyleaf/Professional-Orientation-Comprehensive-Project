<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">6/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">印尼音阶</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        印尼音阶是一种来自于印度尼西亚音乐的七音音阶。
        与西方音乐的音阶体系不同，其音程和音高变化丰富多样。
        以下例子只是一种可能的印尼音阶结构。
        这些音阶中的音符与西方音乐中的12音符无关；它们的音高都是夹在“琴缝间“的音。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="1"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="2"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="3"
        ></AudioPlayerWhite
      ></el-col>

      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="4"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="5"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="6"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="7"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：19平均律 ></el-button
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
        path: "/onlineTeach/advancedTopic/octave",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/19",
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