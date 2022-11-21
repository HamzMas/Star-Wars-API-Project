# Star-Wars-API-Project
![java_badge](https://img.shields.io/badge/-Java-lightgrey?style=for-the-badge&logo=appveyor)
![maven_badge](https://img.shields.io/badge/-Maven-yellow?style=for-the-badge&logo=appveyor)

**Developed by Hamza, Chung, William, John, Ioannis, Mohamed**

### **Table Of Contents**
* [**About Project**](#about-project)
    - [Dependencies](#dependencies)
* [**Getting Started and Program Overview**](#getting-started-and-program-overview)
  - [Installation](#installation)
  - [Program Structure](#program-structure)
* [**Purpose**](#Purpose)
* [**Future Developments**](#future-developments)
  - [**Behaviour-Driven-Development**](#Behaviour-Driven-Development)

***
## About Project

As part of our week 7 project we were tasked with building a testing framework to test the star wars API.
We used a Service Object Model to represent the various API requests which can be made.

The model consists of a DTO model which represents the different responses that can be called, 
the connection which handles the connection to the system and the injector which injects the payload into an appropriate DTO.

### <span style="color: blue;">**Dependencies**</span>

* junit 4.11
* junit-jupiter 5.9.0
* jackson-databind 2.14.0
* cucumber-java 7.8.1
* cucumber-junit 7.8.1

***
## Getting Started and Program Overview
### <span style="color: blue;">**Installation**</span>
Create a local folder and open git bash. Clone the repository by copying the link below and entering "git clone (link)" into git bash.


 Run the following command on git bash.
```bash
cd *folder name*
git clone https://github.com/HamzMas/Star-Wars-API-Project.git
```

### <span style="color: blue;">**Program Structure**</span>
The program was organised into 4 different packages:

* The connection layer abstracts the connection to the API, allowing us to get the different endpoints of the API and the HTTP response. 
* The dto layer contains the multiple dto's, generated using the RoboPojo generator, represents the different endpoints of the API and includes convenience methods for ease of testing.
* The injector layer contains methods for injecting the API endpoints to their corresponding dto and handling any exceptions thrown in the process.
* The utilities layer contains a class called linkValidator which contains methods for checking the validity code of Hateoas links such as their status code.

![img_1.png](img_1.png)
***

## Purpose
The purpose of building this testing framework is to simplify the testing process by abstracting away the connection, injection and dto layers, thus reducing most tests to assertions.

For example, the code for connecting and injecting objects into a dto is simplified in the beforeAll like so:

```java
@BeforeAll 
static void initAll(){
    peopleDTO = injectPeopleDTO(getConnection(Endpoints.PEOPLE, 5));
    statusCode = getStatusCode(Endpoints.PEOPLE);
    header = getHeader("Content-type", Endpoints.PEOPLE);
}
```

As a result, most tests can be simplified to just assertions for ease of use for the tester:

```java
@Test
@DisplayName("Check status code of species")
void checkStatusCodeOfSpecies(){
    assertTrue( peopleDTO.checkStatusCode(peopleDTO.getSpecies()));
}
@Test
@DisplayName("Check films is not null")
void checkFilmsIsNotNull() {
    assertNotNull(peopleDTO.getFilms());
}
```

## Future Development

For future improvements we would like to implement BDD using cucumber to ensure the testing framework is readable for a non-technical user.<br>

***
