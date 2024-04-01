function register(){
    if('serviceWorker' in navigator){
        navigator.serviceWorker
        .register('sw.js')
        .then((reg)=>console.log("Registered"),reg)
        .catch((err)=>console.error(err));
    }else{
        console.log('No service worker support for this browser');
    }
}