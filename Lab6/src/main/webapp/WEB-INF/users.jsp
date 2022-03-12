<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Users Page</title>
        
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
        
    </head>
    <body>
        <form action="user" method="post">
            <h1>Edit Form</h1>
            <input type="hidden" name="action" value="edit">
            <label for="eEmail">Email: </label>
            <input type="text" name="eEmail" id="eEmail" value="${eUser.email}">
            <label for="eFName">First Name: </label>
            <input type="text" name="eFName" id="eFName" value="${eUser.firstName}">
            <label for="eLName">Last Name: </label>
            <input type="text" name="eLName" id="eLName" value="${eUser.lastName}">
            <label for="ePassword">Password: </label>
            <input type="text" name="ePassword" id="ePassword" value="${eUser.password}">
            <label for="eRole">Role: </label>
            <select name="eRole" id="eRole">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.name}">${role.name}</option>
                </c:forEach>
            </select>
            <button type="submit">Update</button>
        </form>
        <h1>User Table</h1>
        <table class="table">
            <thead>
                <tr>
                    <th>E-mail</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Role Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${users}" var="user">
                    <tr>
                        <td>${user.email}</td>
                        <td>${user.firstName}</td>
                        <td>${user.lastName}</td>
                        <td>${user.role.name}</td>
                        <td><a href="user?action=edit&email=${user.email}">Edit</a></td>
                        <td><a href="user?action=delete&email=${user.email}">Delete</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <form action="user" method="post">
            <h1>Add Form</h1>
            <input type="hidden" name="action" value="add">
            <label for="aEmail">Email: </label>
            <input type="text" name="aEmail" id="aEmail">
            <label for="aFName">First Name: </label>
            <input type="text" name="aFName" id="aFName">
            <label for="aLName">Last Name: </label>
            <input type="text" name="aLName" id="aLName">
            <label for="aPassword">Password: </label>
            <input type="text" name="aPassword" id="aPassword">
            <label for="aRole">Role: </label>
            <select name="aRole" id="aRole">
                <c:forEach items="${roles}" var="role">
                    <option value="${role.name}">${role.name}</option>
                </c:forEach>
            </select>
            <button type="submit">Update</button>
        </form>
        <p>${test} ${error}</p>
    </body>
</html>
