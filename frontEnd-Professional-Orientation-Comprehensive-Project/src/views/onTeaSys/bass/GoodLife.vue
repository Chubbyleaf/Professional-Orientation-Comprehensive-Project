<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">2/6：贝斯</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Inner City - “Good Life”</h1>
      <h2 class="title2">
        在创作一首歌时，最简单的一种和弦运用方式是只演奏一个和弦，将其变化发展或重复贯穿整首歌。
      </h2>
      <a
        href="https://www.bilibili.com/video/BV1Yh411R7G4"
        target="_blank"
        class="title5"
        >Good Life - Inner City</a
      >
      <h2 class="title3">贝斯的音色是什么？</h2>
      <h2 class="title2">
        这段短促的，快速行进的贝斯旋律是在Yamaha DX100 合成器上演奏的。
      </h2>
      <h2 class="title2">
        多数合成器，包括DX100，提供丰富的已制作好的音色设置选择，这些音色设置称为预设。
        这首歌使用的是DX100中名为"Solid
        Bass"的预设音色。在许多90年代的techno和house音乐里你都能听到这个声音。
      </h2>
      <h2 class="title3">贝斯旋律是如何创作的？</h2>
      <h2 class="title2">
        这是一首经典的早期techno音乐，贝斯音符短促且节奏复杂。这样它与“four-on-the-floor”的节拍形成很有趣的对比。
      </h2>
    </el-row>

    <el-row>
      <h2 class="title2">
        让我们来尝试创作一些贝斯旋律，你可以借鉴原曲的鲜明特点：音符短促，精细的节奏。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Around the World” ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
export default {
  data() {
    return {};
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/bass/bassCreate",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/bass/AroundTheWorld",
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
  margin-right: 50%;
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