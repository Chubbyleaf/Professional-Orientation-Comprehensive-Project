<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">4/5：节奏</h1>
    </el-row>
    <el-row>
      <h1 class="title1">小节</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        目前为止，所有你见到的鼓点都是四拍一循环。这种四拍一组的节奏单位称为小节
        或者英语中的bar/measure。
      </h2>
      <h2 class="title2">下面是一段两小节长的鼓节奏：</h2>
    </el-row>
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <h2 class="title2">
        将很多个小节组合成一个更长的段落，并将不同段落编排组织形成一段完整的音乐，这就是创作一首歌的过程。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：反拍节奏 ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>
<script>
import AudioPlayer1 from "../../component/AudioPlay1.vue";
export default {
  components: { AudioPlayer1 },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
    };
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/rhythm/tempoGenre",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/rhythm/rockHouse",
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