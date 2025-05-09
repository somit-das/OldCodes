function textSplit(){
    var allh1 = document.querySelectorAll("#page2 h1");
    allh1.forEach(function (h1) {
      var clutter = "";
      var splittedText = h1.textContent.split("");
      splittedText.forEach(function (stext) {
        clutter += `<span>${stext}</span>`;
      });
      h1.innerHTML = clutter;
    });
}


function locoScroll(){
    
    // const scroll = new LocomotiveScroll({
        //   el: document.querySelector("#main"),
        //   smooth: true,
        // });
    gsap.registerPlugin(ScrollTrigger);

    // Using Locomotive Scroll from Locomotive https://github.com/locomotivemtl/locomotive-scroll

    const locoScroll = new LocomotiveScroll({
      el: document.querySelector("#main"),
      smooth: true,
    });
    // each time Locomotive Scroll updates, tell ScrollTrigger to update too (sync positioning)
    locoScroll.on("scroll", ScrollTrigger.update);

    // tell ScrollTrigger to use these proxy methods for the "#main" element since Locomotive Scroll is hijacking things
    ScrollTrigger.scrollerProxy("#main", {
      scrollTop(value) {
        return arguments.length
          ? locoScroll.scrollTo(value, 0, 0)
          : locoScroll.scroll.instance.scroll.y;
      }, // we don't have to define a scrollLeft because we're only scrolling vertically.
      getBoundingClientRect() {
        return {
          top: 0,
          left: 0,
          width: window.innerWidth,
          height: window.innerHeight,
        };
      },
      // LocomotiveScroll handles things completely differently on mobile devices - it doesn't even transform the container at all! So to get the correct behavior and avoid jitters, we should pin things with position: fixed on mobile. We sense it by checking to see if there's a transform applied to the container (the LocomotiveScroll-controlled element).
      pinType: document.querySelector("#main").style.transform
        ? "transform"
        : "fixed",
    });

    // each time the window updates, we should refresh ScrollTrigger and then update LocomotiveScroll.
    ScrollTrigger.addEventListener("refresh", () => locoScroll.update());

    // after everything is set up, refresh() ScrollTrigger and update LocomotiveScroll because padding may have been added for pinning, etc.
    ScrollTrigger.refresh();
        
}



// gsap
function gsapAnimation(){
    let tl = gsap.timeline();
    tl.from("#page1 h1, #page1 h2", {
      y: -2000,
      opacity: 0,
      delay: 1,
      duration: 1,
      stagger: 1,
    });

    tl.from("#page1 img", {
      height: "400px",
      width: "600px",

      // left:"50%",
      // top:"50%",
      transform: "translate(0%,50%)",
      borderRadius: 5,
      delay: 1,
      duration: 0.8,
    });
    tl.from("#page1 #nav-bar", {
      x: -1000,
      opacity: 0,
      stagger: 1,
      duration: 2,
    });
    gsap.to("#page2 h1 span", {
      color: "black",
      duration: 1,
      delay: 1,
      stagger: 0.2,
      fontFamily: "Rampart One",
      scrollTrigger: {
        trigger: "#main #page2 h1",
        scroller: "#main",
        // start:"top 0%",
        start: "top 50%",
        end: "top -10%",
        scrub: 2,
        markers: true,
      },
    });
}

locoScroll();
textSplit();
gsapAnimation();
