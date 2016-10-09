function userFilter() {
    var length=document.getElementById("search").rows.length;
    for(var u = 2; u<length;u++){
        document.getElementById("search").deleteRow(-1);
    }
    var served = false;
    for(var i = 0; i<Object.keys(users).length;i++){
        if(users[i].ID==document.getElementById("userID").value || document.getElementById("userID").value==""){
            if((users[i].firstName + " " +users[i].surname).toUpperCase().includes(document.getElementById("userName").value.toUpperCase()) || document.getElementById("userName").value==""){
                if(users[i].location.name.toUpperCase().includes(document.getElementById("userLocation").value.toUpperCase()) || document.getElementById("userLocation").value==""){
                    if(users[i].rights==document.getElementById("userRights").value || document.getElementById("userRights").value=="All"){
                        var row =document.getElementById("search").insertRow(-1);
                        served = true;
                        row.insertCell(0).innerHTML=users[i].ID;
                        row.insertCell(1).innerHTML=users[i].firstName + " " +users[i].surname;
                        row.insertCell(2).innerHTML=users[i].location.name;
                        row.insertCell(3).innerHTML=users[i].rights;
                        row.insertCell(4).innerHTML="<form  action='/removeUser?ID="+users[i].ID+"' method='post'><input  class='removeUser' type='submit' value='×'></form>";
                        row.insertCell(5).innerHTML="<input class='editUser' type='submit' value='U' onclick='editUser("+i+")'>"
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

function editUser(i) {
    document.getElementById("form").innerHTML = "<form autocomplete='off' style='margin: 0' id='editUserForm' action='/editUser?ID="+users[i].ID+"' method='post'></form>";
    for(var u = 0;u<document.getElementsByClassName("editUser").length;u++){
        document.getElementsByClassName("removeUser")[u].setAttribute("disabled","true");
        document.getElementsByClassName("editUser")[u].setAttribute("disabled","true");
    }
    row =document.getElementById("search").rows[i+2];
    row.cells[1].innerHTML="<input style='width:50%;' type='text' name='firstName' form='editUserForm' value='"+users[i].firstName+"'><input style='width:50%;' type='text' name='surname' form='editUserForm' value='"+users[i].surname+"'>";
    var  locationInput = "<select style='width:100%;' name = 'location' form='editUserForm'>";
    for(var u = 0; u<Object.keys(locations).length;u++){
        locationInput+="<option "+ (locations[u]==users[i].location?"selected":"")+" value='"+locations[u].ID+"'>"+locations[u].name+"</option>";
    }
    locationInput+="</select>";
    row.cells[2].innerHTML=locationInput;
    row.cells[3].innerHTML="<select style='width:100px;' name = 'rights' form='editUserForm'><option value='1'>Admin</option> <option value='0' "+(users[i].rights=="User"?"selected":"")+">User</option> </select>";
    row.cells[4].innerHTML="<input value='×' type='submit' onClick='userFilter()'>";
    row.cells[5].innerHTML="<input value='U' type='submit' form='editUserForm'></form>";
}