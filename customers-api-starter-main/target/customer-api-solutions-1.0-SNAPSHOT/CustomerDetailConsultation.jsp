<%@ page import="fr.esgi.customer.beans.Customer" %>
<%@ page import="fr.esgi.customer.beans.Customer" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Customer customer = (Customer) request.getAttribute("rentalProperty");
%>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Bien en location n°<% out.println(customer.referenceId()); %></title>
</head>
<body>
<h1>Bien en location n°<% out.println(customer.referenceId()); %></h1>
<p>
<ul>
    <li>
        <% out.println(String.format("%s Raison Social", customer.companyName().getDesignation())); %>
    </li>
    <li><% out.println(String.format(" Ville : %s €", customer.town())); %></li>
    <li><% out.println(String.format(" Address : %s m²", customer.address())); %></li>
    <li><% out.println(String.format(" Siret : %s", customer.siret())); %></li>
</ul>
</p>
</body>
</html>