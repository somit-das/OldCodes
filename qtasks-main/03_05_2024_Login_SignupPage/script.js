let loginValidation=(e)=>{
    e.preventDefault();
    console.log(e.target[0]);
    console.log(e);
    
    let userName = e.target[0];
    let passWord = e.target[1];
    console.log(userName);
    console.log(passWord);
    // console.log(userName, passWord);
    let err = `border:solid 2px red`;
    if (userName.value === " " || userName.value === null) {
        userName.style.cssText = err;
        console.log("error");
    } 
    if (passWord.value === "" || passWord.value === null) {
      passWord.style.cssText = err;
    }
}
let loginValidation2=(e)=>{
 
  e.preventDefault();
  console.log(e.target[0]);
  console.log(e);
  let MobNum_Email = e.target[0];
  console.log(MobNum_Email);
  console.log(MobNum_Email.value);
  let fullName = e.target[1];
  let userName = e.target[2];
  let passWord = e.target[3];
  let err = `border:solid 2px red`;
  if(MobNum_Email.value === "" || MobNum_Email.value === null){
    MobNum_Email.style.cssText = err;
    console.log("Mobile Number and Email data can not be empty");
  }
  if (fullName.value === "" || fullName.value === null) {
    fullName.style.cssText = err;
    console.log("Full Name can not be empty");
  }
  if (userName.value === "" || userName.value === null) {
    userName.style.cssText = err;
    console.log("User Name can not be empty");
  }
  if (passWord.value === "" || passWord.value === null) {
    passWord.style.cssText = err;
    console.log("passWord can not be empty");
  }
}