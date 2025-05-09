var images = document.querySelectorAll('#main .images img');
var button = document.querySelector('.btn')

button.addEventListener('click',function(){
    var temp = images[0].src;
    images[0].src = images[1].src;
    images[1].src = temp;
})