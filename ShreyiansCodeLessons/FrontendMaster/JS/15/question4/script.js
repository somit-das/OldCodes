
var ul = document.querySelector("#main ul");
var input = document.querySelector("input")
var add = document.querySelector(".add");
var remove = document.querySelector(".remove");

var li;
add.addEventListener("click",function(){
    if(input.value.trim()==""){
        alert("Nothing to add");
        return;
    }
    li = document.createElement('li');
    li.textContent = input.value.trim();
  
    ul.appendChild(li);
})

remove.addEventListener("click",function(){
    ul.removeChild(li); 

})