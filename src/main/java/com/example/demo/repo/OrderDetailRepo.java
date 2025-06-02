package com.example.demo.repo;

import com.example.demo.entity.OrderDetails;
import org.hibernate.query.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface OrderDetailRepo extends JpaRepository<OrderDetails, Integer>{
}
