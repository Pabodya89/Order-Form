package com.example.demo.dto.request;

import com.example.demo.entity.Item;
import com.example.demo.entity.Orders;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderDetailSaveDTO {

    private String itemName;
    private double qty;
    private Double amount;
    private int orders;
    private int items;
}
