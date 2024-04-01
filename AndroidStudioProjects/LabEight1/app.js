localStorage.setItem("username","rvce");
localStorage.setItem("pass","rvce");

function verify(){
    let uname = document.getElementById("username").value;
    let password = document.getElementById("password").value;
    let un = localStorage.getItem("username");
    let pass = localStorage.getItem("pass");
    
    if(un==uname && pass==password){
        alert("Auntheticated Successfully");
        register();
    }else{
        alert("Invalid Authentication");
    }

}

function register(){
    if ('serviceWorker' in navigator) {
        navigator.serviceWorker
        .register("sw.js")
        .then((reg)=>console.log("registered",reg))
        .catch((err)=>console.log("err",err));
    } else {
        console.log('No service worker support in this browser');
    }
    }

function unregister(){
    if('serviceWorker' in navigator){
        navigator.serviceWorker
        .getRegistrations()
        .then((registrations)=>{
            registrations.forEach((registration)=>{
                registration.unregister()
                .then(()=>console.log("Unregistered"))
                .catch((err)=>console.error("Servcie worker unregistration failed"),err);
            });
        });
    }
}