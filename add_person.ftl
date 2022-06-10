<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Add person</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/style.css">
</head>
<body>

    <nav class="nav main-menu">
        <#list menu as item>
            <a class="nav-link menu-tem" href="${item.path}">${item.title}</a>
        </#list>
    </nav>
    <div class="addPerson_container">
        <div class="addPerson_dataBox">
        <form action="/add" method="post"> 
            <label for="f_name">First name:</label><br>
            <input class="inutp_text" type="text" name="f_name"><br>
            <label for="l_name">Last name:</label><br>
            <input class="inutp_text" type="text" name="l_name"><br>
            <label for="phone_number">Phone number:</label><br>
            <input class="inutp_text" type="text" name="phone_number"><br>
            <input class="btn_addPerson" type="submit" value="Save">
         </form>
         </div>
    </div>

<#if savePerson??>
    <#if savePerson == "true">
        <div class="info_message">
            Data is successfully saved!
            <button id="btn-close" onclick="close_message()">X</button>
        </div>
    <#else>
        <div class="error_message">
            Something is wrong!
            <button id="btn-close" onclick="close_message()">X</button>
        </div>
    </#if>
</#if>

    <script>
        function close_message() {
            document.getElementById("btn-close").parentElement.remove();
        }
    </script>

</body>
</html>