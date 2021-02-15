# Admin Application
## Endpoints
    http GET - /admin - returns a list of debt objects per the requirements of the assignments

## How To Run
Navigate to the root directory of the project in command line.
1. Run Spring Boot app with java -jar command
    
        To run your Spring Boot app from a command line in a Terminal window you can use the java -jar command.
        
        java -jar target/admin-0.0.1-SNAPSHOT.jar

2. Run Spring Boot app using Maven

        You can also use Maven plugin to run your Spring Boot app. Use the below command to run your Spring Boot app with Maven plugin:

        mvn spring-boot:run
       
## Access App from a browser or Postman
After the application is successfully started, you can use a browser or Postman to hit the /admin endpoint.
    
    http GET - http://localhost:8080/admin
    
   * [Admin](http://localhost:8080/admin)
    
## Application Startup
The method to create the response is execute at application startup using the @PostConstruct annotation.  This will Log the response from the assigment into the console that is displaying in the terminal window.


