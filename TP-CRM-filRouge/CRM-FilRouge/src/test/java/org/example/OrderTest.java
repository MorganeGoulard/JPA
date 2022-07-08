package org.example;

import org.example.dao.ClientsDAO;
import org.example.dao.OrdersDAO;
import org.example.entity.Client;
import org.example.entity.Order;
import org.example.util.StateClients;
import org.example.util.StateOrders;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class OrderTest {

    @Test
    public void createOrder() {

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

        Order order = new Order();
        order.setClient(client);
        order.setTypePresta("Formation");
        order.setDesignation("Java");
        order.setNbDays(57);
        order.setUnitPrice(800f);
        order.setState(StateOrders.CONFIRMED);
        OrdersDAO.create(order);

        assertTrue(true);
    }

    @Test
    public void findAllOrders(){

        List<Order> orders = OrdersDAO.findAll();
        assertTrue(orders.size() > 0);

    }

    @Test
    public void findOrderById(){

        Order order = OrdersDAO.findById(2);
        System.out.println(order);

        assertEquals("Formation", order.getTypePresta());

    }

    @Test
    public void deleteOrder(){
        Order order = OrdersDAO.findById(12);
        OrdersDAO.delete(order);

        order = OrdersDAO.findById(12);
        assertNull(order);

    }

    @Test
    public void deleteOrderById(){

        Client client = ClientsDAO.findById(15);

        Order order = new Order();
        order.setClient(client);
        order.setTypePresta("Formation");
        order.setDesignation("Java");
        order.setNbDays(57);
        order.setUnitPrice(800f);
        order.setState(StateOrders.CONFIRMED);
        OrdersDAO.create(order);

        System.out.println(order);

        OrdersDAO.deleteById(order.getId());

        order = OrdersDAO.findById(order.getId());
        assertNull(order);
    }


    @Test
    public void updateOrder(){

        Client client = ClientsDAO.findById(15);

        Order order = new Order();
        order.setClient(client);
        order.setTypePresta("Formation");
        order.setDesignation("Java");
        order.setNbDays(57);
        order.setUnitPrice(800f);
        order.setState(StateOrders.CONFIRMED);
        OrdersDAO.create(order);

        Order newDataOrder = new Order();
        newDataOrder.setDesignation("Python");
        newDataOrder.setUnitPrice(1200f);

        OrdersDAO.updateOrder(order.getId(), newDataOrder);
        assertEquals("Python", order.getDesignation());
        assertEquals(1200f, order.getUnitPrice(),0);

    }

}
