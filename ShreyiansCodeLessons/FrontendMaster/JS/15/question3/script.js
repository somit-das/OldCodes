var fname = document.querySelector(".fname input");

var email = document.querySelector(".email input");

var uname = document.querySelector(".uname input");

var pass = document.querySelector(".passw");
var passw = document.querySelector(".passw input");

var confpass = document.querySelector(".confpass");
var confirmpass = document.querySelector(".confpass input");

var submit = document.querySelector(".submit");


email.addEventListener("keyup", function (dt) {
 
  email.value= email.value.toLowerCase();
  uname.value = email.value.split("@")[0];


});

submit.addEventListener("click", function (e) {
  e.preventDefault();
  var h4 = document.querySelector("h4");
  if (
    fname.value.trim() === "" ||
    uname.value.trim() == "" ||
    passw.value.trim() == "" ||
    email.value.trim() == "" ||
    confirmpass.value.trim() == ""
  ) {
    // var h4 = document.querySelector("h4");
    // h4.textContent = "Some Fields may be Blank";
    // h4.style.color = "red";
     if (fname.value.trim() == "") {
       document.querySelector(".fname").classList.add("error");
       h4.textContent = "Some Fields may be Blank";
       h4.style.color = "red";
     }
     if (email.value.trim() == "") {
       document.querySelector(".email").classList.add("error");
       h4.textContent = "Some Fields may be Blank";
       h4.style.color = "red";
     }
     if (uname.value.trim() == "") {
       document.querySelector(".uname").classList.add("error");
       h4.textContent = "Some Fields may be Blank";
       h4.style.color = "red";
     }
     if (passw.value.trim() == "") {
       pass.classList.add("error");
       h4.textContent = "Some Fields may be Blank";
       h4.style.color = "red";
     }
     if (confirmpass.value.trim() == "") {
       confpass.classList.add("error");
       h4.textContent = "Some Fields may be Blank";
       h4.style.color = "red";
     }
}

 
  else {
    
    h4.textContent = "";
    h4.style.color = "black";

    if (confirmpass.value != passw.value) {
      confpass.classList.add("pass_error");
      var error_content = document.styleSheets[0].cssRules[11];
      error_content.style.content = '"Passwords are not same"';
      passw.classList.add("pass_error");
    } else {
    
        h4.textContent=" Login Successfully ";
        h4.style.color='green';
        h4.style.backgroundColor='white';
        console.log("login successfully");
      document.querySelector(".uname").classList.remove("error");
      document.querySelector(".email").classList.remove("error");
      document.querySelector(".fname").classList.remove("error");
        confpass.classList.remove("error");
      confpass.classList.remove("pass_error");
      pass.classList.remove("error");
      pass.classList.remove("pass_error");
      console.log(fname.value,email.value,uname.value,passw.value,confirmpass.value);
    }
  }
});
