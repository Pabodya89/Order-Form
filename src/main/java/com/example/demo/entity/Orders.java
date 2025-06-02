package com.example.demo.entity;

import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Set;

@Entity
@Table(name = "orders")
//@TypeDefs({
//        @TypeDef(name = "json", typeClass = JsonType.class)
//})
@AllArgsConstructor
@NoArgsConstructor
@Data

public class Orders {

    @Id
    @Column(name = "order_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int orderId;

    @Column(name = "order_date", columnDefinition = "DATETIME")
    private Date date;

    @Column(name = "total", nullable = false)
    private Double total;

    //many order has one customer this is it relationship
    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    //join the orderDetails
    @OneToMany(mappedBy = "orders")
    private Set<OrderDetails> orderDetails;


    public Orders(Customer customer, Date date, Double total)
    {
        this.customer = customer;
        this.date = date;
        this.total = total;
    }

}
