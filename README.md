# 📚 Book Library Backend

![Java](https://img.shields.io/badge/Java-17-blue)
![Spring Boot](https://img.shields.io/badge/SpringBoot-2.x-brightgreen)
![MySQL](https://img.shields.io/badge/Database-MySQL-orange)

---

## 🚀 Project Overview

This is the backend service for a **Book Library / Reading Tracker Application** built using Spring Boot.

The application allows users to:

- Register an account
- Log in securely
- Add books to their personal collection
- View their books
- Update book details
- Delete books

Each user can manage only their own books.

The backend exposes REST APIs consumed by a Flutter frontend application.

---

## 🏗 Architecture

The project follows a layered architecture:

Controller → Service → Repository → Database


Project structure:

src/main/java/com/example/booklibrary

├── controller → REST API endpoints
├── service → Business logic
├── repository → Database access layer
├── entity → JPA entities
├── dto → Request/Response models
├── exception → Global exception handling
└── config → Configuration classes


---

## 🛠 Technology Stack

| Technology | Purpose |
|------------|----------|
| Spring Boot | Backend Framework |
| Spring Data JPA | ORM |
| Hibernate | Persistence Provider |
| MySQL | Relational Database |
| BCrypt | Password Hashing |
| Maven | Dependency Management |

---

## ⚙️ Setup Instructions

### 1️⃣ Clone Repository

```bash
git clone https://github.com/A-deep08/Libook_backend
cd booklibrary-backend
2️⃣ Create MySQL Database
CREATE DATABASE booklibrary;
3️⃣ Configure application.properties
Update:

src/main/resources/application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/booklibrary?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC
spring.datasource.username=springuser
spring.datasource.password=123456

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect
4️⃣ Run Application
Using IntelliJ:
Run BookLibraryApplication.java

Or via terminal:

mvn spring-boot:run
Server runs at:

http://localhost:8080

###🗄 Database Schema
User Table
Field	Type
id	Long (Primary Key)
email	String (Unique)
password	String (BCrypt Hashed)
Book Table
Field	Type
id	Long (Primary Key)
title	String
author	String
description	String
status	String
user_id	Foreign Key (User)
Relationship:

One User → Many Books

🔐 Authentication Flow Explanation
User registers using email and password.

Password is encrypted using BCrypt before being stored in the database.

During login:

Email is validated.

Password is verified using BCrypt matching.

If credentials are valid:

Backend returns userId.

The frontend uses this userId to perform book-related operations.

Note:
JWT authentication can be integrated in future improvements.

📡 API Endpoints
Base URL:

http://localhost:8080
🔐 Authentication APIs
Register User
POST /api/auth/register
Request Body:

{
  "email": "test@gmail.com",
  "password": "123456"
}
Response:

User registered successfully
Login User
POST /api/auth/login
Request Body:

{
  "email": "test@gmail.com",
  "password": "123456"
}
Response:

{
  "message": "Login successful",
  "userId": 1
}
📚 Book APIs
All book APIs require userId as a request parameter.

Add Book
POST /api/books?userId=1
Request Body:

{
  "title": "Atomic Habits",
  "author": "James Clear",
  "description": "Self improvement",
  "status": "READING"
}
Get All Books
GET /api/books?userId=1
