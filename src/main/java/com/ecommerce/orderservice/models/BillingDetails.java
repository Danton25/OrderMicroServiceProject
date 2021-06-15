package com.ecommerce.orderservice.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "billing_details")
@Data
public class BillingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_name")
    private Long billingDetailsId;
    @Column(name = "address_line_1")
    private String addressLine1;
    @Column(name = "address_line_2")
    private String addressLine2;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "zipcode")
    private String zipcode;


    public BillingDetails(Long billingDetailsId, String addressLine1, String addressLine2, String city, String state, String zipcode) {
        this.billingDetailsId = billingDetailsId;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public BillingDetails() {

    }
}