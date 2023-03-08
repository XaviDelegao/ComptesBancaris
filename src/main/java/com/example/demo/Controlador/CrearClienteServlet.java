package com.example.demo.Controlador;

import com.example.demo.DataAcces.ClientDAO;
import com.example.demo.Model.Client;
import com.example.demo.Model.Compte;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/crear-cliente")
public class CrearClienteServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Obtenir els paràmetres del formulari
        String nom = request.getParameter("nom");
        String cognoms = request.getParameter("cognoms");
        String dni = request.getParameter("dni");
        String email = request.getParameter("email");
        String idFiscal = request.getParameter("idFiscal");
        String numCompte = request.getParameter("numCompte");
        double saldoInicial = Double.parseDouble(request.getParameter("saldoInicial"));

        // Validar que s'han omplert tots els camps
        if (nom.isEmpty() || cognoms.isEmpty() || email.isEmpty() || dni.isEmpty() ||idFiscal.isEmpty() || numCompte.isEmpty()) {
            response.getWriter().println("ERROR: Has d'omplir tots els camps del formulari.");
            return;
        }

        // Crear un nou client i compte
        Client client = new Client(nom, cognoms, dni , email, idFiscal);
        Compte compteBancari = new Compte(numCompte, saldoInicial);
        compteBancari.setClient(client);
        client.addCompte(compteBancari);

        // Persistir el nou client i compte a la base de dades
        ClientDAO clientDAO = new ClientDAO();
        clientDAO.guardar(client,compteBancari);

        response.sendRedirect("crear.jsp");
    }

}

