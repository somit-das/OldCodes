let tl1 = gsap.timeline();
tl1.from("#main",{
    scale:-30,
    opacity:0,
    duration:6,
    rotate:"3990"

})
tl1.from('#nav h3, #nav a',{
    y: -50,
    opacity:0,
    // delay:0.5,
    delay:1,
    duration:0.5,
    stagger:0.5
})

tl1.from('#main h1',{
   x:-500,
   opacity:0,
//    delay:0.5,
   stagger:1
})

tl1.from('#main img',{
    x:500,
    rotate:60,
    opacity:0,
    duration:0.5,
    stagger:1
})
tl1.from('#main #footer h3',{
    x:-500,
    rotate:60,
    opacity:0,
    duration:1,
    stagger:1
})


let circle1 = document.querySelector("#circle1");
let circle2 = document.querySelector("#circle2");
let body = document.querySelector("body");
body.addEventListener('mousemove',function(ev){
    // screen
    // console.log(ircle1.getBoundingClientRect().x);
    
    // if(circle1.getBoundingClientRect().x== circle2.getBoundingClientRect().x && circle1.getBoundingClientRect().y==circle2.getBoundingClientRect().y){
    //     circle1.style.display="none";
    // }
    // else{
        circle1.style.left = `${ev.clientX - 7}px`;
        circle1.style.top = `${ev.clientY - 7}px`;
        circle1.style.display = "initial";
    // }
})