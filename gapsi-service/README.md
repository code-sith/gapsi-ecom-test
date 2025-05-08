# Getting started

This service is a test for GAPSI application exam and is intended to be only for testing purposes.

## Local deployment
### Pre requisites
- Java jdr o jdk v17 installed
- port 8080 available
- maven installed

### Instructions
1. clone the repo
2. open a terminal in the project root folder and run <code>mvn spring:run</code>
3. once the application start, verify the application is up and running by opening a browser and go to this url http://localhost:8080/actuator/health
4. if everything is good you should see <code> "status": "UP"</code>

### Test
in order to test this service a postman collection has been added to this repo in /tests directory. 
Export the json file into postman to see the collection and the tests.