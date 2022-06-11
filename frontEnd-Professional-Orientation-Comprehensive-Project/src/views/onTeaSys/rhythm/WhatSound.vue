<template>
  <div style="margin-left: 3%; margin-right: 3%">
    <el-row>
      <h1 class="index-font">1/5：节奏</h1>
    </el-row>
    <el-row>
      <h1 class="title1">这是什么声音？</h1>
    </el-row>
    <el-row> <h2 class="title2">请听下面的节奏:</h2></el-row>
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <h2 class="title2">现在来听这一段，看看是否能找到任何区别：</h2></el-row
    >
    <el-row>
      <AudioPlayer1 ref="audio" :fileurl="audioUrl1"></AudioPlayer1>
    </el-row>
    <el-row>
      <b class="title2"
        >两段音乐的音符全部一样，我们只是改变了音色。但这个改变给予了两个版本非常不同的性格特点。</b
      >

      <h2 class="title3">Kick 底鼓</h2>
    </el-row>
    <el-row>
      <img
        src="../../../assets/kick.png"
        width="500px"
        height="500px"
        class="image"
      />
    </el-row>
    <el-row>
      <b class="title2"
        >也被称为bass
        drum。在架子鼓中，鼓手通过脚踩脚踏板触发连接的踩锤敲击鼓面来发出声音。
        电子底鼓的声音延时可调整到远远长于真实鼓相对于非常短的时值。</b
      >
      <b class="title2">请比较一下电子kick和真鼓kick的音色区别：</b>
    </el-row>
    <el-row style="width: 50%">
      <el-col :span="12">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Electronic Kick"
        ></AudioPlayer2
      ></el-col>

      <el-col :span="12"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Acoustic Kick"
        ></AudioPlayer2
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title3">Clap 拍手</h2>
    </el-row>
    <el-row>
      <img
        src="../../../assets/clap.png"
        width="500px"
        height="500px"
        class="image"
      />
    </el-row>
    <el-row>
      <b class="title2"
        >这个声音来自于一个或多个人拍击双手。今天你所听到的这种声音其电子风格版本（就像这里使用的）比实际录音更为常见。</b
      >
    </el-row>
    <el-row>
      <h2 class="title3">Snare 军鼓</h2>
    </el-row>
    <el-row>
      <img
        src="../../../assets/snare.png"
        width="500px"
        height="500px"
        class="image"
      />
    </el-row>
    <el-row>
      <b class="title2"
        >snare drum 由鼓槌敲击制造出短促、响亮的声音。
        多条螺旋状金属线（称作响弦）拉伸开横置在底部鼓皮 上。
        底部鼓皮的震动带动响弦震动于是产生出军鼓很有特色的“劈裂”声。</b
      >
      <b class="title2"
        >拍手，军鼓，以及其他“尖锐”或“明亮”的音色在鼓节奏中有很相似的使用方式。</b
      >
      <b class="title2">请比较一下电子clap和真鼓snare的音色区别：</b>
    </el-row>
    <el-row style="width: 50%">
      <el-col :span="12">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Electronic Clap"
        ></AudioPlayer2
      ></el-col>
      <el-col :span="12"
        ><AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Acoustic Snare"
        ></AudioPlayer2
      ></el-col>
    </el-row>
    <el-row>
      <h2 class="title3">Closed Hat 踩镲 和 Open Hat 开镲</h2>
    </el-row>
    <el-row>
      <img
        src="../../../assets/hat.png"
        width="500px"
        height="500px"
        class="image"
      />
    </el-row>
    <el-row>
      <b class="title2"
        >这是两种不同的声音由一种名为hihat 的乐器产生出来的。
        Hihat是两片小镲片面对面合并组成，安装在一个三角支架上。
        顶部的镲片固定在支柱上，通过脚踏板上下移动。
        当鼓手用脚踩下脚踏板时，镲片会“关闭”起来，相互碰击。
        当鼓手抬起脚后，镲片“打开”，上下分离。
        在架子鼓中，踩镲完全关闭与完全打开之间也存在着范围很广的变化。每一种开合的状态下声音都是不同的。</b
      >
    </el-row>
    <el-row style="width: 100%; margin-top: 3%">
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Electronic Closed Hat"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Electronic Open Hat"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Acoustic Closed Hat"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Acoustic Open Hat"
        ></AudioPlayer2>
      </el-col>
    </el-row>
    <el-row>
      <b class="title2">试听所有的电子音色：</b>
    </el-row>
    <el-row style="width: 100%; margin-top: 3%">
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Kick"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Clap"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Closed Hat"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Open Hat"
        ></AudioPlayer2>
      </el-col>
    </el-row>
    <el-row>
      <b class="title2">试听所有的真鼓音色：</b>
    </el-row>
    <el-row style="width: 100%; margin-top: 3%">
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Kick"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Clap"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Closed Hat"
        ></AudioPlayer2>
      </el-col>
      <el-col :span="6">
        <AudioPlayer2
          ref="audio"
          :fileurl="audioUrl1"
          audioName="Open Hat"
        ></AudioPlayer2>
      </el-col>
    </el-row>

    <el-row>
      <h2 class="title3">你注意到了吗？</h2>
      <b class="title2"
        >假设你演奏closed hihat时演奏一个open
        hihat，closed的声音会作为“主导”，立刻停止了open声音的进行。
        这个方式匹配了现实当中的hihat演奏：踩镲和开镲无法同时发生。
        这节课中的hihat则是以这个原则进行的。</b
      >
    </el-row>
    <el-row style="width: 100%">
      <el-col :span="12">
        <el-button class="button-last" @click="toLast">上一个 ></el-button>
      </el-col>
      <el-col :span="12">
        <el-button class="button-next" @click="toNext"
          >下一个：节拍和速度 ></el-button
        >
      </el-col>
    </el-row>
  </div>
</template>

<script>
import AudioPlayer1 from "../../component/AudioPlay1.vue";
import AudioPlayer2 from "../../component/AudioPlay2.vue";
export default {
  components: { AudioPlayer1, AudioPlayer2 },
  data() {
    return {
      audioUrl1: "http://rbz8c5rhq.hd-bkt.clouddn.com/y799.mp3",
    };
  },

  methods: {
    toLast() {
      this.$router.push({
        path: "/onlineTeach/index",
      });
    },
    toNext() {
      this.$router.push({
        path: "/onlineTeach/rhythm/beatTempo",
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
  border-color: #000000;
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