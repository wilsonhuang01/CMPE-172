
create database starbucks;
create user 'employee3025'@'%' identified by 'imagine';
grant all on cashier.* to 'employee3025'@'%';

use starbucks;

create database if not exists 'starbucks';
use 'starbucks';


DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
    `next_val` bigint DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

LOCK TABLES `hibernate_sequence` WRITE;
INSERT INTO `hibernate_sequence` VALUES (4);
UNLOCK TABLES;
