<template>
  <div class="back">
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
    <el-container class="user-info">
      <el-main>
        <div
          style="
            padding-top: 200px;
            background-color: rgba(237, 240, 243, 0.37);
            border-radius: 10px;
          "
        >
          <el-col class="album-slide">
            <el-row>
              <el-col class="album-img" :span="12">
                <img
                  :src="this.user.avatarUrl"
                  @click="handleAvatar()"
                  style="cursor: pointer; width: 100%"
                />
                <el-dialog
                  title="上传头像"
                  :visible.sync="dialogVisible2"
                  width="30%"
                >
                  <el-form>
                    <el-form-item ref="uploadElement">
                      <el-upload
                        ref="avatarUpload"
                        action="#"
                        accept="image/png,image/gif,image/jpg,image/jpeg"
                        list-type="picture-card"
                        :limit="1"
                        :auto-upload="false"
                        :before-upload="handleBeforeUpload"
                        :on-preview="handlePictureCardPreview"
                        :on-remove="handleRemove"
                        :on-change="imgChange"
                        :class="{ hide: hideUpload }"
                      >
                        <i class="el-icon-plus"></i>
                      </el-upload>
                      <el-dialog :visible.sync="dialogVisible">
                        <img
                          width="100%"
                          style="alignment: center"
                          :src="dialogImageUrl"
                          alt=""
                        />
                      </el-dialog>
                    </el-form-item>
                    <el-form-item>
                      <el-button
                        size="small"
                        type="primary"
                        @click="uploadAvatar"
                        >立即上传
                      </el-button>
                      <el-button size="small" @click="tocancel"
                        >取消
                      </el-button>
                    </el-form-item>
                  </el-form>
                </el-dialog>
              </el-col>
              <el-col :span="6">
                <el-card class="to-do">
                  <div
                    style="
                      text-align: center;
                      font-size: 20px;
                      font-weight: 600;
                    "
                  >
                    {{ this.user.userName }}
                    <el-button
                      type="success"
                      size="mini"
                      v-if="isFollow === false && isOneself === false"
                      @click="followSomeone"
                      >关注</el-button
                    >
                    <el-button
                      type="danger"
                      size="mini"
                      v-if="isFollow === true && isOneself === false"
                      @click="cancleFollow"
                      >取关</el-button
                    >
                  </div>

                  <div class="divider"></div>
                  <el-row v-if="this.isOneself">
                    <el-popover placement="right" width="300" trigger="click">
                      <el-form :model="form" ref="form">
                        <el-form-item label="新用户名">
                          <el-input v-model="form.newName"></el-input>
                        </el-form-item>
                        <el-form-item label="新邮箱">
                          <el-input v-model="form.newMail"></el-input>
                        </el-form-item>
                        <el-form-item label="所在地">
                          <el-select
                            v-model="form.newAdd"
                            clearable
                            filterable
                            placeholder="请选择"
                          >
                            <el-option
                              v-for="item in areaOptions"
                              :key="item.value"
                              :label="item.label"
                              :value="item.value"
                            >
                            </el-option>
                          </el-select>
                        </el-form-item>
                        <el-form-item>
                          <el-button
                            style="display: block; margin: 0 auto"
                            type="primary"
                            @click="update()"
                            >提交
                          </el-button>
                        </el-form-item>
                      </el-form>
                      <el-button
                        slot="reference"
                        type="warning"
                        style="margin: 5px"
                        ><i class="el-icon-edit"></i>修改信息
                      </el-button>
                    </el-popover>
                    <el-popover placement="right" width="300" trigger="click">
                      <el-form
                        :model="updatePass"
                        :rules="rules"
                        ref="updatePass"
                      >
                        <el-form-item label="旧密码" prop="oldPass">
                          <el-input
                            v-model="updatePass.oldPass"
                            type="password"
                          ></el-input>
                        </el-form-item>
                        <el-form-item label="新密码" prop="newPass">
                          <el-input
                            v-model="updatePass.newPass"
                            type="password"
                          ></el-input>
                        </el-form-item>
                        <el-form-item label="再次输入新密码" prop="checkPass">
                          <el-input
                            v-model="updatePass.checkPass"
                            type="password"
                          ></el-input>
                        </el-form-item>

                        <el-form-item>
                          <el-button
                            style="display: block; margin: 0 auto"
                            type="primary"
                            @click="updatePassword()"
                            >提交
                          </el-button>
                        </el-form-item>
                      </el-form>

                      <el-button
                        slot="reference"
                        type="success"
                        style="margin: 5px"
                        ><i class="el-icon-edit"></i>修改密码
                      </el-button>
                    </el-popover>
                  </el-row>
                  <el-row v-if="isOneself" style="margin-top: 10px"> </el-row>
                  <el-row v-else>
                    <div
                      style="
                        text-align: center;
                        font-size: 15px;
                        font-weight: 300;
                      "
                    >
                      这个人很留下，什么都没懒
                    </div>
                  </el-row>
                </el-card>
              </el-col>
            </el-row>
            <el-row>
              <el-col :span="18">
                <el-card class="my-page">
                  <el-tabs v-model="activeTab">
                    <el-tab-pane
                      label="动态"
                      name="timeline"
                      @click="getUserData"
                    >
                      <div class="block">
                        <el-timeline>
                          <el-timeline-item
                            v-for="(item, index) of timeline"
                            :key="index"
                            :timestamp="item.timestamp"
                            placement="top"
                          >
                            <el-card>
                              <el-row>
                                <el-tooltip
                                  class="item"
                                  effect="light"
                                  content="修改分享"
                                  placement="top"
                                  v-if="isOneself"
                                >
                                  <el-button
                                    size="small"
                                    plain
                                    circle
                                    @click="editSharedMusicHelp(item)"
                                    ><i class="el-icon-edit"></i>
                                  </el-button>
                                </el-tooltip>
                                <el-tooltip
                                  class="item"
                                  effect="light"
                                  content="在线播放"
                                  placement="top"
                                >
                                  <el-button
                                    size="small"
                                    plain
                                    circle
                                    type="primary"
                                    @click="playMusic(item.audioUrl)"
                                  >
                                    <i class="el-icon-headset"></i>
                                  </el-button>
                                </el-tooltip>
                                <el-tooltip
                                  class="item"
                                  effect="light"
                                  content="删除动态，取消分享"
                                  placement="top"
                                  v-if="isOneself"
                                >
                                  <el-button
                                    size="small"
                                    plain
                                    circle
                                    type="danger"
                                    @click="deleteSharedMusic(item.id)"
                                    ><i class="el-icon-delete"></i>
                                  </el-button>
                                </el-tooltip>
                              </el-row>
                              <h4>{{ item.title }}</h4>
                              <p>{{ item.content }}</p>
                            </el-card>
                          </el-timeline-item>
                        </el-timeline>
                      </div>
                    </el-tab-pane>
                    <el-tab-pane
                      label="我的收藏"
                      name="collection"
                      @click="getMyCollection"
                    >
                      <el-row :gutter="20" class="el-row" type="flex">
                        <el-col
                          :span="6"
                          v-for="(item, index) in myCollection"
                          :key="item.id"
                          class="el-col"
                        >
                          <!--
                        <el-col :span="6" v-for="(item, index) in myCollection" :key="item.id" class="el-col">-->

                          <el-card class="el-card" :key="index" onclick="">
                            <div slot="header" class="clearfix">
                              <span> {{ item.collectionName }}</span>
                            </div>
                            <img
                              :src="
                                item.identity == 0
                                  ? require('../../assets/public.jpg')
                                  : require('../../assets/private.jpg')
                              "
                              style="
                                width: 180px;
                                height: 180px;
                                margin-bottom: 5px;
                              "
                              class="image"
                              @click="
                                (showCollectionDialog = true),
                                  showCollection(item.id),
                                  (collectionChosenId = item.id)
                              "
                            />
                            <el-button-group v-if="isOneself">
                              <el-button
                                type="warning"
                                @click="editCollectionHelp(item)"
                                plain
                                ><i class="el-icon-edit"></i>编辑
                              </el-button>
                              <el-popconfirm
                                @confirm="deleteCollection(item.id)"
                                title="确定删除？"
                                ><template #reference>
                                  <el-button type="warning" plain
                                    ><i class="el-icon-delete"></i>删除
                                  </el-button>
                                </template>
                              </el-popconfirm>
                            </el-button-group>
                          </el-card>
                        </el-col>
                        <el-col :span="6">
                          <el-card
                            class="box-card"
                            style="min-height: 200px"
                            align="middle"
                            onclick=""
                            v-if="isOneself"
                          >
                            <div class="el-card__body mid">
                              <el-button
                                icon="el-icon-circle-plus"
                                circle
                                @click="newCollectionDialog = true"
                                type="warning"
                                plain
                              ></el-button>
                              <el-button
                                style="margin-left: 5px; color: #505458"
                                type="text"
                                @click="newCollectionDialog = true"
                                >新建收藏夹</el-button
                              >
                            </div>
                          </el-card>
                        </el-col>
                      </el-row>
                    </el-tab-pane>

                    <el-tab-pane
                      v-if="isOneself"
                      label="个人仓库"
                      name="repository"
                      @click="getMyWarehouse"
                    >
                      <el-row :gutter="20" class="el-row" type="flex">
                        <el-col
                          :span="6"
                          v-for="(item, index) in myWarehouse"
                          :key="item.id"
                          class="el-col"
                        >
                          <el-card class="el-card" :key="index">
                            <div slot="header" class="clearfix">
                              <span> {{ item.warehouseName }}</span>
                            </div>
                            <img
                              src="../../assets/warehouse.jpg"
                              style="
                                width: 180px;
                                height: 180px;
                                margin-bottom: 5px;
                              "
                              class="image"
                              @click="
                                (showRepositoryDialog = true),
                                  showWarehouse(item.id),
                                  (warehouseChosenId = item.id)
                              "
                            />
                            <el-button-group>
                              <el-button @click="editWarehouseHelp(item)" plain
                                ><i class="el-icon-edit"></i>编辑
                              </el-button>
                              <el-popconfirm
                                @confirm="deleteWarehouse(item.id)"
                                title="确定删除？"
                                ><template #reference>
                                  <el-button plain
                                    ><i class="el-icon-delete"></i>删除
                                  </el-button>
                                </template>
                              </el-popconfirm>
                            </el-button-group>
                            <el-button
                              style="margin: 5px"
                              width="100px"
                              plain
                              type="primary"
                              @click="
                                warehouseChosen = item.id;
                                uploadMusicDialog = true;
                              "
                              ><i class="el-icon-folder-add"></i
                              >点击上传您的音乐
                            </el-button>
                          </el-card>
                        </el-col>
                        <el-col :span="6">
                          <el-card
                            class="box-card"
                            style="min-height: 200px"
                            align="middle"
                          >
                            <div class="el-card__body mid">
                              <el-button
                                icon="el-icon-circle-plus"
                                circle
                                @click="newRepositoryDialog = true"
                                type="primary"
                                plain
                              ></el-button>
                              <el-button
                                style="margin-left: 5px; color: #505458"
                                type="text"
                                @click="newRepositoryDialog = true"
                                >新建仓库</el-button
                              >
                            </div>
                          </el-card>
                        </el-col>
                      </el-row>
                    </el-tab-pane>
                  </el-tabs>
                </el-card>
              </el-col>
              <el-col :span="6">
                <el-container class="my-info">
                  <el-form>
                    <div
                      style="
                        text-align: left;
                        font-size: 20px;
                        font-weight: 600;
                      "
                    >
                      用户信息
                    </div>
                    <div class="divider"></div>
                    <el-col>
                      <el-form-item class="tableText"
                        ><i class="el-icon-view">关注</i
                        >&nbsp;&nbsp;&nbsp;&nbsp;
                        <el-button
                          @click="toFollow"
                          type="text"
                          class="title-font"
                          >{{ user.myFollowNum }}</el-button
                        >
                      </el-form-item>
                      <el-form-item class="tableText"
                        ><i class="el-icon-user">粉丝</i
                        >&nbsp;&nbsp;&nbsp;&nbsp;
                        <el-button
                          @click="toFollower"
                          class="title-font"
                          type="text"
                        >
                          {{ user.myFollowerNum }}</el-button
                        >
                      </el-form-item>
                      <el-form-item class="tableText"
                        ><i class="el-icon-video-play">分享的音乐</i
                        >&nbsp;&nbsp;&nbsp;&nbsp;
                        {{ user.myPublicAudioNum }}
                      </el-form-item>

                      <el-form-item class="tableText"
                        ><i class="el-icon-time">加入时间</i> &nbsp;&nbsp;{{
                          this.user.createTime.slice(
                            0,
                            this.user.createTime.indexOf("T")
                          )
                        }}
                      </el-form-item>
                      <el-form-item class="tableText"
                        ><i class="el-icon-school">所在地</i> &nbsp;&nbsp;{{
                          user.address
                        }}
                      </el-form-item>
                    </el-col>
                  </el-form>
                </el-container>
              </el-col>
            </el-row>
          </el-col>
        </div>
      </el-main>
    </el-container>

    <!-- 一些弹出框 -->
    <!-- 上传音乐至个人仓库 -->
    <el-dialog
      title="上传音乐至仓库"
      :visible="uploadMusicDialog"
      :append-to-body="true"
      @close="uploadMusicDialog = false"
    >
      <el-form style="width: 400px">
        <el-form-item>
          <el-alert
            title="提示：您可以上传的音乐文件类型为【MP3】~"
            type="warning"
            :closable="false"
          />
        </el-form-item>
        <el-form-item label="请上传音乐">
          <el-upload
            ref="upload"
            class="upload-demo"
            accept=".mp3,.MP3"
            action="#"
            :limit="1"
            :http-request="beforeUploadHelp"
            :auto-upload="false"
          >
            <el-button style="margin: 5px" width="100px" plain
              ><i class="el-icon-folder-add"></i>从本地选择音乐
            </el-button>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button style="margin: 10px" type="primary" @click="uploadMusic"
              >上传
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="primary"
              plain
              @click="uploadMusicDialog = false"
              >取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>
    <!-- 新建收藏夹 -->
    <el-dialog
      title="新建收藏夹"
      :visible="newCollectionDialog"
      :append-to-body="true"
      @close="newCollectionDialog = false"
    >
      <el-form :data="userCollection" style="width: 400px">
        <el-form-item label="收藏夹名称">
          <el-input v-model="inputName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item label="收藏夹权限">
          <el-select
            v-model="inputAuthority"
            placeholder="请选择"
            style="width: 400px"
          >
            <el-option
              v-for="item in collectionAuthority"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button
              style="margin: 10px"
              type="success"
              @click="createCollection"
              >创建
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="warning"
              @click="newCollectionDialog = false"
              >取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 新建仓库 -->
    <el-dialog
      title="新建仓库"
      :visible="newRepositoryDialog"
      :append-to-body="true"
      @close="newRepositoryDialog = false"
    >
      <el-form style="width: 400px">
        <el-form-item label="仓库名称">
          <el-input v-model="inputName" autocomplete="off"></el-input>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button
              style="margin: 10px"
              type="success"
              @click="createWarehouse"
              >创建
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="warning"
              @click="newRepositoryDialog = false"
              >取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 修改分享的音乐 -->
    <el-dialog
      title="修改分享的音乐"
      :visible="editSharedMusicDialog"
      :append-to-body="true"
      @close="(editSharedMusicDialog = false), (musicSharedInfo = [])"
    >
      <el-form :model="musicSharedInfo" style="width: 400px">
        <el-form-item label="音乐名称">
          <el-input
            v-model="musicSharedInfo.audioName"
            autocomplete="off"
            placeholder="请输入修改后的音乐名称"
          ></el-input>
        </el-form-item>
        <el-form-item label="音乐描述">
          <el-input
            v-model="musicSharedInfo.description"
            autocomplete="off"
            placeholder="请输入就该后的音乐描述"
          ></el-input>
        </el-form-item>
        <el-form-item label="二创/下载权限">
          <el-select
            v-model="musicSharedInfo.identity"
            placeholder="请选择"
            style="width: 400px"
          >
            <el-option
              v-for="item in downloadAuthority"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button
              style="margin: 10px"
              type="success"
              @click="editSharedMusic"
              >点击修改
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="warning"
              @click="(editSharedMusicDialog = false), (musicSharedInfo = [])"
              >取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 分享音乐的弹窗 -->
    <el-dialog
      title="请填写以下信息分享音乐"
      :visible="shareMusicDialog"
      :append-to-body="true"
      @close="(shareMusicDialog = false), (musicSharedInfo = [])"
    >
      <el-alert
        title="请分享自己创作的音乐哦~"
        type="warning"
        :closable="false"
      />
      <el-form :model="musicSharedInfo" style="width: 400px">
        <el-form-item label="音乐名称">
          <el-input
            v-model="musicSharedInfo.audioName"
            autocomplete="off"
            placeholder="请输入音乐名称"
          ></el-input>
        </el-form-item>

        <el-form-item label="音乐描述">
          <el-input
            v-model="musicSharedInfo.description"
            autocomplete="off"
            placeholder="请输入音乐描述"
          ></el-input>
        </el-form-item>
        <el-form-item label="二创/下载权限">
          <el-select
            v-model="musicSharedInfo.identity"
            placeholder="请选择权限"
            style="width: 400px"
          >
            <el-option
              v-for="item in downloadAuthority"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="音乐标签">
          <el-select
            v-model="inputTags"
            multiple
            placeholder="请选择音乐标签"
            @change="$forceUpdate()"
            style="width: 400px"
          >
            <el-option
              v-for="item in allTags"
              :key="item.tagId"
              :label="item.tagName"
              :value="item.tagId"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="选择音乐封面">
          <el-upload
            ref="upload"
            class="upload-demo"
            accept=".jpg,.png"
            action="#"
            :limit="1"
            :http-request="beforeUploadHelp"
            :auto-upload="false"
          >
            <el-button style="margin: 5px" width="100px" plain type="waring"
              ><i class="el-icon-folder-add"></i>从本地选择图片
            </el-button>
          </el-upload>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button style="margin: 10px" type="success" @click="shareMusic"
              >分享
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="warning"
              @click="(shareMusicDialog = false), (musicSharedInfo = [])"
            >
              取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 修改收藏夹 -->
    <el-dialog
      title="修改收藏夹信息"
      :visible="editCollectionDialog"
      :append-to-body="true"
      @close="editCollectionDialog = false"
    >
      <el-form style="width: 400px">
        <el-form-item label="收藏夹名称">
          <el-input
            v-model="inputName"
            autocomplete="off"
            placeholder="请输入修改后的仓收藏夹名称"
          ></el-input>
        </el-form-item>
        <el-form-item label="收藏夹权限">
          <el-select
            v-model="inputAuthority"
            placeholder="请选择"
            style="width: 400px"
          >
            <el-option
              v-for="item in collectionAuthority"
              :key="item.value"
              :label="item.label"
              :value="item.value"
            >
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button
              style="margin: 10px"
              type="success"
              @click="editCollection"
              >点击修改
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="warning"
              @click="editCollectionDialog = false"
              >取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 修改仓库 -->
    <el-dialog
      title="修改仓库信息"
      :visible="editRepositoryDialog"
      :append-to-body="true"
      @close="editRepositoryDialog = false"
    >
      <el-form style="width: 400px">
        <el-form-item label="仓库名称">
          <el-input
            v-model="inputName"
            autocomplete="off"
            placeholder="请输入修改后的仓库名称"
          ></el-input>
        </el-form-item>
        <el-form-item>
          <template>
            <el-button
              style="margin: 10px"
              type="success"
              @click="editWarehouse"
              >点击修改
            </el-button>
          </template>
          <template>
            <el-button
              style="margin: 10px"
              type="warning"
              @click="editRepositoryDialog = false"
              >取消
            </el-button>
          </template>
        </el-form-item>
      </el-form>
    </el-dialog>

    <!-- 显示收藏夹具体内容 -->
    <!-- 显示收藏夹具体内容 -->
    <el-dialog
      title="收藏夹内容"
      :visible="showCollectionDialog"
      :append-to-body="true"
      @close="showCollectionDialog = false"
      width="80%"
    >
      <el-table
        :data="
          collectionChosenData.slice(
            (currentPage - 1) * pagesize,
            currentPage * pagesize
          )
        "
        stripe
        style="width: 100%"
      >
        <el-table-column prop="audioName" label="歌曲名称" align="center">
          <template slot-scope="scope">
            <el-row>
              <img
                :src="scope.row.imgUrl"
                style="width: 40px; height: 40px; margin-left: 150px"
                class="image"
              />
              <p style="margin-left: 10px">{{ scope.row.audioName }}</p>
            </el-row>
          </template>
        </el-table-column>
        <el-table-column prop="userName" label="创作歌手" align="center" />
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
              content="下载歌曲,二次创作"
              placement="top"
              v-if="isOneself || scope.row.download == 0"
            >
              <el-button
                type="warning"
                icon="el-icon-download"
                style="margin: 5px"
                @click="downloadMusic(scope.row.audioUrl)"
                plain
                circle
              ></el-button>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="light"
              content="取消收藏"
              placement="top"
              v-if="isOneself"
            >
              <el-popconfirm
                @confirm="deleteFromCollection(scope.row.audioId)"
                title="确定从此收藏夹移除？"
              >
                <el-button
                  type="danger"
                  icon="el-icon-delete"
                  plain
                  circle
                  slot="reference"
                  style="margin: 5px"
                >
                </el-button>
              </el-popconfirm>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>
      <div class="pagination">
        <el-pagination
          :v-model:currentPage="currentPage"
          :page-size="5"
          layout="total, prev, pager, next, jumper"
          :total="collectionChosenData.length"
          @current-change="handleCurrentChange"
        >
        </el-pagination>
      </div>
    </el-dialog>

    <!-- 显示仓库具体内容 -->
    <el-dialog
      title="仓库内容"
      :visible="showRepositoryDialog"
      :append-to-body="true"
      @close="showRepositoryDialog = false"
      width="80%"
    >
      <el-alert
        title="请分享自己创作的音乐哦~"
        type="warning"
        :closable="false"
      />
      <el-table
        :data="
          warehouseChosenData.slice(
            (currentPage - 1) * pagesize,
            currentPage * pagesize
          )
        "
        stripe
        style="width: 100%"
      >
        <el-table-column prop="audioName" label="歌曲名称" align="center" />
        <el-table-column prop="createTime" label="创作时间" align="center" />
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
                type="warning"
                icon="el-icon-download"
                circle
                plain
                style="margin: 5px"
                @click="downloadMusic(scope.row.audioUrl, scope.row.audioName)"
              ></el-button>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="light"
              content="删除歌曲"
              placement="top"
            >
              <el-popconfirm
                @confirm="deleteFromWarehouse(scope.row.audioId)"
                title="确定从此仓库中移除？"
              >
                <el-button
                  type="danger"
                  icon="el-icon-delete"
                  circle
                  plain
                  slot="reference"
                  style="margin: 5px"
                >
                </el-button>
              </el-popconfirm>
            </el-tooltip>
            <el-tooltip
              class="item"
              effect="light"
              content="分享音乐，同时发布动态"
              placement="top"
            >
              <el-button
                type="primary"
                icon="el-icon-share"
                plain
                circle
                style="margin: 5px"
                @click="shareMusicHelp(scope.row.audioId)"
              ></el-button>
            </el-tooltip>
          </template>
        </el-table-column>
      </el-table>

      <div class="pagination">
        <el-pagination
          :v-model:currentPage="currentPage"
          :page-size="5"
          layout="total, prev, pager, next, jumper"
          :total="warehouseChosenData.length"
          @current-change="handleCurrentChange"
        >
        </el-pagination>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { json } from "body-parser";
