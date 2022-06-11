<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">2/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">调式</h1>
    </el-row>
    <el-row>
      <h2 class="title2">C大调音阶对应钢琴键上的白键，音阶从C音起始。</h2>
      <h2 class="title2">
        通过使用完全相同的音符组合，从不同音起始你可以创建七种其他音阶。以这种方式创建的音阶称为调式。
      </h2>
      <h2 class="title2">我们以C大调音阶为例：</h2>
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
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
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
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="B"
        ></AudioPlayerWhite
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
      <h2 class="title2">如果将D作为起始音而不是C，你就得到了多利亚 调式。</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
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
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="B"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="3"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <b class="title2">以下是基于C大调音阶得出的七种调式： </b>

      <b class="title2"
        >C Ionian（major） — CDEFGABC <br />（音程关系：全 - 全 - 半 - 全 - 全 -
        全 - 半）
      </b>
      <b class="title2"
        >D Dorian — DEFGABCD <br />（音程关系：全 - 半 - 全 - 全 - 全 - 半 -
        全）
      </b>
      <b class="title2"
        >E Phrygian— EFGABCDE<br />
        （音程关系：半 - 全 - 全 - 全 - 半 - 全 - 全）
      </b>
      <b class="title2"
        >F Lydian — FGABCDEF<br />
        （音程关系：全 - 全 - 全 - 半 - 全 - 全 - 半）
      </b>
      <b class="title2"
        >G Mixolydian — GABCDEFG<br />
        （音程关系：全 - 全 - 半 - 全 - 全 - 半 - 全）</b
      >
      <b class="title2"
        >A Aeolian（minor） — ABCDEFGA<br />
        （音程关系：全 - 半 - 全 - 全 - 半 - 全 - 全）</b
      >
      <b class="title2"
        >B Locrian — BCDEFGAB<br />
        （音程关系：半 - 全 - 全 - 半 - 全 - 全 - 全）</b
      >
      <b class="title2"
        >虽然音高和音程总是以相同的顺序排列，但是起始音位置不同，每种模式因此拥有独特的音乐特性。如果将其理解为音阶间的“轮换”，则更容易明白。</b
      >
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：五声音阶 ></el-button
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
        path: "/onlineTeach/advancedTopic/establishMajorScale",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/pentatonicScale",
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