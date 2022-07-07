package org.example.entity;


import javax.persistence.*;

@Entity
@Table(name = "payments")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="card_number")
    private String cardNumber;
    @Column(name="confidential_code")
    private String confidentialCode;
    private String bank;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getConfidentialCode() {
        return confidentialCode;
    }

    public void setConfidentialCode(String confidentialCode) {
        this.confidentialCode = confidentialCode;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public void setNotNullData(Payment newPaymentData){
        if(newPaymentData.getCardNumber() != null){
            this.setCardNumber(newPaymentData.getCardNumber());
        }
        if(newPaymentData.getConfidentialCode() != null){
            this.setConfidentialCode(newPaymentData.getConfidentialCode());
        }
        if(newPaymentData.getBank() != null){
            this.setBank(newPaymentData.getBank());
        }
    }

    @Override
    public String toString() {
        return "Payment {" +
                "cardNumber='" + cardNumber + '\'' +
                ", confidentialCode='" + confidentialCode + '\'' +
                ", bank='" + bank + '\'' +
                '}';
    }
}
