<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" />
    <title>Home</title>
    <link rel="stylesheet" href="/css/style.css">
    
</head>
<body>
    <!-- Menu -->
    <nav class="nav main-menu">
        <#list menu as item>
            <a class="nav-link menu-tem" href="${item.path}">${item.title}</a>
        </#list>
    </nav>
    <div class="people_container">
    <table class="people_table">
        <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
        </tr>
    <#list people as p>
        <tr>
            <td>${p.persons_id}</td>
            <td>${p.first_name}</td>
            <td>${p.last_name}</td>
            <td>${p.phone_number}</td>
            <td><a class="edit-btn" href="/edit/${p.persons_id}">Edit</a></td>
            <td><a class="delete-btn" onclick="show_deleteDialog(${p.persons_id}, '${p.first_name}')" href="#">Delete</a></td>
           <!-- <td><a class="delete-btn" onclick="delete_person_confirm(${p.persons_id}, '${p.first_name}')" href="#">Delete</a></td>
            -->
        </tr>
    </#list>
    </table>
    </div>

    <#if deletePerson ??>
        <#if deletePerson == "true">
            <div class="info_message">
                Person is successfully deleted!
            <button id="btn-close" onclick="close_message()">X</button>
        </div>
        <#else>
            <div class="error_message">
                Something is wrong!
            <button id="btn-close" onclick="close_message()">X</button>
        </div>
        </#if>
    </#if>

    <div id="dialog" class="delete-dialog">
        <p>Do you wish to delete person</p>
        <p>ID: <span id="persons_id"></span></p>
        <p>Fisrt name: <span id="first_name"></span></p>
        <div>
            <button type="button" class="btn btn-secondary btn-sm" onclick="delete_person()">Yes</button>
            <button type="button" class="btn btn-secondary btn-sm" onclick="close_dialog()">No</button>
        </div>
    </div>

    <script>
        /*function delete_person_confirm(persons_id, first_name){
            let dialog = confirm("Do you wish delete person with ID: " + persons_id + "\n" + first_name);
            if(dialog == true){
                window.location = "delete/" + persons_id;
            }
        }*/

        function close_message() {
            document.getElementById("btn-close").parentElement.remove();
        }

        function show_deleteDialog(persons_id, first_name){
            document.getElementById("persons_id").innerHTML = persons_id;
            document.getElementById("first_name").innerHTML = first_name;
            document.getElementById("dialog").style.display = "block";
        }

        function delete_person(){
            let id = document.getElementById("persons_id").innerHTML;
            window.location = "delete/" + id;
        }

        function close_dialog(){
            document.getElementById("dialog").style.display = 'none';
        }

    </script>

</body>
</html>