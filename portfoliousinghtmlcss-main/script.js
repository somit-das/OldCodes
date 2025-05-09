// let loginPageValidation = (e) => {
//   e.preventDefault();

//   let user = e.target[0];
//   let pass = e.target[1];

//   let err = `border:solid 2px red`;
//   if (user.value === "" || user.value === null) {
//     user.style.cssText = err;
//   } else if (pass.value === "" || pass.value === null) {
//     pass.style.cssText = err;
//   }
// };

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

// let i = 0;
// var index = 0;
// var txt = 'Lorem ipsum dummy text blabla.';
// var text_colors = ['#E70A3E','#09E8D5','#67AC42','#754724','#EC63CA']
// var colors=['#000000','#303E3D','#000000','#ABD5C4','#ABD5C4']
// var titles=['a Java Developer','a Backend Developer ', 'a Programmer', 'a Data Analyst','a UI Designer'];
// var speed = 50;

// function typeWriter() {
//   if (i < titles[index].length) {
//     document.querySelector('.job-specification').textContent += titles[index].charAt(i);
//     i++;
//     setTimeout(typeWriter, speed);
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
// },2000);

// let lightDark = () =>{
//     let btn = document.querySelector('.fa-sun');

//     btn.classList.toggle('fa-solid');
//     btn.classList.toggle('fa-regular');
//     // console.log(btn)
//     document.querySelector("body").classList.toggle('body_Color');
//     document.querySelector("a").classList.toggle('whiteColors');

// }
