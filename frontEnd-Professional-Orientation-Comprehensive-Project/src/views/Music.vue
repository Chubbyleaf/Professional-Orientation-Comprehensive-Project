<template>
  <div class="headerBack">
    <vue-particles
      class="user-bg"
      color="#fff"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="circle"
      :particleSize="4"
      linesColor="#fff"
      :linesWidth="2"
      :lineLinked="true"
      :lineOpacity="0.4"
      :linesDistance="150"
      :moveSpeed="2"
      :hoverEffect="true"
      hoverMode="grab"
      :clickEffect="true"
      clickMode="push"
    ></vue-particles>
    <el-container class="header-sheet">
      <el-main>
        <el-container>
          <el-header>
            <p
              style="
                color: white;
                font: 28px Microsoft YaHei;
                float: left;
                margin-left: 10px;
              "
            >
              {{ audio.audioName }}
            </p>
          </el-header>
          <el-main>
            <el-row>
              <el-col :span="2" v-for="tag in audio.tagList" :key="tag.tagId">
                <el-button
                  size="medium"
                  round
                  style="background: rgba(217, 254, 255, 0.1); color: white"
                  >{{ tag.tagName }}
                </el-button>
              </el-col>
            </el-row>
            <el-row>
              <p
                style="
                  width: fit-content;
                  padding: 10px;
                  border-radius: 5px;
                  background: rgba(255, 255, 255, 0.25);
                  color: blanchedalmond;
                  font: 15px Microsoft YaHei;
                "
              >
                &nbsp;&nbsp;{{ audio.des }}
              </p>
            </el-row>
            <el-row :gutter="20" style="margin-top: 3%">
              <el-col :offset="14" :span="2">
                <el-button
                  size="medium"
                  round
                  style="background: rgba(217, 254, 255, 0.1); color: white"
                  @click="handleDown()"
                  >下载
                </el-button>
              </el-col>
              <el-col :span="2">
                <el-button
                  size="medium"
                  round
                  style="background: rgba(217, 254, 255, 0.1); color: white"
                  @click="
                showCollectionDialog = true "
                  >收藏
                </el-button>
                 <!-- 显示收藏夹 -->
    <el-dialog
      title="请选择收藏夹"
      :visible="showCollectionDialog"
      :append-to-body="true"
      @close="showCollectionDialog = false"
      width="50%"
    >
      <el-row :gutter="20" class="el-row">
        <el-col
          :span="8"
          v-for="(item, index) in myCollect"
          :key="item.id"
          class="el-col"
        >
          <el-card class="el-card" :key="index">
            <div slot="header" class="clearfix" style="text-align: center">
              <span> {{ item.collectionName }}</span>
            </div>
            <img
              :src="
                item.identity == 0
                  ? require('../assets/public.jpg')
                  : require('../assets/private.jpg')
              "
              style="width: 180px; height: 180px"
              class="image"
              @click="(showCollectionDialog = true), addToCollection(item.id)"
            />
          </el-card>
        </el-col>
      </el-row>
    </el-dialog>
                <!-- <el-dialog
                  :visible.sync="collectDialog"
                  title="选择合集"
                  center
                  width="300px"
                >
                  <el-select v-model="collect_id">
                    <el-option
                      v-for="i in myCollect"
                      :key="i.id"
                      :label="i.collectionName"
                      :value="i.id"
                    >
                    </el-option>
                  </el-select>
                  <div slot="footer" class="dialog-footer">
                    <el-button @click="collectDialog = false">取消</el-button>
                    <el-button type="primary" @click="addAudioToCollect()"
                      >确定
                    </el-button>
                  </div>
                </el-dialog> -->
              </el-col>
              <el-col :span="2">
                <el-button
                  size="medium"
                  round
                  style="background: rgba(217, 254, 255, 0.1); color: white"
                  @click="copyTemplate()"
                  >分享
                </el-button>
              </el-col>
            </el-row>
          </el-main>
        </el-container>
      </el-main>
      <el-aside>
        <img
          :src="audio.avatarUrl"
          class="avatar-img"
          @click="toUser(audio.apubAuthorId)"
        />
        <div
          style="
            color: white;
            font: 15px Microsoft YaHei bold;
            margin: 10px 10px;
            margin-left: 30px;
            text-align: left;
          "
        >
          作者：{{ audio.authorName }}
          <br />
          上传时间：{{ parseTime(audio.createTime) }}
        </div>
      </el-aside>
    </el-container>
    <div class="audio_info">
      <img
        :src="audio.imgUrl"
        referrerPolicy="no-referrer"
        style="border: 5px; width: 250px; height: 200px; object-fit: cover"
      />
      <div class="audio_control">
        <div class="playorpause" @click="playorpause()">
          <i v-if="status == 0" class="el-icon-video-play"></i>
          <i v-else class="el-icon-video-pause"></i>
        </div>

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
        </div>

        <audio
          id="audio"
          preload="metadata"
          v-show="false"
          :src="audio.audioUrl"
          controls="controls"
          ref="audio"
        ></audio>
      </div>
    </div>

    <div
      style="
        height: auto;
        width: 100%;
        padding: 10px 0px;
        background-color: rgba(255, 255, 255, 0.75);
      "
    >
      <div
        style="
          width: 100%;
          margin-left: 20px;
          padding-top: 20px;
          text-align: left;
          font-size: 20px;
          font-weight: 500;
        "
      >
        <i class="el-icon-s-comment"></i> 发表新的评论：
      </div>
      <br />
      <div style="width: 95%; margin: auto">
        <el-input
          type="textarea"
          :autosize="{ minRows: 6 }"
          placeholder="请输入评论内容"
          v-model="commentContent"
        >
        </el-input>
      </div>

      <div>
        <br />

        <el-button type="primary" style="width: 20%" @click="submitComment()"
          >发表
        </el-button>
      </div>
    </div>
    <div class="comments">
      <span style="margin-left: 20px; font-weight: bold; font-size: 20px"
        >{{ commentList.length }} 条评论</span
      >
      <div
        class="each_comment"
        v-for="item in commentList"
        :key="item.commentId"
      >
        <img
          :src="item.avatarUrl"
          class="comment-user-img"
          @click="toUser(item.comOwnerId)"
        />
        <div style="display: flex; flex-direction: column; text-align: left">
          <span
            style="
              color: rgb(40, 40, 40);
              font: 16px Microsoft YaHei;
              margin-bottom: 2px;
            "
          >
            {{ item.userName }}
          </span>
          <span style="color: rgb(150, 150, 150); font: 13px Microsoft YaHei">
            {{ parseTime(item.createTime) }}
          </span>
          <span
            style="
              color: rgb(40, 40, 40);
              font: 16px Microsoft YaHei;
              margin-top: 15px;
            "
          >
            {{ item.content }}
          </span>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
