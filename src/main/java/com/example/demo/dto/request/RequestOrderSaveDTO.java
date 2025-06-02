package com.example.demo.dto.request;

import com.example.demo.entity.Customer;
import com.example.demo.entity.OrderDetails;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RequestOrderSaveDTO {
    private int customer;
    private Date date;
    private Double total;
    private List<RequestOrderDetailSaveDTO> orderDetails;

}
