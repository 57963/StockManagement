var navOpen = false;
var openList = "";
var iconColor = "white";

function toggleNav() {
    navOpen=!navOpen;
    if(navOpen){
        document.getElementById("navBar").style.width = "240px";
        document.getElementById("navBar").style.height = "100%";
        document.getElementById("navBar").firstElementChild.innerHTML = "&times;";
        document.getElementById("navBar").style.backgroundColor = "rgb(59,62,67)";
        document.getElementById("navBar").style.color = "white";
    } else{
        document.getElementById("navBar").style.width = "40px";
        document.getElementById("navBar").style.height = "50px";
        document.getElementById("navBar").firstElementChild.innerHTML = "&#9776;";
        document.getElementById("navBar").style.backgroundColor = "transparent";
        iconUpdate();
        document.getElementById("navBar").style.color = iconColor;
        [].forEach.call(document.getElementsByClassName("sublist"),function (sublist) {sublist.style.height = 0;});
    }

}

function toggleSublist(listName, listHeight){
    [].forEach.call(document.getElementsByClassName("sublist"),function (sublist) {sublist.style.height = 0;});
    document.getElementById(listName).style.height = listHeight;
    if(openList == listName){
        document.getElementById(listName).style.height = "0";
        openList = "";
    } else {
        openList = listName;
    }
}

function iconUpdate(){
    if ((document.body.scrollTop > 40 || document.documentElement.scrollTop > 40)&&!navOpen) {
        iconColor = "rgb(59,62,67)";
        document.getElementById("navBar").style.backgroundColor = "transparent";
    } else {
        iconColor = "white";
        document.getElementById("navBar").style.backgroundColor = "rgb(59,62,67)";
    }
    document.getElementById("navBar").style.color = iconColor;
}