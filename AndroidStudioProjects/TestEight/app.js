localStorage.setItem("username","rvce");
localStorage.setItem("password","rvce");

function verify(){
    uname = document.getElementById("username").value;
    pass = document.getElementById("password").value;
    username = localStorage.getItem("username");
    password = localStorage.getItem("password");

    if(uname==username && pass==password){
        alert("Authentication successful");
        register();
    }else{
        alert("Authentication Failed");
    }
}

function register(){
    if('serviceWorker' in navigator){
        navigator.serviceWorker
        .register("sw.js")
        .then((reg)=>console.log("registered",reg))
        .catch((err)=>console.log("Error",err));
    }else{
        console.log("Service worker does not support for this browser");
    }
}

function unregister(){
    if('serviceWorker' in navigator){
        navigator.serviceWorker
        .getRegistrations()
        .then((registrations)=>{
            registrations.forEach((registration)=>{
                registration.unregister()
                .then(()=>console.log("Service Worker unregistered"))
                .catch((err)=>console.error("Error",err));
            })
        })
    }
}