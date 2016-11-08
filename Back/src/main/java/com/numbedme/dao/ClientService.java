package com.numbedme.dao;

import com.numbedme.model.Client;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

/**
 * Created by User on 08.11.2016.
 */

@Stateless
public class ClientService {
    @PersistenceContext(unitName = "eclipse")
    private EntityManager manager;

    public ClientService() {

    }

    public void persist(Client client) {
        manager.persist(client);
    }

    public Client merge(Client client) {
        return manager.merge(client);
    }

    public void delete(Client client) {
        manager.remove(client);
    }

    public Client find(int id) {
        try {
            return manager.find(Client.class, id);
        } catch (Exception e) {
            return null;
        }
    }

    public List<Client> findAll() {

        return manager.createQuery("SELECT c from Client c", Client.class).getResultList();

    }
}
