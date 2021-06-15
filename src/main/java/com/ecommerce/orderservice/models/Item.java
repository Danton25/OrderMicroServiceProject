package com.ecommerce.orderservice.models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Entity
@Table(name = "items")
@Slf4j
@Data
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
    private Long itemId;

    @Column(name = "item_name")
    private String itemName;
    @Column(name = "item_qty")
    private int itemQty;

    @Column(name = "item_price")
    private int itemPrice;

    public Item() {
        log.info("const 200");
    }

    public Item(long itemId, String itemName, int itemQty, int itemPrice) {
        this.itemName = itemName;
        this.itemQty = itemQty;
        this.itemPrice = itemPrice;
        this.itemId = itemId;

    }


}
