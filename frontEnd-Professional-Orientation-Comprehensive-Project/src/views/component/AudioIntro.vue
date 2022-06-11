<template>
  <div>
    <el-card class="card">
      <div
        v-show="pauseVisible"
        title="播放|暂停"
        class="el-icon-video-pause icon1"
        @click="playOrPause"
      ></div>
      <div
        v-show="playVisible"
        title="播放|暂停"
        class="el-icon-caret-right"
        @click="playOrPause"
      ></div>
    </el-card>
    <audio
      id="audio"
      preload="metadata"
      v-show="false"
      :src="musicURL"
      controls="controls"
      ref="audio"
    ></audio>
  </div>
</template>

<script>
export default {
  name: "AudioBar",
  props: ["fileurl"],
  data() {
    return {
      // 基本信息
      fileUrl: this.fileurl,
      playProcess: 0,
      musicCurrentTime: "0:00",
      musicTime: "--:--",
      pauseVisible: false,
      playVisible: true,
      song_id: "0",
      musicURL: this.fileurl,
      musicName: "曹操",
      totalTime: 0,
      typePic: "https://s2.loli.net/2022/05/08/4tzFr2R1wcVL37G.png",

      // 定时播放相关
      clock: "",
      timer: "",
    };
  },

  mounted() {
    this.timer = setInterval(this.store, 700);
  },
  methods: {
    rePlay() {
      // 需要重新播放
      this.pauseVisible = true;
      this.playVisible = false;
      const playPromise = this.$refs.audio.play();
      if (playPromise !== undefined) {
        playPromise
          .then(() => {
            this.$refs.audio.play();
          })
          .catch(() => {});
      }
    },
    // 重新设定时间
    resetTime() {
      // 计算总时间
      this.totalTime = this.$refs.audio.duration;
      if (isNaN(this.totalTime)) return;
      let minutes = Math.floor(this.totalTime / 60);
      let seconds = Math.floor(this.totalTime - minutes * 60);
      if (seconds < 10) this.musicTime = minutes + ":0" + seconds;
      else this.musicTime = minutes + ":" + seconds;
      // 计算当前时间
      const currentTime = this.$refs.audio.currentTime;
      if (isNaN(currentTime)) return;
      minutes = Math.floor(currentTime / 60);
      seconds = Math.floor(currentTime - minutes * 60);
      if (minutes < 10 && seconds < 10)
        this.musicCurrentTime = "0" + minutes + ":0" + seconds;
      else if (minutes < 10 && seconds >= 10)
        this.musicCurrentTime = "0" + minutes + ":" + seconds;
      else if (minutes >= 10 && seconds < 10)
        this.musicCurrentTime = minutes + ":0" + seconds;
      else this.musicCurrentTime = minutes + ":" + seconds;
    },
    // 播放和暂停
    playOrPause() {
      if (this.pauseVisible) {
        this.pauseVisible = false;
        this.playVisible = true;
        this.$refs.audio.pause();
        window.clearInterval(this.clock);
        this.resetTime();
      } else {
        this.rePlay();
      }
    },
  },
};
</script>

<style scoped>
.card {
  width: 98px;
  height: 100px;
  background: rgba(255, 255, 255, 0.7);
  font-size: 50px;
  font-family: "Microsoft JhengHei";
}

.music-time {
  float: left;
  color: wheat;
}
.icon1 {
  margin-top: -90%;
  font-size: 40px;
  color: whitesmoke;
}
</style>
