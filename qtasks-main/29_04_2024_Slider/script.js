let image = document.querySelector('img');

let index = 1;
let numofimages = 5;

let nexImage = () =>{

    ++index;
	image.src = `./Images/${index}.jpg`;
    
    if(index>numofimages){
        index = 1;
    }
}

let prevImage = () =>{
	
	if(index>=2){
		index--;
		image.src = `./Images/${index}.jpg`;
    
   
	}else{
		index=numofimages;
		image.src = `../../JS/Images/${index}.jpg`;
	}
		
}