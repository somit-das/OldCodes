gsap.to("#page2 img",{
    width:"90%",
    // height:"90%",
    scrollTrigger:{
        trigger:"#page2",
        scroller:"body",
        markers :true,
        start:"top 0",
        end:"top -100%",
        scrub:2,
        pin:true
        
    }

})

gsap.from("#page3 .circle", {
  scale: 0,
  delay: 1,
  duration: 2,
  rotate: 720,
  //   scrollTrigger:"#page2 .circle"
  scrollTrigger: {
    trigger: "#page3 .circle",
    scroller: "body",
    markers: true,
    // scrub:true,
    scrub: 2,
    start: "top 60%",
    end: "top 10%",
    
  },
});