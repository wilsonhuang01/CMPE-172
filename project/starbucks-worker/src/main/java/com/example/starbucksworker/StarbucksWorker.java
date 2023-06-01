package com.example.starbucksworker;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RabbitListener(queues = "starbucks")
public class StarbucksWorker {

    private static final Logger log = LoggerFactory.getLogger(StarbucksWorker.class);

    @Autowired
    private StarbucksOrderRepository starbucksOrderRepository;

    @RabbitHandler
    public void processStarbucksOrder(String orderid) {
        log.info("Received order #" + orderid);

        try {
            Thread.sleep(10000);
        } catch (Exception e) {}

        Optional<StarbucksOrder> resultOrder = starbucksOrderRepository.findById(Long.parseLong(orderid));
        if (resultOrder.isPresent()) {
            StarbucksOrder order = resultOrder.get();
            order.setStatus("Fulfilled");
            starbucksOrderRepository.save(order);

            log.info("Processed Order #" + order.getId());
        } else {
            log.info("[ERROR] Order #" + orderid + " Not Found!");
        }
    }

}
