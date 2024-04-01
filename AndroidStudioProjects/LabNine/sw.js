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

self.addEventListener("fetch", (event) =>{
    console.log("fetched");
    console.log(event.request);
    event.responseWith(
        caches.match(event.request).then(async (response)=>
        {
            if(response){
                return response;
            }
            let data=fetch(event.request);
            let dataClone=(await data).clone();
            event.waitUntil(caches.open('gitdata').then((cache)=> cache.put(event.request,dataClone)));
            return data;  
        })
    )
});