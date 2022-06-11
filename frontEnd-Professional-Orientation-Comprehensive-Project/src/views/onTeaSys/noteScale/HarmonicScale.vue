<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">2/3：音符和音阶</h1>
    </el-row>
    <el-row>
      <h1 class="title1">调和音阶</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        大多数音乐都有特定的调。假设一首歌是C调，这意味着C音是这首歌最为稳定的“首要音”（也就是主音）。
      </h2>
      <h2 class="title2">
        同样的，大多数音乐使用特定音阶中的音 — 一组从低到高顺序排列的音符集合。
      </h2>
      <b class="title3">大调音阶</b>
      <h2 class="title2">下面是C大调音阶：</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="B"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">大多数人认为大调音阶听起来为“高兴的”或“明亮的”。</h2>
      <h2 class="title2">
        你可以将音阶想象成画家的调色板。
        它就好比是所有可选音符的子集，这些音符的选择基于它们相互联系的关系。
        每一音阶都有着独特的声音气质，许多人甚至会对某一些音阶产生情感共鸣。
      </h2>
      <h2 class="title2">
        你可以添加一些音符然后以一种特定的距离关系（音程）从主音往上排列来创建音阶。最常见的音阶种类为大调和小调
        音阶。
      </h2>
    </el-row>

    <el-row>
      <h1 class="title3">小调音阶</h1>
      <h2 class="title2">小调音阶是由另一种音程关系排列而成的。</h2>
      <h2 class="title2">下面是C小调音阶：</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3">
        <AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Eb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Ab"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Bb"
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
      <h2 class="title2">很多人认为小调音阶听起来有点“悲伤”或“阴郁”。</h2>
      <h2 class="title2">
        （带有♭降号符号的音符对应钢琴键盘上的黑键。 “B♭” 读作“降B”。）
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：添加更多音符 ></el-button
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
        path: "/onlineTeach/noteScale/exploreNote",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/noteScale/addNote",
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