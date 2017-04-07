# JDbcCrud

JDBC Mysql CRUD Student demo app CLi and Gui Front End
create a database project and table users

mysql> use project
Database changed
========================================
create a table
=========================================
mysql>  CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(80) NOT NULL,
  `name` varchar(32) NOT NULL,
  `password` varchar(32) NOT NULL,
  `activation` int(2) DEFAULT NULL,
  `activ_date` date DEFAULT NULL,
  `last_login` date DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `email` (`email`)
);
==============================
Please Enter  A Choice
==============================
 1. Insert User 
 2. Update User 
 3. Delete User 
 4. List All User 
 0. Exit 
