<template>
    <div>
        <el-button class="button-next" @click="showdiv()" v-text="btnText"></el-button>
        <div v-show="!show">
            <el-row>
                <h1 class="title1" style="font-weight: bold">一场简单的字符跳动即将开始</h1>
            </el-row>
            <el-row>
                <h1 class="title1" style="font-weight: bold">你准备好了吗？</h1>
            </el-row>
            <el-button class="butt" @click="topiano()"> 下一个：钢琴创作 </el-button>
        </div>
        <div v-show="show">
            <el-row>
                <el-col :span="10">
                    <el-card class="card">
                        <p class="title2" style="font-weight: bold">数字简谱是简谱记谱法的一种更简化形式</p>
                        <p class="title2">相对于简谱而言仅保留了音调，而不记录旋律信息.</p>
                        <p class="title2" style="font-weight: bold">规定如下：</p>
                        <p class="title2">- 音符以数字1、2、3、4、5、6、7表示</p>
                        <p class="title2">- 调号为C大调</p>
                        <p class="title2">- 若为半音，就在音符前方加一个`#`号</p>
                        <p class="title2">- 若高一个八度，音符就用中括号`[]`包裹起来，再高一个八度，就用双重中括号`[[]]`包裹起来</p>
                        <p class="title2">- 若低一个八度，音符就用小括号`()`包裹起来，再低一个八度，就用双重小括号`(())`包裹起来</p>
                        <p class="title2">- 空格、换行和`-`号表示暂停一个音的时长，出现多个将暂停多次</p>
                        <p class="title2" style="font-weight: bold">数字简谱不记录旋律信息</p>
                        <p class="title2" style="font-weight: bold">不适合记录节奏复杂多变的乐曲</p>
                        <p class="title2">（可善加使用暂停符来控制节奏）</p>
                    </el-card>
                </el-col>
                <el-col :span="12">
                    <el-card class="card2">
                        <textarea  name="jianpu" id="jianpu"  class="textblack"  v-model="textdata" style="width: 400px;height:400px;border-radius:5px;font-size: 18px;padding: 10px;"
                                   type="textarea"></textarea>
                    </el-card>
                </el-col>
                <el-col :span="2">
                    <div>
                        <el-button class="button-m" type="primary" id="play">试听</el-button>
                        <el-upload ref="input" action="/" :show-file-list="false" :auto-upload="false" :on-change="importExcel" type="file">
                            <el-button class="button-m" style="margin-left: -35px" type="primary" id="load">导入</el-button>
                        </el-upload>
                        <el-button class="button-m" type="primary" id="open" @click="open">打开</el-button>
                        <el-button class="button-m" type="primary" id="download" @click="download">下载</el-button>
                        <el-button class="button-m" type="primary" id="upload" @click="upload">上传</el-button>
                    </div>
                </el-col>
            </el-row>
        </div>
        <el-dialog title="添加简谱" :visible.sync="uploadVisible" width="400px" center :modal-append-to-body="false">
            <el-form :model="uploadForm" status-icon ref="uploadForm" label-width="80px">
                <el-form-item prop="audioName" label="简谱名字" size="mini">
                    <el-input v-model="uploadForm.audioName" placeholder="简谱名字"></el-input>
                </el-form-item>

                <el-form-item label="收藏夹" size="mini">
                    <el-select v-model="warehouse_id" size="small" filterable clearable placeholder="请选择放入的收藏夹">
                        <el-option v-for="item in options" :key="item.warehouse_id" :label="item.warehouse_name" :value="item.warehouse_id"  :disabled="item.disabled"></el-option>
                    </el-select>
                </el-form-item>
            </el-form>
            <span slot="footer">
        <el-button size="mini" @click="uploadVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="uploadtxt">确 定</el-button>
      </span>
        </el-dialog>
        <el-dialog title="下载简谱到本地" :visible.sync="downloadVisible" width="400px" center :modal-append-to-body="false">
            <el-form :model="downloadForm" status-icon ref="downloadForm" label-width="80px">
                <el-form-item prop="audioName" label="简谱名字" size="mini">
                    <el-input v-model="downloadForm.audioName" placeholder="简谱名字"></el-input>
                </el-form-item>
            </el-form>
            <span slot="footer">
        <el-button size="mini" @click="downloadVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="downloadtxt">确 定</el-button>
      </span>
        </el-dialog>
        <el-dialog title="选择个人仓库中的简谱文件" :visible.sync="openVisible" width="400px" center :modal-append-to-body="false">
            <el-table ref="multipleTable" size="mini" border style="width: 100%" :data="tableData"
                      @selection-change="handleSelectionChange">
                <el-table-column type="selection" width="40" prop="txt_url" ></el-table-column>
                <el-table-column prop="audio_name" label="简谱文件名称" width="110" align="center"></el-table-column>
                <el-table-column prop="create_time" label="创作时间"  align="center"></el-table-column>
            </el-table>
            <span slot="footer">
        <el-button size="mini" @click="openVisible = false">取 消</el-button>
        <el-button type="primary" size="mini" @click="opentxt">确 定</el-button>
      </span>
        </el-dialog>

    </div>

</template>

