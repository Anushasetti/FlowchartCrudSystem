# Flowchart CRUD System

This is a Spring Boot-based backend application that provides RESTful APIs for managing flowcharts. A flowchart consists of **nodes** and **edges** forming a directed graph. The application supports **CRUD operations** and includes integration with an H2 database for persistence.

---

## Features

1. **Create Flowchart**: Add a new flowchart with nodes and edges.
2. **Fetch Flowchart**: Retrieve flowchart details by ID.
3. **Update Flowchart**: Modify nodes and edges of an existing flowchart.
4. **Delete Flowchart**: Remove a flowchart by ID.
5. **Swagger Documentation**: API documentation with testing capabilities.(in-progress and needs more development and testing)

---

## Technologies Used

- **Java 17**
- **Spring Boot 3.x**
- **Spring Data JPA**
- **H2 Database**
- **Springdoc OpenAPI (Swagger)**
- **JUnit 5** (for testing)

---

## Getting Started

### Prerequisites

- **Java 23**
- **Maven**
- A development environment (e.g., IntelliJ IDEA, Eclipse(recommended), or VS Code)

### Clone the Repository

```bash
git clone https://github.com/Anushasetti/FlowchartCrudSystem.git
cd FlowchartCrudSystem
```
### Build and Run the Application

1. **Build the Project**:

   ```bash
   mvn clean install
   ```

2. **Run the Application**:

   ```bash
   mvn spring-boot:run
   ```

3. Access the application:
   - Swagger UI: [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)
   - H2 Console: [http://localhost:8080/h2-console](http://localhost:8080/h2-console)

### Default H2 Database Configuration

- **URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: password

You can modify these in the `application.properties` file.
---

## API Endpoints

| HTTP Method | Endpoint               | Description                  |
|-------------|------------------------|------------------------------|
| POST        | `/api/flowcharts`      | Create a new flowchart       |
| GET         | `/api/flowcharts/{id}` | Fetch flowchart by ID        |
| PUT         | `/api/flowcharts/{id}` | Update an existing flowchart |
| DELETE      | `/api/flowcharts/{id}` | Delete a flowchart by ID     |

### Example JSON Payloads

#### Create Flowchart
```json
{
  "nodes": ["A", "B", "C"],
  "edges": [
    { "fromNode": "A", "toNode": "B" },
    { "fromNode": "B", "toNode": "C"}
  ]
}
```

#### Update Flowchart
```json
{
  "nodes": ["A", "B", "C", "D"],
  "edges": [
    { "fromNode": "A", "toNode": "B" },
    { "fromNode": "B", "toNode": "D"}
  ]
}
```

---
## Application Structure

```plaintext
src/main/java
├── com.example.flowchart
│   ├── controller
│   │   └── FlowchartController.java
│   ├── model
│   │   ├── Flowchart.java
│   │   └── Edge.java
│   ├── repository
│   │   ├── FlowchartRepository.java
│   │   └── EdgeRepository.java
│   ├── service
│   │   └── FlowchartService.java
│   └── config
│       └── SwaggerConfig.java
```

- **Controller**: Handles API endpoints.
- **Model**: Defines entities (Flowchart and Edge).
- **Repository**: Interfaces for data access.
- **Service**: Business logic for CRUD operations.
- **Config**: Configuration for Swagger documentation.

---
## Contact

For any queries or suggestions, feel free to contact:
- **Name**: Anusha Setti
- **GitHub**: [Anushasetti](https://github.com/Anushasetti)
- **mail**: anushasetti42@gmail.com

