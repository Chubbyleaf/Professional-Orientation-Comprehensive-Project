<template>
    <div>
        <h2 style="color: white">【钢琴创作】</h2>
        <div class="piano">
            <div data-note="C3" class="key white"><span class="word" style="color: black">C3</span></div>
            <div data-note="Db3" class="key black"><span class="word" style="color: white">S</span></div>
            <div data-note="D3" class="key white"><span class="word" style="color: black">&nbsp;X</span></div>
            <div data-note="Eb3" class="key black"><span class="word" style="color: white">&nbsp;D</span></div>
            <div data-note="E3" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;&nbsp;&nbsp;C</span></div>
            <div data-note="F3" class="key white"><span class="word" style="color: black">V</span></div>
            <div data-note="Gb3" class="key black"><span class="word" style="color: white">G</span></div>
            <div data-note="G3" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;B</span></div>
            <div data-note="Ab3" class="key black"><span class="word" style="color: white">&nbsp;H</span></div>
            <div data-note="A3" class="key white"><span class="word" style="color: black">&nbsp;N</span></div>
            <div data-note="Bb3" class="key black"><span class="word" style="color: white">&nbsp;J</span></div>
            <div data-note="B3" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;&nbsp;&nbsp;M</span></div>

            <div data-note="C4" class="key white"><span class="word" style="color: black">C4</span></div>
            <div data-note="Db4" class="key black"><span class="word" style="color: white">L</span></div>
            <div data-note="D4" class="key white"><span class="word" style="color: black">&nbsp;.</span></div>
            <div data-note="Eb4" class="key black"><span class="word" style="color: white">&nbsp;;</span></div>
            <div data-note="E4" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;&nbsp;&nbsp;/</span></div>
            <div data-note="F4" class="key white"><span class="word" style="color: black">Q</span></div>
            <div data-note="Gb4" class="key black"><span class="word" style="color: white">2</span></div>
            <div data-note="G4" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;W</span></div>
            <div data-note="Ab4" class="key black"><span class="word" style="color: white">&nbsp;3</span></div>
            <div data-note="A4" class="key white"><span class="word" style="color: black">&nbsp;E</span></div>
            <div data-note="Bb4" class="key black"><span class="word" style="color: white">&nbsp;4</span></div>
            <div data-note="B4" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;&nbsp;&nbsp;R</span></div>

            <div data-note="C5" class="key white"><span class="word" style="color: black">T</span></div>
            <div data-note="Db5" class="key black"><span class="word" style="color: white">6</span></div>
            <div data-note="D5" class="key white"><span class="word" style="color: black">&nbsp;Y</span></div>
            <div data-note="Eb5" class="key black"><span class="word" style="color: white">&nbsp;7</span></div>
            <div data-note="E5" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;&nbsp;&nbsp;U</span></div>
            <div data-note="F5" class="key white"><span class="word" style="color: black">I</span></div>
            <div data-note="Gb5" class="key black"><span class="word" style="color: white">9</span></div>
            <div data-note="G5" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;O</span></div>
            <div data-note="Ab5" class="key black"><span class="word" style="color: white">&nbsp;0</span></div>
            <div data-note="A5" class="key white"><span class="word" style="color: black">&nbsp;P</span></div>
            <div data-note="Bb5" class="key black"><span class="word" style="color: white">&nbsp;-</span></div>
            <div data-note="B5" class="key white"><span class="word" style="color: black">&nbsp;&nbsp;&nbsp;&nbsp;[</span></div>
        </div>
        <audio id="C3" src="./soundFont/C3.mp3"></audio>
        <audio id="Db3" src="./soundFont/Db3.mp3"></audio>
        <audio id="D3" src="./soundFont/D3.mp3"></audio>
        <audio id="Eb3" src="./soundFont/Eb3.mp3"></audio>
        <audio id="E3" src="./soundFont/E3.mp3"></audio>
        <audio id="F3" src="./soundFont/F3.mp3"></audio>
        <audio id="Gb3" src="./soundFont/Gb3.mp3"></audio>
        <audio id="G3" src="./soundFont/G3.mp3"></audio>
        <audio id="Ab3" src="./soundFont/Ab3.mp3"></audio>
        <audio id="A3" src="./soundFont/A3.mp3"></audio>
        <audio id="Bb3" src="./soundFont/Bb3.mp3"></audio>
        <audio id="B3" src="./soundFont/B3.mp3"></audio>

        <audio id="C4" src="./soundFont/C4.mp3"></audio>
        <audio id="Db4" src="./soundFont/Db4.mp3"></audio>
        <audio id="D4" src="./soundFont/D4.mp3"></audio>
        <audio id="Eb4" src="./soundFont/Eb4.mp3"></audio>
        <audio id="E4" src="./soundFont/E4.mp3"></audio>
        <audio id="F4" src="./soundFont/F4.mp3"></audio>
        <audio id="Gb4" src="./soundFont/Gb4.mp3"></audio>
        <audio id="G4" src="./soundFont/G4.mp3"></audio>
        <audio id="Ab4" src="./soundFont/Ab4.mp3"></audio>
        <audio id="A4" src="./soundFont/A4.mp3"></audio>
        <audio id="Bb4" src="./soundFont/Bb4.mp3"></audio>
        <audio id="B4" src="./soundFont/B4.mp3"></audio>

        <audio id="C5" src="./soundFont/C5.mp3"></audio>
        <audio id="Db5" src="./soundFont/Db5.mp3"></audio>
        <audio id="D5" src="./soundFont/D5.mp3"></audio>
        <audio id="Eb5" src="./soundFont/Eb5.mp3"></audio>
        <audio id="E5" src="./soundFont/E5.mp3"></audio>
        <audio id="F5" src="./soundFont/F5.mp3"></audio>
        <audio id="Gb5" src="./soundFont/Gb5.mp3"></audio>
        <audio id="G5" src="./soundFont/G5.mp3"></audio>
        <audio id="Ab5" src="./soundFont/Ab5.mp3"></audio>
        <audio id="A5" src="./soundFont/A5.mp3"></audio>
        <audio id="Bb5" src="./soundFont/Bb5.mp3"></audio>
        <audio id="B5" src="./soundFont/B5.mp3"></audio>
        <div style="margin-top: 23%;">
            <el-row style="margin-top: -22px">
                <el-col span="8">
                    <el-button class="butt1" @click="tojianpu()"> 上一个：简谱创作 </el-button>
                </el-col>
                <el-col span="8">
                    <div style="color: white">
                        <p>使用方法：鼠标点击琴键或键盘敲击对应按键</p>
                        <p>录制方法：点击下方录制按钮进行录制</p>
                    </div>
                    <div style="text-align: center; color: white; margin-top: 18px">
                        <input id="record" type="button" value="录屏" @click="open" style="text-align:center; background-color:#FFF;font-size:20px;font-weight:bolder;color:#93d5dc;" class="but">
                        <input id="uploadjianputxt" type="button" value="上传简谱" @click="uploadtxtj" style="margin-left:10px;text-align:center; background-color:#FFF;font-size:20px;font-weight:bolder;color:#93d5dc;" class="but">
                    </div>
                </el-col>
                <el-col span="8">
                    <el-button class="butt1" @click="togudian()"> 下一个：鼓点创作 </el-button>
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
    </div>
</template>


<script>
    import axios from "axios";

    import('./script.js')

    export default {
        mounted: function () {
            if (location.href.indexOf("#reloaded") === -1) {
                location.href = location.href + "#reloaded";
                window.location.reload();
            }
            window.uploadtxtja = this.uploadtxtj
        },
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
                datatxt:'',
                uploadVisible:false,
                uploadForm:{
                    authorId: '',
                    audioName: '',
                },
                options: [],
                warehouse_id:'',
            };
        },
        methods: {
            tojianpu(){
                this.$router.push({
                    path: "/onlineMake/notation/index",
                });
            },
            togudian(){
                this.$router.push({
                    path: "/onlineMake/taptap/index",
                });
            },
            open(){
                window.open(`/record.html`)
            },
            uploadtxtj(data){
                this.datatxt = data
                if(typeof(this.datatxt)==="string" ){
                    this.uploadtxtaa()
                }
            },
            uploadtxtaa(){
                this.uploadVisible=true
            },
            uploadtxt() {
                let content1 = [encodeURIComponent(this.datatxt)];
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
        },

    }
