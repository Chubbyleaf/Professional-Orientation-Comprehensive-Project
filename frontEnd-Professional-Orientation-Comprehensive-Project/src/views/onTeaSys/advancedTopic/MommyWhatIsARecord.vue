<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">9/9：高级话题</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Kerri Chandler - “Mommy What's a Record”</h1>

      <h2 class="title2">
        目前你所学到的和弦都是调内和弦。 但有很多音乐都使用到了非调内和弦。
        非调内和弦包含了不属于该调的音符。
        在创作一首歌时，最简单的一种和弦运用方式是只演奏一个和弦，将其变化发展或重复贯穿整首歌。
      </h2>
      <a
        href="https://v.qq.com/x/page/g0522lfgebv.html"
        target="_blank"
        class="title5"
        >Mommy What's a record</a
      >
      <h2 class="title3">演奏和弦的乐器</h2>
      <h2 class="title2">
        这首歌中的和弦是通过一种合成器或采样器 来演奏的 —
        一种播放预先录制的声音（或采样 ）的乐器。
        随着歌曲的进行发展，叠加的声音也越来越多。
        但现在，让我们专注听一下歌曲开头类似于弦乐器的声音以及它演奏的和弦。
      </h2>
      <h2 class="title3">和弦是如何工作的</h2>
      <h2 class="title2">这首歌只用了三个和弦的和弦进行：</h2>
      <h2 class="title2">C小七，G小七，和A小七</h2>
      <h2 class="title2">
        这三个和弦的类别以及和弦排列法完全相同（小七原位和弦）。
        像这样由一种和弦的复制和移调组成的和弦连接称为平行
        连接。因为在和弦进行时，每一和弦音符走向方向和距离都是相同的。
      </h2>
      <h2 class="title2">
        这是一个非调内和弦连接的例子，因为这些和弦的音符都没有明确指向任何大调或小调音阶。
        事实上，从中判断什么调是有些困难的。平行和弦连接通常带有“模糊” 或 “飘浮”
        的声音色彩。
      </h2>
      <h2 class="title2">
        平行和弦连接常用在deep house 或其他相似风格的音乐中。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext">科普结束 ></el-button>
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
        path: "/onlineTeach/advancedTopic/seventh",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/end",
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