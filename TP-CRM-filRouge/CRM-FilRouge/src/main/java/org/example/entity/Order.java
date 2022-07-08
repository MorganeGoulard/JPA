package org.example.entity;

import org.example.util.StateOrders;

import javax.persistence.*;

@Entity
@Table(name="orders")
public class Orders {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="client_id")
    private long clientId;
    @Column(name="type_presta")
    private String typePresta;
    private String designation;
    @Column(name="nb_days")
    private int nbDays;
    @Column(name="unit_price")
    private int unitPrice;
    private StateOrders state; // CANCELLED:0 / OPTION:1 / CONFIRMED:2
    @Column(name="total_exclude_taxe")
    private float TotalExcludeTaxe;
    @Column(name="total_with_taxe")
    private float totalWithTaxe;


    public Orders() {
    }

    public Orders(String typePresta, String designation) {
        this.typePresta = typePresta;
        this.designation = designation;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getClientId() {
        return clientId;
    }

    public void setClientId(long clientId) {
        this.clientId = clientId;
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

    public int getNbDays() {
        return nbDays;
    }

    public void setNbDays(int nbDays) {
        this.nbDays = nbDays;
    }

    public int getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(int unitPrice) {
        this.unitPrice = unitPrice;
    }

    public StateOrders getState() {
        return state;
    }

    public void setState(StateOrders state) {
        this.state = state;
    }

    public float getTotalExcludeTaxe() {
        return TotalExcludeTaxe;
    }

    public void setTotalExcludeTaxe(float totalExcludeTaxe) {
        TotalExcludeTaxe = totalExcludeTaxe;
    }

    public float getTotalWithTaxe() {
        return totalWithTaxe;
    }

    public void setTotalWithTaxe(float totalWithTaxe) {
        this.totalWithTaxe = totalWithTaxe;
    }

    @Override
    public String toString() {
        return "OrdersDAO{" +
                "id=" + id +
                ", clientId=" + clientId +
                ", typePresta='" + typePresta + '\'' +
                ", designation='" + designation + '\'' +
                ", nbDays=" + nbDays +
                ", unitPrice=" + unitPrice +
                ", state=" + state +
                ", TotalExcludeTaxe=" + TotalExcludeTaxe +
                ", totalWithTaxe=" + totalWithTaxe +
                '}';
    }

}
