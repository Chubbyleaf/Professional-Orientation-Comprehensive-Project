async function jianpu(text, duration) {
    duration |= 220;

    let ctx, xml, data, frequencyRatioTempered, map;
    let list = [];

    // 初始化AudioContext
    window.AudioContext = window.AudioContext || window.webkitAudioContext;
    ctx = new AudioContext();

    // 获取指定音源文件的二进制数据
    xml = new XMLHttpRequest();
    xml.open('GET', 'media/piano.wav', true);
    xml.responseType = 'arraybuffer';
    xml.onload = function() {
        // 获取二进制数据并解码
        console.log(xml.response)
        ctx.decodeAudioData(
            xml.response,
            function(_data) {
                data = _data;
                console.log(data)
            },
            function(e) {
                alert(e.err);
            }
        );
    };
    xml.send();

    function sleep (time) {
        return new Promise((resolve) => setTimeout(resolve, time));
    }

    // 根据平均律得出的相邻音调之间的频率比(近似値)
    frequencyRatioTempered = 1.059463;

    map = {
        '((1))' : '36', '((#1))': '35', '((2))' : '34', '((#2))': '33', '((3))' : '32', '((4))': '31',
        '((#4))': '30', '((5))' : '29', '((#5))': '28', '((6))' : '27', '((#6))': '26', '((7))': '25',
        '(1)' : '24', '(#1)': '23', '(2)' : '22', '(#2)': '21', '(3)' : '20', '(4)': '19',
        '(#4)': '18', '(5)' : '17', '(#5)': '16', '(6)' : '15', '(#6)': '14', '(7)': '13',
        '1' : '12', '#1': '11', '2' : '10', '#2': '9', '3' : '8', '4': '7',
        '#4': '6',  '5' : '5',  '#5': '4',  '6' : '3', '#6': '2', '7': '1',
        '[1]' : '0',  '[#1]': '-1', '[2]' : '-2', '[#2]': '-3', '[3]' : '-4',  '[4]': '-5',
        '[#4]': '-6', '[5]' : '-7', '[#5]': '-8', '[6]' : '-9', '[#6]': '-10', '[7]': '-11',
        '[[1]]' : '-12', '[[#1]]': '-13', '[[2]]' : '-14', '[[#2]]': '-15', '[[3]]' : '-16', '[[4]]': '-17',
        '[[#4]]': '-18', '[[5]]' : '-19', '[[#5]]': '-20', '[[6]]' : '-21', '[[#6]]': '-22', '[[7]]': '-23',
    }

    function play(k){
        var i, v, frequencyRatio;

        v = map[k];

        // 根据基准音C求得其他音调相对于它的频率比例
        frequencyRatio = 1;
        if(v > 0){
            for (i = 0; i < v; i++) {
                frequencyRatio /= frequencyRatioTempered;
            }
        }else{
            for (i = 0; i > v; i--) {
                frequencyRatio *= frequencyRatioTempered;
            }
        }

        let bufferSource = ctx.createBufferSource();
        bufferSource.buffer = data;
        // 通过改变音源播放速度的比率，调整音高
        bufferSource.playbackRate.value = frequencyRatio;
        bufferSource.connect(ctx.destination);
        bufferSource.start(0);
    }

    list.push(' ');
    for (let i = 0; i < text.length; i++) {
        switch(text[i]){
            case ' ':
            case '-':
            case '\n':
                list.push(' ');
                break;
            case '(':
            case '[':
                if(text[i+1] === '(' || text[i+1] === '['){
                    if(text[i+2] === '#'){
                        list.push(text[i] + text.substr(i+1, 5));
                        i+=5;
                    }else{
                        list.push(text[i] + text.substr(i+1, 4));
                        i+=4;
                    }
                }else if(text[i+1] === '#'){
                    list.push(text[i] + text.substr(i+1, 3));
                    i+=3;
                }else{
                    list.push(text[i] + text.substr(i+1, 2));
                    i+=2;
                }
                break;
            case '#':
                list.push(text[i] + text.substr(i+1, 1));
                i+=1;
                break;
            default:
                list.push(text[i]);
        }
    }

    for (let i = 0; i < list.length; i++) {
        if(list[i] === ' '){
            await sleep(duration);
        }else{
            // console.log(list[i]);
            play(list[i]);
            await sleep(duration);
        }
    }
}

let name;
let textarea = document.getElementById('jianpu');
document.getElementById('play').onclick = function() {
    jianpu(textarea.value);
}

