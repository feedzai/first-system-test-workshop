# Workshop: Your First System Test - an introduction to Test Automation

<p style='text-align: justify;'>This workshop will cover some techniques and tools that allow us to apply test automation to perform regression testing  in a system. Nowadays, any software project needs to have automated tests that guarantee that the main functionality does not break during the development lifecycle. In this workshop we will focus on how to achieve this, by writing some automated tests for the APIs and GUI using the PetClinic application (https://github.com/spring-projects/spring-petclinic).</p>

#### Requirements:
* Laptop
* Java (https://www.java.com/en/download/)
* Maven (https://maven.apache.org/install.html)
* Docker (https://docs.docker.com/v17.12/install/ check the tab 'DockerCE' on the left bar of the site for different OS versions)
* Chrome (https://www.google.com/chrome/)
* IDE (recommended https://www.jetbrains.com/idea/download/ or https://www.eclipse.org/downloads/)

## Getting Started
### 1 - Installing Java and Maven

Make sure you have Java 8 or later on your local development machine.
```sh 
java -version
```
Make sure you have Maven 3.X on your local development machine.

```sh 
 mvn -v
```

Make sure you have Docker on your local development machine.

```sh 
 docker -v
```  


### 2 - Running the Project

Verify that everything works by running:

```sh
git clone https://github.com/feedzai/first-system-test-workshop
cd first-system-test-workshop
mvn clean install
```

Ensure that there were no failures. It means that you were able to launch test-containers and run a test against it.

If there are any questions or issues in the setup, feel free to email me: ricardo.lopes@feedzai.com


---

## Step by step

### Your First System Test, an introduction to Test Automation
### 1 - Bootstrap the application under test manually with Docker.
Run the following command:
```sh
docker run -dit -p 8080:8080 --name petclinic arey/springboot-petclinic
```

### 2 - Add a new RestAPI test to validate the 'Add Owner' functionality at `PetClinicApiTest` class
Lets start by doing it manually in Chrome:
- Open the browser and navigate to the PetClinic homepage at http://localhost:8080
- Open the Chrome Dev Tools in the Network tab
- Fill the user form and submit. The body from the POST request to create the owner should be similar to:
```json
{
  "firstName":"John",
  "lastName":"Dow",
  "address":"Instituto Pedro Nunes",
  "city":"Coimbra",
  "telephone":"200000000",
  }
```
Now in the project open the `PetClinicApiTest` class and add a new test that adds a new owner to PetClinic:
- Create a `post` and `addOwner` method in `PetclinicApi` class
- Add a parameter body in `addOwner` with type `Object`
- Create a new test calling that endpoint, pass a map in the body parameter with the structure from the json above

### 3 - Create a Owner Object using a builder pattern

### 4 - Add a set of Rest API tests to validate the telephone number implementation

### 5 - Enable the `PetClinicApiTest` to run against Test Containers instead of a already running container

### 6 - Execute the Selenium Test and ensure that it works

### 7 - Add a new Selenium test that associates a new Pet with an existent user

### 8 - Refactor the code in order to have methods to interact with common elements

### 9 - Setup the Test-containers to run against Test Containers instead of a already running container

### 10 - Ensure that all tests run with
```sh
mvn clean install
```

--- 
### Learn More
* Test Containers (https://www.testcontainers.org/)
* Rest Assured (http://rest-assured.io/)
* Docker (https://github.com/wsargent/docker-cheat-sheet)
* Selenide (https://selenide.org/)
* Selenium (https://www.seleniumhq.org)
* Test Levels and Approach to automation (https://martinfowler.com/articles/practical-test-pyramid.html)
* Rules for writting automated tests (https://devops.com/10-rules-for-writing-automated-tests)
