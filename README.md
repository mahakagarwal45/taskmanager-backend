Task Management System — Backend

Overview
Backend service built using Spring Boot.
It provides REST APIs for managing tasks and handles business logic, request processing, and database interaction using MySQL.

Table of Contents
1. Architecture
2. Tech Stack
3. Design Decisions
4. ERD Diagram
5. API Reference
6. Running Locally
7. Configuration
8. Limitations
9. Future Enhancements

Architecture

| Layer      | Description           |
| ---------- | --------------------- |
| Controller | Handles HTTP requests |
| Service    | Business logic        |
| Repository | Database interaction  |
| Database   | Stores task data      |


Tech Stack

| Category   | Technology  |
| ---------- | ----------- |
| Backend    | Spring Boot |
| Language   | Java        |
| Database   | MySQL       |
| Build Tool | Maven       |

---

Design Decisions

| Decision     | Choice     | Reason           |
| ------------ | ---------- | ---------------- |
| Architecture | Layered    | Clean structure  |
| API Style    | REST       | Easy integration |
| DB Type      | Relational | Structured data  |

---

ERD Diagram

TASK
id (PK)
title
description
status


API Reference

| Method | Endpoint    | Description   |
| ------ | ----------- | ------------- |
| POST   | /tasks      | Create task   |
| GET    | /tasks      | Get all tasks |
| PUT    | /tasks/{id} | Update task   |
| DELETE | /tasks/{id} | Delete task   |


Running Locally

1. Configure MySQL database
2. Update application properties
3. Run using Maven

Configuration

| Property | Description         |
| -------- | ------------------- |
| DB URL   | Database connection |
| Username | DB user             |
| Password | DB password         |


Limitations

* No authentication
* No pagination
* Basic validation


Future Enhancements

* JWT Authentication
* Logging
* Pagination

