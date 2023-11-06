# School and Student Management



Application Readme
CRUD Operations Application for Managing Educational Data
This README file provides an overview of the CRUD (Create, Read, Update, Delete) operations application for managing educational data. The application handles four main entities: Course, Instructor, InstructorDetails, Student, and School. Below is a brief explanation of how these entities are managed in the application:

Entities
1. Course
The Course entity represents different courses offered in the educational system.

2. Instructor
The Instructor entity represents instructors who teach courses. Each Instructor has a one-to-one relation with an InstructorDetails entity.

3. InstructorDetails
InstructorDetails holds additional information about instructors and is associated with the Instructor entity in a one-to-one relationship.

4. Student
The Student entity represents students who can register for courses. Students have a many-to-many relationship with the Course entity.

5. School
The School entity represents educational institutions. The School entity is managed using JDBC template.

Application Components
Spring Rest Starter: The Course entity is managed using Spring Rest Starter, which provides RESTful APIs for creating, updating, deleting, and retrieving course information.

JDBC Template: The School and Student entities are managed using JDBC template to interact with the database.

Test Code
Test code is provided for the School Service. This test code ensures that the School entity is managed correctly and that the necessary CRUD operations are functioning as expected. In the future, additional validation and testing for other components can be added.

JSON Responses
The application is designed to return appropriate JSON responses when performing CRUD operations or when errors occur. These responses are structured to provide information about the success or failure of the operations, as well as any data requested or updated.

Future Work
In the future, you can consider the following enhancements to the application:

Validation: Implement data validation to ensure that data entered into the system is accurate and follows the required format and constraints.

Testing: Expand the test coverage to include other components such as Instructor, InstructorDetails, Student, and Course.

Error Handling: Enhance error handling to provide more descriptive error messages and appropriate HTTP status codes in the responses.

Security: Implement security measures to protect the application, especially when dealing with sensitive student and instructor data.

Additional Features: Add features like user authentication and authorization to control access to the application, and potentially integrate more advanced features for educational management.

This application serves as a foundation for managing educational data and can be extended and improved to meet specific requirements in the future.

Feel free to reach out if you have any questions or need further assistance with this application.

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
 
-  Instructor:
  - GET /api/instructor/getinstructor/{id}
  - GET /api/instructor/getallinstructor
  - POST /api/instructor/addinstructor
  - PUT /api/instructor/updatestudent/{id}
  - DELETE /api/instructor/deleteinstructor/{id}

## Swagger Documentation

Access API documentation and test the endpoints in Swagger UI: [http://localhost:9090/swagger-ui.html](http://localhost:9090/swagger-ui/index.html)

## Project Structure

- `src/main/java`: Java source code.
- `src/main/resources`: Application configuration.
- `pom.xml`: Maven project configuration.

## Database Configuration

Set your database connection details in `application.properties`.
Open sql Work Bench and create table
CREATE TABLE school (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    address VARCHAR(255),
    contactNumber VARCHAR(20),
    about TEXT
);


## Usage

1. Run the application.
2. Use the provided API endpoints for managing schools and students.
3. Explore and test the APIs in Swagger.


