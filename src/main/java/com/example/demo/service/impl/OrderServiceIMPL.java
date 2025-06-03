package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.dto.request.RequestOrderSaveDTO;
import com.example.demo.entity.OrderDetails;
import com.example.demo.entity.Orders;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.repo.ItemRepo;
import com.example.demo.repo.OrderDetailRepo;
import com.example.demo.repo.OrderRepo;
import com.example.demo.service.OrderService;
import com.example.demo.util.mappers.ItemMapper;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class OrderServiceIMPL implements OrderService {

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    @Transactional
    public String addOrder(RequestOrderSaveDTO requestOrderSaveDTO) {
        Orders order = new Orders(
                customerRepo.getById(requestOrderSaveDTO.getCustomer()),
                requestOrderSaveDTO.getDate(),
                requestOrderSaveDTO.getTotal()
        );
        orderRepo.save(order);

        if(orderRepo.existsById(order.getOrderId()))
        {
            List<OrderDetails> orderDetails = modelMapper.
                    map(requestOrderSaveDTO.getOrderDetails(),new TypeToken<List<OrderDetails>>(){
                    }.getType ());
            for(int i=0;i<orderDetails.size();i++)
            {
                orderDetails.get(i).setOrders(order);
                orderDetails.get(i).setItems(itemRepo.getById(requestOrderSaveDTO.getOrderDetails().get(i).getItems()));
            }

            if(orderDetails.size() > 0)
            {
                orderDetailRepo.saveAll(orderDetails);
            }
            return "saved";
        }
        return null;
    }
}
