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
    
    
    
    function unregister() {
        if ('serviceWorker' in navigator) {
            navigator.serviceWorker
            .getRegistrations()
            .then((registrations) => {
                    registrations.forEach((registration) => {
                        registration.unregister()
                            .then(() => console.log("Service Worker unregistered"))
                            .catch((err) => console.error("Service Worker unregistration failed:", err));
                    });
                });
        }
    }