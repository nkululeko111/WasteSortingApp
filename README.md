# Waste Sorting Application

This is a Spring Boot-based REST API application for managing waste sorting data. The application is designed for Enviro365 to help users retrieve information about waste categories, disposal guidelines, and recycling tips. It uses an in‑memory H2 database for persistence and demonstrates best practices in building RESTful APIs with Spring Boot.

## Table of Contents

- [Features](#features)
- [Technologies Used](#technologies-used)
- [Getting Started](#getting-started)
  - [Prerequisites](#prerequisites)
  - [Installation](#installation)
  - [Running the Application](#running-the-application)
- [API Endpoints](#api-endpoints)
- [Testing the Endpoints](#testing-the-endpoints)
- [H2 Database Console](#h2-database-console)
- [Project Structure](#project-structure)
- [License](#license)

## Features

- **CRUD Operations**: Create, retrieve, update, and delete waste categories, disposal guidelines, and recycling tips.
- **Validation**: Input validation using Spring Boot validation annotations.
- **In-Memory Database**: Uses H2 for rapid development and testing.
- **Exception Handling**: Global exception handling for a consistent error response format.
- **RESTful API Design**: Clean and modular REST endpoints for integration with frontend applications.

## Technologies Used

- **Java 11**
- **Spring Boot 2.5.4**
- **Spring Web**
- **Spring Data JPA**
- **H2 Database**
- **Spring Boot DevTools**
- **Maven**

## Getting Started

### Prerequisites

- **Java 11** or higher installed on your machine.
- **Maven** installed (or use your IDE's built-in Maven support).
- An IDE (e.g., IntelliJ IDEA, Eclipse, VS Code) for code editing (optional).

### Installation

1. **Clone the repository:**

   ```bash
   git clone https://github.com/nkululeko111/WasteSortingApp.git
   cd waste-sorting
   ```

2. **Build the project using Maven:**

   ```bash
   mvn clean install
   ```

### Running the Application

1. **Run the Spring Boot application:**

   You can run the application either from your IDE by executing the `main` method in the `WasteSortingApplication` class, or by using Maven:

   ```bash
   mvn spring-boot:run
   ```

2. **Access the Application:**

   The application will start on port **8080**. You can access the endpoints using:
   
   - Base URL: `http://localhost:8080`

## API Endpoints

The application exposes the following endpoints:

### Waste Categories

- **GET /api/waste-categories**  
  Retrieves all waste categories.

- **GET /api/waste-categories/{id}**  
  Retrieves a specific waste category by its `id`.

- **POST /api/waste-categories**  
  Creates a new waste category.  
  **Example Request Body:**
  ```json
  {
    "name": "Glass",
    "description": "glass items can be recycled."
  }
  ```

- **PUT /api/waste-categories/{id}**  
  Updates an existing waste category by its `id`.

- **DELETE /api/waste-categories/{id}**  
  Deletes a waste category by its `id`.

### Disposal Guidelines

- **GET /api/disposal-guidelines**  
  Retrieves all disposal guidelines.

- **GET /api/disposal-guidelines/{id}**  
  Retrieves a specific disposal guideline by its `id`.

- **POST /api/disposal-guidelines**  
  Creates a new disposal guideline.

- **PUT /api/disposal-guidelines/{id}**  
  Updates an existing disposal guideline.

- **DELETE /api/disposal-guidelines/{id}**  
  Deletes a disposal guideline.

### Recycling Tips

- **GET /api/recycling-tips**  
  Retrieves all recycling tips.

- **GET /api/recycling-tips/{id}**  
  Retrieves a specific recycling tip by its `id`.

- **POST /api/recycling-tips**  
  Creates a new recycling tip.

- **PUT /api/recycling-tips/{id}**  
  Updates an existing recycling tip.

- **DELETE /api/recycling-tips/{id}**  
  Deletes a recycling tip.

## Testing the Endpoints

You can test the API endpoints using:

### cURL

Example command to create a new waste category:

```bash
curl -X POST http://localhost:8080/api/waste-categories \
     -H "Content-Type: application/json" \
     -d '{"name": "Glass", "description": "glass items can be recycled."}'
```

### Postman / Insomnia

- Create a new POST request.
- Set the URL to `http://localhost:8080/api/waste-categories`.
- Add a header: `Content-Type: application/json`.
- Include a JSON body (see the example above).

## H2 Database Console

The application uses an in-memory H2 database. To access the H2 console:

1. Open your web browser and go to:  
   `http://localhost:8080/h2-console`

2. Configure the connection:
   - **JDBC URL:** `jdbc:h2:mem:envirodb`
   - **User Name:** `sa`
   - **Password:** *(leave blank, unless configured otherwise)*

3. Click **Connect** to access the database and inspect tables/data.

## Project Structure

```
src/main/java/com/enviro/assessment/grad001/nkululeko-zwane/
├── WasteSortingApplication.java         
├── controller/
│   ├── WasteCategoryController.java       
│   ├── DisposalGuidelineController.java   
│   └── RecyclingTipController.java         
├── entity/
│   ├── WasteCategory.java                 
│   ├── DisposalGuideline.java             
│   └── RecyclingTip.java                  
├── repository/
│   ├── WasteCategoryRepository.java       
│   ├── DisposalGuidelineRepository.java   
│   └── RecyclingTipRepository.java         
└── exception/
    ├── GlobalExceptionHandler.java        
    └── ResourceNotFoundException.java     
```

