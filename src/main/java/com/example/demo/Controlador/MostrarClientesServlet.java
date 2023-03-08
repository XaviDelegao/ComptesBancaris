package com.example.demo.Controlador;

import com.example.demo.DataAcces.ClientDAO;
import com.example.demo.Model.Client;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(name = "MostrarClientesServlet", value = "/mostrar-clientes")
public class MostrarClientesServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String idFiscal = request.getParameter("idFiscal");
        String compte = request.getParameter("compte");

        // Si ambos campos están vacíos, redirecciona a la página de inicio
        if (idFiscal.isEmpty() || compte.isEmpty()) {
            response.getWriter().println("ERROR: Has d'omplir tots els camps del formulari.");
            return;
        }

        ClientDAO dao = new ClientDAO();
        List<Client> clients = dao.cercar(idFiscal, compte);

        request.setAttribute("clients", clients);
        request.getRequestDispatcher("cerca.jsp").forward(request, response);
    }

}
