<template>
  <div>
    <el-card class="card">
      <div style="display: flex; flex-direction: row">
        <img class="song-card" :src="typePic" alt="res" />
        <div>
          <div class="process-card">
            <el-slider
              :show-tooltip="false"
              v-model="playProcess"
              @change="flushPlay"
            ></el-slider>
            <div>
              <div class="music-time">{{ musicCurrentTime }}</div>
              <div class="music-time" style="margin-left: 88%">
                {{ musicTime }}
              </div>
            </div>
            <div>
              <div
                v-show="pauseVisible"
                title="播放|暂停"
                style="margin-left: 28px"
                class="el-icon-video-pause icon1"
                @click="playOrPause"
              ></div>
              <div
                v-show="playVisible"
                title="播放|暂停"
                style="margin-left: 28px"
                class="el-icon-video-play icon1"
                @click="playOrPause"
              ></div>
            </div>
          </div>
        </div>
      </div>
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
import axios from "axios";
export default {
  name: "playmusic",
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
      musicURL: "",
      musicName: "曹操",
      totalTime: 0,
      typePic: "https://s2.loli.net/2022/05/08/4tzFr2R1wcVL37G.png",

      // 定时播放相关
      clock: "",
      timer: "",
    };
  },
  created() {
    this.song_id = localStorage.getItem("bgm_value");
    console.log(this.fileUrl)
    if (this.fileUrl === ""||typeof(this.fileUrl)==="undefined") {
      console.log("为空");
      axios
        .get(
          "http://localhost:8089/audio/find/mp3/byid" +
            "?bgm_value=" +
            this.song_id
        )
        .then((res) => {
          console.log(res);
          this.musicURL = res.data.audio_url;
        });
    } else this.musicURL = this.fileUrl;
  },
  mounted() {
    this.timer = setInterval(this.store, 700);
  },
  methods: {
    store() {
      // 创建一个定时器
      this.$store.commit("setCurrentSongId", this.song_id);
    },
    sleep(time) {
      return new Promise((resolve) => setTimeout(resolve, time));
    },
    // 定时
    countUp() {
      window.clearInterval(this.clock);
      // eslint-disable-next-line no-unused-vars
      let maxTime = 0;
      if (!isNaN(this.$refs.audio.duration)) {
        maxTime = Math.floor(this.$refs.audio.duration);
      } else return;
      this.clock = window.setInterval(() => {
        this.playProcess = this.playProcess + (1 / maxTime) * 100;
        this.resetTime();
        if (this.playProcess >= 100) {
          window.clearInterval(this.clock);
        }
      }, 1000);
    },
    // 拖动进度条播放音乐
    flushPlay(process) {
      this.playProcess = process;
      if (!isNaN(this.$refs.audio.duration)) {
        this.$refs.audio.currentTime =
          process * 0.01 * this.$refs.audio.duration;
        this.resetTime();
      }
    },
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
      this.countUp();
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
.song-card {
  margin-top: -12px;
  margin-left: -11px;
  height: 85px;
  width: 85px;
  filter: drop-shadow(8px 8px 10px powderblue);
}
.card {
  background: rgba(255, 255, 255, 0.158);
  filter: alpha(opacity: 0.3);
  display: flex;
  flex-direction: row;
  border-radius: 10px;
  height: 100px;
}
.process-card {
  margin-left: 9px;
  float: left;
  width: 600px;
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
