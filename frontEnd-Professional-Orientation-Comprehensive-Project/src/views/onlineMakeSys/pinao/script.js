const KEYS_ARR = ['z', 's', 'x', 'd',  'c', 'v', 'g', 'b', 'h','n', 'j','m',',', 'l','.', ';','/', 'q', '2', 'w', '3', 'e', '4', 'r', 't', '6', 'y', '7', 'u', 'i', '9', 'o', '0', 'p', '-', '[', ']'];
const NOT_EXIST=-1;
const keys = document.querySelectorAll('.key');
let contenet=''

document.addEventListener('keydown', event => {
  if (event.repeat) return;
  const key = event.key;
  const keyIndex = KEYS_ARR.indexOf(key);
  if (keyIndex > NOT_EXIST)
  playNote(keys[keyIndex]);
})

keys.forEach(key => {
  key.addEventListener('click', () => playNote(key));
})

function playNote(key) {
  const noteAudio = document.getElementById(key.dataset.note);
  if(noteAudio.id === "C3"){
    contenet = contenet + "(1)"
  }
  else if(noteAudio.id === "Db3"){
    contenet = contenet + "(#1)"
  }
  else if(noteAudio.id === "D3"){
    contenet = contenet + "(2)"
  }
  else if(noteAudio.id === "Eb3"){
    contenet = contenet + "(#2)"
  }
  else if(noteAudio.id === "E3"){
    contenet = contenet + "(3)"
  }
  else if(noteAudio.id === "F3"){
    contenet = contenet + "(4)"
  }
  else if(noteAudio.id === "Gb3"){
    contenet = contenet + "(#4)"
  }
  else if(noteAudio.id === "G3"){
    contenet = contenet + "(5)"
  }
  else if(noteAudio.id === "Ab3"){
    contenet = contenet + "(#5)"
  }
  else if(noteAudio.id === "A3"){
    contenet = contenet + "(6)"
  }
  else if(noteAudio.id === "Bb3"){
    contenet = contenet + "(#6)"
  }
  else if(noteAudio.id === "B3"){
    contenet = contenet + "(7)"
  }

  if(noteAudio.id === "C4"){
    contenet = contenet + "1"
  }
  else if(noteAudio.id === "Db4"){
    contenet = contenet + "#1"
  }
  else if(noteAudio.id === "D4"){
    contenet = contenet + "2"
  }
  else if(noteAudio.id === "Eb4"){
    contenet = contenet + "#2"
  }
  else if(noteAudio.id === "E4"){
    contenet = contenet + "3"
  }
  else if(noteAudio.id === "F4"){
    contenet = contenet + "4"
  }
  else if(noteAudio.id === "Gb4"){
    contenet = contenet + "#4"
  }
  else if(noteAudio.id === "G4"){
    contenet = contenet + "5"
  }
  else if(noteAudio.id === "Ab4"){
    contenet = contenet + "#5"
  }
  else if(noteAudio.id === "A4"){
    contenet = contenet + "6"
  }
  else if(noteAudio.id === "Bb4"){
    contenet = contenet + "#6"
  }
  else if(noteAudio.id === "B4"){
    contenet = contenet + "7"
  }


  if(noteAudio.id === "C5"){
    contenet = contenet + "[1]"
  }
  else if(noteAudio.id === "Db5"){
    contenet = contenet + "[#1]"
  }
  else if(noteAudio.id === "D5"){
    contenet = contenet + "[2]"
  }
  else if(noteAudio.id === "Eb5"){
    contenet = contenet + "[#2]"
  }
  else if(noteAudio.id === "E5"){
    contenet = contenet + "[3]"
  }
  else if(noteAudio.id === "F5"){
    contenet = contenet + "[4]"
  }
  else if(noteAudio.id === "Gb5"){
    contenet = contenet + "[#4]"
  }
  else if(noteAudio.id === "G5"){
    contenet = contenet + "[5]"
  }
  else if(noteAudio.id === "Ab5"){
    contenet = contenet + "[#5]"
  }
  else if(noteAudio.id === "A5"){
    contenet = contenet + "[6]"
  }
  else if(noteAudio.id === "Bb5"){
    contenet = contenet + "[#6]"
  }
  else if(noteAudio.id === "B5"){
    contenet = contenet + "[7]"
  }
  console.log(contenet)
  noteAudio.currentTime = 0;
  noteAudio.play();
  key.classList.add('active');
  noteAudio.addEventListener('ended', () => {
    key.classList.remove('active');
  })
}

onload = function() {
  let click_cnt = 0;
  let html = document.getElementsByClassName("piano")[0];
  let body = document.getElementsByTagName("body")[0];
  const colors = ['#3B7097','#75BDE0', '#A9D09E', '#F6E2BC', '#e3b4b8'];
  html.onclick = function(e) {
    click_cnt++;
    let elem = document.createElement("b");
    elem.style.color = colors[click_cnt % 5];
    elem.style.zIndex = "9999";
    elem.style.position = "absolute";
    elem.style.select = "none";
    let x = e.pageX;
    let y = e.pageY;
    elem.style.left = (x - 10) + "px";
    elem.style.top = (y - 20) + "px";
    elem.innerText = "🎵";
    elem.style.fontSize = Math.random() * 10 + 15 + "px";
    let increase = 0;
    let anim;
    setTimeout(function() {
      anim = setInterval(function() {
        if (++increase === 150) {
          clearInterval(anim);
          body.removeChild(elem);
        }
        elem.style.top = y - 20 - increase + "px";
        elem.style.opacity = (150 - increase) / 120;
      }, 10);
    }, 100);
    body.appendChild(elem);
  };
};

function dosome(){
  window.uploadtxtja(contenet)
}
document.querySelector('#uploadjianputxt').onclick = function () {
  dosome()
};