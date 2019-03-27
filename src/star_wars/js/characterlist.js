var request = new XMLHttpRequest();
request.open('GET', 'https://swapi.co/api/people/', true);
request.onload = function() {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {

        var html = "<ul>";
        for (var i = 0; i < data.results.length; i++) {
            html += "<li onclick='gotToDetailsPage(this.id)' id=" + data.results[i].url + ">" + data.results[i].name;
            if (isFavourite(data.results[i].url)) {
                html += "<i style='margin-left: 1em; color: red' class='fas fa-heart'></i>";
            } else {

            }
            html += "</li>";
        }
        html+="</ul>";
        document.getElementById("character_list").innerHTML = html;

    } else {
        alert('error fetching data');
    }
};
request.send();


function gotToDetailsPage(url) {
    var querystring = '?detailsUrl=' + url;
    window.open('./details.html' + querystring, '_blank');
}


function isFavourite(url) {
    var favouritesMap = JSON.parse(localStorage.getItem('favouritesMap'));
    if (!!url && !!favouritesMap) {
        return favouritesMap.includes(url);
    }
}