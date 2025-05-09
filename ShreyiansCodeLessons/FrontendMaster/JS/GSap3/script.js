// Without ScrollTrigger
// gsap.from("#page1 .circle",{
//     scale:0,
//     delay:1,
//     duration:2,
//     rotate:720       
// })


// gsap.from("#page2 .circle", {
//   scale: 0,
//   delay: 1,
//   duration: 2,
//   rotate: 720,
// });


// gsap.from("#page3 .circle", {
//   scale: 0,
//   delay: 1,
//   duration: 2,
//   rotate: 720,
// });

// With ScrollTrigger
gsap.from("#page1 .circle", {
  scale: 0,
  delay: 1,
  duration: 2,
  rotate: 720,

});

gsap.from("#page2 .circle", {
  scale: 0,
  delay: 1,
  duration: 2,
  rotate: 720,
//   scrollTrigger:"#page2 .circle"
  scrollTrigger:{
    trigger:"#page2 .circle",
    scroller:"body",
    markers:true,
    // scrub:true,
    scrub:2,
    start:"top 60%",
    end:"top 10%"
  }
});

gsap.from("#page3 .circle", {
  scale: 0,
  delay: 1,
  duration: 2,
  rotate: 720,
  // scrollTrigger: "#page3 .circle",
  scrollTrigger: {
    trigger: "#page3 .circle",
    scroller: "body",
    markers: true,
    scrub:true,
    // scrub: 2,
    // start: "top 40%",
    // end: "top 20%",
  },
});