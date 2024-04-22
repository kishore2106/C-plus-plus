function register(){
    if('serviceWorker' in navigator){
        navigator.serviceWorker
        .register("sw.js")
        .then((reg)=>console.log("registered",reg))
        .catch((err)=>console.log("Error",err));
    }else{
        console.log("Service Worker doesn't support for this browser");
    }
}

function unregister(){
    if('serviceWorker' in navigator){
        navigator.serviceWorker
        .getRegistrations()
        .then((registrations)=>{
            registrations.forEach((registration)=>{
                registration.unregister()
                .then(()=>console.log("unregistered"))
                .catch((err)=>console.error("Error",err));
            });
        });
    }
    
}