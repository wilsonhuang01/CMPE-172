package com.example.springstarbucksapi.model;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="ACTIVE_ORDER")
@Data
@RequiredArgsConstructor
public class ActiveOrder {

    @Id
    private String register;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    private StarbucksOrder order;
}
