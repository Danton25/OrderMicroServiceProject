package com.ecommerce.orderservice.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "orders")
@Slf4j
@AllArgsConstructor

public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "order_id")
    private Long orderId;
    @Column(name = "customer_id")
    private String customerId;
    @Column(name = "customer_name")
    private String customerName;
    @Column(name = "customer_email")
    private String customerEmail;
    @Column(name = "status")
    private String status;
    @Column(name = "created_date")
    private Date createdDate;
    @Column(name = "modified_date")
    private Date modifiedDate;
    @Column(name = "notes")
    private String notes;
    @Column(name = "order_shipping_charges")
    private double orderShippingCharges;
    @Column(name = "order_subtotal")
    private double orderSubtotal;
    @Column(name = "order_total")
    private double orderTotal;
    @Column(name = "order_tax")
    private double orderTax;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Payment payment;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private BillingDetails billingDetails;

    @OneToOne(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private ShippingDetails shippingDetails;

    @OneToMany(cascade= CascadeType.ALL)
    @JoinColumn(name = "order_id")
    private Set<Item> items = new HashSet<>();

    public Order() {
        log.info("const 100");
        log.info(this.customerId);
    }
    public Order( String customerId, String customerName, String customerEmail, String status,
                  double orderShippingCharges, double orderSubtotal, double orderTotal, double orderTax) {
        log.info("const 1");
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.status = status;
        this.orderShippingCharges = orderShippingCharges;
        this.orderSubtotal = orderSubtotal;
        this.orderTotal = orderTotal;
        this.orderTax = orderTax;
    }

    public Order(Long orderId, String customerId, String customerName, String customerEmail,
                 double orderShippingCharges, double orderSubtotal, double orderTotal, double orderTax) {
        log.info("const 2");
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderShippingCharges = orderShippingCharges;
        this.orderSubtotal = orderSubtotal;
        this.orderTotal = orderTotal;
        this.orderTax = orderTax;
    }
    public Order(String customerId, String customerName, String customerEmail,
                 double orderShippingCharges, double orderSubtotal, double orderTotal, double orderTax) {
        log.info("const 3");
        this.customerId = customerId;
        this.customerName = customerName;
        this.customerEmail = customerEmail;
        this.orderShippingCharges = orderShippingCharges;
        this.orderSubtotal = orderSubtotal;
        this.orderTotal = orderTotal;
        this.orderTax = orderTax;
    }

    public void addItem(Item item){
        if (items == null) {
            items=new HashSet<>();
        }
        items.add(item);
    }

    public double getOrderShippingCharges() {
        return orderShippingCharges;
    }

    public void setOrderShippingCharges(double orderShippingCharges) {
        this.orderShippingCharges = orderShippingCharges;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public double getOrderSubtotal() {
        return orderSubtotal;
    }

    public void setOrderSubtotal(double orderSubtotal) {
        this.orderSubtotal = orderSubtotal;
    }

    public double getOrderTotal() {
        return orderTotal;
    }

    public void setOrderTotal(double orderTotal) {
        this.orderTotal = orderTotal;
    }

    public double getOrderTax() {
        return orderTax;
    }

    public void setOrderTax(double orderTax) {
        this.orderTax = orderTax;
    }

    public Set<Item> getItems() {
//        if(items == null){
//            items =  new HashSet<>();
//        }
        return items;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public BillingDetails getBillingDetails() {
        return billingDetails;
    }

    public void setBillingDetails(BillingDetails billingDetails) {
        this.billingDetails = billingDetails;
    }

    public ShippingDetails getShippingDetails() {
        return shippingDetails;
    }

    public void setShippingDetails(ShippingDetails shippingDetails) {
        this.shippingDetails = shippingDetails;
    }

    public void setItems(Set<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", customerId='" + customerId + '\'' +
                ", customerName='" + customerName + '\'' +
                ", customerEmail='" + customerEmail + '\'' +
                ", status='" + status + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                ", notes='" + notes + '\'' +
                ", orderShippingCharges=" + orderShippingCharges +
                ", orderSubtotal=" + orderSubtotal +
                ", orderTotal=" + orderTotal +
                ", orderTax=" + orderTax +
                ", items=" + items +
                '}';
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return orderId.equals(order.getOrderId());
    }

}
