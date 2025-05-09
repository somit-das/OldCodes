
var i=0;
setInterval(function(){
    var titles=['a Java Developer','a Gamer ', 'a Programmer', 'a Data Analyst','a UI Designer'];//add more titles if you want
    // var colors=['#3b82f6','#121481','#FFEAE3','#FFCBCB','#FFB1B1'];
    // var text_colors=['EF476F','#06A2BF','#E3F8FF','#CBFFFF2','#B1FFFF']
    var text_colors = ['#E70A3E','#09E8D5','#67AC42','#754724','#EC63CA']
    var colors=['#000000','#303E3D','#000000','#ABD5C4','#ABD5C4']
    if(i===titles.length) {
        i=0;
    }
    // document.title = titles[i];
    document.querySelector('.job-specification').textContent = titles[i];
    document.querySelector('.job-specification').style.backgroundColor = colors[i];
    document.querySelector('.job-specification').style.color = text_colors[i];
    
    i++;
    
}, 500);
