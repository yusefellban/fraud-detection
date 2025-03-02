# Social Engineering Detection API

This project is a Spring Boot application that acts as an intermediary for detecting potential social engineering attempts. It receives a client message via a REST API endpoint, forwards the message to an external Flask service for analysis, and returns the detection result to the client.

## Features

- **REST API Endpoint:**  
  Accepts POST requests at `/api/send-massage`.

- **External Analysis:**  
  Forwards the client message to a Flask-based service that analyzes the message for social engineering patterns.

- **Response Format:**  
  Returns a JSON response containing a boolean flag (`is_SE`) indicating whether the message is a social engineering attempt, along with an associated abnormal type (`abnormalType`).

## Technologies Used

- Java (JDK 17 or later)
- Spring Boot
- RestTemplate
- JUnit & Mockito (for testing)
- Flask (external service for message processing)

## Folder Structure (Single Folder Setup)

All files are kept in a single folder:

```
project-root/
├── App.java
├── AgentController.java
├── ApiResponse.java
├── AgentRequest.java
├── AgentResponse.java
├── AgentService.java
├── AgentControllerTest.java
├── AgentServiceTest.java
├── TestApplicationTests.java
├── application.properties
├── pom.xml
└── README.md
```

*Note: While this simplified structure is suitable for small projects, it is recommended to use the standard Maven structure (e.g., `src/main/java` and `src/test/java`) for larger projects.*

## Prerequisites

- JDK 17 or later
- Maven
- A running instance of the Flask service at `http://10.10.8.243:5000/process-message`  
  *(Adjust the URL in `AgentService.java` if needed.)*

## Getting Started

### 1. Clone the Repository

```bash
git clone https://github.com/your-username/your-repo-name.git
cd your-repo-name
```

### 2. Build the Project

Use Maven to build the project:

```bash
mvn clean install
```

### 3. Run the Application

You can run the application using Maven or by executing the generated JAR file.

**Using Maven:**

```bash
mvn spring-boot:run
```

**Or run the JAR file:**

```bash
java -jar target/your-jar-file-name.jar
```

The application will start and listen on all network interfaces as specified in `application.properties`.

### 4. API Usage

Send a POST request to the `/api/send-massage` endpoint with a JSON body containing the `message` field.

**Example using `curl`:**

```bash
curl -X POST \
  http://localhost:8080/api/send-massage \
  -H 'Content-Type: application/json' \
  -d '{"message": "Your sample message here"}'
```

Expected JSON response:

```json
{
  "status": true,
  "message": "Valid response"
}
```

## Running Tests

Unit tests are provided using JUnit and Mockito. To run the tests, execute:

```bash
mvn test
```


## Contributing

Contributions are welcome! Feel free to open issues or submit pull requests with improvements or suggestions.

## License

This project is licensed under the [MIT License](LICENSE).

