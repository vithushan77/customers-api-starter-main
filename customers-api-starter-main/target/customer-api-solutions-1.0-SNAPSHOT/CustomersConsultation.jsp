<%@ page import="fr.esgi.customer.beans.Customer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="fr">
<head>
    <title>Liste des Clients</title>
</head>
<body>
<h1>Liste des Clients</h1>
<p>
        <%
    List<Customer> customers = (List<Customer>) request.getAttribute("customers");
    for (Customer customer : customers) {
%>
<ul>
    <li>
        <a href="/customers-api/list?id=<% out.println(customer.referenceId()); %>">
            <li><% out.println(String.format("Raison Social : %s ", customer.companyName().getDesignation())); %></li>

        </a>
    </li>
    <li><% out.println(String.format(" Ville : %s ", customer.town())); %></li>
    <li><% out.println(String.format(" Address: %s", customer.address())); %></li>
    <li><% out.println(String.format(" Siret : %s", customer.siret())); %></li>
</ul>
<%
    }
%>
</p>
</body>
</html>




