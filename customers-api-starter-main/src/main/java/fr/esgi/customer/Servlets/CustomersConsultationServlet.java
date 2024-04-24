package fr.esgi.customer.Servlets;


import fr.esgi.customer.beans.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import fr.esgi.customer.services.CustomersFileParser;

import java.io.IOException;
import java.util.List;

@WebServlet("/list")
public class CustomersConsultationServlet extends HttpServlet {

    private final CustomersFileParser customersFileParser;

    public CustomersConsultationServlet() {
        this.customersFileParser = new CustomersFileParser();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Customer> customers = customersFileParser.parse("customers.csv");
        request.setAttribute("customers", customers);

        request.getRequestDispatcher("/CustomersConsultation.jsp").forward(request, response);
    }

}