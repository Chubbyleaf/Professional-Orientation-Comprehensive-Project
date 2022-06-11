<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">5/5：旋律</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Robert Hood - “Ride”</h1>
      <a
        href="https://v.qq.com/x/page/e0541luctqg.html"
        target="_blank"
        class="title5"
        >Robert Hood-Ride</a
      >
      <h2 class="title3">演奏旋律的有哪些乐器？</h2>
      <h2 class="title2">
        与Kraftwerk示例一样，这里的所有声音都是由合成器和鼓机制作的。声音在这段音乐里的使用极为节制但其实又在不断地发展。
      </h2>
      <h2 class="title2">
        Robert Hood 在这张唱片里大量使用了Roland Alpha Juno
        2合成器，很可能这首歌的旋律部分使用了此台合成器。
      </h2>
      <h2 class="title3">旋律是如何形成的？</h2>
      <h2 class="title2">除鼓之外，只有一种旋律模式在整个音轨中重复出现。</h2>
      <h2 class="title2">
        这首音乐便是一个极简techno的例子：音乐的发展更专注于细微、缓慢的变化，重点在于声音本身的本质而非音符和节奏。
      </h2>
      <h2 class="title2">
        你可以听到旋律在非常大的音高范围之间跳跃。
        当你在聆听反复出现的旋律时，也许有时会听到一个完整的乐句，而有时又会听到两条完全分开的交替旋律。高音部分偏向主旋律的作用，低音部分则偏向bass旋律。
      </h2>
      <h2 class="title2">
        所以这到底是一条旋律还是分开的，或者是两者都包括？对于这样的音乐，决定在于听者。
      </h2>
      <h2 class="title2">
        同时你也会注意到稳定的四四拍底鼓节奏使得人们很容易地跟随律动。
        但同时又不太容易分辨乐句究竟从哪开始。
        如果你随意跳到视频的某一位置播放，也许你会听到旋律仿佛“漂移”到了不同的地方。
      </h2>
      <h2 class="title2">让我们看看我们所听到的旋律不同起始位置会有哪些。</h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：玩转歌曲结构 ></el-button
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
        path: "/onlineTeach/melody/Praxis",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/advancedTopic/establishMajorScale",
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