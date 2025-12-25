# 🔐 Secure Auth Service

A centralized authentication service built using **Spring Boot** and **Spring Security**, implementing **JWT-based authentication**, **email-driven first-login password setup**, and **secured API access**.

This project is designed to be reusable as a **standalone authentication service** for future applications and microservices.

---

## 📌 Key Features

- User registration with email notification  
- System-generated temporary password on registration  
- First-login password reset enforcement  
- JWT-based authentication and authorization  
- Stateless security using Spring Security filters  
- Secure access to protected APIs  
- Random quote generation after successful authentication  
- Password encryption using BCrypt  

---

## 🏗️ Authentication Flow

1. User registers with email  
2. System generates a random temporary password  
3. Temporary password is sent via email  
4. User logs in using temporary password  
5. User is forced to reset password on first login  
6. JWT token is issued after successful authentication  
7. Authenticated user can access protected resources  

---

## 🛠️ Tech Stack

- Java 17  
- Spring Boot  
- Spring Security  
- JWT (JSON Web Token)  
- Spring Data JPA / Hibernate  
- Java Mail Sender  
- Maven  
- MySQL / H2  

---

## 📂 Project Structure

