package com.example.springcashier;


import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.net.InetAddress;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Controller
@RequestMapping("/user/cashier")
public class SpringCashierController {

    @Value("${starbucks.cashier.apikey}") String API_KEY ;
    @Value("${starbucks.cashier.apihost}") String API_HOST ;
    @Value("${starbucks.cashier.register}") String REGISTER ;

    @GetMapping
    public String getAction(@ModelAttribute("command") Command command,
                             Model model, HttpSession session) {

        command.setRegister("5012349");
        command.setDrink("Caffe Latte");
        command.setMilk("Whole Milk");
        command.setSize("Tall");

        String message = "Starbucks Reserved Order" + "\n\n" +
                "Register: " + command.getRegister() + "\n" +
                "Status:   " + "Ready for New Order"+ "\n";

        System.out.println("message: " + message);

        String server_ip = "";
        String host_name = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            server_ip = ip.getHostAddress();
            host_name = ip.getHostName();
        } catch (Exception e) { }

        model.addAttribute( "message", message );
        model.addAttribute( "server",  host_name + "/" + server_ip );

        return "user/cashier";
    }


    @PostMapping
    public String postAction(@Valid @ModelAttribute("command") Command command,
                             @RequestParam(value="action", required=true) String action,
                             Errors errors, Model model, HttpServletRequest request) {

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        String resourceUrl = "";
        String message = "";

        // Set API Key Header
        headers.set("apikey", API_KEY);

        log.info("Action: " + action);
        command.setRegister(command.getStores());
        command.setDrink(command.getDrinks());
        command.setMilk(command.getMilks());
        command.setSize(command.getSizes());
        log.info("Command: " + command);

        /* Process Post Action */
        if (action.equals("Place Order")) {
            resourceUrl = "http://"+API_HOST+"/order/register/"+command.getRegister();
            //Order orderRequest = Order.GetNewOrder();
            Order orderRequest = new Order();
            orderRequest.setDrink(command.getDrink());
            orderRequest.setMilk(command.getMilk());
            orderRequest.setSize(command.getSize());
            System.out.println("Sending order request: " + orderRequest);

            try {
                HttpEntity<Order> newOrderRequest = new HttpEntity<Order>(orderRequest, headers);
                ResponseEntity<Order> newOrderResponse = restTemplate.postForEntity(resourceUrl, newOrderRequest, Order.class);
                Order order = newOrderResponse.getBody();
                System.out.println("post order response: " + order);

                message = "Starbucks Reserved Order" + "\n\n" +
                        "Drink: " + order.getDrink() + "\n" +
                        "Milk:  " + order.getMilk() + "\n" +
                        "Size:  " + order.getSize() + "\n" +
                        "Total: " + order.getTotal() + "\n\n" +
                        "Register: " + order.getRegister() + "\n" +
                        "Status:   " + order.getStatus() + "\n";

            } catch (Exception e) {
                System.out.println("Unable to place order: " + e.getMessage() + ", for register " + command.getRegister());

                if (e.getMessage().contains("Invalid Order Request!")) {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Invalid order request!";
                } else if (e.getMessage().contains("Active Order Exists!")) {
                    resourceUrl = "http://"+API_HOST+"/order/register/"+command.getRegister()+"?apikey="+API_KEY;
                    ResponseEntity<Order> getOrderResponse = restTemplate.getForEntity(resourceUrl, Order.class, API_KEY);
                    Order order = getOrderResponse.getBody();
                    System.out.println("get order response: " + order);

                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Drink: " + order.getDrink() + "\n" +
                            "Milk:  " + order.getMilk() + "\n" +
                            "Size:  " + order.getSize() + "\n" +
                            "Total: " + order.getTotal() + "\n\n" +
                            "Register: " + order.getRegister() + "\n" +
                            "Status:   " + order.getStatus() + "\n\n" +
                            "Please clear order before placing a new order!";
                } else if (e.getMessage().contains("Invalid Size!")) {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Invalid size!";
                } else if (e.getMessage().contains("Invalid Drink!")) {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Invalid drink!";
                } else {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Unknown error occurred! Please try again later.";
                }
            }

            System.out.println("message: " + message);

        } else if (action.equals("Get Order")) {
            resourceUrl = "http://"+API_HOST+"/order/register/"+command.getRegister()+"?apikey="+API_KEY;

            try {
                ResponseEntity<Order> getOrderResponse = restTemplate.getForEntity(resourceUrl, Order.class, API_KEY);
                Order order = getOrderResponse.getBody();
                System.out.println("get order response: " + order);

                message = "Starbucks Reserved Order" + "\n\n" +
                        "Drink: " + order.getDrink() + "\n" +
                        "Milk:  " + order.getMilk() + "\n" +
                        "Size:  " + order.getSize() + "\n" +
                        "Total: " + order.getTotal() + "\n\n" +
                        "Register: " + order.getRegister() + "\n" +
                        "Status:   " + order.getStatus() + "\n";

            } catch (Exception e) {
                System.out.println("Unable to get order: " + e.getMessage() + ", for register " + command.getRegister());

                if (e.getMessage().contains("Order Not Found!")) {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Order not found!";
                } else {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Unknown error occurred! Please try again later.";
                }
            }

            System.out.println("message: " + message);

        } else if (action.equals("Clear Order")) {
            resourceUrl = "http://"+API_HOST+"/order/register/"+command.getRegister()+"?apikey="+API_KEY;

            try {
                restTemplate.delete(resourceUrl);

                message = "Starbucks Reserved Order" + "\n\n" +
                        "Register: " + command.getRegister() + "\n" +
                        "Status:   " + "Ready for New Order"+ "\n";
            } catch (Exception e) {
                System.out.println("Unable to delete order: " + e.getMessage() + ", for register " + command.getRegister());

                if (e.getMessage().contains("Order Not Found!")) {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Order not found!";
                } else {
                    message = "Starbucks Reserved Order" + "\n\n" +
                            "Register: " + command.getRegister() + "\n" +
                            "Status:   " + "Ready for New Order"+ "\n\n" +
                            "Unknown error occurred! Please try again later.";
                }
            }
        }

        command.setMessage( message );

        String server_ip = "";
        String host_name = "";
        try {
            InetAddress ip = InetAddress.getLocalHost();
            server_ip = ip.getHostAddress();
            host_name = ip.getHostName();
        } catch (Exception e) { }

        model.addAttribute( "message", message );
        model.addAttribute( "server",  host_name + "/" + server_ip );

        return "user/cashier";

    }
}
