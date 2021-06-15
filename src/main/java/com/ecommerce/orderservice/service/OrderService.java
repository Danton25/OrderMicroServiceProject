package com.ecommerce.orderservice.service;
import com.ecommerce.orderservice.models.*;
//import com.ecommerce.orderservice.repository.ItemRepository;
import com.ecommerce.orderservice.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;

import javax.transaction.Transactional;
import java.time.Instant;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;


    public List<Order> getAllOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public Optional<Order> findByOrderId(Long orderId) {
        return orderRepository.findById(orderId);
    }

    public Order findByCustomerName(String customerName) {
        return orderRepository.findByCustomerName(customerName);
    }

    @Transactional
    public Order saveOrder(Order order) {
        log.info("order : "+order);


        Order order1 = new Order();

        order1.setNotes(order.getNotes());
        order1.setOrderShippingCharges(order.getOrderShippingCharges());
        order1.setCustomerEmail(order.getCustomerEmail());
        order1.setCustomerId(order.getCustomerId());
        order1.setCustomerName(order.getCustomerName());

        System.out.println("All the items **************:    "+order.getItems());

        ShippingDetails shippingDetails1 = order.getShippingDetails();
        Payment payment = order.getPayment();
        BillingDetails billingDetails = order.getBillingDetails();

        order1.setShippingDetails(shippingDetails1);
        order1.setPayment(payment);
        order1.setBillingDetails(billingDetails);

        for(Item items: order.getItems()){

            Item i1 = new Item();
            i1.setItemName(items.getItemName());
            i1.setItemPrice(items.getItemPrice());
            i1.setItemQty(items.getItemQty());

            order1.addItem(i1);

        }
        setupOrder(order1);
        Order order2 = orderRepository.save(order1);
        return order2;
    }

    public void deleteOrder(Optional<Order> order) {
        orderRepository.delete(order.get());
        return;
    }

    private Order setupOrder(Order order) {
        double totalPayment = 0d;
        double tax = 0;
        double subTotal = 0d;
        Set<Item> orderItems = order.getItems();

        Order saveOrder = order;

        log.info("orderItems " + orderItems);

        if(orderItems != null && !orderItems.isEmpty()) {
            for (Item item : orderItems) {
                subTotal += item.getItemQty() * item.getItemPrice();
            }

            tax = 0.07 * subTotal;
            totalPayment = subTotal + tax;

            log.info("tax " + tax);
            log.info("totalPayment " + totalPayment);
            log.info("subTotal " + subTotal);
            saveOrder.setOrderTax(tax);
            saveOrder.setOrderTotal(totalPayment);
            saveOrder.setOrderSubtotal(subTotal);

            saveOrder.setCreatedDate(Date.from(Instant.now()));
            saveOrder.setStatus("RECEIVED");
        }
        return saveOrder;
    }

    public void cancelOrder(Optional<Order> orderToBeCancelled) {
        orderToBeCancelled.get().setStatus("Cancelled");
        orderToBeCancelled.get().setModifiedDate(Date.from(Instant.now()));
        orderRepository.save(orderToBeCancelled.get());
    }
}
