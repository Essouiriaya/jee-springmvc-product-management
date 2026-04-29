<%@ page language="java" contentType="text/html;charset=UTF-8"
pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gestion des Produits</title>
</head>

<body>

<h1>Gestion des produits | Spring MVC</h1>

<p>
    Utilisateur : <b>${sessionScope.user}</b> |
    Role : <b>${sessionScope.role}</b> |
    <a href="${pageContext.request.contextPath}/auth/logout">Logout</a>
</p>

<hr/>

<!-- 🔍 Recherche -->
<form action="search" method="get">
    ID : <input type="text" name="idProduit" />
    <input type="submit" value="Afficher" />
</form>

<hr/>

<!-- ➕ Ajout / ✏️ Modification -->
<form action="${produitEdit != null ? 'update' : 'add'}" method="post">

    <input type="hidden" name="idProduit"
           value="${produitEdit != null ? produitEdit.idProduit : ''}" />

    Nom :
    <input type="text" name="nom"
           value="${produitEdit != null ? produitEdit.nom : ''}" />

    Description :
    <input type="text" name="description"
           value="${produitEdit != null ? produitEdit.description : ''}" />

    Prix :
    <input type="text" name="prix"
           value="${produitEdit != null ? produitEdit.prix : ''}" />

    <input type="submit"
           value="${produitEdit != null ? 'Mettre à jour' : 'Ajouter'}"/>
</form>

<hr/>

<!-- 📋 Liste -->
<table border="1" width="60%">
    <tr>
        <th>ID</th>
        <th>NOM</th>
        <th>DESCRIPTION</th>
        <th>PRIX</th>
        <th colspan="2">Options</th>
    </tr>

    <c:forEach items="${listeProduit}" var="o">
        <tr>
            <td>${o.idProduit}</td>
            <td>${o.nom}</td>
            <td>${o.description}</td>
            <td>${o.prix}</td>

            <!-- 🗑️ Suppression -->
            <td>
                <a href="delete?id=${o.idProduit}">Supprimer</a>
            </td>

            <!-- ✏️ Modification -->
            <td>
                <a href="edit?id=${o.idProduit}">Modifier</a>
            </td>
        </tr>
    </c:forEach>

</table>

</body>
</html>