# Alchemy-Tech Microservice Application

This is a microservice application developed using Java with Spring Boot framework. It provides RESTful endpoints to perform CRUD operations on user records.

## Building and Running Locally

1. Ensure you have Java Development Kit (JDK) version 11 or higher installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory.
4. Run the following command to build the application:
    ./mvnw clean package
5. Once the build is successful, run the following command to start the application locally:
    java -jar target/alchemy-tech.jar


## Building and Running Docker Container

1. Ensure you have Docker installed on your system.
2. Clone this repository to your local machine.
3. Navigate to the project directory.
4. Run the following command to build the Docker image:
   docker build -t alchemy-tech .
5. Once the Docker image is built, run the following command to start the Docker container:
   docker run -p 8080:8080 alchemy-tech


## API Endpoints

- GET /api/users: Retrieve all user records.
- GET /api/users/{id}: Retrieve a user record by ID.
- POST /api/users: Create a new user record.
- PUT /api/users/{id}: Update an existing user record.
- DELETE /api/users/{id}: Delete a user record by ID.

### Testing the API

You can use tools like Postman to test the API endpoints.

#### Swagger API Document

You can use below URL to see API Documentation on SWAGGER :
http://localhost:8080/swagger-ui/index.html

## Deploying to AWS

To deploy the application to AWS, follow these steps:
1. Package the application into a deployable artifact
2. Set up an AWS EC2 instance.
3. Install Docker on the EC2 instance.
4. Copy the deployable artifact to the EC2 instance.
5. Build and run the Docker container on the EC2 instance.
