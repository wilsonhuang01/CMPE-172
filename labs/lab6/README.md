# CMPE 172 - Lab #6 Notes

## Spring JDBC
![](images/01_jdbc.png)
![](images/02_console.png)

Full desktop view and console view.
Logger prints out operations on the database, 
e.g., "Creating tables" and "Inserting customer
record for Jeff Dean".

## Spring MySQL

![](images/03_docker_run.png)
![](images/04_console.png)

Full desktop view and console view showing MySQL
running in Docker.

![](images/05_mysql.png)

A `user` table is created. MySQL Workbench is used
to view the database.

![](images/06_add.png)

Adding a user where `name` = "First" and `email` = 
"someemail@someemailprovider.com".

![](images/07_get.png)

Getting users from the database returns all users in
the database. In this case, it returns only 1 user.

## Spring Gumball v3

![](images/08_docker_console.png)

2 containers are currently running in Docker - mysql
and spring-gumball.

![](images/09_webpage.png)

Webpage shows the `Model`, `Serial`, `Hash`, etc.

![](images/10_html_source.png)

HTML source shows hidden fields.

![](images/11_command.png)

Commands to create MySQL and Gumball containers.

![](images/12_before.png)

Before purchasing a gumball, 1000 in stock.

![](images/13_after.png)

After purchasing a gumball, gumballs in stock decrease to 999.

