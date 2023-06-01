# CMPE 172 - Lab #8 Notes

## Install Kong on Local Docker

### Create Kong Docker Network

![](images/01_network.png)
![](images/02_network.png)

### Run Starbucks API in Docker

![](images/03_run_api.png)
![](images/04_run_api.png)

### Run Kong in Docker

![](images/05_run_kong.png)
![](images/06_run_kong.png)
![](images/07_config_kong.png)
![](images/08_config_kong.png)
![](images/09_reload_kong.png)

## Deploy on Google GKE

### Build and Push Starbucks API

![](images/10_push.png)
![](images/11_push.png)

### Create a Cluster

![](images/12_cluster.png)
![](images/13_cluster.png)

### Connect Cloud Shell Terminal to Cluster

![](images/14_connect.png)
![](images/15_connect.png)

### Create MySQL Database

![](images/16_create_mysql.png)
![](images/17_create_mysql.png)
![](images/18_create_mysql.png)
![](images/19_create_mysql.png)
![](images/20_mysql.png)
![](images/21_mysql.png)

### Test MySQL Database from Jumpbox

![](images/22_jumpbox_update.png)
![](images/23_jumpbox_update.png)
![](images/24_jumpbox_mysql_client.png)

### Deploy Starbucks API

![](images/25_deployment.png)
![](images/26_deployment_logs.png)
![](images/27_deployment_logs.png)

### Create a Service for Starbucks API

![](images/28_service.png)
![](images/29_service_logs.png)

### Test Reachability from Jumpbox

![](images/30_ping.png)
![](images/31_ping.png)

### Install Kong

![](images/32_kong.png)
![](images/33_kong.png)

### Configure Kong's IP

![](images/34_ip.png)
![](images/35_ip.png)

### Create an Ingress Rule to Proxy the Starbucks Service

![](images/36_kong_ingress_rule.png)
![](images/37_kong_ingress_rule.png)
![](images/38_kong_strip_path.png)
![](images/39_kong_strip_path.png)
![](images/40_kong_patch_ingress.png)
![](images/41_kong_patch_ingress.png)

### Test Kong API Ping Endpoint

![](images/42_ping.png)
![](images/43_ping.png)

### Add Kong Key-Auth Plugin

![](images/44_kong_key_auth.png)
![](images/45_kong_key_auth.png)

### Configure an API Client Key

![](images/46_kong_consumer.png)
![](images/47_kong_consumer.png)

### Create Kubernetes Secret and Apply API Key Credentials to API Client

![](images/48_kong_credentials.png)
![](images/49_kong_credentials.png)

### Test Starbucks API Against Kong via Public IP of Load Balancer

![](images/50_ping.png)
![](images/51_ping.png)
![](images/52_cards_orders.png)

## Test Starbucks API from Postman

![](images/53_postman.png)
![](images/54_postman_ping.png)
![](images/55_postman_new_card.png)
![](images/56_postman_get_cards.png)
![](images/57_postman_get_card.png)
![](images/58_postman_activate_card.png)
![](images/59_postman_new_order.png)
![](images/60_postman_get_orders.png)
![](images/61_postman_get_order.png)
![](images/62_postman_clear_order.png)

## Discussion

### Challenges

One challenge I faced was that the kong-ingress-rule.yaml
provided in the assignment page uses a deprecated API 
and it caused errors when I tried to deploy it on GKE.
I solved this issue by looking at the documentation page,
which has an example yaml file. I modified the
kong-ingress-rule.yaml file to have similar structure as
the one listed on the documentation page.

### MySQL

My Starbucks API image uses MySQL so I created a new
MySQL instance on Google Cloud. Then I took the instance's
IP address and paste it into deployment.yaml.