</script>


<style scoped>
    *, *::before, *::after {
        box-sizing: border-box;
    }

    .piano {
        display: flex;
        position:absolute; /*参照物是父容器*/
        left:54%;
        transform:translateX(-50%); /*百分比的参照物是自身*/
    }

    .word {
        margin-left: -8px;
        margin-top: 100px;
    }

    .key {
        height: calc(var(--width) * 4);
        width: var(--width);
        border-radius:0.2em;

        background:linear-gradient(to bottom right,rgba(0,0,0,0.3),rgba(0,0,0,0)),url(https://s3-us-west-2.amazonaws.com/s.cdpn.io/187/vwood.png);
        box-shadow:0 0 50px rgba(0,0,0,0.5) inset,0 1px rgba(212,152,125,0.2) inset,0 5px 15px rgba(0,0,0,0.5);
    }

    .white {
        --width: 50px;
        border: 1px solid #333;

        box-shadow:-1px 0 0 rgba(255,255,255,0.8) inset,0 0 5px #ccc inset,0 0 3px rgba(0,0,0,0.2);
        background: white linear-gradient(to bottom, #eee 0%, #fff 100%);
    }

    .white.active {
        box-shadow:2px 0 3px rgba(0,0,0,0.1) inset,-5px 5px 20px rgba(0,0,0,0.2) inset,0 0 3px rgba(0,0,0,0.2);
        background: #CCC linear-gradient(to bottom, #fff 0%, #e9e9e9 100%);
    }

    .black {
        --width: 30px;
        margin-left: calc(var(--width) / -2);
        margin-right: calc(var(--width) / -2);
        z-index: 2;

        box-shadow:-1px -1px 2px rgba(255,255,255,0.2) inset,0 -5px 2px 3px rgba(0,0,0,0.6) inset,0 2px 4px rgba(0,0,0,0.5);
        background: black linear-gradient(45deg, #222 0%, #555 100%);
    }

    .black.active {
        box-shadow:-1px -1px 2px rgba(255,255,255,0.2) inset,0 -2px 2px 3px rgba(0,0,0,0.6) inset,0 1px 2px rgba(0,0,0,0.5);
        background: #333 linear-gradient(to right, #444 0%, #222 100%);
    }
    .but {
        border: 4px solid #c6e6e8;
        border-radius: 5px;
        background-color: rgba(198,230,232,0.8);
        width: 125px;
        height: 55px;
        color: #c0c4c3;
    }
    .butt1 {
        width: 80%;
        height: 80px;
        background: rgba(255, 255, 255, 0.158);
        font-size: 30px;
        color: white;
        margin-top: 45px;
        margin-right: 40px;
        float: right;
    }
</style>