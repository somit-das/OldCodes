var i=0;
setInterval(function(){
    var titles=['a C++ Developer','a Nerd ', 'a Programmer', 'a Data Analyst','a UI Designer'];//add more titles if you want
    var colors=['#00ffff',,'#121481','#FFEAE3','#FFCBCB','#FFB1B1'];
    var text_colors=['#FF0000','#06A2BF','#E3F8FF','#CBFFFF2','#B1FFFF']
    if(i===titles.length) {
        i=0;
    }
    // document.title = titles[i];
    document.querySelector('.job-specification').textContent = titles[i];
    document.querySelector('.job-specification').style.backgroundColor = colors[i];
    document.querySelector('.job-specification').style.color = text_colors[i];
    
    i++;
    
}, 5000);