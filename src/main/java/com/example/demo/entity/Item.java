package com.example.demo.entity;

import com.example.demo.entity.enums.MeasuringUnitType;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name="Item")

@AllArgsConstructor
@NoArgsConstructor
//@Getter
//@Setter
//@ToString
@Data
public class Item {

    @Id
    @Column(name = "item_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int itemId;

    @Column(name = "item_name", length = 100, nullable = false)
    private String itemName;

    @Enumerated(EnumType.STRING)
    @Column(name = "measure_type", length = 25, nullable = false)
    private MeasuringUnitType measuringUnitType;

    @Column(name = "balance_qty", length = 50, nullable = false)
    private double balanceQty;

    @Column(name = "supplier_price", length = 50, nullable = false)
    private double supplierPrice;

    @Column(name = "selling_price", length = 50, nullable = false)
    private double sellingPrice;

    @Column(name = "active_state", columnDefinition = "TINYINT default 1")
    private boolean activeState;

    //join the orderDetails
    @OneToMany(mappedBy = "items")
    private Set<OrderDetails> orderDetails;

    public void setActiveState(boolean b) {
    }

    public Integer getItemId() {
        return itemId;
    }

    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }
}
