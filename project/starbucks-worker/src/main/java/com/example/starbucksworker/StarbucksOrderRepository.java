package com.example.starbucksworker;

/* https://docs.spring.io/spring-data/jpa/docs/2.4.6/reference/html/#repositories */

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarbucksOrderRepository extends CrudRepository<StarbucksOrder, Long> {

}


