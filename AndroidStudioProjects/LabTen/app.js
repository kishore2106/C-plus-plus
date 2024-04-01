if('serviceWorker' in navigator){
    navigator.serviceWorker
    .register("sw.js")
    .then((reg)=>console.log("registered"),reg)
    .cache((err)=>console.log("error"),err);
}else{
    console.log("Service Worker is not supported");
}