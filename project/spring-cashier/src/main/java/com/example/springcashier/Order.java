package com.example.springcashier;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@RequiredArgsConstructor
class Order {
    private static final String[] DRINK_OPTIONS = { "Caffe Latte-Tall", "Caffe Latte-Grande", "Caffe Latte-Venti",
            "Caffe Latte-Your Own Cup", "Caffe Americano-Tall", "Caffe Americano-Grande", "Caffe Americano-Venti",
            "Caffe Americano-Your Own Cup", "Caffe Mocha-Tall", "Caffe Mocha-Grande", "Caffe Mocha-Venti",
            "Caffe Mocha-Your Own Cup", "Cappuccino-Tall", "Cappuccino-Grande", "Cappuccino-Venti",
            "Cappuccino-Your Own Cup", "Espresso-Short", "Espresso-Tall" };
    private static final String[] MILK_OPTIONS = { "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" };

    private @Id int id;
    private String drink ;
    private String milk ;
    private String size ;
    private String total ;
    private String register ;
    private String status ;
    
    public static Order GetNewOrder() {
        Order o = new Order();

        String drink = DRINK_OPTIONS[(int) (Math.random() * DRINK_OPTIONS.length)];
        String[] drinkInfo = drink.split("-");

        o.drink = drinkInfo[0];
        o.size = drinkInfo[1];
        o.milk = MILK_OPTIONS[(int) (Math.random() * MILK_OPTIONS.length)];

        return o;
    }

}


/*

https://priceqube.com/menu-prices/%E2%98%95-starbucks

var DRINK_OPTIONS = [ "Caffe Latte", "Caffe Americano", "Caffe Mocha", "Espresso", "Cappuccino" ];
var MILK_OPTIONS  = [ "Whole Milk", "2% Milk", "Nonfat Milk", "Almond Milk", "Soy Milk" ];
var SIZE_OPTIONS  = [ "Short", "Tall", "Grande", "Venti", "Your Own Cup" ];

Caffè Latte
=============
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Caffè Americano
===============
tall 	$2.25
grande 	$2.65
venti 	$2.95 (Your Own Cup)

Caffè Mocha
=============
tall 	$3.45
grande 	$4.15
venti 	$4.45 (Your Own Cup)

Cappuccino
==========
tall 	$2.95
grande 	$3.65
venti 	$3.95 (Your Own Cup)

Espresso
========
short 	$1.75
tall 	$1.95

 */



