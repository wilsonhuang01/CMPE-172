# CMPE 172 Project Journal

## Journal #1 - Mar 26

![](journal-images/journal01_01_cashier.png)

Pulled source codes and files from gitpod repository.
Made changes to SpringCashierController.java and starbucks.html to display message in textarea.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/f6732feed9dc0fa5f2ab23de8cf7acc7820d9c61

## Journal #2 - April 23

![](journal-images/journal02_01_get_order.png)
![](journal-images/journal02_02_place_order.png)
![](journal-images/journal02_03_mysql.png)

Updated cashier to use implementation from the midterm.
Cashier now displays the active order of the register
and its status.

Cashier is currently using MySQL to store information
about orders and active orders, which can be queried
by using the 'select' command.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/6099b74b850c88b29b462d8c48332ef1a8dde077

## Journal #3 - April 25

![](journal-images/journal03_01_desktop.png)
![](journal-images/journal03_02_browser.png)

Updated the controller for Place Order.
The implementation now checks if an active order is
already present for the register. If an active order
exists, it tells the user to clear the order first
before placing a new order.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/65a951a183c42b27b96d1c6d92f7c1b7693db6d3

## Journal #4 - April 26

![](journal-images/journal04_01_desktop.png)
![](journal-images/journal04_02.png)
![](journal-images/journal04_03.png)

Updated order id generation method to use Math.random()
instead of Order.hashCode(). This fixes the issue where
identical orders would have the same hashCode.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/6163b7543ab31ee6eded09736f9b26fab3e888dc

## Journal #5 - May 5

![](journal-images/journal05_01_desktop.png)
![](journal-images/journal05_02_browser.png)

Updated spring-cashier to use Kong API instead of
storing orders in MySQL.

![](journal-images/journal05_03_get_order_error.png)
![](journal-images/journal05_04.png)

The code currently does not handle the error when
"Get Order" is called when there is no active order
at the register. The API returns error code 400: 
Order not found.

![](journal-images/journal05_05_place_order_error.png)
![](journal-images/journal05_06.png)

The code currently does not handle the error when
"Place Order" is called when an active order for the
register already exists. The API returns error code
400: Active order exists.

![](journal-images/journal05_07_delete_order_error.png)
![](journal-images/journal05_08.png)

The code also does not handle the error when
"Delete Order" is called when there is no active order
at the register. The API returns error code 400: 
Order not found.

Some sort of error handling is required to handle
the error and properly render the view.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/38178b346ad45c61f01ac7ea7fe49b162ae8b72e

## Journal #6 - May 6

![](journal-images/journal06_01_desktop.png)
![](journal-images/journal06_02_browser.png)
![](journal-images/journal06_03_log.png)

Implemented HTTP error code handling for "Get Order", 
"Place Order", and "Delete Order". Currently working
on the functionality for registering new account 
and logging out.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/4cd203bf67ccc4a294f047adac573e2232054cc3

## Journal #7 - May 7

![](journal-images/journal07_01_desktop.png)
![](journal-images/journal07_02_desktop.png)
![](journal-images/journal07_03_browser.png)
![](journal-images/journal07_04_mysql.png)
![](journal-images/journal07_05_desktop.png)
![](journal-images/journal07_06_postman.png)
![](journal-images/journal07_07_desktop.png)
![](journal-images/journal07_08_rabbitmq.png)

Implemented Request API to put Order request in a
RabbitMQ Queue. Also implemented Check Order Status
API to check the status of a Starbucks Order. 

![](journal-images/journal07_09_desktop.png)
![](journal-images/journal07_10_browser.png)
![](journal-images/journal07_11_docker.png)
![](journal-images/journal07_12_postman.png)

Implemented Background Worker Job to pick up Orders
and make Drinks. Once a drink has been made, the 
Order's status changes to "Fulfilled".

Links:

https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/0811dea670b9ed6897d5bce7a55132ff1ef06a8c
https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/3a09e3a93a5cb9ca545e60aae35801dc674234cd
https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/842bcf49c5987c9d1144f37d081aa85a41f95053

