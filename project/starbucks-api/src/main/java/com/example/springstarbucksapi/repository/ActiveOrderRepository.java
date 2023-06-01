package com.example.springstarbucksapi.repository;

import com.example.springstarbucksapi.model.ActiveOrder;
import com.example.springstarbucksapi.model.StarbucksOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActiveOrderRepository extends JpaRepository<ActiveOrder, String> {
}
