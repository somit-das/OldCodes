var body = document.querySelector('body');
var circle = document.querySelector("#circle");
// circle.addEventListener('mouse')
body.addEventListener('mousemove',function(det){
    console.log(det);
    circle.style.left=`${det.clientX-7}px`;
    circle.style.top = `${det.clientY-7}px`;
})