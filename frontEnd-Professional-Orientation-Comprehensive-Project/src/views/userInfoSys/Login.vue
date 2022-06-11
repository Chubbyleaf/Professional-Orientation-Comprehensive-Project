<template>
  <div class="login-register">
    <vue-particles
      class="login-bg"
      color="#fff"
      :particleOpacity="0.7"
      :particlesNumber="80"
      shapeType="star"
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

    <div class="contain">
      <div class="big-box" :class="{ active: isLogin }">
        <!--        登录-->
        <div class="big-contain" v-if="isLogin" @keyup.enter="login">
          <div class="btitle">用户登录</div>
          <div class="bform-one">
            <input
              type="text"
              placeholder="请输入邮箱/id"
              v-model="loginForm.id"
            />
            <input
              type="password"
              placeholder="请输入密码"
              v-model="loginForm.password"
            />

            <span class="errTips" v-if="passwordError"
              >* 用户名或密码错误 *</span
            >
            <span class="errTips" v-if="isNotFound">* 用户不存在！ *</span>

            <input
              clearable
              placeholder="请输入验证码"
              v-model="loginForm.vertificationCode"
            />
            <div @click="refreshCode">
              <s-identify :identifyCode="identifyCode" />
            </div>
          </div>

          <el-row>
            <el-col :span="8" :offset="3">
              <el-button @click="login" class="bbbutton">登录</el-button>
            </el-col>
            <el-col :span="9" :offset="2">
              <el-button @click="clickForgetPass" class="bbbutton"
                >忘记密码</el-button
              >
            </el-col>
          </el-row>
        </div>

        <!--注册-->
        <div class="big-contain" v-else @keyup.enter="register">
          <div class="btitle">创建账户</div>
          <div class="bform-two">
            <input type="email" placeholder="请输入id" v-model="form.id" />
            <span class="errTips" v-if="alreadyExisted">* 用户已存在！ *</span>
            <input type="text" placeholder="请输入昵称" v-model="form.name" />

            <input
              type="text"
              placeholder="请输入邮箱"
              v-model="form.mailbox"
            />
            <input
              type="password"
              placeholder="请输入密码"
              v-model="form.password"
            />
            <input
              type="password"
              placeholder="请再次输入密码"
              v-model="form.checkPassword"
            />
          </div>
          <button class="bbutton" @click="register()">注册</button>
        </div>
      </div>
      <div class="small-box" :class="{ active: isLogin }">
        <div class="small-contain" v-if="isLogin">
          <div class="stitle">注册账户</div>
          <p class="scontent">闭目聆听那些美好</p>
          <button class="sbutton" @click="changeType">注册</button>
        </div>
        <div class="small-contain" v-else>
          <div class="stitle">欢迎回来!</div>
          <p class="scontent">请登录你的账户</p>
          <button class="sbutton" @click="changeType">登录</button>
        </div>
      </div>
    </div>

    <el-dialog
      title="忘记密码"
      center
      :visible.sync="dialogForgetPass"
      :append-to-body="true"
      width="30%"
    >
      <el-form :model="passForm">
        <el-form-item label="新密码" label-width="80px">
          <el-input
            type="password"
            v-model="passForm.newPass"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="确认密码" label-width="80px">
          <el-input
            type="password"
            v-model="passForm.checkPass"
            autocomplete="off"
          ></el-input>
        </el-form-item>
        <el-form-item label="帐号" label-width="80px">
          <el-input v-model="passForm.account" autocomplete="off"></el-input>
          <el-button @click="getEmailCode()" :disabled="!showCount">
            <span v-show="showCount">发送验证码</span>
            <span v-show="!showCount" class="count"
              >{{ count }} s后重发</span
            ></el-button
          >
        </el-form-item>
        <el-form-item label="验证码" label-width="80px">
          <el-input v-model="passForm.valid" autocomplete="off"></el-input>

          <span class="errTips" v-if="codeError">* 验证码或邮箱错误！ *</span>
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="forgetPass">重置密码</el-button>
        <el-button @click="dialogForgetPass = false">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import sIdentify from "../../components/sIdentify.vue";
