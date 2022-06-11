<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">3/5：旋律</h1>
    </el-row>
    <el-row>
      <h1 class="title1">Kraftwerk - “Tour de France”</h1>
      <a
        href="https://www.bilibili.com/video/BV1xW41157S1/"
        target="_blank"
        class="title5"
        >【8-bit】Kraftwerk-Tour De France</a
      >
      <h2 class="title3">演奏旋律的有哪些乐器？</h2>
      <h2 class="title2">
        这首歌中的所有声音均通过合成器与鼓机创作（除了人声），主旋律是由一种类似于弦乐音色的合成器完成。
      </h2>
      <h2 class="title3">旋律是如何创作的？</h2>
      <h2 class="title2">
        歌曲中的主旋律比较长，但你可以将其分解成四个较小的片段也就是乐句，每一乐句的演奏略有差异。
      </h2>
      <h2 class="title2">
        第一个乐句与第二个乐句相比除了最后一个音其他部分是相同的。
        在第一乐句中，最后两个音是
        B♭向下进行到A♭，而第二个乐句中则是B♭向上进行到
        C。你可以注意到，这如同是种“问与答”的关系。第一乐句听起来像未完成的状态，而第二乐句听起来像是回答了第一乐句的问题。
      </h2>
      <h2 class="title2">
        第三乐句与第四乐句的关系是同样道理。
        第三乐句与第一乐句的旋律走向相同，只不过调性从F转到了G。第四乐句回答了第三乐句的问题，旋律最末做了简单变化。
      </h2>
      <h2 class="title2">
        试着用这种创作技巧来创作你自己的旋律：重复的乐句并稍做变化；“问与答”的关系，旋律上行与下行交替运用。
      </h2>
      <h2 class="title2">
        顺带说明一下：旋律开始的一部分借鉴于一首年代久远的音乐：Paul Hindemith's
        Sonata for Flute and Piano (1936).
      </h2>
      <a
        href="https://www.bilibili.com/video/BV1DK4y1s71s?from=search&seid=7164541414789594925&spm_id_from=333.337.0.0"
        target="_blank"
        class="title5"
        >Paul Hindemith - Sonata for Flute and Piano(2016)</a
      >
    </el-row>

    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：“Praxis” ></el-button
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
        path: "/onlineTeach/melody/LoveWillTearUsApart",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/melody/Praxis",
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