import TagList from "@/components/TagList.vue";

export default {
  components: {
    TagList,
  },
  data() {
    return {
      userId: "",
      audioId: "",
      audio: "",
      collectDialog: false,
      collect_id: "",
      // 基本信息
      playProcess: 0,
      musicCurrentTime: "0:00",
      musicTime: "--:--",

      song_id: "21",
      musicName: "曹操",
      totalTime: 0,
      typePic: "https://s2.loli.net/2022/05/08/4tzFr2R1wcVL37G.png",

      // 定时播放相关
      clock: "",
      timer: "",

      showCollectionDialog:false,

      
      audio_cover: require("../assets/1.jpg"),
      user_cover: require("../assets/6.jpg"),
      upload_cover: require("../assets/7.jpg"),
      user_id: "",
      audio_id: "",
      down_url: "",
      display_url: "",
      audioTag: [
        { id: 1, labelName: "奇幻" },
        { id: 2, labelName: "冥想" },
      ],
      audioInfo: {
        audioName: "冥想者",
        des: "路飞躺在在三角钢琴上，枕着脑袋，望着天花板，静静的听布鲁克弹唱这首歌，歌声结束时候路飞说“来我的船上吧”布鲁克没有任何犹豫回答了“好”。",
        authorName: "李佳颖",
        authorId: "123",
        uploadUserPhoto:
          "https://tse1-mm.cn.bing.net/th/id/R-C.acd9f2c78fae3c156705201f575172fa?rik=QgJxactB%2fHuh6g&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2f41b8bdd8-ee3d-49b6-957a-e35141af8d61.jpg&ehk=JDC%2fO6zFqUhes3vx%2bXJgAHGfAyg509NZnDa%2fjOE%2b29E%3d&risl=&pid=ImgRaw&r=0",
        createTime: "2070年1月1日",
        cover:
          "https://gitee.com/pinkcrow/hexo_img/raw/master/img/image-20210829211448542.png",
      },
      commentList: [
        {
          commentId: "116",
          photoUrl:
            "https://tse1-mm.cn.bing.net/th/id/R-C.acd9f2c78fae3c156705201f575172fa?rik=QgJxactB%2fHuh6g&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2f41b8bdd8-ee3d-49b6-957a-e35141af8d61.jpg&ehk=JDC%2fO6zFqUhes3vx%2bXJgAHGfAyg509NZnDa%2fjOE%2b29E%3d&risl=&pid=ImgRaw&r=0",
          userName: "李佳颖",
          content: "妙哉妙哉",
          createTime: "2070年1月2日12:33",
        },
        {
          commentId: "117",
          photoUrl:
            "https://tse1-mm.cn.bing.net/th/id/R-C.acd9f2c78fae3c156705201f575172fa?rik=QgJxactB%2fHuh6g&riu=http%3a%2f%2fimage.bamen.bbs.bamenzhushou.com%2f41b8bdd8-ee3d-49b6-957a-e35141af8d61.jpg&ehk=JDC%2fO6zFqUhes3vx%2bXJgAHGfAyg509NZnDa%2fjOE%2b29E%3d&risl=&pid=ImgRaw&r=0",
          userName: "李佳颖",
          content: "妙哉妙哉",
          createTime: "2070年1月2日12:33",
        },
      ],
      tagList: [],
      commentContent: "",
      score: 0,
      myCollect: [],
      status: 0,
      currentTime: 0,
      currentDuration: "00:00:00",
      percent: 0,
      duration: "00:00:00",
      second: 365,
      /*playerOptions: {
        aspectRatio: "16:9", // 将播放器置于流畅模式，并在计算播放器的动态大小时使用该值。值应该代表一个比例 - 用冒号分隔的两个数字（例如"16:9"或"4:3"）
        sources: [
          {
            // 播放资源和资源格式
            type: "video/mp3",
            src: "http://r3tw40sg8.hd-bkt.clouddn.com/test4379996365", //你的视频地址（必填）
          },
        ],
      },*/
    };
  },
  methods: {
    displayAudio() {},
    handleDown() {
      // window.location.href=this.audio.audioUrl;
      const url = this.audio.audioUrl;
      const a = document.createElement("a");
      fetch(url)
        .then((res) => res.blob())
        .then((blob) => {
          // 将链接地址字符内容转变成blob地址
          a.href = URL.createObjectURL(blob);
          console.log(a.href);
          a.download = `${this.audio.audioName}.mp3`;
          document.body.appendChild(a);
          a.click();
        });
    },
    handleCollect() {
      this.collectDialog = true;
    },
    // collectDialog(){},
     addToCollection(id) {
      this.$axios({
        method: "post",
        url: "http://localhost:8088/Collection/AddMusic",
        data: {
          acCollectionId: id,
          acAudioId: this.audioId,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.data.status == 1) {
          this.$message({
            type: "success",
            message: "添加成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "添加失败，歌曲已存在！",
          });
        }
      });
    },
    addAudioToCollect(){
      console.log(this.collect_id)
      this.$axios.post("http://localhost:8088/Collection/AddMusic",{
      acAudioId:this.audioId,
      acCollectionId:this.collect_id
      }).then(res=>{
        this.$message({
        message: "收藏成功",
        type: "success",
      });
      })
      .catch(res=>{
        this.$message.error("收藏失败");
      })
    },
    copyTemplate() {
      console.log("url==" + window.location.href);
      this.copyToClipboard(window.location.href); // 需要复制的文本内容
      this.$message.success("成功复制到剪贴板，快去粘贴分享吧!");
    },
    copyToClipboard(content) {
      if (window.clipboardData) {
        window.clipboardData.setData("text", content);
      } else {
        (function (content) {
          document.oncopy = function (e) {
            e.clipboardData.setData("text", content);
            e.preventDefault();
            document.oncopy = null;
          };
        })(content);
        document.execCommand("Copy");
      }
    },
    toUser(id) {
      this.$router.push({
        path: "/user",
        query: {
          userId: id,
        },
      });
    },
    submitComment(){
     
      this.$axios
        .post("http://localhost:9003/comment", {
          comAudioPublicId: this.audioId,
          comOwnerId: this.userId,
          content: this.commentContent,
          createTime: "",
        })
        .then((res) => {
          this.$message({
            message: "评论成功",
            type: "success",
          });
          this.commentContent = "";
          this.$axios
            .get(
              "http://localhost:9003/comment/selectCommentByAudioId?audioId=" +
                this.audioId
            )
            .then((response) => {
              this.commentList = response.data.data;
            });
        })
        .catch((res) => {
          this.$message.error("评论失败");
        });
    },

    playorpause() {
      if (this.status) {
        //暂停
        this.status = false;
        this.$refs.audio.pause();
        window.clearInterval(this.clock);
        this.resetTime();
      } else {
        //播放
        this.status = true;
        this.rePlay();
      }
    },
    progressClick(e) {
      const rect = this.$refs.progressBar.getBoundingClientRect();
      const offsetWidth = e.pageX - rect.left;
      this.$refs.progress.style.width = offsetWidth;
      this.$refs.progressBtn.style.left = offsetWidth;
      this.percent = offsetWidth / rect.width;
      this.$refs.maudio.currentTime = this.second * this.percent;
    },
    store() {
      // 创建一个定时器
      // this.$store.commit('setCurrentSongId', this.audioId)
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
      console.log("Replay");
      // 需要重新播放，可从中间开始

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
        this.$refs.audio.pause();
        window.clearInterval(this.clock);
        this.resetTime();
      } else {
        this.rePlay();
      }
    },
  },

  mounted() {
    this.userId = sessionStorage.getItem("userId");
    this.timer = setInterval(this.store, 700);

    this.audioId = this.$route.query.id;
    let url =
      "http://localhost:9003/audioPublic/selectFullAudioById?audioId=" +
      this.audioId;
    this.$axios.get(url).then((response) => {
      this.audio = response.data.data[0];

      console.log(this.$refs.audio);
      // console.log(response.data)
    });

    this.$axios
      .get("http://localhost:8088/Collection/GetByOwner", {
        params: { ownerId: this.userId },
        crossDomain: true,
      })
      .then((response) => {
        console.log("myCollection", response.data);
        this.myCollect = response.data;
      });

    this.$axios
      .get(
        "http://localhost:9003/comment/selectCommentByAudioId?audioId=" +
          this.audioId
      )
      .then((response) => {
        this.commentList = response.data.data;
      });
  },
};
</script>

