# School and Student Management

A Spring Boot project to manage schools and students. Uses Spring JDBC Template and Swagger for API documentation.

## Prerequisites

- Java JDK (8+)
- Maven or Gradle
- MySQL or another relational database

## Getting Started

1. Clone this repository.
2. Configure your database connection in `application.properties`.
3. Build and run the project.

## API Endpoints

- Schools:
  - GET /api/school/getschool/{id}
  - GET /api/school/getallschool
  - POST /api/school
  - PUT /api/school/updateschool/{id}
  - DELETE /api/school/deleteschool/{id}

- Students:
  - GET /api/student/getstudent/{id}
  - GET /api/student/getallstudent
  - POST /api/student
  - PUT /api/student/updatestudent/{id}
  - DELETE /api/student/deletestudent/{id}

## Swagger Documentation

Access API documentation and test the endpoints in Swagger UI: [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui.html)

## Project Structure

- `src/main/java`: Java source code.
- `src/main/resources`: Application configuration.
- `pom.xml`: Maven project configuration.

## Database Configuration

Set your database connection details in `application.properties`.

## Usage

1. Run the application.
2. Use the provided API endpoints for managing schools and students.
3. Explore and test the APIs in Swagger.


