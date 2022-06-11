
let canvasWidth = window.innerWidth-300;
let canvasHeight = window.innerHeight-100;

function changeRadian(angle) {
  return (Math.PI / 180) * angle;
}
function getRandNumber(start, end) {
  return Math.floor(Math.random() * (end - start + 1)) + start;
}
function getRandColor() {
  let color = [
    '#f9f8e6',
    '#ff8b8b',
    '#61bfad',
    '#f9f7e8',
    '#f9f7e8',
    '#61bfad',
    '#ffffff',
    '#e54b4b',
    '#167c80',
    '#f03f35',
    '#b7e3e4',
    '#fff3b2',
    '#ffe0d8',
    '#ff9b93',
    '#41584b',
    '#f03f35',
    '#efe8d8',
    '#28292b',
    '#e57066',
    '#32b67a',
    '#000000',
    '#facac0',
    '#e6625e',
    '#0bbcda',
    '#d31b33',
    '#fdfo6f',
    '#1fc8e6',
    '#ffefe5',
    '#008fd3',
    '#f4c7ee',
    '#fde3c8',
    '#055a58',
  ];
  let i = Math.floor(getRandNumber(0, color.length));
  return color[i];
}

// 1表示从mp4获取，0表示从歌曲库获取
let bgm_type = localStorage.getItem('bgm_type');
let bgm_value = localStorage.getItem('bgm_value');
const audio00 = './audio/沙锤.mp3';
const audio01 = './audio/脚鼓.mp3';
const audio02 = './audio/饶钹.mp3';
const audio10 = './audio/踏钹.mp3';
const audio11 = './audio/军鼓.mp3';
const audio12 = './audio/掌声.mp3';
const bgMusic = './audio/bgmusic.mp3';
const bgVideo = './audio/bg.mp4';