// let dialog_outter = document.querySelector("#dialog_outter")
// let overlap = document.querySelector("#overlap")
// const dialog_html_str = '<div class="dialog_wrapper">' +
//     '<div class="dialog_close_btn" onclick="closeDialog()">X</div>' +
//     '<div class="dialog_title">起个名字</div>' +
//     '<div class="dialog_content">' +
//     '<div class="form_item">' +
//     '<span>请为简谱起名：</span>' +
//     '<input type="text" id="jianpu_name">' +
//     '</div>' +
//     '<div class="dialog_btn_group">' +
//     '<div class="btn_confirm" onclick="submit()">确定</div>' +
//     '<div class="btn_cancel" onclick="closeDialog()">取消</div>' +
//     '</div>' +
//     '</div>'
//
// document.getElementById('101.132.121.170').onclick = function() {
//     if (name != null) {
//         download(name, textarea.value)
//     }
//     else {
//         overlap.style.display = "block";
//         let fg = document.createRange().createContextualFragment(dialog_html_str)
//         dialog_outter.appendChild(fg)
//     }
// }
//
// function closeDialog() {
//     overlap.style.display = "none";
//     let dialog = document.querySelector(".dialog_wrapper");
//     dialog.remove(1);
// }
//
// function submit() {
//     name = document.getElementById("jianpu_name").value
//     download(name,textarea.value);
//     overlap.style.display = "none";
//     let dialog = document.querySelector(".dialog_wrapper");
//     dialog.remove(1);
// }
//
// function download(filename, text) {
//     let element = document.createElement('a');
//     element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
//     element.setAttribute('download', filename);
//
//     element.style.display = 'none';
//     document.body.appendChild(element);
//     element.click();
//     document.body.removeChild(element);
// }
//
// const dialog_html_str2 = '<div class="dialog_wrapper">' +
//     '<div class="dialog_close_btn" onclick="closeDialog()">X</div>' +
//     '<div class="dialog_title">起个名字</div>' +
//     '<div class="dialog_content">' +
//     '<div class="form_item">' +
//     '<span>请为简谱起名：</span>' +
//     '<input type="text" id="jianpu_name2">' +
//     '</div>' +
//     '<div class="dialog_btn_group">' +
//     '<div class="btn_confirm" onclick="submit2()">确定</div>' +
//     '<div class="btn_cancel" onclick="closeDialog()">取消</div>' +
//     '</div>' +
//     '</div>'
//
//
// document.getElementById('upload').onclick = function() {
//     if (name != null) {
//         upload(name, textarea.value)
//     }
//     else {
//         overlap.style.display = "block";
//         let fg = document.createRange().createContextualFragment(dialog_html_str2)
//         dialog_outter.appendChild(fg)
//     }
// }
//
// function submit2() {
//     name = document.getElementById('jianpu_name2').value
//     upload(name, textarea.value)
//     overlap.style.display = "none";
//     let dialog = document.querySelector(".dialog_wrapper");
//     dialog.remove();
// }
//
// function upload(fileName, text) {
//     let content1 = [encodeURIComponent(text)];
//     let blob1 = new Blob([content1], {type: 'text/plain'});
//     let file1 = new File([blob1], fileName + '.txt', {type: 'text/plain'})
//     let formData = new FormData(); // Currently empty
//     formData.append("file", file1, fileName + '.txt');
//     formData.append("user", localStorage.getItem('user'));
//
//     let xhr = new XMLHttpRequest();
//     xhr.open("POST", 'http://101.132.121.170:8085/file/loader', true);
//     xhr.onload = function () {
//         if (this.status == 200) {
//             console.log('response', this.response); // JSON response
//             if (this.response == "{\"result\":true,\"message\":\"上传成功\"}") {
//                 alert("上传成功")
//             }
//             else if (this.response == "{\"result\":false,\"message\":\"上传失败，请选择文件\"}") {
//                 alert("上传失败，请选择文件")
//             }
//             else {
//                 alert("上传失败")
//             }
//         }
//         else {
//             alert("请求错误！！！")
//         }
//     }
//     xhr.send(formData);
// }
//
// const file_html_str = '<div class="dialog_wrapper">' +
//     '<div class="dialog_close_btn" onclick="closeDialog()">X</div>' +
//     '<div class="dialog_title">选择文件</div>' +
//     '<div class="dialog_content">' +
//     '<form class="form_item">' +
//     '<input type="file" id="uploadFile" name="file">' +
//     '</form>' +
//     '<div class="dialog_btn_group">' +
//     '<div class="btn_confirm" onclick="submit3()">上传</div>' +
//     '<div class="btn_cancel" onclick="closeDialog()">取消</div>' +
//     '</div>' +
//     '</div>'
//
// document.getElementById('load').onclick = function () {
//     overlap.style.display = "block";
//     let fg = document.createRange().createContextualFragment(file_html_str)
//     dialog_outter.appendChild(fg)
// }
//
// function submit3() {
//     let file = document.querySelector('input[type=file]').files[0];
//     console.log(file)
//     //判断上传文件是不是txt格式,判断后缀是不是.txt
//     if(file.name.substr(-4).toLocaleLowerCase() != '.txt'){
//         alert("请上传格式为txt的文件！");
//     }
//     else//如果上传文件是txt文件，则显示文件的预览
//     {
//         let reader = new FileReader;
//         reader.readAsText(file,'gb2312');
//         //reader.readAsDataURL(file);
//         reader.onload=function(evt){
//             let data = evt.target.result;
//             data = data.replace(/%5B/g, '[')
//             data = data.replace(/%5D/g, ']')
//             data = data.replace(/%0A/g, ' ')
//             data = data.replace(/ /g, '\n')
//             textarea.value = data
//         }
//     }
//     overlap.style.display = "none";
//     let dialog = document.querySelector(".dialog_wrapper");
//     dialog.remove();
// }
//
// const open_html_str = '<div class="dialog_wrapper">' +
//     '<div class="dialog_close_btn" onclick="closeDialog()">X</div>' +
//     '<div class="dialog_title">选择文件</div>' +
//     '<div class="dialog_content">' +
//     '<div class="form_item">' +
//     '<span>请选择文件：</span>' +
//     '<select id="txt_list">' +
//     '<option value="txt_id">--请选择--</option>' +
//     '</select>' +
//     '</div>' +
//     '<div class="dialog_btn_group">' +
//     '<div class="btn_confirm" onclick="submit4()">确定</div>' +
//     '<div class="btn_cancel" onclick="closeDialog()">取消</div>' +
//     '</div>' +
//     '</div>'
//
// document.getElementById('open').onclick = function () {
//     overlap.style.display = "block";
//     let fg = document.createRange().createContextualFragment(open_html_str)
//     dialog_outter.appendChild(fg)
//
//     let xhr = new XMLHttpRequest();
//     let email = localStorage.getItem('user')
//     let url = "http://101.132.121.170:8085/api/v1/table/txt?user_id=" + email;
//     xhr.open("GET",url,true);
//     xhr.responseType = 'json';
//     xhr.onload = function(e) {
//         if (this.status == 200) {
//             console.log('response', this.response); // JSON response
//             for (let i = 0; i < this.response.length; i++) {
//                 console.log(this.response)
//                 document.getElementById("txt_list").innerHTML += "<option value=" + this.response[i].name + ">" + this.response[i].name + "</option>"
//             }
//         }
//         else {
//             alert("请求错误！！！")
//         }
//     };
//     xhr.send();
// }
//
// function submit4() {
//     let txt = document.getElementById("txt_list").value
//     let xhr = new XMLHttpRequest();
//     xhr.responseType = 'blob';
//     xhr.open("GET", "http://101.132.121.170:8085/file/read?fileName=" + txt, true);
//     xhr.onload = function() {
//         if (this.status == 200) {
//             let blob = this.response;
//             //通过FileReader读取数据
//             let reader = new FileReader();
//             //以下这两种方式我都可以解析出来，因为Blob对象的数据可以按文本或二进制的格式进行读取
//             reader.readAsBinaryString(blob);
//             //reader.readAsText(blob, 'utf8');
//             reader.onload = function(){
//                 let receive_data = this.result;//这个就是解析出来的数据
//                 receive_data = receive_data.replace(/%5B/g, '[')
//                 receive_data = receive_data.replace(/%5D/g, ']')
//                 receive_data = receive_data.replace(/%0A/g, ' ')
//                 receive_data = receive_data.replace(/ /g, '\n')
//                 textarea.value = receive_data
//             }
//         }
//         else {
//             alert("请求错误！！！")
//         }
//     };
//     xhr.send();
//
//     overlap.style.display = "none";
//     let dialog = document.querySelector(".dialog_wrapper");
//     dialog.remove();
// }
