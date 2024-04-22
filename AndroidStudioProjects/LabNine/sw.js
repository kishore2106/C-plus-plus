self.addEventListener("install",e=>{
    console.log("installed");
    e.waitUntil(
        caches.open('gitdata')
        .then(cache=>
            cache.addAll([
                '/git'
            ])
        )
    )
});

self.addEventListener("activate",(e)=>{
    e.waitUntil(caches.delete('gitdata'));
    console.log("activated");
});

self.addEventListener("fetch", e=>{
    console.log("fetched");
    console.log(e.request);
    e.respondWith(
        caches.match(e.request).then(async (response)=>{
            if(response){
                return response;
            }
            let data=await fetch(e.request);
            let dataClone = (await data).clone();
            e.waitUntil(caches.open('gitdata').then(cache=>cache.put(e.request,dataClone)));
            return data;
        })
    )
});