## Journal #8 - May 9

![](journal-images/journal08_01_desktop.png)
![](journal-images/journal08_02_already_registered.png)
![](journal-images/journal08_03_invalid.png)

Added new account registration page and changed the login
page. Registration page shows "User already registered" if
the email has already been used. Login page shows
"Invalid username and password" if either username or
password is wrong.

![](journal-images/journal08_04_desktop.png)
![](journal-images/journal08_05_browser.png)

Added a Logout button in the cashier page that logs the 
user out when the user clicks on it.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/c475e7330e9b74dbe1bee6186cb88508ad3ef1f8

## Journal #9 - May 12

![](journal-images/journal09_01_desktop.png)
![](journal-images/journal09_02_workloads.png)
![](journal-images/journal09_03_services.png)
![](journal-images/journal09_04_ingress.png)

Added yaml files to deploy the project on Google Cloud.
Pods, services, and ingress are running without errors.

![](journal-images/journal09_05_desktop.png)
![](journal-images/journal09_06_place.png)
![](journal-images/journal09_07_desktop.png)
![](journal-images/journal09_08_paid.png)
![](journal-images/journal09_09_fulfilled.png)

In store order processing works properly using URL used
by the app deployed on Google Kubernetes Engine.

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/36f2abfa1780c5c48683485609b081ece36d3e52

## Journal #10 - May 13

![](journal-images/journal10_01_desktop.png)
![](journal-images/journal10_02_browser.png)
![](journal-images/journal10_03_desktop.png)
![](journal-images/journal10_04_place_order.png)

Added order customization. 

Link: https://github.com/nguyensjsu/cmpe172-wilsonhuang01/commit/f2d2a81f8c877932ae6dceee4cff7b0f6e079082



## Architecture Diagrams

### Docker

![](journal-images/journalx_00_01_desktop.png)
![](journal-images/journalx_00_02_docker.png)

### GKE

![](journal-images/journalx_00_03_desktop.png)
![](journal-images/journalx_00_04_gke.png)

## Technical Requirements

### Cashier's App - Admin Login

![](journal-images/journalx_01_01_desktop.png)
![](journal-images/journalx_01_02_register.png)
![](journal-images/journalx_01_03_login.png)
![](journal-images/journalx_01_04_desktop.png)
![](journal-images/journalx_01_05_logout.png)

Web pages showing admin register, login, and logout.

![](journal-images/journalx_01_06_desktop.png)
![](journal-images/journalx_01_07_db.png)

User info are stored in MySQL database.

![](journal-images/journalx_01_08_desktop.png)
![](journal-images/journalx_01_09_source.png)

User info are not hard coded in source code.

### Cashier's App - GKE Pods

![](journal-images/journalx_02_01_desktop.png)
![](journal-images/journalx_02_02_workloads.png)
![](journal-images/journalx_02_03_desktop.png)
![](journal-images/journalx_02_04_info.png)
![](journal-images/journalx_02_05_info.png)
![](journal-images/journalx_02_06_info.png)

Cashier's app are deployed and running on GKE pods.

### Cashier's App - Order Selection

![](journal-images/journalx_03_01_desktop.png)
![](journal-images/journalx_03_02_place.png)

The "Place Order" button places an order that corresponds 
to the selections.

![](journal-images/journalx_03_03_desktop.png)
![](journal-images/journalx_03_04_db.png)

Order is stored in MySQL database.

![](journal-images/journalx_03_05_desktop.png)
![](journal-images/journalx_03_06_postman.png)

API call using Postman confirms order placed.

### Cashier's App - REST API

![](journal-images/journalx_04_01_desktop.png)
![](journal-images/journalx_04_02_source.png)
![](journal-images/journalx_04_03_source.png)
![](journal-images/journalx_04_04_source.png)
![](journal-images/journalx_04_05_source.png)

Source code confirming the use of REST API calls from 
Starbucks API to render views.

![](journal-images/journalx_04_06_desktop.png)
![](journal-images/journalx_04_07_deployment.png)

