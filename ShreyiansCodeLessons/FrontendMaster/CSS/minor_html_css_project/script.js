async function functionFetchinData(){
    let app = await fetch("https://api.github.com/users");
    let data = await app.json();
    console.log(data);

    let document1 = document.querySelector(".container1");
    let document2 = document.querySelector(".container2");
    console.log(document1);
    let imgurls = data.map((i)=>{
        return i.avatar_url;
    }) 
    console.log(imgurls);
    for(i = 0;i<imgurls.length;i++){
        const newDiv1 = document.createElement("img");
        const newDiv2 = document.createElement("img");
        newDiv1.src=imgurls[i];
        newDiv2.src=imgurls[i];

        document1.appendChild(newDiv1);
        document2.appendChild(newDiv2);
    }
    console.log(document1);
    return (data);
}
let dataParsed = functionFetchinData();
