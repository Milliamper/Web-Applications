- STS IDE
- Right click -> Run As -> Spring Boot App
- 
In case of error: "Web server failed to start. Port 8080 was already in use.
- CMD -> Run as Administrator
- netstat -ano | findstr *<port used>*
- taskkill /F / PID *<pid>*
