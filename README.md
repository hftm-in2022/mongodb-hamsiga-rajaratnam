# Task Manager API (Quarkus + MongoDB)

## Overview
This is a **Task Manager API** built with **Quarkus** and **MongoDB** using Panache. It allows users to manage tasks, users, categories, and comments efficiently.

## Features
- **CRUD operations for tasks, users, and categories**
- **Embedded comments inside tasks**
- **REST API endpoints for seamless interaction**
- **MongoDB Atlas integration**
- **Panache for simplified database access**
- **Health check endpoints for monitoring**

---

## Setup Instructions

### **Prerequisites**
- Java 21+
- Maven
- MongoDB Atlas (or local MongoDB instance)
- IntelliJ IDEA (or any Java IDE)

### ** Clone the Repository**
```sh
 git clone https://github.com/your-repo/task-manager-api.git
 cd task-manager-api
```

### **Configure MongoDB Connection**
Open `src/main/resources/application.properties` and set your MongoDB connection:
```properties
quarkus.mongodb.connection-string=mongodb+srv://<username>:<password>@cluster0.mongodb.net/<database-name>
quarkus.mongodb.database=task_manager
```

### **Run the Application**
```sh
 ./mvnw quarkus:dev
```

The application will be available at `http://localhost:8080`.

---

## API Endpoints

### **User Management**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/users` | Create a new user |
| `GET` | `/users` | Retrieve all users |

### **Category Management**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/categories` | Create a new category |
| `GET` | `/categories` | Retrieve all categories |

### **Task Management**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/tasks` | Create a new task |
| `GET` | `/tasks` | Retrieve all tasks |
| `GET` | `/tasks/{taskId}` | Retrieve a specific task |
| `PUT` | `/tasks/{taskId}` | Update a task |
| `DELETE` | `/tasks/{taskId}` | Delete a task |

### ** Comment Management (Embedded in Tasks)**
| Method | Endpoint | Description |
|--------|---------|-------------|
| `POST` | `/tasks/{taskId}/comments` | Add a comment to a task |
| `GET` | `/tasks/{taskId}/comments` | Retrieve comments for a task |

---

##Health Check
Quarkus provides a built-in **liveness** check:
```sh
 GET http://localhost:8080/q/health/live
```
Expected Response:
```json
{
  "status": "UP",
  "checks": [{ "name": "alive", "status": "UP" }]
}
```

---

## Additional Notes
- You can extend the API by adding **pagination, authentication, and task filtering**.
- Consider deploying the application to **Docker or Kubernetes** for production.

---

## Future Improvements
- Implement authentication (JWT)
- Add task filtering and sorting
- Deploy to Kubernetes with Helm

---

## License
This project is licensed under the **MIT License**.

---
