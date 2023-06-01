package com.example.springcashier;


import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
class Command {

    private String action ;
    private String message ;
    private String stores ;
    private String register ;
    private String drinks ;
    private String drink ;
    private String milks ;
    private String milk ;
    private String sizes ;
    private String size ;

}
