<template>
  <div class="hall">
    <!-- 粒子特效 -->
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
    <el-row>
      <el-input
        v-model="search"
        placeholder="请输入音乐名"
        style="margin: 15px 10px 15px 10px; width: 45%"
      ></el-input>
      <el-button
        type="primary"
        plain
        style="width: 5%"
        @click="searchByAudioName"
        >搜索</el-button
      >
      <el-button type="primary" plain style="width: 10%" @click="getAll"
        >查看全部歌曲</el-button
      >
    </el-row>
    <el-table
      :data="tableData"
      stripe
      style="width: 60%; margin: auto; border-radius: 10px 10px 10px 10px"
    >
      <el-table-column type="expand">
        <template #default="props">
          <el-descriptions
            title="详细信息"
            style="margin-top: 10px; margin-left: 60px"
          >
            <el-descriptions-item label="音乐描述">{{
              props.row.des
            }}</el-descriptions-item>
          </el-descriptions>
        </template>
      </el-table-column>
      <el-table-column prop="audioName" label="歌曲名称"> </el-table-column>
      <el-table-column prop="apubAuthor.userName" label="创作歌手" />
      <el-table-column prop="createTime" label="歌曲发布时间" sortable />
      <el-table-column label="操作" align="center">
        <template slot-scope="scope">
          <el-tooltip
            class="item"
            effect="light"
            content="在线播放"
            placement="top"
          >
            <el-button
              type="success"
              icon="el-icon-headset"
              plain
              circle
              style="margin: 5px"
              @click="playMusic(scope.row.audioUrl)"
            ></el-button>
          </el-tooltip>
          <el-tooltip
            class="item"
            effect="light"
            content="下载歌曲"
            placement="top"
          >
            <el-button
              type="success"
              icon="el-icon-download"
              style="margin: 5px"
              @click="downloadMusic(scope.row.audioUrl, scope.row.audioName)"
              plain
              circle
            ></el-button>
          </el-tooltip>
          <el-tooltip
            class="item"
            effect="light"
            content="添加至收藏夹"
            placement="top"
          >
            <el-button
              type="warning"
              icon="el-icon-plus"
              circle
              style="margin: 5px"
              @click="
                (showCollectionDialog = true), (musicChosenId = scope.row.id)
              "
            ></el-button>
          </el-tooltip>
        </template>
      </el-table-column>
    </el-table>

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
          v-for="(item, index) in myCollection"
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
  </div>
</template>


<script>
export default {
  data() {
    return {
      search: "", //搜索名称
      tableData: [], //展示信息
      allData: [], //所有音乐内容
      showCollectionDialog: false, //显示收藏夹的弹窗
      myCollection: [], //我的收藏夹
      musicChosenId: "", //被选中的收藏夹
    };
  },
  methods: {
    //获取全部过审音乐
    getAll() {
      this.axios
        .post("http://localhost:8088/ShareMusic/AllPass")
        .then((response) => {
          console.log("getAll", response.status);
          this.allData = response.data;
          this.tableData = response.data;
        });
    },
    //获取用户收藏夹
    getMyCollection() {
      this.axios
        .get("http://localhost:8088/Collection/GetByOwner", {
          params: { ownerId: sessionStorage.getItem("userId") },
          crossDomain: true,
        })
        .then((response) => {
          console.log("myCollection", response.data);
          this.myCollection = response.data;
        });
    },
    //通过歌曲名称搜索音乐
    searchByAudioName() {
      this.axios({
        method: "post",
        url: "http://localhost:8088/ShareMusic/Search",
        params: {
          audioName: this.search,
        },
      }).then((res) => {
        console.log("SearchResult", res.data);
        this.tableData = res.data;
        if (res.status == 200) {
          this.$message({
            type: "success",
            message: "搜索成功~",
          });
        } else {
          this.$message({
            type: "error",
            message: "搜索失败~",
          });
        }
      });
    },
    //跳转播放
    playMusic(url) {
      window.open(url, "_blank");
    },
    //下载音乐
    downloadMusic(url, name) {
      window.open(url + "?attname=" + name + ".mp3", "_blank");
    },
    //添加音乐至收藏夹
    addToCollection(id) {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Collection/AddMusic",
        data: {
          acCollectionId: id,
          acAudioId: this.musicChosenId,
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
  },

  mounted() {
    this.getAll();
    this.getMyCollection();
  },
};
</script>
<style  scoped>
/* 卡片样式 */
.clearfix:before,
.clearfix:after {
  display: table;
  content: "";
}
.clearfix:after {
  clear: both;
}

.el-card {
  min-width: 100%;
  height: 100%;
  margin-right: 20px;
  margin-bottom: 20px;
  transition: all 0.5s;
}
/* 卡片样式结束 */
.user-bg {
  position: fixed;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
  background: url("../assets/bg.jpeg");
}
.el-carousel__item h3 {
  color: #475669;
  font-size: 18px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
  text-align: center;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n + 1) {
  background-color: #d3dce6;
}
.home {
  margin-left: 5%;
  margin-right: 5%;
  border-radius: 10px;
}
.banner_img {
  /*设置图片宽度和浏览器宽度一致*/
  width: 100%;
  height: inherit;
}
.el-scrollbar__wrap {
  overflow-x: hidden;
  overflow-y: hidden;
}
.back {
  margin-left: 10%;
  margin-right: 10%;
  border-radius: 20px;
}
.setHeight {
  overflow: hidden;

  -webkit-line-clamp: 1;
  display: -webkit-box;
  -webkit-box-orient: vertical;
  text-overflow: ellipsis;
}
.tag {
  width: 100%;
  height: 100%;
  color: white;
  background-image: url("../assets/music_bg.jpg");
  cursor: pointer;
  line-height: 200px;
}

.el-carousel__item--card.is-in-stage {
  height: 100px;
  width: 100px;
}
</style>
<style lang="scss" scoped>
// @import '../styles/base.scss';
$font-size-huge: 20px;

.swiper {
  height: 200px;
  width: 100%;

  .swiper-slide {
    display: flex;
    // justify-content: center;
    // align-items: center;
    // text-align: center;
    font-weight: bold;
    font-size: $font-size-huge * 2;
    cursor: pointer;

    // background-image: url("../assets/music_bg.jpg");
  }
}
$container-width: 300px;
@media (max-width: $container-width) {
  .swiper-button-next {
    right: 20px;
    transform: rotate(90deg);
  }

  .swiper-button-prev {
    left: 20px;
    transform: rotate(90deg);
  }
}
</style>