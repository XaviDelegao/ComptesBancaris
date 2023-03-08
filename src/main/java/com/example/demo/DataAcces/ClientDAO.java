package com.example.demo.DataAcces;

import java.util.List;
import java.util.stream.Collectors;

import com.example.demo.Controlador.HibernateUtil;
import com.example.demo.Model.Client;
import com.example.demo.Model.Compte;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class ClientDAO {

    public List<Client> cercar(String id_fiscal, String compte) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        List<Client> clients = session.createQuery("from Client").list();
        tx.commit();

        List<Client> filteredClients = clients.stream()
                .filter(client -> client.getIdFiscal().equals(id_fiscal) &&
                        client.getComptes() != null && Hibernate.isInitialized(client.getComptes()) &&
                        client.getComptes().stream()
                                .anyMatch(c -> c.equals(compte)))
                .collect(Collectors.toList());

        return filteredClients;
    }


    public void guardar(Client client, Compte compte) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction tx = session.beginTransaction();
        session.save(client);
        session.save(compte);
        tx.commit();
    }
}

