package com.baumannibiuna.rest.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.baumannibiuna.rest.models.Order;


public interface OrderRepository extends JpaRepository<Order, Long>{

}
