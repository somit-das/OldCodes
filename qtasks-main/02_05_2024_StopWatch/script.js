let digitalClock = () =>{
    let span = document.getElementsByTagName('span');
    let dateObj = new Date();
    span[0].innerText = dateObj.getHours();
    span[1].innerText = dateObj.getMinutes();
    span[2].innerText = dateObj.getSeconds();
    span[3].innerText = dateObj.getDate();
    span[4].innerText = dateObj.getMonth();
    span[5].innerText = dateObj.getFullYear();
    span[6].innerText = dateObj.getDay();
}
let digitalClock2 = ()=>{
      let span = document.getElementsByTagName('span');
    let dateObj = new Date();
    span[0].innerText = dateObj.toLocaleTimeString;
    span[1].innerText = dateObj.toLocaleDateString;
}