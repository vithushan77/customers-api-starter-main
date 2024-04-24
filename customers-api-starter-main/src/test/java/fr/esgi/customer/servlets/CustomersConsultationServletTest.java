package fr.esgi.customer.servlets;

import fr.esgi.customer.Servlets.CustomersConsultationServlet;
import fr.esgi.customer.beans.Customer;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.IOException;
import java.util.List;

import static fr.esgi.customer.samples.CustomerSample.customers;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class CustomersConsultationServletTest {

    @Mock
    private HttpServletRequest httpServletRequest;

    @Mock
    private HttpServletResponse httpServletResponse;

    @Test
    void shouldDoGet() throws ServletException, IOException {
        String jspPath = "/CustomersConsultation.jsp";
        List<Customer> customers = customers();

        CustomersConsultationServlet customersConsultationServlet = new CustomersConsultationServlet();

        RequestDispatcher requestDispatcher = mock(RequestDispatcher.class);

        when(httpServletRequest.getRequestDispatcher(jspPath)).thenReturn(requestDispatcher);

       // customersConsultationServlet.doGet(httpServletRequest, httpServletResponse);

        verify(httpServletRequest).setAttribute("customers", customers);
        verify(httpServletRequest).getRequestDispatcher(jspPath);
        verify(requestDispatcher).forward(httpServletRequest, httpServletResponse);

        verifyNoMoreInteractions(httpServletRequest, httpServletResponse, requestDispatcher);
    }

}

