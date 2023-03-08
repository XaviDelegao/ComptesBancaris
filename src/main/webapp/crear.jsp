<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Creació de clients i comptes bancaris</title>
</head>
<body>
<h1>Creació de clients i comptes bancaris</h1>
<form action="crear-cliente" method="post">
    <fieldset>
        <legend>Informació del client</legend>
        <p>
            <label for="nom">Nom:</label>
            <input type="text" id="nom" name="nom" required>
        </p>
        <p>
            <label for="cognoms">Cognoms:</label>
            <input type="text" id="cognoms" name="cognoms" required>
        </p>
        <p>
            <label for="dni">DNI:</label>
            <input type="text" id="dni" name="dni" required>
        </p>
        <p>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </p>
        <p>
            <label for="idFiscal">Identificació fiscal:</label>
            <input type="text" id="idFiscal" name="idFiscal" required>
        </p>

    </fieldset>
    <fieldset>
        <legend>Informació del compte</legend>
        <p>
            <label for="numCompte">Número de compte:</label>
            <input type="text" id="numCompte" name="numCompte" required>
        </p>
        <p>
            <label for="saldoInicial">Saldo inicial:</label>
            <input type="number" id="saldoInicial" name="saldoInicial" required>
        </p>
    </fieldset>
    <button type="submit">Crear client</button>
</form>
</body>
</html>