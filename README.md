# CapeStart portal for Employee mgmt  - Java (maven)
- discription of the project

### Usage
- Build the project with maven 
```java
mvn clean install

- Run the project with maven 
```java
mvn spring-boot:run


### endpoints available

localhost:8200/portal/health
localhost:8200/portal/health/info

### dependancies
- postgresql running locally

- spring boot, actuator, slf4j, jdbc with liquibase, objectMapper

### features

- liquibase takes care of DB operations while starting up the application.

- actuator will help to refresh the application without down-time to enable/disable features. 

- spring boot annotations are used through-out the application for easy configurations.

- slf4j for basic logging with differnt log levels like INFO, ERROR, WARN, etc.

### application design

- DAO layer for DB operations abstraction
- Service layer for business logics
- Controller layer for exposing endpoints
- Routes layer for EDA listeners (TODO: apache camel framework) 

### TODO

- sonar cloud for code quality and test coverage

- new relic for monitoring