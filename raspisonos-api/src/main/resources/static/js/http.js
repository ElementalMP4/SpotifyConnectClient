function doHttpGet(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            callback(xhr.status, xhr.responseText);
        }
    }
    xhr.open("GET", url, true);
    xhr.send();
}

function doHttpPostWithBody(url, body, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            callback(xhr.status, xhr.responseText);
        }
    }
    xhr.open("POST", url, true);
    xhr.send(body);
}

function doHttpPost(url, callback) {
    doHttpPostWithBody(url, null, callback);
}

function doHttpPutWithBody(url, body, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            callback(xhr.status, xhr.responseText);
        }
    }
    xhr.open("PUT", url, true);
    xhr.send(body);
}

function doHttpPut(url, callback) {
    doHttpPutWithBody(url, null, callback);
}

function doHttpDelete(url, callback) {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState == 4) {
            callback(xhr.status, xhr.responseText);
        }
    }
    xhr.open("DELETE", url, true);
    xhr.send();
}