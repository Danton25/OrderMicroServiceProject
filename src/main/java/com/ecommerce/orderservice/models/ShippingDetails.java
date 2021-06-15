package com.ecommerce.orderservice.models;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "shipping_details")
@Data
public class ShippingDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shippingDetailsId;

    @Column(name = "shipping_method")
    private String shippingMethod;
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



    public ShippingDetails(){}

    public ShippingDetails(Long shippingDetailsId, String shippingMethod, String addressLine1, String addressLine2, String city, String state, String zipcode) {
        this.shippingDetailsId = shippingDetailsId;
        this.shippingMethod = shippingMethod;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }
}
