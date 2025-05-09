let start  = document.querySelector(".start");
let stop = document.querySelector(".stop");
let h3 = document.querySelector("h3");
var count = 0;
var st = 0;
 var interval;
start.addEventListener("click", function () {

 if(st == 0){
    
     count = Number(h3.textContent);
     st = 1;
     start.textContent = " 🛑 Pause";
     interval = setInterval(function () {
       h3.textContent = count;
       count++;
     }, 1000);
 }
 else if(st == 1){
    start.textContent = "🠊 START";
      st = 0;
    count = Number(h3.textContent);
    clearInterval(interval);
 }
});

stop.addEventListener("click",function(){
    
     
      
     h3.textContent = "0";
    
    clearInterval(interval);
    st = 0;
    start.textContent = "🠊 START";
})