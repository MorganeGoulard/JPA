package org.example.entity;

import org.example.util.StateOrders;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Order {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private long id;
    /*@Column(columnDefinition = "INT")
    private long clientId;*/
    private String typePresta;
    private String designation;
    private Integer nbDays;
    private Float unitPrice;
    @Column(columnDefinition = "BIT")
    private StateOrders state; // CANCELLED:0 / OPTION:1 / CONFIRMED:2
    //private float TotalExcludeTaxe;
    //private float totalWithTaxe;

    @ManyToOne
    @JoinColumn (name = "clientId")//, insertable=false, updatable=false)
    private Client client;


    public Order() {
    }

    public Order(String typePresta, String designation) {
        this.typePresta = typePresta;
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTypePresta() {
        return typePresta;
    }

    public void setTypePresta(String typePresta) {
        this.typePresta = typePresta;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public Integer getNbDays() {
        return nbDays;
    }

    public void setNbDays(Integer nbDays) {
        this.nbDays = nbDays;
    }

    public Float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public StateOrders getState() {
        return state;
    }

    public void setState(StateOrders state) {
        this.state = state;
    }


    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setNotNullData(Order newOrderData ){
        if(newOrderData.getClient() != null) {
            this.setClient(newOrderData.getClient());
        }
        if(newOrderData.getDesignation() != null) {
            this.setDesignation(newOrderData.getDesignation());
        }
        if(newOrderData.getTypePresta() != null) {
            this.setTypePresta(newOrderData.getTypePresta());
        }
        if(newOrderData.getNbDays() != null) {
            this.setNbDays(newOrderData.getNbDays());
        }
        if(newOrderData.getUnitPrice() != null) {
            this.setUnitPrice(newOrderData.getUnitPrice());
        }
        if(newOrderData.getState() != null) {
            this.setState(newOrderData.getState());
        }
    }


        @Override
    public String toString() {
        return "OrdersDAO{" +
                "id=" + id +
                //", clientId=" + clientId +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                '}';
    }

}
