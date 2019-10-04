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
### 1 - TDB
This section will be only be some hours before the workshop.

--- 
### Learn More
* Test Containers (https://www.testcontainers.org/)
* Rest Assured (http://rest-assured.io/)
* Docker (https://github.com/wsargent/docker-cheat-sheet)
* Selenide (https://selenide.org/)
* Selenium (https://www.seleniumhq.org)
* Test Levels and Approach to automation (https://martinfowler.com/articles/practical-test-pyramid.html)
* Rules for writting automated tests (https://devops.com/10-rules-for-writing-automated-tests)