<style scoped>
.user-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
  background: url("../assets/bg.jpeg");
  background-repeat: repeat-y;
}
.header-sheet {
  text-align: center;
  /*position: absolute;*/

  border-width: 1px;
  border-style: solid;
  border-color: transparent;
  background-image: url("../assets/music_bg.jpg");
  border-radius: 5px;
  /* height: 320px; */
}

.headerBack {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  margin-left: 2.3%;
  margin-right: 2.3%;
  margin-top: 0.5%;
  text-align: center;
  height: fit-content;
  border-radius: 5px;
}

.el-rate__icon {
  font-size: 10px;
  margin-right: 0;
}

.back {
  margin-top: 10%;
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 1px;
}

.main-sheet {
  margin: 10px;
  border-radius: 5px;
  background: rgba(255, 255, 255, 0.5);
}

.avatar-img {
  cursor: pointer;
  height: 150px;
  width: 150px;
  /* display: inline-block;
  position: relative; */
  margin-left: -100px;
  margin-top: 100px;
  /* margin: 10px 10px; */
  border-radius: 50%;
  overflow: hidden;
  border: 1px solid white;
  object-fit: cover;
}
.comment-user-img {
  cursor: pointer;
  height: 45px;
  width: 45px;
  display: inline-block;
  position: relative;
  margin-left: 20px;
  margin-right: 20px;
  border-radius: 50%;
  overflow: hidden;
  border: 1px solid white;
  object-fit: cover;
}
.audio_info {
  width: 100%;
  display: flex;
  margin: 0px;
  border-bottom: 3px dashed;
  background-color: rgba(255, 255, 255, 0.75);
  border-radius: 5px;
}

.comments {
  width: 100%;
  padding-bottom: 20px;
  text-align: left;
  background-color: rgba(255, 255, 255, 0.75);
}

.each_comment {
  display: flex;
  padding: 10px 0px;
  border-bottom: 1px solid rgb(197, 193, 193);
}

.audio_control {
  display: flex;
  width: 100%;
  margin: auto;
  line-height: 80px;
}

.playorpause {
  width: 80px;
  height: 80px;
  font-size: 50px;
  line-height: 80px;
  margin-top: 30px;
  text-align: center;
  overflow: hidden;
}

.song-card {
  margin-top: -12px;
  margin-left: -11px;
  height: 85px;
  width: 85px;
  filter: drop-shadow(8px 8px 10px powderblue);
}
.card {
  background: rgba(255, 255, 255, 0.158);
  /* filter:alpha(opacity:30); */
  display: flex;
  flex-direction: row;
  border-radius: 10px;
  height: 100px;
}
.process-card {
  margin-left: 9px;
  margin-top: 50px;
  float: left;
  width: 600px;
}
.music-time {
  float: left;
  color: currentColor;
}
.icon1 {
  margin-top: -90%;
  font-size: 40px;
  color: whitesmoke;
}
</style>
