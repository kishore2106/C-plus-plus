// sw.js
// method that runs when service worker is installed first time
self.addEventListener('install', event => {
    console.log('service worker installing');
    // loading static html into cache first

    self.skipWaiting();
});

// method that runs when the service worker is activated
self.addEventListener('activate', event => {
    console.log('service worker activating...')
});

// method that will run when the app makes fetch calls
self.addEventListener('fetch', event => {
    console.log('fetching', event.request.url);
});