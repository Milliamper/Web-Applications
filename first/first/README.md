- STS IDE: Right click -> Run As -> Spring Boot App
- Eclipse IDE Right click -> Run as -> Maven build... -> Goal: spring-boot:run

In case of error: "Web server failed to start. Port 8080 was already in use.
- CMD -> Run as Administrator
- netstat -ano | findstr portnumber
- taskkill /F / PID pidnumber

- http://localhost:8080/v3/api-docs
- http://localhost:8080/swagger-ui/index.html
