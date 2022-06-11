<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">4/5：旋律</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Ikonika - “Praxis”</h1>
      <a
        href="https://v.qq.com/x/page/c0541u5p1tp.html"
        target="_blank"
        class="title5"
        >Ikonika - Praxis</a
      >
      <h2 class="title3">这是什么声音？</h2>
      <h2 class="title2">
        这首歌有很多的层次，且所有的声音都来自不同类型的电子乐器。
      </h2>
      <h2 class="title3">旋律是如何创作的？</h2>
      <h2 class="title2">
        这首歌是E小调。 同Kraftwerk的例子相似，主旋律部分是两条几乎相同的乐句。
        每一乐句为两小节，两句唯一的不同是最后一个音。
      </h2>
      <h2 class="title2">
        旋律的节奏很有意思：从D到B向上进行的五音旋律，重复两次。因每次的结尾音落在每小节节拍的不同位置，使得旋律的节奏有较强的张力。
      </h2>
      <h2 class="title3">你注意到了吗？</h2>
      <h2 class="title2">
        你也许已经注意到了视频中音符的音高和方格中音符的音高听起来有些不一样。
        那是因为原曲的音高设置在了常规概念中12固定音的音高之间。
        这大概是因为Ikonika在使用一些具有灵活音高设置的合成器时，她用耳朵校准乐器音高而非参照“传统”的校准参数。
      </h2>
      <h2 class="title2">
        当你在听这首原曲时，所有乐器很和谐并没有不相容感。那是因为它们演奏了同一组音符并且彼此间有相对音准。
        在方格中，我们选择了将音符移高到“常规”的音高范围（E小调），但我们也可以选择将调向下移低，因为这首歌的音高恰恰介于
        E♭ 和 E之间。
      </h2>
      <h2 class="title2">
        尝试运用一些不传统的音符组合方式和带有变化的重复乐句来创作你自己的旋律吧。
      </h2>
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Ride” ></el-button
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
        path: "/onlineTeach/melody/TourDeFrance",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/melody/Ride",
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