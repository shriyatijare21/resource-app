# Study Resource Sharing App
 
## Project Description
This is a simple web-based application that allows users to add, view, and manage study resources such as notes, links, and references. The project demonstrates a complete DevOps pipeline including version control, automated build, testing, containerization, and deployment.

## Features
* Add study resources with Title, Description, Link, and Subject
* View all added resources
* Clickable links to access resources
* Delete resources
* Input validation:
    * All fields are mandatory
    * Link must start with http or https

## Tech Stack
### Frontend
* HTML
* CSS
* JavaScript

### Backend
* Spring Boot (Java)
* REST APIs

### Database
* H2 Database (In-memory)

### DevOps Tools
* Git and GitHub
* Maven
* GitHub Actions
* Docker
* Render (Cloud Deployment)

## Project Structure
```
resource-app/
│
├── src/
│   ├── main/
│   │   ├── java/com/example/resourceapp/
│   │   │   ├── controller/
│   │   │   ├── service/
│   │   │   ├── model/
│   │   │   └── repository/
│   │   └── resources/
│   │       ├── static/index.html
│   │       └── application.properties
│   │
│   └── test/
│       └── java/com/example/resourceapp/
│           ├── ResourceControllerTest.java
│           ├── ResourceServiceTest.java
│           └── ResourceAppApplicationTests.java
│
├── Dockerfile
├── pom.xml
└── .github/workflows/ci.yml
```

## How to Run Locally
1. Clone the repository
```bash
git clone [https://github.com/your-username/resource-app.git](https://github.com/your-username/resource-app.git)
cd resource-app
```

2. Build the project
```bash
mvn clean install
```

3. Run the application
```bash
mvn spring-boot:run
```

4. Open in browser
```
http://localhost:8080
```

## Running Tests
To run unit tests, controller tests, and validation checks:
```bash
mvn test
```

## Continuous Integration
GitHub Actions is used to automate the build and testing process. 
Pipeline steps include:
1. Checkout code
2. Setup Java
3. Build project using Maven
4. Run JUnit tests
5. Success/Failure reporting based on test results

## Docker Usage
Build Docker image:
```bash
docker build -t resource-app .
```

Run container:
```bash
docker run -p 8080:8080 resource-app
```

## Deployment
The application is deployed on Render using the free cloud plan.
Live URL: https://resource-app-1.onrender.com

## DevOps Workflow
1. Code is developed using Spring Boot
2. Code is pushed to GitHub repository
3. GitHub Actions runs CI pipeline
4. Maven builds the project and runs tests
5. Docker container is created
6. Application is deployed on cloud

## Validation Rules
* Title, Description, Link, and Subject are mandatory
* Link must start with http or https
* Invalid inputs are rejected

## Future Improvements
* Add user authentication
* Add edit functionality
* Add search and filter options
* Use a persistent database like MySQL or PostgreSQL

## Author
Developed as part of DevOps Mini Project
Cummins College of Engineering for Women, Pune

## License
This project is for academic purposes only.
```
