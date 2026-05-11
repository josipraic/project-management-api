# Project Management API
REST API for managing projects and tasks built with Spring Boot.

##    Features
- Create and manage projects
- Create, update and delete tasks
- Assign tasks to projects
- Pagination support
- Global exception handling
- Request validation

---

##   Tech Stack
- Java 21
- Spring Boot
- Spring Data JPA
- Hibernate
- H2 Database
- Maven

---

##   Run Application

Clone repository:

bash
git clone https://github.com/josipraic/project-management-api.git

cd project-management-api

---

##   Database

H2 Console:
- http://localhost:9090/h2-console

JDBC URL:
- jdbc:h2:mem:pmdb

---

##   API Endpoints
Projects

| Method | Endpoint             | Description       |
| ------ | -------------------- | ----------------- |
| POST   | `/api/projects`      | Create project    |
| GET    | `/api/projects`      | Get all projects  |
| GET    | `/api/projects/{id}` | Get project by id |
| DELETE | `/api/projects/{id}` | Delete project    |

Tasks

| Method | Endpoint                          | Description           |
| ------ | --------------------------------- | --------------------- |
| POST   | `/api/projects/{projectId}/tasks` | Create task           |
| GET    | `/api/projects/{projectId}/tasks` | Get tasks for project |
| PUT    | `/api/tasks/{id}`                 | Update task           |
| DELETE | `/api/tasks/{id}`                 | Delete task           |

---

##   Example Request

Create project

{
"name": "Backend Project",
"description": "Main project",
"status": "DRAFT"
}

Create task

{
"title": "Implement Task API",
"description": "Create service and controller",
"status": "TODO"
}

---

##   Architecture

Layered architecture:

Controller -> Service -> Repository