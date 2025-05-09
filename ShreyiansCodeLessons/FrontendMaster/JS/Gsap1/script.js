gsap.to("#box",{
    x:1000,       // in x-axis willgo 1000px
    duration:20,  //  time will to be in final position
    delay:1,
    rotate:340,
    backgroundColor:"blue"
})

gsap.from("#box2", {
  x: 1000,
  duration: 2, 
  delay: 1,
  rotate: 90,
  backgroundColor: "red", 
});

// GSAP TIME LINE

// without using delay keeping same time line
gsap.to("#box3",{
    x:1200,
    duration:2,
    delay:2,
    rotate:180,
    scale:0.5,
})

gsap.to("#box4", {
  x: 1200,
  duration: 2,
  delay: 3,
  rotate: 180,
  scale: 0.5,
});


gsap.to("#box5", {
  x: 1200,
  duration: 2,
  delay: 4,
  rotate: 180,
  scale: 0.5,
});

// Using GSAP TImeline
let tl = gsap.timeline();
tl.to("#box6", {
  x: 1200,
  duration: 2,
//   delay: 4,
  rotate: 180,
  scale: 0.5,
});

tl.to("#box7", {
  x: 1200,
  duration: 2,
  //   delay: 4,
  rotate: 180,
  scale: 0.5,
});

tl.to("#box8", {
  x: 1200,
  duration: 2,
  //   delay: 4,
  rotate: 180,
  scale: 0.5,
});