import qs from "qs";

export default {
  data() {
    var validatePass = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请输入新密码"));
      } else {
        if (this.updatePass.checkPass !== "") {
          this.$refs.updatePass.validateField("checkPass");
        } else if (value == this.updatePass.oldPass) {
          callback(new Error("新密码不能与旧密码相同"));
        }
        callback();
      }
    };
    var validatePass2 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("请再次输入新密码"));
      } else if (value !== this.updatePass.newPass) {
        callback(new Error("两次输入密码不一致!"));
      } else {
        callback();
      }
    };
    var validatePass3 = (rule, value, callback) => {
      if (value === "") {
        callback(new Error("旧密码不能为空"));
      }
    };

    return {
      //分页
      currentPage: 1,
      pagesize: 5,
      isOneself: true,
      userCollectionBtn: false,
      uploadAudioBtn: false,
      dialogVisible: false, //图片预览弹窗
      dialogVisible2: false,
      hideUpload: false,
      dialogImageUrl: "",
      updateBtn: false,

      newCollectionDialog: false, //新建收藏夹弹出框
      newRepositoryDialog: false, //新建仓库弹出框
      editCollectionDialog: false, //修改收藏夹信息弹出框
      showCollectionDialog: false, //显示仓库内容的弹窗
      editRepositoryDialog: false, //修改个人仓库信息弹出框
      showRepositoryDialog: false, //显示仓库内容的弹窗
      editSharedMusicDialog: false, //修改分享音乐的弹窗
      shareMusicDialog: false, //修改分享音乐的弹窗
      uploadMusicDialog: false, //上传音乐的弹窗

      warehouseChosenId: "", //被选中的仓库
      collectionChosenId: "", //被选中的收藏夹

      collectionChosenData: [], //当前查看收藏夹的歌单
      warehouseChosenData: [], //当前查看仓库的歌单
      allTags: [], //所有的标签
      inputTags: [], //选择的标签

      //填写信息的一些东西：
      inputName: "",
      inputAuthority: "",
      inputId: "",

      userId: 1,
      form: {
        newMail: "",
        newName: "",
        newAdd: "",
      },
      updatePass: {
        oldPass: "",
        newPass: "",
        checkPass: "",
      },
      rules: {
        oldPass: [{ validator: validatePass3, trigger: "blur" }],
        newPass: [{ validator: validatePass, trigger: "blur" }],
        checkPass: [{ validator: validatePass2, trigger: "blur" }],
      },
      user: {
        userName: "世界上最可爱的熊祯琪",
        address: "shanghai",
        email: "1442391739xxx@qq.com",
        createTime: "2012",
        avatarUrl: require("../../assets/avatar.jpg"),
        myFollowNum: "0",
        myFollowerNum: "0",
        myPublicAudioNum: "0",
      },
      userAudio: {
        name: "",
        description: "",
      },
      userCollection: {
        name: "",
      },

      myCollection: [], //我的收藏夹
      myWarehouse: [], //我的仓库

      fileChosen: "", //选中的要上传的音乐,图片

      //收藏夹权限选择下拉框
      collectionAuthority: [
        {
          value: 0,
          label: "公开",
        },
        {
          value: 1,
          label: "仅个人可见",
        },
      ],
      //收藏夹权限选择下拉框
      downloadAuthority: [
        {
          value: 0,
          label: "允许下载，可进行二次创作",
        },
        {
          value: 1,
          label: "不允许下载，不可进行二次创作",
        },
      ],

      //修改分享音乐的基本信息
      musicSharedInfo: {
        audioId: "",
        //audioSign:"",
        audioName: "",
        description: "",
        identity: "",
      },
      areaOptions: [
        {
          value: "北京市",
          label: "北京市",
        },
        {
          value: "上海市",
          label: "上海市",
        },
        {
          value: "天津市",
          label: "天津市",
        },
        {
          value: "重庆市",
          label: "重庆市",
        },
        {
          value: "河北省",
          label: "河北省",
        },
        {
          value: "山西省",
          label: "山西省",
        },
        {
          value: "辽宁省",
          label: "辽宁省",
        },
        {
          value: "吉林省",
          label: "吉林省",
        },
        {
          value: "黑龙江省",
          label: "黑龙江省",
        },
        {
          value: "江苏省",
          label: "江苏省",
        },
        {
          value: "浙江省",
          label: "浙江省",
        },
        {
          value: "安徽省",
          label: "安徽省",
        },
        {
          value: "福建省",
          label: "福建省",
        },
        {
          value: "江西省",
          label: "江西省",
        },
        {
          value: "山东省",
          label: "山东省",
        },
        {
          value: "河南省",
          label: "河南省",
        },
        {
          value: "湖北省",
          label: "湖北省",
        },
        {
          value: "湖南省",
          label: "湖南省",
        },
        {
          value: "广东省",
          label: "广东省",
        },
        {
          value: "海南省",
          label: "海南省",
        },
        {
          value: "四川省",
          label: "四川省",
        },
        {
          value: "贵州省",
          label: "贵州省",
        },
        {
          value: "云南省",
          label: "云南省",
        },
        {
          value: "陕西省",
          label: "陕西省",
        },
        {
          value: "甘肃省",
          label: "甘肃省",
        },
        {
          value: "青海省",
          label: "青海省",
        },
        {
          value: "台湾省",
          label: "台湾省",
        },
        {
          value: "内蒙古自治区",
          label: "内蒙古自治区",
        },
        {
          value: "广西壮壮族自治区",
          label: "广西壮壮族自治区",
        },
        {
          value: "西藏自治区",
          label: "西藏自治区",
        },
        {
          value: "宁夏回族自治区",
          label: "宁夏回族自治区",
        },
        {
          value: "新疆维吾尔自治区",
          label: "新疆维吾尔自治区",
        },
      ],

      options: [],
      //动态的时间轴线
      timeline: [
        {
          id: "",
          audioName: "",
          identity: "",
          des: "",
          timestamp: "2022-01-01",
          title: "hi",
          content: "ni",
          audioUrl: "",
        },
      ],
      activeTab: "timeline",
      myAudio_cover: require("../../assets/avatar.jpg"),

      collectDialog: false,
      collect_id: "",
      audioList: [],
      createDialog: true,
      coverFile: "",
      audioFile: "",
      selectLabel: "",
      returnAudioId: "",
      isFollow: false,
    };
  },
  beforeRouteEnter: (to, from, next) => {
    next((vm) => {
      const currentId = sessionStorage.getItem("userId");
      //const currentId = 1003;
      console.log("currentId:" + currentId);
      console.log("router userId:" + vm.$route.query.userId);

      if (currentId !== null) {
        //vm.$store.state.isSignIn = true;
        vm.timeline = [];
        if (vm.$route.query.userId === undefined) {
          vm.userId = currentId;
        } else if (currentId != vm.$route.query.userId) {
          vm.userId = vm.$route.query.userId;
          vm.isOneself = false;
        } else vm.userId = vm.$route.query.userId;

        vm.getIsFollow(vm);
      } else {
        vm.$message({
          message: "尚未登录！跳转中...",
          type: "warning",
        });
        vm.$router.push("/login");
      }
    });
  },
  methods: {
    //分页
    handleCurrentChange(currentPage) {
      this.currentPage = currentPage;
    },
    //只能上传mp3的消息提示
    getUserData() {
      this.axios({
        method: "get",
        url: "/api/user/info",
        params: { userId: this.userId },
      }).then((res) => {
        console.log("getUserData", res);
        if (res.data.avatarUrl == null)
          res.data.avatarUrl = this.user.avatarUrl;
        this.user = res.data;
        let moment = {};
        let time = res.data.createTime.slice(
          0,
          res.data.createTime.indexOf(".")
        );
        moment["id"] = 0;
        moment["timestamp"] = time.replace("T", " ");
        moment["title"] = "TA加入了我们！";
        moment["content"] = "此刻，" + res.data.userName + "诞生啦！";
        //this.timeline.push(moment);
      });
      //获取用户分享过的音乐
      this.axios
        .get("http://localhost:8088/ShareMusic/SomeoneAll", {
          params: { ownerId: this.userId },
          crossDomain: true,
        })
        .then((res) => {
          let musicShared = res.data;
          this.user.myPublicAudioNum = res.data.length;
          console.log("musicShared", musicShared);
          for (var i in musicShared) {
            var obj = musicShared[i];
            let music = {};
            for (var key in obj) {
              if ((key = "id")) {
                music["id"] = obj[key];
              }
              if ((key = "audioName")) {
                music["title"] = "分享了音乐【" + obj[key] + "】";
                music["audioName"] = obj[key];
              }
              if ((key = "des")) {
                music["content"] = "您对此音乐的描述为【" + obj[key] + "】";
                music["des"] = obj[key];
              }
              if ((key = "createTime")) {
                music["timestamp"] = obj[key];
              }
              if ((key = "audioUrl")) {
                music["audioUrl"] = obj[key];
              }
              if ((key = "identity")) {
                music["identity"] = obj[key];
                if (obj[key] == 1) {
                  music["title"] += "，并设置为【不可】下载~";
                } else {
                  music["title"] += "，并设置为【可】下载~";
                }
              }
            }
            this.timeline.push(music);
          }
        });
    },
    //修改动态辅助函数
    editSharedMusicHelp(item) {
      this.editSharedMusicDialog = true;
      this.musicSharedInfo.audioId = item.id;
      this.musicSharedInfo.audioName = item.audioName;
      this.musicSharedInfo.description = item.des;
      this.musicSharedInfo.identity = item.identity;
    },

    //修改动态中分享的信息
    editSharedMusic() {
      this.axios({
        method: "post",
        url: "http://localhost:8088/ShareMusic/Edit",
        data: this.musicSharedInfo,
      }).then((res) => {
        console.log(res.status);
        if (res.status == 200) {
          this.timeline = [];
          this.musicSharedInfo = [];
          this.getUserData(); //刷新
          this.editSharedMusicDialog = false; //关闭弹出框
          this.$message({
            type: "success",
            message: "修改成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "修改失败！",
          });
        }
      });
    },

    //分享音乐的辅助函数
    shareMusicHelp(id) {
      this.musicSharedInfo.audioId = id;
      this.shareMusicDialog = true;
      console.log(this.musicSharedInfo.audioId);
    },

    //分享音乐至动态
    shareMusic() {
      console.log(this.inputTags.toString());

      this.$refs.upload.submit();
      let fd = new FormData(); //通过form数据格式来传
      fd.append("file", this.fileChosen);
      fd.append("audioId", this.musicSharedInfo.audioId);
      fd.append("audioName", this.musicSharedInfo.audioName);
      fd.append("description", this.musicSharedInfo.description);
      fd.append("identity", this.musicSharedInfo.identity);
      fd.append("tags", this.inputTags.toString());
      this.inputTags = [];
      this.axios.defaults.headers.post["Content-Type"] =
        "multipart/form-data;charset=UTF-8";
      this.axios({
        method: "post",
        url: "http://localhost:8088/ShareMusic",
        data: fd,
      }).then((res) => {
        console.log(this.musicSharedInfo.audioId);

        console.log(res.status);
        if (res.status == 200) {
          this.timeline = [];
          this.musicSharedInfo = [];
          this.getUserData(); //刷新
          this.shareMusicDialog = false; //关闭弹出框
          this.$message({
            type: "success",
            message: "分享成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "分享失败！",
          });
        }
      });
    },

    getIsFollow(vm) {
      //console.log("getIsFollowData", vm);
      this.axios({
        method: "post",
        url: "/api/user/isFollow",
        data: {
          meId: sessionStorage.getItem("userId"),
          myFollowId: vm.userId,
        },
      }).then((res) => {
        console.log("getIsFollow", res);
        if (res.data.data == true) this.isFollow = true;
      });
    },
    successTips(msg) {
      this.$message({
        message: msg,
        type: "success",
      });
    },
    failTips(msg) {
      this.$message.error(msg);
    },

    beforeUploadAudio(file) {
      console.log(file.type === "audio/mpeg");
      if (!(file.type === "audio/mpeg")) {
        this.$notify.warning({
          title: "警告",
          message: "请上传mp3音频格式文件！",
        });
      }
      this.audioFile = file;
    },
    beforeUploadCover(file) {
      if (
        !(
          file.type === "image/png" ||
          file.type === "image/jpg" ||
          file.type === "image/jpeg"
        )
      ) {
        this.$notify.warning({
          title: "警告",
          message: "封面请上传图片！",
        });
      }
      this.coverFile = file;
    },
    //上传头像前的控制
    handleBeforeUpload(file) {
      if (
        !(
          file.type === "image/png" ||
          file.type === "image/gif" ||
          file.type === "image/jpg" ||
          file.type === "image/jpeg"
        )
      ) {
        this.$notify.warning({
          title: "警告",
          message:
            "请上传格式为image/png, image/gif, image/jpg, image/jpeg的图片",
        });
      }
      let size = file.size / 1024 / 1024 / 2;
      if (size > 2) {
        this.$notify.warning({
          title: "警告",
          message: "图片大小必须小于2M",
        });
      }
      let fd = new FormData(); //通过form数据格式来传
      fd.append("file", file); //传文件
      fd.append("userId", "1003");
      this.axios.defaults.headers.post["Content-Type"] =
        "multipart/form-data;charset=UTF-8";
      this.axios.patch("/api/user/uploadAvatar", fd).then((res) => {
        console.log("uploadAvatar", res);
        switch (res.data.code) {
          case 200:
            this.dialogVisible = false;
            this.dialogVisible = false;
            this.$notify.info({
              title: "提示",
              message: "头像上传成功！跳转中...",
            });
            this.$router.go(0);
        }
      });
    },
    handleAvatar() {
      if (this.isOneself) this.dialogVisible2 = true;
    },

    handleRemove(file, fileList) {
      this.hideUpload = fileList.length >= this.limitNum;
    },
    imgChange(files, fileList) {
      this.hideUpload = fileList.length >= 1;
      if (fileList) {
        this.$refs.uploadElement.clearValidate();
      }
    },
    handleDeleteAudio(item) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteAudio(item);
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          document.execCommand("Refresh");
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消删除操作",
          });
        });
    },
    handleDeleteCoAudio(item) {
      this.$confirm("确认删除吗?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning",
      })
        .then(() => {
          this.deleteCoAudio(item);
          this.$message({
            type: "success",
            message: "删除成功!",
          });
          document.execCommand("Refresh");
        })
        .catch(() => {
          this.$message({
            type: "info",
            message: "取消删除操作",
          });
        });
    },

    handleManage(row) {
      this.collect_id = row.collectionId;
      this.getCoAudio();
      this.collectDialog = true;
    },

    //上传头像
    uploadAvatar() {
      this.$refs.avatarUpload.submit();
    },

    tocancel() {
      this.dialogVisible2 = false;
    },
    //更新个人信息
    update() {
      var temp = {};
      if (
        this.form.newAdd == "" &&
        this.form.newName == "" &&
        this.form.newMail == ""
      ) {
        this.failTips("表单不能为空");
        return;
      }
      if (this.form.newAdd == "") temp.newAdd = this.user.address;
      else temp.newAdd = this.form.newAdd;
      if (this.form.newName == "") temp.newName = this.user.userName;
      else temp.newName = this.form.newName;
      if (this.form.newMail == "") temp.newMail = this.user.email;
      else temp.newMail = this.form.newMail;

      this.axios({
        method: "post",
        url: "/api/user/updateUserInfo",
        data: {
          userId: this.userId,
          address: temp.newAdd,
          userName: temp.newName,
          email: temp.newMail,
        },
      }).then((res) => {
        console.log("updateInfo", res);
        switch (res.data.code) {
          case 2007:
            this.failTips("邮箱已被注册！");
            break;

          case 200:
            this.successTips("修改成功！跳转中...");
            this.$router.go(0);
        }
      });
    },
    //更新密码
    updatePassword() {
      if (this.updatePassword.oldPass != this.updatePassword.newPass) {
        this.message.warning("两次密码不一致！");
        return;
      }
      this.axios({
        method: "post",
        url: "/api/user/updatePassword",
        data: {
          userId: this.userId,
          oldPass: this.updatePass.oldPass,
          newPass: this.updatePass.newPass,
        },
      }).then((res) => {
        console.log("updatePass", res);
        switch (res.data.code) {
          case 2003:
            this.failTips("旧密码错误");
            break;

          case 200:
            this.successTips("修改成功！跳转中...");
            this.$router.go(0);
            this.updateBtn = false;
            this.$router.push({
              name: "User",
              path: "/user",
            });
        }
      });
    },
    //删除分享的音乐
    deleteSharedMusic(id) {
      this.axios({
        method: "post",
        url: "http://localhost:8088/ShareMusic/Delete",
        params: {
          id: id,
        },
      }).then((res) => {
        console.log("deleteShare", res.data);
        if (res.data.status == 1) {
          (this.timeline = []), this.getUserData(); //刷新
          this.$message({
            type: "success",
            message: "删除成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败！",
          });
        }
      });
    },

    followSomeone() {
      this.axios({
        method: "post",
        url: "http://localhost:9001/user/followSomeone",
        data: {
          meId: sessionStorage.getItem("userId"),
          myFollowId: this.userId,
        },
      }).then((res) => {
        console.log("followSomeone", res);
        switch (res.data.code) {
          case 200:
            this.successTips("关注成功！跳转中...");
            this.$router.go(0);
            this.updateBtn = false;
            this.$router.push({
              name: "User",
              path: "/user",
            });
        }
      });
    },
    cancleFollow() {
      this.axios({
        method: "post",
        url: "http://localhost:9001/user/cancelFollowSomeone",
        data: {
          meId: sessionStorage.getItem("userId"),
          myFollowId: this.userId,
        },
      }).then((res) => {
        console.log("cancleFollow", res);
        switch (res.data.code) {
          case 200:
            this.successTips("取关成功！跳转中...");
            this.$router.go(0);
            this.updateBtn = false;
            this.$router.push({
              name: "User",
              path: "/user",
            });
        }
      });
    },
    toConCollect(row) {
      this.$router.push({
        path: "/conCollect",
        query: {
          info: this.$Base64.encode(JSON.stringify(row.collectionId)),
          t: Date.now(),
        },
      });
    },
    toAudio(row) {
      this.$router.push({
        path: "/audio",
        query: {
          info: this.$Base64.encode(JSON.stringify(row.audioId)),
          t: Date.now(),
        },
      });
    },
    toFollow() {
      this.$router.push({
        path: "/follow",
        query: {
          id: this.userId,
          name: this.user.userName,
          url: this.user.avatarUrl,
        },
      });
    },
    toFollower() {
      this.$router.push({
        path: "/follower",
        query: {
          id: this.userId,
          name: this.user.userName,
          url: this.user.avatarUrl,
        },
      });
    },

    /**
     * 音乐管理
     */
    //获取所有音乐标签
    getAllTags() {
      this.axios
        .get("http://localhost:8088/ShareMusic/AllTags", {
          crossDomain: true,
        })
        .then((response) => {
          console.log("allTags", response.data);
          this.allTags = response.data;
        });
    },

    //获取该用户的仓库
    getMyWarehouse() {
      this.axios
        .get("http://localhost:8088/Warehouse/GetByOwner", {
          params: { ownerId: this.userId },
          crossDomain: true,
        })
        .then((response) => {
          console.log("myWarehouse", response.data);
          this.myWarehouse = response.data;
        });
    },
    //获取用户收藏夹
    getMyCollection() {
      this.axios
        .get("http://localhost:8088/Collection/GetByOwner", {
          params: { ownerId: this.userId },
          crossDomain: true,
        })
        .then((response) => {
          console.log("myCollection", response.data);
          if (this.isOneself) this.myCollection = response.data;
          else {
            this.myCollection = [];
            for (var i = 0; i < response.data.length; i++) {
              if (response.data[i].identity == 0)
                this.myCollection.push(response.data[i]);
            }
          }
        });
    },
    //新建仓库
    createWarehouse() {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Warehouse/Add",
        data: {
          ownerId: this.userId,
          warehouseId: "",
          warehouseName: this.inputName,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.data.status == 1) {
          this.inputName = "";
          this.getMyWarehouse(); //刷新
          this.newRepositoryDialog = false; //关闭弹出框
          this.$message({
            type: "success",
            message: "新建仓库成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "新建仓库失败！",
          });
        }
      });
    },
    //新建收藏夹
    createCollection() {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Collection/Add",
        data: {
          ownerId: this.userId,
          collectionId: "",
          collectionName: this.inputName,
          collectionIdentity: this.inputAuthority,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.data.status == 1) {
          this.inputName = "";
          this.inputAuthority = "";
          this.getMyCollection(); //刷新
          this.newCollectionDialog = false; //关闭弹出框
          this.$message({
            type: "success",
            message: "新建收藏夹成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "新建收藏夹失败！",
          });
        }
      });
    },
    //删除仓库
    deleteWarehouse(id) {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Warehouse/Delete",
        params: {
          warehouseId: id,
        },
      }).then((res) => {
        if (res.data.status == 1) {
          this.getMyWarehouse(); //刷新
          this.$message({
            type: "success",
            message: "删除成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败！",
          });
        }
      });
    },
    //删除收藏夹
    deleteCollection(id) {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Collection/Delete",
        params: {
          collectionId: id,
        },
      }).then((res) => {
        if (res.data.status == 1) {
          this.getMyCollection(); //刷新
          this.$message({
            type: "success",
            message: "删除成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败！",
          });
        }
      });
    },
    //修改的辅助函数
    editCollectionHelp(item) {
      this.inputId = item.id;
      this.inputName = item.collectionName;
      this.inputAuthority = item.identity;
      this.editCollectionDialog = true;
    },
    editWarehouseHelp(item) {
      this.inputId = item.id;
      this.inputName = item.warehouseName;
      this.editRepositoryDialog = true;
    },
    //修改仓库名称
    editWarehouse() {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Warehouse/Update",
        data: {
          ownerId: this.userId,
          warehouseId: this.inputId,
          warehouseName: this.inputName,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.data.status == 1) {
          this.inputName = "";
          this.getMyWarehouse(); //刷新
          this.editRepositoryDialog = false; //关闭弹出框
          this.$message({
            type: "success",
            message: "修改成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "修改失败！",
          });
        }
      });
    },
    //修改收藏夹名称、权限
    editCollection() {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Collection/Update",
        data: {
          ownerId: this.userId,
          collectionId: this.inputId,
          collectionName: this.inputName,
          collectionIdentity: this.inputAuthority,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.data.status == 1) {
          this.inputName = "";
          this.inputAuthority = "";
          this.getMyCollection(); //刷新
          this.editCollectionDialog = false; //关闭弹出框
          this.$message({
            type: "success",
            message: "修改成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "修改失败！",
          });
        }
      });
    },
    //查看某个仓库
    showWarehouse(id) {
      this.axios
        .get("http://localhost:8088/Warehouse/AllMusic", {
          params: { warehouseId: id },
          crossDomain: true,
        })
        .then((response) => {
          console.log("showWarehouse", response.data);
          this.warehouseChosenData = response.data;
        });
    },
    //查看某个收藏夹
    showCollection(id) {
      this.axios
        .get("http://localhost:8088/Collection/AllMusic", {
          params: { collectionId: id },
          crossDomain: true,
        })
        .then((response) => {
          console.log("showCollection", response.data);
          this.collectionChosenData = response.data;
        });
    },
    //从收藏夹删除音乐
    deleteFromCollection(id) {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Collection/DeleteMusic",
        data: {
          acCollectionId: this.collectionChosenId,
          acAudioId: id,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.status == 200) {
          this.showCollection(this.collectionChosenId); //刷新
          this.$message({
            type: "success",
            message: "删除成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败！",
          });
        }
      });
    },
    //从仓库删除音乐
    //从收藏夹删除音乐
    deleteFromWarehouse(id) {
      this.axios({
        method: "post",
        url: "http://localhost:8088/Warehouse/DeleteMusic",
        data: {
          awWarehouseId: this.warehouseChosenId,
          awAudioPrivateId: id,
        },
      }).then((res) => {
        console.log(res.data);
        if (res.status == 200) {
          this.showWarehouse(this.warehouseChosenId); //刷新
          this.$message({
            type: "success",
            message: "删除成功！",
          });
        } else {
          this.$message({
            type: "error",
            message: "删除失败！",
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
    beforeUploadHelp(item) {
      this.fileChosen = item.file;
    },

    //上传音乐至仓库
    uploadMusic() {
      this.$refs.upload.submit();
      this.uploadMusicDialog = false;
      let fd = new FormData(); //通过form数据格式来传
      fd.append("file", this.fileChosen); //传文件
      fd.append("ownerId", this.userId);
      fd.append("warehouseId", this.warehouseChosen);
      this.fileChosen = "";
      this.axios.defaults.headers.post["Content-Type"] =
        "multipart/form-data;charset=UTF-8";
      this.axios
        .post("http://localhost:8088/Warehouse/UploadMusic", fd)
        .then((res) => {
          console.log("uploadMusic", res.status);
          if (res.status == 200) {
            this.$message({
              type: "success",
              message: "音乐上传成功！",
            });
          } else if (res.status == 500) {
            this.$message({
              type: "error",
              message: "音乐上传失败！",
            });
          }
        });
    },
  },
  mounted() {
    this.getMyWarehouse();
    this.getMyCollection();
    this.getUserData();
    this.getAllTags();
    // //this.getOption();
  },
};
</script>

<style scoped>
.back {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;
}

.user-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  min-height: 100%;
  height: fit-content;
  z-index: -1;

  background: url("../../assets/bg.jpeg");
}

.divider {
  position: relative;
  margin: 10px auto;
  width: auto;
  height: 1px;
  background-color: #d4d4d4;
  text-align: center;
  font-size: 16px;
  color: #475669;
}

.album-slide {
  float: left;
  width: 100%;
}

.album-img {
  height: 200px;
  width: 200px;
  display: inline-block;
  position: relative;
  top: -150px;
  margin-left: 30px;
  border-radius: 50%;
  overflow: hidden;
  border: 5px solid white;
}

.user-info {
  background: rgba(255, 255, 255, 0);
  text-align: center;
  margin: 10px;
  padding: 10px;
  border-radius: 8px;
}

.to-do {
  margin: -150px 20px 20px;
  background: rgba(255, 255, 255, 0);
}

.my-page {
  margin-top: -125px;
  opacity: 0.9;
}

.my-info {
  background: rgba(255, 250, 250, 0.5);
  margin-top: -125px;
  margin-left: 20px;
  padding: 10px;
}

.tableText {
  text-align: left;
  font-weight: bold;
  font-size: 15px;
}

::v-deep.el-upload el-upload--picture-card {
  alignment: center;
}

.time-font {
  font-size: 13px;
  color: #999;
}

.title-font {
  font-size: 20px;
  color: black;
}

.card-image {
  height: 120px;
  width: 100%;
  border-radius: 10px;
  box-shadow: 5px 5px 5px #888888;
}

/* 文字提示样式 */
.el-popper.is-customized {
  padding: 6px 12px;
  background: linear-gradient(90deg, rgb(159, 229, 151), rgb(204, 229, 129));
}

.el-popper.is-customized .el-popper__arrow::before {
  background: linear-gradient(45deg, #b2e68d, #bce689);
  right: 0;
}

/* 文字提示样式结束 */

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
  transition: all 0.5s;
}

.el-card:hover {
  margin-top: -5px;
}

/* 卡片样式结束 */
.el-row {
  margin-bottom: 20px;
  display: flex;
  flex-wrap: wrap;
}

.el-col {
  border-radius: 4px;
  align-items: stretch;
  margin-bottom: 40px;
}

/* 好看的按钮颜色 */
.el-button--goon {
  color: #fff;
  background-color: #1e90ff;
  border-color: #1e90ff;
  height: 34px;
  line-height: 34px;
  padding: 0 20px;
}

.el-button--goon:focus,
.el-button--goon:hover {
  color: #fff;
  background-color: hsl(139, 48%, 66%);
  border-color: #1e90ff;
  height: 34px;
  line-height: 34px;
  padding: 0 20px;
}

.el-button--goon:active {
  color: #fff;
  background-color: #1e90ff;
  border-color: #1e90ff;
  height: 34px;
  line-height: 34px;
  padding: 0 20px;
}
</style>
