# Library Web Application

## Overview

This project was developed as part of a proficiency exam for the Web Programming Elective course at Fatec Mogi das
Cruzes. The main goal is to create a simple library application that allows for:

- Book registration and management
- Book loans and returns
- Fines for late returns

## Technologies Used

- **Java**: The main programming language for developing the application.
- **Spring Boot**: Framework to facilitate backend development with support for JPA and Flyway.
- **MySQL**: Relational database management system used to store data.
- **Docker**: Platform for creating, deploying, and managing application containers.
- **Docker Compose**: Tool for defining and running multi-container Docker applications.
- **Thymeleaf**: Template engine for rendering HTML pages.
- **Bootstrap 5**: CSS framework for styling and responsiveness.
- **Flyway**: Library for database migration management.

## Running the Project

Follow the steps below to run the project using Docker Compose:

1. **Clone the Repository**

   Clone the project repository to your local environment:

   ```bash
    git clone https://github.com/LucasHenriqueSZ/ILP-exam.git
    cd ILP-exam
    ```

2. **Start the Containers**

   Use Docker Compose to build and start the application and MySQL database containers:

     ```bash
      docker-compose up --build
     ```
   Docker Compose will create and start two containers: one for the Java application and one for the MySQL database.

3. **Access the Application**
   Once the containers are running, the application will be available at http://localhost:80. You can access the web
   interface to manage books, process loans, and returns.

4. **Check the Logs**

   To check the container logs and monitor the application execution, you can use:

   ```bash
     docker-compose logs -f
    ```

