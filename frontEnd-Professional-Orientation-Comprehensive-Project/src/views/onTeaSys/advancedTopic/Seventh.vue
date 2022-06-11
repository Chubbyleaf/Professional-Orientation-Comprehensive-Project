<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">8/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">七和弦</h1>
    </el-row>
    <el-row>
      <h2 class="title2">
        你已经学习了如何构建七组调内三和弦。但是三和弦只是一种和弦，你可以从三和弦的最高音继续往上叠加三度音程以获得更多的和弦。
      </h2>
      <h2 class="title2">
        我们来回顾一下，建立三和弦需在根音上叠加三音和五音。
        现在你可以继续向上叠加一个音，即七音。
        如果是大三和弦，叠加七音后就是大七和弦。
      </h2>
      <h2 class="title2">你可以构建一个C大七和弦如步骤所示：</h2>

      <li class="title4">C（根音）</li>
      <li class="title4">E（C上方第三音；通常称为“三音”）</li>
      <li class="title4">G（C上方第五音；通常称为“五音”）</li>
      <li class="title4">B（C上方第七音；通常称为“七音”）</li>

      <h2 class="title2">如果是小三和弦，叠加七音后就是小七和弦。</h2>
      <h2 class="title2">你可以构建一个C小七和弦如步骤所示：</h2>

      <li class="title4">C（根音）</li>
      <li class="title4">E♭（C上方第三音；通常称为“三音”）</li>
      <li class="title4">G（C上方第五音；通常称为“五音”）</li>
      <li class="title4">Bb（C上方第七音；通常称为“七音”）</li>

      <h2 class="title3">七和弦的转位</h2>
      <h2 class="title2">
        同三和弦一样，七和弦也有转位。
        由于和弦多加了一个音，因此也多了一种转位：第三转位 —
        即以第七音作为最低音。
      </h2>
      <h2 class="title2">你可以称C小七和弦第三转位C/B♭ ("C over B♭")。</h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="4"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="E"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G"
        ></AudioPlayerWhite
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerWhite
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A"
        ></AudioPlayerWhite
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title2">
        如果你弹过钢琴，你也许已经不经意间发现了小调五声音阶：只需从D♯/E♭开始弹八度内的每一个黑键。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="4"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D# Eb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="F# Gb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="G# Ab"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="A# Bb"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="C# Db"
        ></AudioPlayerBlack
      ></el-col>
      <el-col :span="4"
        ><AudioPlayerBlack
          ref="audio"
          :fileurl="audioUrl1"
          audioName="D# Eb"
        ></AudioPlayerBlack
      ></el-col>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Mommy What's a Record” ></el-button
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
        path: "/onlineTeach/advancedTopic/19",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/MommyWhatIsARecord",
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
