var request = new XMLHttpRequest();
request.open('GET', 'https://swapi.co/api/people/', true);
request.onload = function() {
    // Begin accessing JSON data here
    var data = JSON.parse(this.response);
    if (request.status >= 200 && request.status < 400) {

        var html = "<ul>";
        for (var i = 0; i < data.results.length; i++) {
            html+="<li>"+data.results[i].name+"</li>";
        }
        html+="</ul>";
        document.getElementById("character_list").innerHTML = html;

    } else {
        alert('error fetching data');
    }
};
request.send();