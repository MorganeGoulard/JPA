package org.example.entity;

import org.example.util.StateClients;

import javax.persistence.*;

@Entity
@Table(name="clients")
public class Client {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT")
    private Long id;

    @Column(columnDefinition = "TEXT")
    private String address;
    private String city;
    private String companyName;
    private String country;
    private String email;
    private String firstName;
    private String lastName;
    private String phone;
    private String zipCode;
    @Column(columnDefinition = "BIT")
    private StateClients state; // INACTIVE:0 / ACTIVE:1

    public Client() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public StateClients getState() {
        return state;
    }

    public void setState(StateClients state) {
        this.state = state;
    }

    public void setNotNullData(Client newClientData ){
        if(newClientData.getFirstName() != null){
            this.setFirstName(newClientData.getFirstName());
        }
        if(newClientData.getLastName() != null){
            this.setLastName(newClientData.getLastName());
        }
        if(newClientData.getAddress() != null){
            this.setAddress(newClientData.getAddress());
        }
        if(newClientData.getCity() != null){
            this.setCity(newClientData.getCity());
        }
        if(newClientData.getCountry() != null){
            this.setCountry(newClientData.getCountry());
        }
        if(newClientData.getCompanyName() != null){
            this.setCompanyName(newClientData.getCompanyName());
        }
        if(newClientData.getEmail() != null){
            this.setEmail(newClientData.getEmail());
        }
        if(newClientData.getPhone() != null){
            this.setPhone(newClientData.getPhone());
        }
        if(newClientData.getZipCode() != null){
            this.setPhone(newClientData.getPhone());
        }
        if(newClientData.getState() != null){
            this.setState(newClientData.getState());
        }
    }

    @Override
    public String toString() {
        return "ClientsDAO{" +
                "id=" + id +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", companyName='" + companyName + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone='" + phone + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", state=" + state +
                '}';
    }

}
