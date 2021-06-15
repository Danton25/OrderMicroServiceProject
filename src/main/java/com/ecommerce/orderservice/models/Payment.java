package com.ecommerce.orderservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "payment")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_name")
    private Long paymentId;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "payment_date")
    private Date paymentDate;
    @Column(name = "payment_confirmation_number")
    private String paymentConfirmationNumber;
    @Column(name = "payment_amount")
    private Double paymentAmount;
    @Column(name = "payment_card_number")
    private String paymentCardNumber;
    @Column(name = "payment_card_cvv")
    private String paymentCardCVV;

    public Payment(String paymentMethod, Date paymentDate, String paymentConfirmationNumber, Double paymentAmount, String paymentCardNumber, String paymentCardCVV) {
        this.paymentMethod = paymentMethod;
        this.paymentDate = paymentDate;
        this.paymentConfirmationNumber = paymentConfirmationNumber;
        this.paymentAmount = paymentAmount;
        this.paymentCardNumber = paymentCardNumber;
        this.paymentCardCVV = paymentCardCVV;
    }

    public Payment() {

    }
}
