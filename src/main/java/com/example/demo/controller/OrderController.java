package com.example.demo.controller;

import com.example.demo.dto.request.RequestOrderSaveDTO;
import com.example.demo.service.OrderService;
import com.example.demo.util.mappers.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/order")
@CrossOrigin
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping(path = "/save")
    public ResponseEntity<StandardResponse> saveItem (@RequestBody RequestOrderSaveDTO requestOrderSaveDTO)
    {
        String id = orderService.addOrder(requestOrderSaveDTO);

        return new ResponseEntity<StandardResponse>(
                new StandardResponse(201, id + "item successfully saves", id),
                HttpStatus.CREATED
        );
    }

}
