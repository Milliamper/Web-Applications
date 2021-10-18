- STS IDE
- Right click -> Run As -> Spring Boot App

- Eclipse IDE
- Right click -> Run as -> Maven build... -> Goal: spring-boot:run
- STS IDE: Right click -> Run As -> Spring Boot App
- Eclipse IDE Right click -> Run as -> Maven build... -> Goal: spring-boot:run

In case of error: "Web server failed to start. Port 8080 was already in use.
- CMD -> Run as Administrator
- netstat -ano | findstr portnumber
- taskkill /F / PID pidnumber


http://localhost:8080/v3/api-docs

if there is any json response then http://localhost:8080/swagger-ui/index.html

Replace the "https://petstore.swagger.io/v2/swagger.json" with the "http://localhost:8080/v3/api-docs" before the explore button

- https://stackoverflow.blog/2020/03/02/best-practices-for-rest-api-design/
- https://www.baeldung.com/global-error-handler-in-a-spring-rest-api
- https://reflectoring.io/bean-validation-with-spring-boot/

CRUD:
- Create POST
- Read GET
- Update PUT
- Delete DELETE

SOLID:
- Single responsibility
- Open closed
- Liskov substitution
- Interface segregation
- Dependency inversion
