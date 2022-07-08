package org.example;

import org.example.dao.ClientsDAO;
import org.example.entity.Client;
import org.example.util.StateClients;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class AppTest {

    @Test
    public void createClient(){
        Client client = new Client();
        client.setAddress("rue de la gare");
        client.setCity("Rennes");
        client.setCompanyName("Sopra Steria");
        client.setCountry("France");
        client.setEmail("truc@muche.fr");
        client.setFirstName("Truc");
        client.setLastName("Muche");
        client.setPhone("0605040302");
        client.setZipCode("35000");
        client.setState(StateClients.ACTIVE);
        ClientsDAO.create(client);

        assertTrue(true);
    }

    @Test
    public void findAllClients(){

        List<Client> clients = ClientsDAO.findAll();
        assertTrue(clients.size() > 0);

    }

    @Test
    public void findClientById(){

        Client client = ClientsDAO.findById(2);
        System.out.println(client);

        assertEquals("Julien", client.getFirstName());

    }

    @Test
    public void deleteClient(){
        Client client = ClientsDAO.findById(8);
        ClientsDAO.delete(client);
        List<Client> clients = ClientsDAO.findAll();
        assertEquals(4, clients.size());

    }

    @Test
    public void deleteClientById(){

        Client client = new Client();
        client.setAddress("rue de la gare");
        client.setCity("Rennes");
        client.setCompanyName("Sopra Steria");
        client.setCountry("France");
        client.setEmail("truc@muche.fr");
        client.setFirstName("Truc");
        client.setLastName("Muche");
        client.setPhone("0605040302");
        client.setZipCode("35000");
        client.setState(StateClients.ACTIVE);
        ClientsDAO.create(client);
        ClientsDAO.deleteById(client.getId());
        client = ClientsDAO.findById(client.getId());

        assertNull(client);
    }

    @Test
    public void clientToUpdate(){

        Client clientToUpdate = new Client();
        clientToUpdate.setAddress("rue de la gare");
        clientToUpdate.setCity("Rennes");
        clientToUpdate.setCompanyName("Sopra Steria");
        clientToUpdate.setCountry("France");
        clientToUpdate.setEmail("truc@muche.fr");
        clientToUpdate.setFirstName("Truc");
        clientToUpdate.setLastName("Muche");
        clientToUpdate.setPhone("0605040302");
        clientToUpdate.setZipCode("35000");
        clientToUpdate.setState(StateClients.ACTIVE);
        ClientsDAO.create(clientToUpdate);

        System.out.println(clientToUpdate);

        Client clientNewData = new Client();
        clientNewData.setFirstName("Jean");
        clientNewData.setLastName("Zozor");
        clientNewData.setEmail("jean@zozor.fr");

        ClientsDAO.updateClient(clientToUpdate.getId(), clientNewData);

        Client clientUpdated = ClientsDAO.findById(clientToUpdate.getId());
        assertEquals("Jean", clientUpdated.getFirstName());
        assertEquals("Zozor", clientUpdated.getLastName());

    }

}
