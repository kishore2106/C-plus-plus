self.addEventListener('install',event=>{
    console.log("Service Worker Installed");
});

self.addEventListener('activate',event=>{
    console.log("Service Worker Activating...");
});

self.addEventListener('fetch',event=>{
    console.log("fetching",event.request.url);
});