# Parental Control Service API

The Parental Control Service API has one endpoint which accepts the customer’s parental control level preference and a 
movie id as input. If the customer is able to watch the movie the API indicates this to the calling client.

# Table of contents

1. [Prerequisites](#Prerequisites)
2. [Getting started](#Getting-started)
    1. [Download source code](#Download-source-code)
    2. [Running the tests](#Running-the-tests)
    3. [Building the jar](#Building-the-jar)
    4. [Running the API](#Running-the-jar)
4. [Using the API](#Using-the-API)
5. [Feedback](#Feedback)

## Prerequisites

You will need...

* Git installed on your machine to clone the source code from this repository. To install Git please refer to the 
[Git-scm instructions.](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)

* [Maven](https://maven.apache.org/docs/3.6.3/release-notes.html) installed to run tests and build the application

* Java 8 to run the application. To check which version please refer to the 
[Oracle version manual.](https://www.java.com/en/download/help/version_manual.xml) If you do not have Java 8 
installed, please refer to the 
[Oracle Java installation instructions.](https://www.java.com/en/download/help/index_installing.xml)

## Getting started

The following sub-sections explain how to download the source code, run the existing tests, build the application 
(as a jar,) and how to run the application.

### Download source code

* Download the source code locally so you can run the tests and build the jar to run the API
  
* *Tip:* In your terminal or command console, create a directory where you would like to download the source code and use 
`git clone https://github.com/Aamirio/ParentalControl.git` or alternatively you can download it as a zip using the 
github *Download ZIP* feature in the UI.

### Running the tests

* In your terminal or command console, navigate to the root directory where you have downloaded the source code and run 
`mvn clean test` to verify all tests are passing.

* Unit tests have been written for the `ParentalControlService` in `ParentalControlServiceTest`. The MovieService 
dependency has been mocked using Mockito.

* Integration tests have been written for the API in `ParentalControllerTest` using Spring MockMvc. A stub has been 
provided for the MovieService called `MovieServiceStub`. More on this later.

### Building the jar

In your terminal or command console, navigate to the root directory where you have downloaded the source code and run 
`mvn clean package` to verify all tests are passing and build the jar.

### Running the jar

In your terminal or command console, after you have built the jar, navigate to the `target` directory and run
`java -jar aamiridrees-1.0.0-SNAPSHOT.jar` This will host the API at
[http://localhost:8080](http://localhost:8080/pc/movie/alpha/rating/U)

## Using the API

* The API can be used by hitting the endpoint at 
`http://localhost:8080/pc/movie/<movieId>/rating/<parentalControlLevel>` 

* For example, if the client wanted to check if a 12 rating was okay for "Beta" they would hit the endpoint at 
`http://localhost:8080/pc/movie/beta/rating/12` 

* However, because the MovieService has not been implemented yet, a stubbed version has been provided so at least the 
application can be used for exploratory testing. 

* `MovieServiceStub` only holds ratings for 5 different movie ids, *"alpha" (U)*, *"beta" (PG)*, *"charlie" (12)*, 
*"delta" (15)*, *"echo" (18)*. Also, if *"foxtrot"* is passed as a movie id then the stub throws a 
`TechnicalFailureException` and the Controller returns this as a `500 Internal Server Error` to the client with a message 
informing there has been a System error. If any other movie id is passed then a `TitleNotFoundException` is thrown and 
the Controller returns a `404 Not Found Error` with a message informing the client that the movie could not be found.

## Feedback

* Thank you for taking your time to have a look. Any constructive feedback can be [emailed](mailto:aamiridrees@hotmail.com) 
and will be most appreciated.