### Description 

This project is a Spring Boot based backend system that includes:

* Sign up function
* H2 Database storage of account details
* Login function
* Generation of JWT (JSON Web Token) on login
* Verification of JWT in request headers
* Access grant to protected resources based on JWT

### Tools Used

* Java
* Maven
* Spring Boot
* Lombok
* JSON Web Tokens
* H2 Database


### Prerequisites:

* Java
* Maven

### Usage Guide:

* Download the project
* Ensure you have the prerequisites
* Navigate to project root and run the following
* `mvn clean install`
* `mvn spring-boot:run`
* Open http://localhost:8081/ in your browser
* Follow the instructions on the screen to Sign Up and Log in



(References)

* https://stackoverflow.com/questions/38700790/how-to-return-an-html-page-from-a-restful-controller-in-spring-boot#:~:text=To%20do%20this%20in%20a,will%20know%20what%20to%20display.&text=Already%20answered%20by%20%40kukkuz%20%26%20%40,also%20use%20with%20%40GetMapping%20annotation.&text=You%20get%20only%20the%20name,name%20return%20%22login%22%3B%20.
* https://stackoverflow.com/questions/56203811/package-javax-persistence-does-not-exist-using-spring-data-jpa-and-intellij
* https://docs.spring.io/spring-security/site/docs/5.5.x/guides/form-javaconfig.html
* https://www.baeldung.com/spring-security-login
* https://start.spring.io/
* Lombok setup https://www.youtube.com/watch?v=ftKBLu47u_U&ab_channel=CodingwithJohn