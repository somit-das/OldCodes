/*
var i=0;
setInterval(function(){
    var titles=['a Java Developer','a Gamer ', 'a Programmer', 'a Data Analyst','a UI Designer'];//add more titles if you want
    // var colors=['#3b82f6','#121481','#FFEAE3','#FFCBCB','#FFB1B1'];
    // var text_colors=['EF476F','#06A2BF','#E3F8FF','#CBFFFF2','#B1FFFF']
    var text_colors = ['#E70A3E','#09E8D5','#67AC42','#754724','#EC63CA']
    var colors=['#000000','#303E3D','#000000','#ABD5C4','#ABD5C4']
    if(i===titles.length) {
        i=0;
    }
    // document.title = titles[i];
    document.querySelector('.job-specification').textContent = titles[i];
    document.querySelector('.job-specification').style.backgroundColor = colors[i];
    document.querySelector('.job-specification').style.color = text_colors[i];
    
    i++;
    
}, 5000);
*/

let i = 0;
var index = 0;
var txt = 'Lorem ipsum dummy text blabla.';
var text_colors = ['#E70A3E','#09E8D5','#67AC42','#754724','#EC63CA']
var colors=['#000000','#303E3D','#000000','#ABD5C4','#ABD5C4']
var titles=['a Java Developer','a Gamer ', 'a Programmer', 'a Data Analyst','a UI Designer'];
var speed = 50;
// // debugger;
// function typeWriter() {
//   if (i < (titles[index]).length) {
//     setTimeout(typeWriter, speed);  
//     document.querySelector('.job-specification').textContent += titles[index].charAt(i);
//     i++;
//     // document.querySelector('.job-specification').textContent = titles[i];
//     document.querySelector('.job-specification').style.backgroundColor = colors[index];
//     document.querySelector('.job-specification').style.color = text_colors[index];
//   }
//   else{
//     i = 0;
//   }
// }
// setInterval(()=>{
//     document.querySelector('.job-specification').textContent='';
//     if(index == titles.length){
//         index = 0;
//     }
//     index++;
//     typeWriter();
// },500);


const carouselText = [
  { text: "A Java Developer", color: "#E70A3E" },
  { text: "A Web Developer", color: "#09E8D5" },
  { text: "A Game Designer", color: "#67AC42" },
  { text: "A Data Analyst", color: "#754724" },
  { text: "A Cyber Expert", color: "#EC63CA" },
];

$(document).ready(async function () {
  carousel(carouselText, ".job-specification");
});

async function typeSentence(sentence, eleRef, delay = 100) {
  const letters = sentence.split("");
  let i = 0;
  while (i < letters.length) {
    await waitForMs(delay);
    $(eleRef).append(letters[i]);
    i++;
  }
  return;
}

async function deleteSentence(eleRef) {
  const sentence = $(eleRef).html();
  const letters = sentence.split("");
  let i = 0;
  while (letters.length > 0) {
    await waitForMs(100);
    letters.pop();
    $(eleRef).html(letters.join(""));
  }
}

async function carousel(carouselList, eleRef) {
  var i = 0;
  while (true) {
    updateFontColor(eleRef, carouselList[i].color);
    await typeSentence(carouselList[i].text, eleRef);
    await waitForMs(1500);
    await deleteSentence(eleRef);
    await waitForMs(500);
    i++;
    if (i >= carouselList.length) {
      i = 0;
    }
  }
}

function updateFontColor(eleRef, color) {
  $(eleRef).css("color", color);
}

function waitForMs(ms) {
  return new Promise((resolve) => setTimeout(resolve, ms));
}