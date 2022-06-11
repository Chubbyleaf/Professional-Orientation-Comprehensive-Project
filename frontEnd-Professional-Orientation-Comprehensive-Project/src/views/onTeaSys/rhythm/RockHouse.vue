<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">5/5：节奏</h1>
    </el-row>
    <el-row>
      <h1 class="title1">节奏示例</h1>
    </el-row>
    <el-row>
      <h2 class="title3">基本摇滚节奏</h2>
    </el-row>
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <h2 class="title3">经典house</h2>
    </el-row>
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <h2 class="title2">
        是否注意到house和摇滚的节奏极其相似？
        尽管速度不同以及hihat和kick的演奏方式稍有些区别，但节奏型是完全相同的。
        你会发现许多鼓的节奏型被复制到了不同的音乐风格中。
      </h2>
    </el-row>
    <el-row>
      <a
        href="https://music.163.com/#/song?id=1869271&market=baiduqk"
        target="_blank"
        class="title3"
        >Queen - “We Will Rock You”</a
      >
      <h2 class="title2">
        原曲当中的鼓全部利用身体打击乐创作出来。“kick”来自于脚用力跺在木地板上，clap也是来自于真实的手掌拍击。
      </h2>

      <a
        href="https://www.iqiyi.com/v_19rrk7siuc.html"
        target="_blank"
        class="title3"
        >Beyoncé - “Single Ladies (Put a Ring on It)”</a
      >

      <h2 class="title2">
        在之前的节奏示例中，你也许已发现hihat通常很规律地重复每半拍奏一下。
        但在这个例子中，hihat的运用却没有那么常规。
        每半拍依然一个鼓点，但这里使用的是clap音色而不再是hihat。
      </h2>
      <h2 class="title2">
        你已了解了一点节奏的玩法，现在让我们继续探索其他的音乐创作思路吧。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：探索音高 ></el-button
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
        path: "/onlineTeach/rhythm/bar",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/noteScale/exploreNote",
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
.title5 {
  font-size: 20px;
  font-family: "Microsoft JhengHei";
  float: left;
  color: #fff;
  margin-right: 50%;
  margin-top: 2%;
  text-align: left;
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