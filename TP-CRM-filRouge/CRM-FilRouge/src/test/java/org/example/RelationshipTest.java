package org.example;

import org.example.dao.ClientsDAO;
import org.example.dao.OrdersDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.StateClients;
import org.example.util.StateOrders;
import org.junit.Test;

public class RelationshipTest {

    @Test
    public void manyToMany(){

        Client client = new Client();
        client.setAddress("rue de la causette");
        client.setCity("Brec'h");
        client.setCompanyName("Ikea");
        client.setCountry("France");
        client.setEmail("toto@delalande.fr");
        client.setFirstName("Toto");
        client.setLastName("Delalande");
        client.setPhone("0600000000");
        client.setZipCode("56400");
        client.setState(StateClients.ACTIVE);
        ClientsDAO.create(client);

        Order order = new Order();
        order.setClient(client);
        order.setTypePresta("Apprentissage");
        order.setDesignation("HTML-CSS");
        order.setNbDays(4);
        order.setUnitPrice(500f);
        order.setState(StateOrders.CONFIRMED);
        OrdersDAO.create(order);

        Order order2 = new Order();
        order2.setClient(client);
        order2.setTypePresta("Formation");
        order2.setDesignation("Angular");
        order2.setNbDays(10);
        order2.setUnitPrice(1000f);
        order2.setState(StateOrders.CONFIRMED);
        OrdersDAO.create(order2);

    }

}

