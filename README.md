# Enterprise Banking REST API

A production-ready, backend banking engine built with **Java 17**, **Spring Boot**, and **MySQL**. This application simulates core banking functionalities—including account initialization, secure balance transfers, and automated ledger recording—while adhering to strict Object-Oriented Programming (OOP) and layered architecture principles.

---

## 🏛️ Architectural Overview

The application is structured using a **Layered Architecture pattern**, ensuring loose coupling, high maintainability, and clean separation of concerns:

1. **Controller Layer (`@RestController`)**: Acts as the bank's front desk. It exposes public HTTP REST endpoints to handle incoming client network requests.
2. **Service Layer (`@Service`)**: Acts as the bank's brain. It encapsulates business rules, executes financial balance calculations, and enforces safety guards.
3. **Repository Layer (`@Repository`)**: Acts as the bank's vault. Leveraging **Spring Data JPA**, it abstracts data operations and communicates directly with the persistent MySQL database.
4. **Model/Domain Layer (`@Entity`)**: Houses the core banking structural blueprints (`User`, `Account`, `Transaction`).

---

## 🛠️ Key Features Built So Far

* **Object-Oriented Account Hierarchy**: Modeled a robust domain layer using abstract base classes (`Account`) and polymorphically extended them into specialized banking models (`CheckingAccount` with overdraft protection, and `SavingsAccount` with interest calculation metrics).
* **Single Table Inheritance Mapping**: Utilized Hibernate's `SINGLE_TABLE` inheritance strategy to map polymorphic Java entities into a single, unified SQL `accounts` table equipped with a discriminator tracking column.
* **Immutable Ledger Pattern**: Designed an unalterable `Transaction` model to record chronological historical audit trails of every single currency movement.
* **Robust Exception Routing**: Configured custom unchecked business exceptions (`InsufficientFundsException`) to short-circuit invalid or risky transactions before state processing occurs.
* **Dependency Injection (DI)**: Leveraged Spring's IoC container to automate component lifecycles via constructor dependency injection.
* **Automated Data Seeding**: Integrated a `CommandLineRunner` hook to securely register mock client data and prime checking/savings accounts upon server ignition.

---

## 🚀 Tech Stack

* **Language**: Java 17
* **Framework**: Spring Boot 3.x (Spring MVC, Spring Data JPA)
* **Database**: MySQL 8.x
* **Build Tool**: Maven

---

## 🔧 Database Schema Layout

The persistent relational layer consists of three interconnected tables inside the `bank_db` schema:
* `users`: Stores core client identification information.
* `accounts`: Stores polymorphic balances, overdraft boundaries, interest data, and a foreign key binding back to the owner (`user_id`).
* `transactions`: An immutable audit table tracking historical ledger data.

---

## 🏃‍♂️ How to Run and Test Locally

### 1. Prerequisites
* Java 17 JDK installed.
* Local MySQL instance running on port `3306`.

### 2. Configure Environment Properties
Update your `src/main/resources/application.properties` file with your local MySQL access credentials:
```properties
spring.datasource.url=jdbc:mysql://localhost:3306/bank_db?createDatabaseIfNotExist=true&serverTimezone=UTC
spring.datasource.username=root
spring.datasource.password=YOUR_LOCAL_PASSWORD
