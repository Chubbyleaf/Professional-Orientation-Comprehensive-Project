<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">1/3：音符和音阶</h1>
    </el-row>
    <el-row>
      <h1 class="title1">探索音高</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        在这节课中，你将学习到有关音高 的知识，即声音相对的“高度”和“低度”。
      </h2>
      <h2 class="title2">在下方框中来回拖拽鼠标试听音的高低。</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <AudioPlayer3
          ref="audio"
          :fileurl="audioUrl1"
          audioName="低音"
        ></AudioPlayer3
      ></el-col>
      <el-col :span="12"
        ><AudioPlayer3
          ref="audio"
          :fileurl="audioUrl1"
          audioName="高音"
        ></AudioPlayer3
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">
        一些音高（或note）会有特定的名字。下面这五个便是非常常见的音。
      </h2></el-row
    >
    <el-row style="width: 100%">
      <el-col :span="4"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayer2
      ></el-col>
      <el-col :span="4"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayer2
      ></el-col>
      <el-col :span="4"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayer2
      ></el-col>
      <el-col :span="4"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayer2
      ></el-col>
      <el-col :span="4"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayer2
      ></el-col>
    </el-row>
    <el-row>
      <b class="title2">这五个特定的音符名称为A, C, D, E, G。</b>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：调和音阶 ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AudioPlayer3 from "../../component/AudioPlay3.vue";
import AudioPlayer2 from "../../component/AudioPlay2.vue";
export default {
  components: { AudioPlayer3, AudioPlayer2 },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
    };
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/rhythm/rockHouse",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/noteScale/harmonicScale",
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
.button-play2 {
  width: 100%;
  height: 250px;
  background: rgba(255, 255, 255, 0.35);
  font-size: 21px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  border-color: rgb(0, 0, 0);
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