Deployment yaml file shows API_HOST and API_KEY being used.

![](journal-images/journalx_04_08_desktop.png)
![](journal-images/journalx_04_09_gke.png)

GKE console showing Kong's IP address and port.

### Cashier's App - Kong

![](journal-images/journalx_05_01_desktop.png)
![](journal-images/journalx_05_02_deployment.png)
![](journal-images/journalx_05_03_desktop.png)
![](journal-images/journalx_05_04_kong.png)
![](journal-images/journalx_05_05_kong.png)
![](journal-images/journalx_05_06_kong.png)

### Cashier's App - Payment

![](journal-images/journalx_06_01_desktop.png)
![](journal-images/journalx_06_02_before.png)
![](journal-images/journalx_06_03_desktop.png)
![](journal-images/journalx_06_04_after.png)

### GCP Cashier's App LB - External IP

![](journal-images/journalx_07_01_desktop.png)
![](journal-images/journalx_07_02_gke.png)
![](journal-images/journalx_07_03_cashier.png)

### GCP Cashier's App LB - Health Check

![](journal-images/journalx_08_01_desktop.png)
![](journal-images/journalx_08_02_service.png)
![](journal-images/journalx_08_03_service.png)

### GCP Starbucks API Internal LB - Health Check

![](journal-images/journalx_09_01_desktop.png)
![](journal-images/journalx_09_02_service.png)
![](journal-images/journalx_09_03_service.png)

### GCP Starbucks API Internal LB - Reachability

![](journal-images/journalx_10_01_desktop.png)
![](journal-images/journalx_10_02_ingress.png)
![](journal-images/journalx_10_03_desktop.png)
![](journal-images/journalx_10_04_postman.png)
![](journal-images/journalx_10_05_ping.png)
![](journal-images/journalx_10_06_host.png)

### MySQL Cloud SQL - MySQL Instance

![](journal-images/journalx_11_01_desktop.png)
![](journal-images/journalx_11_02_mysql.png)
![](journal-images/journalx_11_03_info.png)

### MySQL Cloud SQL - MySQL IP

![](journal-images/journalx_12_01_desktop.png)
![](journal-images/journalx_12_02_ip.png)

### MySQL Cloud SQL - Correspondence

![](journal-images/journalx_13_01_desktop.png)
![](journal-images/journalx_13_02_cashier.png)
![](journal-images/journalx_13_03_mysql.png)
![](journal-images/journalx_13_04_desktop.png)
![](journal-images/journalx_13_05_postman.png)

### RabbitMQ - Deployment

![](journal-images/journalx_14_01_desktop.png)
![](journal-images/journalx_14_02_rabbitmq.png)
![](journal-images/journalx_14_03_info.png)
![](journal-images/journalx_14_04_service.png)
![](journal-images/journalx_14_05_desktop.png)
![](journal-images/journalx_14_06_source.png)

### RabbitMQ - Functionality

![](journal-images/journalx_15_01_desktop.png)
![](journal-images/journalx_15_02_postman.png)
![](journal-images/journalx_15_03_browser.png)

Before payment.

![](journal-images/journalx_15_04_desktop.png)
![](journal-images/journalx_15_05_browser.png)
![](journal-images/journalx_15_06_postman.png)

After payment.

![](journal-images/journalx_15_07_desktop.png)
![](journal-images/journalx_15_08_logs.png)

Logs.

### Kong Connection - Mobile App

![](journal-images/journalx_16_01_desktop.png)
![](journal-images/journalx_16_02_connection.png)

### Kong Connection - Cashier's App

![](journal-images/journalx_17_01_desktop.png)
![](journal-images/journalx_17_02_connection.png)

### Kong API Auth - API Key Auth

![](journal-images/journalx_18_01_desktop.png)
![](journal-images/journalx_18_02_header.png)
![](journal-images/journalx_18_03_desktop.png)
![](journal-images/journalx_18_04_get.png)
![](journal-images/journalx_18_05_desktop.png)
![](journal-images/journalx_18_06_delete.png)


