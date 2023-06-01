# CMPE 172 - Lab #9 Notes

## RabbitMQ

![](images/01_rabbitmq.png)
![](images/02_terminal.png)

## RabbitMQ - Hello World

### Sender

![](images/03_helloworld_send.png)
![](images/04_helloworld_send_terminal.png)

### Console

![](images/05_helloworld_desktop.png)
![](images/06_helloworld_browser.png)

### Receiver

![](images/07_helloworld_receive.png)
![](images/08_helloworld_receive_terminal.png)

## RabbitMQ - Work Queues

### Sender

![](images/09_workqueues_send.png)
![](images/10_workqueues_send_terminal.png)

### Console

![](images/11_workqueues_desktop.png)
![](images/12_workqueues_browser.png)

### Receiver

![](images/13_workqueues_receive.png)
![](images/14_workqueues_receive_terminal.png)

## Discussion

### Spring Profiles

Spring profiles are sets of Spring Properties that can be
applied to the project in different phases. (Ex. 
application-dev.properties for development and 
application-prod.properties for production.) Use these profiles
to configure the project.

### RabbitMQ

RabbitMQ can be used for async messaging. A sender can send
a message to a queue and a receiver can receive it later on 
when needed.