const TIME_COUNT = 60;
export default {
  components: { sIdentify },
  name: "loginPage",
  data() {
    return {
      isLogin: true,
      codeError: false,
      passwordError: false,
      isNotFound: false,
      alreadyExisted: false,
      showCount: true,
      count: 0,
      loginForm: {
        id: "",
        password: "",
        vertificationCode: "",
      },
      form: {
        id: "",
        name: "",
        mailbox: "",
        password: "",
        checkPassword: "",
      },
      dialogForgetPass: false,
      passForm: {
        newPass: "",
        checkPass: "",
        account: "",
        valid: "",
      },
      formLabelWidth: "120px",

      identifyCode: "",
      identifyCodes: "1234567890abcdefghijklmnopqrstuvwxyz",
    };
  },
  methods: {
    changeType() {
      this.isLogin = !this.isLogin;
      this.form.id = "";
      this.form.telephone = "";
      this.form.mailbox = "";
      this.form.password = "";
    },
    //修改提示状态
    changeTips() {
      this.passwordError = false;
      this.isNotFound = false;
      this.alreadyExisted = false;
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
    clickForgetPass() {
      this.passForm.newPass = "";
      this.passForm.checkPass = "";
      this.passForm.account = "";
      this.passForm.valid = "";
      this.dialogForgetPass = true;
    },
    //登录
    login() {
      this.changeTips();

      const self = this;
      console.log("self.identifyCode", self.identifyCode);

      if (self.loginForm.id == "" || self.loginForm.password == "") {
        this.failTips("账号或密码为空！");
      } else if (self.identifyCode != self.loginForm.vertificationCode) {
        this.failTips("验证码错误！");
      } else {
        console.log(this.loginForm);

        // 我使用暂存 存一下用户的id和name
        // storage.set('user_id',this.loginForm.id)
        // 结束

        this.axios({
          method: "post",
          url: "/api/user/login",
          data: {
            loginKey: this.loginForm.id,
            password: this.loginForm.password,
          },
        })
          .then((res) => {
            console.log("login", res);
            switch (res.data.code) {
              case 2001:
                //console.log("密码错误");
                this.passwordError = true;
                break;
              case 2003:
                //console.log("用户不存在");
                this.isNotFound = true;
                break;
              case 201:
                this.$router.push({
                  path: "/admin/bulletin",
                });
                break;
              default:
                this.successTips("欢迎回来！");
                sessionStorage.setItem("userId", this.loginForm.id);
                sessionStorage.setItem("isSignIn", true);
                this.$store.state.isSignIn = true;
                this.$router.push({
                  name: "User",
                  path: "/user",
                });
                break;
            }
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },

    //注册
    register() {
      this.changeTips();

      if (this.form.password != this.form.checkPassword) {
        this.failTips("两次的密码不一致！");
      } else if (this.form.id == "") {
        this.failTips("帐号不能为空！");
      } else if (this.form.name == "") {
        this.failTips("昵称不能为空！");
      } else if (this.form.mailbox == "") {
        this.failTips("邮箱不能为空！");
      } else if (this.form.password == "") {
        this.failTips("邮箱不能为空！");
      } else if (
        this.form.id !== "" &&
        this.form.name !== "" &&
        this.form.mailbox !== "" &&
        this.form.password !== ""
      ) {
        let regemail = /^[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
        if (!regemail.test(this.form.mailbox)) {
          this.failTips("请输入正确的邮箱格式！");
        } else {
          this.axios({
            method: "post",
            url: "/api/user/register",
            data: {
              userId: this.form.id,
              email: this.form.mailbox,
              password: this.form.password,
              userName: this.form.name,
            },
          })
            .then((res) => {
              console.log("注册", res);
              switch (res.data.code) {
                case 2004:
                  this.failTips("用户已存在!");
                  break;
                case 2005:
                  this.failTips("邮箱已被注册！");
                  break;
                case 200:
                  this.successTips("注册成功，跳转到登录页中...");
                  this.form = {};
                  this.isLogin = true;
                  break;
                default:
                  this.failTips("注册失败");
                  break;
              }
            })
            .catch((err) => {
              console.log(err);
            });
        }
      }
    },
    getEmailCode() {
      if (this.passForm.account === "") {
        this.failTips("请先输入帐号");
      } else {
        this.axios({
          method: "get",
          url: "http://localhost:9001/user/sendEmail",
          params: { userId: this.passForm.account },
        }).then((res) => {
          console.log("getEmailCode", res);
        });

        // 验证码倒计时
        if (!this.timer) {
          this.count = TIME_COUNT;
          this.showCount = false;
          this.timer = setInterval(() => {
            if (this.count > 0 && this.count <= TIME_COUNT) {
              this.count--;
            } else {
              this.showCount = true;
              clearInterval(this.timer);
              this.timer = null;
            }
          }, 1000);
        }
      }
    },
    // 刷新验证码
    refreshCode() {
      this.identifyCode = "";
      this.makeCode(this.identifyCodes, 4);
    },
    makeCode(o, l) {
      for (let i = 0; i < l; i++) {
        this.identifyCode +=
          this.identifyCodes[this.randomNum(0, this.identifyCodes.length)];
      }
    },
    randomNum(min, max) {
      return Math.floor(Math.random() * (max - min) + min);
    },
    forgetPass() {
      if (
        this.passForm.account == "" ||
        this.passForm.valid == "" ||
        this.passForm.newPass == "" ||
        this.passForm.checkPass == ""
      ) {
        this.failTips("请先输入帐号、新密码和验证码");
      } else if (this.passForm.newPass != this.passForm.checkPass) {
        this.failTips("两次密码不一致！");
      } else {
        this.axios({
          method: "post",
          url: "http://localhost:9001/user/forgetPassword",
          data: {
            userId: this.passForm.account,
            newPassword: this.passForm.newPass,
            valid: this.passForm.valid,
          },
        })
          .then((res) => {
            console.log("忘记密码" + res);
            switch (res.data.code) {
              case 200:
                this.passForm.newPass = "";
                this.passForm.checkPass = "";
                this.passForm.account = "";
                this.passForm.valid = "";
                this.dialogForgetPass = false;
                this.successTips("重置密码成功");

                break;
              default:
                this.failTips(res.data.message);
                break;
            }
          })
          .catch((err) => {
            console.log(err);
          });
      }
    },
  },
  mounted() {
    this.identifyCode = "";
    this.makeCode(this.identifyCodes, 4);
  },
};
</script>

<style scoped>
.login-bg {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  z-index: -1;
  background: url("../../assets/7.jpg");
}

.login-register {
  width: 90vw;
  height: 70vh;
  box-sizing: border-box;
}

.contain {
  width: 750px;
  height: 464px;
  position: relative;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  background: rgba(255, 255, 255, 0.8);
  border-radius: 20px;
  box-shadow: 0 0 3px #f0f0f0, 0 0 6px #f0f0f0;
}

.big-box {
  width: 70%;
  height: 100%;
  position: absolute;
  top: 0;
  left: 30%;
  transform: translateX(0%);
  transition: all 1s;
}

.big-contain {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.btitle {
  font-size: 1.5em;
  font-weight: bold;
  color: #0277bd;
}

.bform-one {
  width: 100%;
  height: 45%;
  padding: 2em 0;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

.bform-two {
  width: 100%;
  height: 65%;
  padding: 2em 0;
  display: flex;
  flex-direction: column;
  justify-content: space-around;
  align-items: center;
}

.bform-one .errTips,
.bform-two .errTips {
  display: block;
  width: 50%;
  text-align: left;
  color: red;
  font-size: 0.7em;
  margin-left: 1em;
}

.bform-one input,
.bform-two input {
  width: 50%;
  height: 40px;
  border: 1px solid white;
  outline: none;
  border-radius: 10px;
  padding-left: 2em;
  /*background-color: #f0f0f0;*/
  background-color: #ffffff;
}

.bform-one input:focus,
.bform-two input:focus {
  border-color: #0091ea;
  outline: none;
  background-color: #fdfdfd;
}

.el-row {
  width: 50%;
}

.bbutton {
  width: 20%;
  height: 40px;
  border-radius: 24px;
  border: none;
  outline: none;
  background-color: #0277bd;
  color: #fff;
  font-size: 0.9em;
  cursor: pointer;
}
.bbbutton {
  width: 100%;
  height: 40px;
  border-radius: 24px;
  border: none;
  outline: none;
  background-color: #0277bd;
  color: #fff;
  font-size: 0.9em;
  cursor: pointer;
}

.small-box {
  width: 30%;
  height: 100%;
  background: linear-gradient(135deg, #44daff, #0277bd);
  position: absolute;
  top: 0;
  left: 0;
  transform: translateX(0%);
  transition: all 1s;
  border-top-left-radius: inherit;
  border-bottom-left-radius: inherit;
}

.small-contain {
  width: 100%;
  height: 100%;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
}

.stitle {
  font-size: 1.5em;
  font-weight: bold;
  color: #fff;
}

.scontent {
  font-size: 0.8em;
  color: #fff;
  text-align: center;
  padding: 2em 4em;
  line-height: 1.7em;
}

.sbutton {
  width: 60%;
  height: 40px;
  border-radius: 24px;
  border: 1px solid #fff;
  outline: none;
  background-color: transparent;
  color: #fff;
  font-size: 0.9em;
  cursor: pointer;
}

.big-box.active {
  left: 0;
  transition: all 0.5s;
}

.small-box.active {
  left: 100%;
  border-top-left-radius: 0;
  border-bottom-left-radius: 0;
  border-top-right-radius: inherit;
  border-bottom-right-radius: inherit;
  transform: translateX(-100%);
  transition: all 1s;
}
</style>
