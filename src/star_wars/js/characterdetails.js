var urlParams = new URLSearchParams(window.location.search);
var detailsUrl = urlParams.get('detailsUrl');
var data;
var request = new XMLHttpRequest();
request.open('GET', detailsUrl, true);
request.onload = function() {
    // Begin accessing JSON data here
    data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {
        var html = "<h2>" + data.name;
        if (isFavourite(data.url)) {
            html += "<i style='margin-left: 1em;  color: red' onclick='makeFavourite(this.id)' class='fas fa-heart'" + "id=" + data.url + "></i>";
        } else {
            html += "<i style='margin-left: 1em; color: grey' onclick='makeFavourite(this.id)' class='fas fa-heart'" + "id=" + data.url + "></i>";
        }
        if (isFavourite(data.url)) {
            html += "<i style='margin-left: 1em; color: grey' onclick='removeFromFavourite(this.id)' class='fas fa-trash-alt'" + "id=" + data.url + "></i>";
        }
        html += "</h2>";

        html += "<span>";
        html += "<h3>" + "Bio information" + "</h3>";
        html += "Height: " + data.height;
        html += "<br>";
        html += "Mass: " + data.mass;
        html += "<br>";
        html += "Hair color: " + data.hair_color;
        html += "<br>";
        html += "Skin color: " + data.skin_color;
        html += "<br>";
        html += "Eye color: " + data.eye_color;
        html += "<br>";
        html += "Birth year: " + data.birth_year;
        html += "<br>";
        html += "Gender: " + data.gender;
        html += "<br>";
        html += "Home world: " + data.home_world;
        html += "<br>";
        html += "Created: " + data.created;
        html += "<br>";
        html += "url: " + data.url;
        html += "<br>";
        html += "</span>";

        if (data.films.length > 0) {
            html += "<h3>" + "Films" + "</h3>";
            html += "<ul>";
            for (var i = 0; i < data.films.length; i++) {
                html += "<li>" + data.films[i] + "</li>";
            }
            html += "</ul>";
        }

        if (data.species.length > 0) {
            html += "<h3>" + "Species" + "</h3>";
            html += "<ul>";
            for (var i = 0; i < data.species.length; i++) {
                html += "<li>" + data.species[i] + "</li>";
            }
            html += "</ul>";
        }

        if (data.vehicles.length > 0) {
            html += "<h3>" + "Vehicles" + "</h3>";
            html += "<ul>";
            for (var i = 0; i < data.vehicles.length; i++) {
                html += "<li>" + data.vehicles[i] + "</li>";
            }
            html += "</ul>";
        }

        if (data.starships.length > 0) {
            html += "<h3>" + "Starships" + "</h3>";
            html += "<ul>";
            for (var i = 0; i < data.starships.length; i++) {
                html += "<li>" + data.starships[i] + "</li>";
            }
            html += "</ul>";
        }

        document.getElementById("details_div").innerHTML = html;

    } else {
        alert('error fetching data');
    }
};
request.send();

function makeFavourite(url) {
    var favouritesMap = JSON.parse(localStorage.getItem('favouritesMap'));
    if (!!favouritesMap) {
        if (!favouritesMap.includes(url)) {
            favouritesMap.push(url);
        }
    } else {
        favouritesMap = [];
        favouritesMap.push(url);
    }
    localStorage.setItem('favouritesMap', JSON.stringify(favouritesMap));
    document.getElementById(url).style.color = 'red';
}

function isFavourite(url) {
    var favouritesMap = JSON.parse(localStorage.getItem('favouritesMap'));
    if (!!url && !!favouritesMap) {
        return favouritesMap.includes(url);
    }
}

function removeFromFavourite(url) {
    var favouritesMap = JSON.parse(localStorage.getItem('favouritesMap'));
    favouritesMap.splice(favouritesMap.indexOf(url), 1);
    localStorage.setItem('favouritesMap', JSON.stringify(favouritesMap));
    document.getElementById(url).style.color = 'grey';
}