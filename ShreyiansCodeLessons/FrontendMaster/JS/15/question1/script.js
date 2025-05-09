var paragraph = document.querySelector('p');
var button = document.querySelector('button');
console.log(button);
var count = 0;
button.addEventListener('click',function(){
    if(count==0){

        paragraph.innerText= paragraph.innerText+" Somit";
        count =1;
    }
    else{
        paragraph.innerText= "Hello, ";
        count=0;
    }
})