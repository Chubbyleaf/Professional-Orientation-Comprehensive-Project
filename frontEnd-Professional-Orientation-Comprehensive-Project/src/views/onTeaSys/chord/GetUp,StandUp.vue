<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">2/3：和弦</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Bob Marley & The Wailers - “Get Up, Stand Up”</h1>
      <h2 class="title2">
        在创作一首歌时，最简单的一种和弦运用方式是只演奏一个和弦，将其变化发展或重复贯穿整首歌。
      </h2>
      <a
        href="https://v.qq.com/x/page/o0020cw9l16.html"
        target="_blank"
        class="title5"
        >Bob Marley《Get Up, Stand Up》</a
      >
      <h2 class="title3">和声乐器有哪些？</h2>
      <h2 class="title2">
        在这首歌里你能听到许多种乐器在演奏和弦，包括电吉他、木吉他和电钢琴。
      </h2>
      <h2 class="title2">
        这些乐器的使用方式却非常不同。
        一些吉他和键盘以规律、重复的节奏演奏和弦，而其他吉他和键盘则以更难以预测的方式即兴演奏。
      </h2>
      <h2 class="title3">和弦是如何使用的？</h2>
      <h2 class="title2">铺在整首歌底层的是循环重复的C小调和弦</h2>

      <h2 class="title2">
        一些声音会反复出现在一拍中一半的位置。这种offbeat（弱拍）的节奏在雷鬼音乐中称为skank。
      </h2>
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Mary Had a Little Lamb” ></el-button
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
        path: "/onlineTeach/chord/triad",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/chord/MaryHadALittleLamb",
      });
    },
  },
  mounted() {},
};
</script>

<script>
export default {
  data() {
    return {};
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/chord/triad",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/chord/MaryHadALittleLamb",
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