const musicFragments = [
  [audio00, audio01, audio02],
  [audio10, audio11, audio12],
];
function stroke(row, col) {
  var snd = new Audio(musicFragments[row][col]);
  snd.play();
  changeBackground();
  if (isRecording) {
    recordingSequence.push({
      type: 'music',
      time: Date.now(),
      audio: musicFragments[row][col],
      animation: animations[3 * row + col],
    });
  }
}
document.querySelector('#rect11').onclick = function () {
  stroke(0, 0);
  var s = Snap("#svg");
  //var bigCircle = s.circle(150, 150, 100);
  s.clear();
  let srad = getRandNumber(20, 40);
  let num = Math.floor(getRandNumber(5, 15));
  let angle = 360 / num;
  let rad = getRandNumber(100, 300);
  let color = getRandColor();
  for (let i = 0; i < num; i++) {
    (function (i) {
      setTimeout(() => {
            s.circle({
              cx: canvasWidth / 2 + Math.cos(changeRadian(i * angle)) * rad - canvasWidth / 6,
              cy: canvasHeight / 2 - Math.sin(changeRadian(i * angle)) * rad,
              r: srad,
              fill: color,
            })
      }, 20 * i);
    })(i);
  }
  var set = s.selectAll("circle");

  set.forEach((ele) => {
      ele.animate(
          { cx: getRandNumber(0, 2*canvasWidth/3), cy: getRandNumber(0, canvasHeight), r: 0 },
          500,
          mina.easeout
      );
  });
  set.clear();
};
document.querySelector('#rect12').onclick = function () {
  stroke(0, 1);
  var s = Snap("#svg");
  s.clear();
  let num = Math.floor(getRandNumber(5, 10));
  let srad = getRandNumber(20, 40);
  for (let i = 0; i < num; i++) {
        s.circle({
          cx: (Math.random() * 2 * canvasWidth) / 3,
          cy: Math.random() * canvasHeight,
          r: srad,
        })
  }
  var set = s.selectAll("circle");
  set.forEach((ele) => {
    let color = getRandColor();
    ele.attr({
      fill: color,
    });
    let srad = getRandNumber(5,50);
    ele.animate(
        [0],
        [srad],
        500,
        function () {
          set.animate({ r: 0 }, 500, mina.easeout);
        }
    );
  });
  set.clear();
};
document.querySelector('#rect13').onclick = function () {
  stroke(0, 2);
  var s = Snap("#svg");
  s.clear();
  let num = 15;
  for (let i = 0; i < num; i++) {
    let color = getRandColor();
    let srad = getRandNumber(20, 40);
    s.circle({
      cx: (Math.random() * 2 * canvasWidth) / 3,
      cy: Math.random() * canvasHeight,
      r: srad,
      fillOpacity: 0,
      stroke: color,
      strokeWidth: 4,
    })
  }
  var set = s.selectAll("circle");
  // set.forEach((ele) => {
  //   let srad = getRandNumber(5, 50);
  //   ele.animate(
  //       [0, canvasWidth / 3, canvasHeight / 2],
  //       [srad, getRandNumber(0, (2 * canvasWidth) / 3), getRandNumber(0, canvasHeight)],
  //       function (val) {
  //         ele.attr({ r: val[0], cx: val[1], cy: val[2] });
  //       },
  //       500,
  //       mina.easeout,
  //       function () {
  //         set.animate({ r: 0 }, 300, mina.backin);
  //       }
  //   );
  // });
  set.clear();

};
document.querySelector('#rect21').onclick = function () {
  stroke(1, 0);

  var s = Snap("#svg");
  s.clear();
  let num = 15;
  for (let i = 0; i < num; i++) {
    let color = getRandColor();
    let srad = getRandNumber(20, 40);
    s.paper.rect({
      x: (Math.random() * 2 * canvasWidth) / 3,
      y: Math.random() * canvasHeight,
      width: srad,
      height:srad,
      fill: color,
    })
  }
  var set = s.selectAll("rect");
  // set.forEach((ele) => {
  //   let w = getRandNumber(20, 100);
  //   ele.animate(
  //       [canvasWidth / 3, canvasHeight / 2, 0, 0],
  //       [getRandNumber(0, (2 * canvasWidth) / 3), getRandNumber(0, canvasHeight), w, w],
  //       function (val) {
  //         ele.attr({ x: val[0], y: val[1], width: w, height: w });
  //       },
  //       500,
  //       mina.bounce,
  //       function () {
  //         set.animate({ opacity: 0 }, 300, mina.easeout);
  //       }
  //   );
  // });
  set.clear();

};
document.querySelector('#rect22').onclick = function () {
  stroke(1, 1);
  var s = Snap("#svg");
  s.clear();
  let num = Math.floor(getRandNumber(5, 15));
  for (let i = 0; i < num; i++) {
    let color = getRandColor();
    let srad = getRandNumber(20, 40);
    s.paper.rect({
      x: (Math.random() * 2 * canvasWidth) / 3,
      y: Math.random() * canvasHeight,
      width: srad,
      height:srad,
      stroke: color,
      strokeWidth: 4,
      fillOpacity: 0,
    })
  }
  var set = s.selectAll("rect");
  set.clear();
};
document.querySelector('#rect23').onclick = function () {
  stroke(1, 2);
  let shapes = ['circle', 'rect'];
  let shape = shapes[Math.floor(getRandNumber(0, shapes.length-1))];
  let num = Math.floor(getRandNumber(5, 10));
  var s = Snap("#svg");
  s.clear();
  if (shape === 'circle') {
    for (let i = 0; i < num; i++) {
      let color = getRandColor();
      let srad = getRandNumber(20, 40);
      s.ellipse({
        cx: (Math.random() * 2 * canvasWidth) / 3,
        cy: Math.random() * canvasHeight,
        rx: srad,
        ry: srad/2,
        stroke: color,
        strokeWidth: 4,
        fillOpacity: 0,
      })
    }
  }
  if (shape === 'rect') {
    for (let i = 0; i < num; i++) {
      let color = getRandColor();
      let srad = getRandNumber(20, 40);
      s.paper.rect({
        x: (Math.random() * 2 * canvasWidth) / 3,
        y: Math.random() * canvasHeight,
        width: srad*2,
        height:srad,
        stroke: color,
        strokeWidth: 4,
        fillOpacity: 0,
      })
    }
  }

  // for (let i = 0; i < num; i++) {
  //   let color = getRandColor();
  //   let srad = getRandNumber(20, 40);
  //   s.paper.rect({
  //     x: (Math.random() * 2 * canvasWidth) / 3,
  //     y: Math.random() * canvasHeight,
  //     width: srad,
  //     height:srad,
  //     stroke: color,
  //     strokeWidth: 4,
  //     fillOpacity: 0,
  //   })
  // }
  var set = s.selectAll("rect");
  var set1 = s.selectAll("ellipse");
  set.clear();
  set1.clear();
};
function getCurBgColor(bgChangeCnt) {
  const colors = ['#efcb7b','#0d1831', '#ff9b83', '#61bfad'];
  bgChangeCnt /= 5;
  return colors[bgChangeCnt % 4];
}
class ShapeOverlays {
  constructor(elm) {
    this.elm = elm;
    this.path = elm.querySelectorAll('path');
    this.numPoints = 4;
    this.duration = 800;
    this.delayPointsArray = [];
    this.delayPointsMax = 180;
    this.delayPerPath = 70;
    this.timeStart = Date.now();
    this.isOpened = false;
    this.isAnimating = false;
  }
  toggle() {
    this.isAnimating = true;
    const range = Math.random() * Math.PI * 2;
    for (var i = 0; i < this.numPoints; i++) {
      const radian = (i / (this.numPoints - 1)) * Math.PI * 2;
      this.delayPointsArray[i] =
          ((Math.sin(radian + range) + 1) / 2) * this.delayPointsMax;
    }
    if (this.isOpened === false) {
      this.open();
    } else {
      this.close();
    }
  }
  open() {
    this.isOpened = true;
    this.elm.classList.add('is-opened');
    this.timeStart = Date.now();
    this.renderLoop();
  }
  close() {
    this.isOpened = false;
    this.elm.classList.remove('is-opened');
    this.timeStart = Date.now();
    this.renderLoop();
  }
  updatePath(time) {
    const points = [];
    for (var i = 0; i < this.numPoints; i++) {
      points[i] =
          ease.cubicInOut(
              Math.min(
                  Math.max(time - this.delayPointsArray[i], 0) / this.duration,
                  1
              )
          ) * 100;
    }

    let str = '';
    str += this.isOpened ? `M 0 0 V ${points[0]} ` : `M 0 ${points[0]} `;
    for (var i = 0; i < this.numPoints - 1; i++) {
      const p = ((i + 1) / (this.numPoints - 1)) * 100;
      const cp = p - ((1 / (this.numPoints - 1)) * 100) / 2;
      str += `C ${cp} ${points[i]} ${cp} ${points[i + 1]} ${p} ${
          points[i + 1]
      } `;
    }
    str += this.isOpened ? `V 0 H 0` : `V 100 H 0`;
    return str;
  }
  render() {
    if (this.isOpened) {
      for (var i = 0; i < this.path.length; i++) {
        this.path[i].setAttribute(
            'd',
            this.updatePath(Date.now() - (this.timeStart + this.delayPerPath * i))
        );
      }
    } else {
      for (var i = 0; i < this.path.length; i++) {
        this.path[i].setAttribute(
            'd',
            this.updatePath(
                Date.now() -
                (this.timeStart + this.delayPerPath * (this.path.length - i - 1))
            )
        );
      }
    }
  }
  renderLoop() {
    this.render();
    if (
        Date.now() - this.timeStart <
        this.duration +
        this.delayPerPath * (this.path.length - 1) +
        this.delayPointsMax
    ) {
      requestAnimationFrame(() => {
        this.renderLoop();
      });
    } else {
      this.isAnimating = false;
    }
  }
}
const elmOverlay = document.querySelector('.shape-overlays');
const overlay = new ShapeOverlays(elmOverlay);

