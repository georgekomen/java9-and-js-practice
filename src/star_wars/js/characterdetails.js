var urlParams = new URLSearchParams(window.location.search);
var detailsUrl = urlParams.get('detailsUrl');

var request = new XMLHttpRequest();
request.open('GET', detailsUrl, true);
request.onload = function() {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {

        console.log(data);

    } else {
        alert('error fetching data');
    }
};
request.send();