<script>
    import axios from "axios";
    export default {
        async created() {
            var params = {
                userId: '1001' ,
            }
            await axios.get('http://localhost:8089/WHouse/find/all'+'?userId='+params.userId).then(res => {
                console.log(res)
                this.options=res.data
            })
        },
        data() {
            return {
                btnText: '关于简谱',
                show: false,
                textdata:'',
                uploadVisible:false,
                downloadVisible:false,
                openVisible:false,
                uploadForm:{
                    authorId: '',
                    audioName: '',
                },
                downloadForm:{
                    audioName: '',
                },
                tableData:{
                    audio_id:'',
                    audio_name:'',
                    creat_time:'',
                    txt_url:'',
                    user_id:'',
                },
                multipleSelection: [],
                options: [],
                warehouse_id:'',
            };
        },
        methods: {
            showdiv(){
                if (this.show !== false) {
                    this.show = false
                    this.btnText='关于简谱'
                } else {
                    this.show = true
                    this.btnText='点击收起'
                }
            },
            topiano(){
                this.$router.push({
                    path: "/onlineMake/pinao/index",
                });
            },

            // 以下是对txt简谱文件的操作。。。。。。
            //将文本框中的txt文件上传至服务器
            upload(){
                this.uploadVisible=true
            },
            uploadtxt() {
                let content1 = [encodeURIComponent(this.textdata)];
                let blob1 = new Blob([content1], {type: 'text/plain'});
                let file1 = new File([blob1], this.uploadForm.audioName + '.txt', {type: 'text/plain'})
                let formData = new FormData(); // Currently empty
                formData.append("file", file1, this.uploadForm.audioName + '.txt');
                formData.append("user", '1001');
                formData.append("warehouse_id", this.warehouse_id);
                let xhr = new XMLHttpRequest();
                xhr.open("POST", 'http://localhost:8089/audio/loader', true);
                xhr.onload = function () {
                    if (this.status === 200) {
                        console.log('response', this.response); // JSON response
                        if (this.response === "{\"result\":true,\"message\":\"上传成功\"}") {
                            alert("上传成功")
                        }
                        else if (this.response === "{\"result\":false,\"message\":\"上传失败，请选择文件\"}") {
                            alert("上传失败，请选择文件")
                        }
                        else {
                            alert("上传失败")
                        }
                    }
                    else {
                        alert("请求错误！！！")
                    }
                }
                xhr.send(formData);
                this.uploadVisible=false
            },
            // 将输入框中的内容下载到本地
            download(){
                this.downloadVisible=true
            },
            downloadtxt(){
                let element = document.createElement('a');
                element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(this.textdata));
                element.setAttribute('download', this.downloadForm.audioName);

                element.style.display = 'none';
                document.body.appendChild(element);
                element.click();
                document.body.removeChild(element);
                this.downloadVisible=false
            },
            //导入本地简谱文件
            importExcel(file) {
                const types = file.name.split(".")[1];
                const fileType = ["txt", "doc", "docx"].some(
                    item => item === types
                );
                if (!fileType) {
                    alert("格式错误！请重新选择");
                    return;
                }
                const reader = new FileReader()
                reader.onload = (e) => this.$emit("load", this.dealNum(e.target.result));
                reader.readAsText(file.raw, "utf-8");
            },
            dealNum(item) {
                this.textdata = item;
            },
            // 将服务器中的文件直接显示在输入框中
            open(){
                var params = {
                    userId: '1001' ,
                }
                axios.get('http://localhost:8089/audio/find/all/txt'+'?userId='+params.userId).then(res => {
                    console.log(res)
                    this.tableData=res.data
                })
                this.openVisible=true
            },
            opentxt(){
                var len=this.multipleSelection.length
                if(len!=1){
                    alert("请选择一个要打开的文件")
                }
                console.log(this.multipleSelection[0].txt_url)
                let xhr = new XMLHttpRequest();
                xhr.responseType = 'blob';
                xhr.open("GET", this.multipleSelection[0].txt_url, true);
                xhr.send();
                var $this = this
                xhr.onload = function() {
                    if (this.status === 200) {
                        let blob = this.response;
                        //通过FileReader读取数据
                        let reader = new FileReader();
                        //以下这两种方式我都可以解析出来，因为Blob对象的数据可以按文本或二进制的格式进行读取
                        reader.readAsBinaryString(blob);
                        //reader.readAsText(blob, 'utf8');
                        reader.onload = function(){
                            $this.textdata  = this.result;//这个就是解析出来的数据
                        }
                    }
                    else {
                        alert("请求错误！！！")
                    }
                };
                console.log(this.textdata)
                this.openVisible=false
            },
            handleSelectionChange (val) {
                this.multipleSelection = val
            },


        },
    }
    import('./jianpu.js')
</script>

<style scoped>
    .title1 {
        font-size: 40px;
        float: left;
        color: #fff;
    }
    .title2 {
        font-size: 15px;
        margin-top: -1%;
        text-align: center;
    }
    .card{
        margin-top: 2%;
        opacity: 0.6;
        align-content: center;
        display: flex;
    }
    .card2{
        background-color:rgba(1,221,221,1);
        margin-top: 2%;
        opacity: 0.6;
        align-content: center;
        display: flex;
        margin-left: 8%;
        margin-right: 8%;
    }
    .textblack{
        font-weight: bold;
    }
    .button-next {
        width: 60%;
        height: 80px;
        background: rgba(255, 255, 255, 0.158);
        font-size: 30px;
        color: white;
        margin-bottom: 20px;
    }
    .butt {
        width: 30%;
        height: 80px;
        background: rgba(255, 255, 255, 0.158);
        font-size: 30px;
        color: white;
        margin-bottom: 20px;
        margin-right: 40px;
        float: right;
    }
    .button-m{
        margin-right: 12%;
        margin-left: -25px;
        margin-top: 40px;
        text-align:center;
        font-size:20px;
        font-weight:bolder;
        color:#93d5dc;
        background: rgba(255, 255, 255, 0.4);
    }
</style>