let bgChangeCnt = 0;

function changeBackground() {
  if (overlay.isAnimating) {
    return false;
  }
  bgChangeCnt += 1;
  if (bgChangeCnt % 10 === 0) {
    document.documentElement.style.setProperty('--color-bg', getCurBgColor(bgChangeCnt));
  } else if (bgChangeCnt % 5 === 0) {
    document.documentElement.style.setProperty('--path-fill-4', getCurBgColor(bgChangeCnt));
  }
  if (bgChangeCnt % 5 === 0) {
    overlay.toggle();
  }
}

let video = null;
let bgMusicObj = null;
let isRecording = false;
let recordingSequence = [];

function setRecordingTrue() {
  isRecording = true;
  document.querySelector('#recording').style.display = 'flex';
  document.querySelector('#notrecording').style.display = 'none';
}

function setRecordingFalse() {
  isRecording = false;
  document.querySelector('#recording').style.display = 'none';
  document.querySelector('#notrecording').style.display = 'flex';
}

document.querySelector('#select_bgm').onclick = select_bgm;

document.onkeydown = function (evt) {
  const keyCode = evt.keyCode;
  if (keyCode < 65 || keyCode > 90) {
    return;
  }
  if (keyCode === 81) {
    keydown(0, 0, 0);
  } else if (keyCode === 87) {
    keydown(0, 1, 1);
  } else if (keyCode === 69) {
    keydown(0, 2, 2);
  } else if (keyCode === 65) {
    keydown(1, 0, 3);
  } else if (keyCode === 83) {
    keydown(1, 1, 4);
  } else if (keyCode === 68) {
    keydown(1, 2, 5);
  } else {
    switch (keyCode % 6) {
      case 0:
        keydown(0, 0, 0);
        break;
      case 1:
        keydown(0, 1, 1);
        break;
      case 2:
        keydown(0, 2, 2);
        break;
      case 3:
        keydown(1, 0, 3);
        break;
      case 4:
        keydown(1, 1, 4);
        break;
      case 5:
        keydown(1, 2, 5);
        break;
      default:
        break;
    }
  }
};
function keydown(i, j, k) {
  stroke(i, j);
}

function select_bgm() {
  window.open('./dialog.html', '_self')
}


