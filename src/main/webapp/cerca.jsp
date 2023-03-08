<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Mostrar clientes</title>
</head>
<body>
<h1>Mostrar clientes</h1>

<form method="post" action="mostrar-clientes">
    <label for="idFiscal">ID fiscal:</label>
    <input type="text" id="idFiscal" name="idFiscal">

    <label for="compte">Compte:</label>
    <input type="text" id="compte" name="compte">

    <input type="submit" value="Buscar">
</form>

<table>
    <tr>
        <th>ID fiscal</th>
        <th>Nom</th>
        <th>Compte</th>
        <th>Saldo</th>
    </tr>

    <c:forEach items="${clients}" var="client">
        <tr>
            <td>${client.idFiscal}</td>
            <td>${client.nom}</td>
            <td>${client.comptes[0].compte}</td>
            <td>${client.comptes[0].saldo}</td>
        </tr>
    </c:forEach>
</table>

</body>
</html>

