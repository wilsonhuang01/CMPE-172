package com.example.starbucksworker;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "STARBUCKS_ORDER")
@Data
@RequiredArgsConstructor
public class StarbucksOrder {

    private @Id
    @GeneratedValue
    @JsonIgnore
            Long id;
    @Column(nullable = false)
    private String drink;
    @Column(nullable = false)
    private String milk;
    @Column(nullable = false)
    private String size;
    private double total;
    private String status;
    private String register;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "card_id", referencedColumnName = "id")
    @JsonIgnore
    private StarbucksCard card;


}