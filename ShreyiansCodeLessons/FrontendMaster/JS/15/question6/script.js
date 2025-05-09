let tabs = document.querySelectorAll(".tab");
let texts = document.querySelectorAll(".content")
let home = document.querySelector("#home");
let about = document.querySelector("#about");
let contact = document.querySelector("#contact");

let hometext = document.querySelector("#hometext");
let abouttext = document.querySelector("#abouttext");
let contacttext = document.querySelector("#contacttext");

// home.addEventListener("click",function(){
//     removeAll();
//     hometext.style.display="initial";
//     // abouttext.style.display="none";
//     // contacttext.style.display="none";
// })

// about.addEventListener("click", function () {
//     removeAll();
//   abouttext.style.display = "initial";
// //   contacttext.style.display = "none";
// //   hometext.style.display = "none";
// });

// contact.addEventListener("click", function () {
//     removeAll();
//   contacttext.style.display = "initial";
// //   hometext.style.display = "none";
// //   abouttext.style.display = "none";
// });

function removeAll(){
    document.querySelectorAll(".content").forEach(function(content){
        content.style.display="none";
    })
}

tabs.forEach(function(tab,index){
    tab.addEventListener("click",function(){
        removeAll();
        texts[index].style.display="initial";
    })
})