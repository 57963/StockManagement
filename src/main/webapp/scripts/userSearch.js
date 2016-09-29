function userFilter() {
    var length=document.getElementById("search").rows.length;
    for(var u = 2; u<length;u++){
        document.getElementById("search").deleteRow(-1);
    }
    var served = false;
    for(var i = 0; i<Object.keys(users).length;i++){
        if(users[i].ID==document.getElementById("userID").value || document.getElementById("userID").value==""){
            if(users[i].name.toUpperCase().includes(document.getElementById("userName").value.toUpperCase()) || document.getElementById("userName").value==""){
                if(users[i].location.toUpperCase().includes(document.getElementById("userLocation").value.toUpperCase()) || document.getElementById("userLocation").value==""){
                    if(users[i].rights==document.getElementById("userRights").value || document.getElementById("userRights").value=="All"){
                        var row =document.getElementById("search").insertRow(-1);
                        served = true;
                        row.insertCell(0).innerHTML=users[i].ID;
                        row.insertCell(1).innerHTML=users[i].name;
                        row.insertCell(2).innerHTML=users[i].location;
                        row.insertCell(3).innerHTML=users[i].rights;
                        row.insertCell(4).innerHTML="<form action='/removeUser?ID="+users[i].ID+"' method='post'><input type='submit' value='×'></form>";
                    }

                }
            }

        }
    }
    if(!served){
        var row =document.getElementById("search").insertRow(-1);
        cell = row.insertCell(-1);
        cell.setAttribute("colspan",4);
        cell.setAttribute("style","text-align: center");
        cell.innerHTML="<span >No results.</span>";
    }
}