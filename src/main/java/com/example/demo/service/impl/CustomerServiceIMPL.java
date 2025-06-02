package com.example.demo.service.impl;

import com.example.demo.dto.CustomerDTO;
import com.example.demo.entity.Customer;
import com.example.demo.repo.CustomerRepo;
import com.example.demo.service.CustomerService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CustomerServiceIMPL implements CustomerService {

    @Autowired
    private CustomerRepo customerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void addCustomer(CustomerDTO customerDTO) {
        Customer customer = new Customer(
                customerDTO.getCustomerID(),
                customerDTO.getCustomerName(),
                customerDTO.getCustomerAddress(),
                customerDTO.getCustomerSalary(),
                customerDTO.getNic(),
                customerDTO.isActiveState()
        );

        if (!customerRepo.existsById(customer.getCustomerID())) {
            customerRepo.save(customer);
        } else
            System.out.println("customer id already exists");
    }

    @Override
    public String updateCustomer(CustomerDTO customerDTO) {
        return "";
    }

    @Override
    public CustomerDTO getCustomerById(int customerId) {
        Customer customer = customerRepo.getReferenceById(customerId);

        CustomerDTO customerDTO = modelMapper.map(customer,CustomerDTO.class);
        return customerDTO;

                //        if (customer != null) {
                //            CustomerDTO customerDTO;
                //            customerDTO = new CustomerDTO(
                //                    customer.getCustomerID(),
                //                    customer.getCustomerName(),
                //                    customer.getCustomerAddress(),
                //                    customer.getCustomerSalary(),
                //                    customer.getNic(),
                //                    customer.isActiveState()
                //
                //            );
                //            return customerDTO;
                //        } else {
                //            return null;
                //        }

    }

    @Override
    public List<CustomerDTO> getAlldustomers() {
        List<Customer>getCustomers = customerRepo. findAll() ;
//        List<CustomerDTO>customerDTOList = new ArrayList<>();

//        for(Customer customer :getCustomers) {
//            CustomerDTO customerDTO = new CustomerDTO(
//                    customer.getCustomerID(),
//                    customer.getCustomerName(),
//                    customer.getCustomerAddress(),
//                    customer.getCustomerSalary(),
//                    customer.getNic(),
//                    customer.isActiveState()
//            );
//
//            customerDTOList.add(customerDTO);
//        }

        //ek type list ekk twa type ekkt convert krnwa
        if(getCustomers!=null){
            List<CustomerDTO>customerDTOList = modelMapper.
                    map(getCustomers,new TypeToken<List<CustomerDTO>>(){
                    }.getType ());
            return customerDTOList;
        }
        else
        {
            return null;
        }

    }

    @Override
    public String deleteCustomer(int customerId) {
        if(customerRepo.existsById(customerId))
        {
            customerRepo.deleteById(customerId);
            return "deleted";
        }
        else
        {
            return "no customer found at this id";
        }
    }

    public void setCustomerRepo(CustomerRepo customerRepo) {
        this.customerRepo = customerRepo;
    }
}
