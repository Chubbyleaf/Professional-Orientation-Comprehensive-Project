<template>
    <div>
        <svg class="animation" id="svg" width="100%" height="600px" style="margin-top: -50px"></svg>
<!--       <svg class="animation" id="svg1" width="100%" height="600px" style="margin-top: -50px"></svg>-->

        <svg class="shape-overlays" viewBox="0 0 100 100" preserveAspectRatio="none">
            <path class="shape-overlays__path"></path>
            <path class="shape-overlays__path"></path>
            <path class="shape-overlays__path"></path>
            <path class="shape-overlays__path"></path>
        </svg>
        <div class="keypadqq">
<!--        <el-button class="butt1" @click="topiano()"> 上一个：钢琴创作 </el-button>-->
            <playmusic ref="playmusic"/>
        </div>
        <div class="keypad">
            <div class="row">
                <div class="col" id="rect11">
                    <img src="./icons/audio_icon11.svg"  alt=""/>
                </div>
                <div class="col" id="rect12">
                    <img src="./icons/audio_icon12.svg" alt=""/>
                </div>
                <div class="col" id="rect13">
                    <img src="./icons/audio_icon13.svg" alt=""/>
                </div>
            </div>
            <div class="row">
                <div class="col" id="rect21">
                    <img src="./icons/audio_icon21.svg" alt=""/>
                </div>
                <div class="col" id="rect22">
                    <img src="./icons/audio_icon22.svg" alt=""/>
                </div>
                <div class="col" id="rect23">
                    <img src="./icons/audio_icon23.svg"  alt=""/>
                </div>
            </div>
        </div>
        <div class="control_area">
            <div class="status_bar">
                <div id="recording" style="display: none">
                    <img id="pauseIcon" src="./icons/pause.svg" alt=""/>
                    <p class="word" id="pauseBgmWord">暂停</p>
                    <img id="stopIcon" src="./icons/stop.svg" alt=""/>
                    <p class="word" id="stopBgmWord">停止</p>
                </div>
                <div id="notrecording" style="display: flex">
                    <h3 id="select_bgm" onclick="select_bgm()">选择BGM</h3>
                    <a href="TapRecord.html" target="_black" rel="noopener noreferrer">录屏</a>
                </div>
            </div>
        </div>
    </div>
</template>

<script>
    import('./index.js')
    import playmusic from './playmusic'
    export default {
        components: {playmusic},
        methods: {
            topiano(){
                alert(localStorage.getItem("bag_value"))
                this.$router.push({
                    path: "/onlineMake/pinao/index",
                });
            },
        },
    }

</script>

<style scoped>
    body {
        padding: 0;
        margin: 0;
        user-select: none;
        overflow: hidden;
    }
    .keypad {
        display: inline-flex;
        flex-direction: column;
        position: absolute;
        right: 10%;
        top: 73px;
        z-index: 100;
        padding-top: 24px;
    }
    .keypadqq {
        position: absolute;
        left: 10%;
        top: 25%;
        right: 32%;
        z-index: 100;
    }
    .row {
        display: flex;
    }
    .row:first-child {
        align-items: flex-end;
    }
    .row:last-child {
        margin-top: 48px;
        align-items: flex-start;
    }
    .col {
        width: 100px;
        height: 100px;
        margin-right: 28px;
        border-radius: 28px;
        display: inline-flex;
        justify-content: center;
        align-items: center;
        cursor: pointer;
    }
    .col > img {
        width: 80px;
    }
    #rect11 {
        background: #0c7b93;
    }
    #rect12 {
        background: #27496d;
        height: 200px;
    }
    #rect13 {
        background: #00a8cc;
    }
    #rect21 {
        background: #00a8cc;
    }
    #rect22 {
        background: #27496d;
        height: 200px;
    }
    #rect23 {
        background: #0c7b93;
    }

    .control_area {
        display: inline-flex;
        flex-direction: column;
        position: absolute;
        right:0;
        top: 34%;
        z-index: 100;
    }
    .status_bar {
        display: inline-block;
        width: 260px;
        height: 70px;
        background: #f9f7e8;
        border-radius: 40px;
        margin: -140px 10px 40px 0;
        color: #000;
    }
    .status_bar > div {
        width: 100%;
        height: 100%;
        justify-content: center;
        align-items: center;
    }
    .status_bar img {
        width: 56px;
    }

    .status_bar a {
        text-decoration: none;
        color: #1890ff;
        line-height: 1.5;
        font-size: 24px;
        margin-left: 24px;
    }

    .animation {
        z-index: 100;
    }

    .word {
        font-size: 23px;
    }
    .butt1 {
        width: 35%;
        height: 80px;
        background: rgba(255, 255, 255, 0.158);
        font-size: 30px;
        color: white;
        margin-top: 45px;
        margin-right: 40px;
        float: right;
    }

</style>