# CMPE-172

Archive repository for CMPE-172 - Enterprise Software Platforms at SJSU in the Spring 2023 semester.

---

## Labs

- Lab 1: [Hello Spring](labs/lab1)
- Lab 2: [Spring MVC](labs/lab2)
- Lab 3: [Spring Gumball](labs/lab3)
- Lab 4: [Spring Security](labs/lab4)
- Lab 5: [Spring REST](labs/lab5)
- Lab 6: [Spring Data](labs/lab6)
- Lab 7: [Spring Payments](labs/lab7)
- Lab 8: [Kong API Gateway](labs/lab8)
- Lab 9: [Spring RabbitMQ](labs/lab9)
- Lab 10: [DevOps CI/CD](https://github.com/wilsonhuang01/spring-gumball)

---

## Project

The Starbucks project comprises the following components:

- [Cashier's App](project/spring-cashier) simulates an app that cashiers use to enter the order info from customers
- [Starbucks App](project/starbucks-app) simulates a mobile app that customers use to make a payment during checkout
- [Kong API Gateway](https://konghq.com) handles API calls from Cashier's App and Starbucks App
- [Starbucks API](project/starbucks-api) processes API calls from Cashier's App and Starbucks App
- [HAProxy](https://www.haproxy.org) (for local deployment) distributes traffic across multiple Cashier's App/Starbucks API servers
- [MySQL Database](https://www.mysql.com) stores info related to orders, cards, users, sessions, etc.
- [Jumpbox](https://www.ssh.com/academy/iam/jump-server) provides remote access to components inside the network (e.g. MySQL DB)
- [RabbitMQ](https://www.rabbitmq.com) provides async order processing
- [Starbucks Worker](project/starbucks-worker) receives the order info from RabbitMQ and updates the database when the drink is made

[Project Demo](https://www.youtube.com/watch?v=SAjWL4Q2kvQ)
