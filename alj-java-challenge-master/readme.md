### How to use this spring-boot project

- Install packages with `mvn package`
- Run `mvn spring-boot:run` for starting the application (or use your IDE)

Application (with the embedded H2 database) is ready to be used ! You can access the url below for testing it :

- Swagger UI : http://localhost:8080/swagger-ui.html
- H2 UI : http://localhost:8080/h2-console

> Don't forget to set the `JDBC URL` value as `jdbc:h2:mem:testdb` for H2 UI.


#### My experience in Java

-- IT professional with total 9 years of experience in Core Java, J2EE, SQL,
  3.5 years of experience in Spring Framework, Rest Web services, Hibernate
  3 years in Spring Boot and development of Microservices.


##### Below changes has been done by me
-- Replaced Getter/Setter annotation with @Data, Instead of attributes moved it to class level
-- Test cases has been added for all CRUD operations.
-- Added @TestMethodOrder annotation and added required dependency on pom.xml
-- @TestMethodOrder used to execute test cases in specific order
-- Added cache implementation by adding cache dependency in pom.xml and using @EnableCaching, @Cacheable.

##### If I would have more time I could authenticate endpoints by using @EnableWebSecurity. (Spring security feature) Also returned custom exceptions in case employee Id not found.




