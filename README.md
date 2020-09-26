# Spring Security using Spring Data JPA & MySQL

This example shows how Spring Security connects to a MySQL DB for authentication. There are three pages in this application, i.e. a public page, a secured page, and an admin page. The public page is available to everyone (no authentication is required to access it). The secured page is accessible to the users with `USER` or `ADMIN` roles. The admin page is only accessible to the users with `ADMIN` role. The database configuration is in the `application.properties` file. Database initialization file is `V1__init.sql` used by [Flyway](https://flywaydb.org/). Flyway creates the below tables on the app startup and populate them with a few records as below:

**USER**
ID | USERNAME | PASSWORD
--- | --- | ---
1 | user | password
2 | admin | password


**ROLE**
ID | NAME
--- | ---
1 | USER
2 | ADMIN


**USER_ROLE**
ID | USER_ID | ROLE_ID
--- | --- | ---
1 | 1 | 1
2 | 2 | 2

Before running the app, MySQL needs to be up and accessible by the app. To run a MySQL DB server locally, there is a Docker compose file (`docker-compose.yml`) that can be used as below:

- `git clone  https://github.com/amirghaffari/spring-security-mysql.git`
- `cd spring-security-mysql`
- `docker-compose up -d`
- `docker exec -it mySqlDB mysql -uroot -p` (enter root's password)
- `create database spring_security_db;` (to create a DB required by the app)

To run the app:

- `mvn clean compile spring-boot:run`
- Visit http://localhost:8080/
