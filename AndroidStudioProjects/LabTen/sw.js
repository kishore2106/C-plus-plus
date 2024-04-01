self.addEventListener("install",e=>{
    console.log("Service Worker has been installed");
    self.skipWaiting();
});

self.addEventListener("activate",e=>{
    console.log("Service Worker has been activating...");
});

self.addEventListener("fetch",event=>{
    console.log("fetched",event.request.url);
});