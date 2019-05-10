# Weather App

Web App. which will return current weather data from OpenWeatherMap.org, based on a city id chosen by the user.

Supported cities:

- London - 2643743
- Hong Kong - 1819729

## Getting Started

The application is located in a GitHub repository: 

```
https://github.com/drupalio/weather/

```

### Prerequisites

You will need to have Git, Maven and Java 1.8 in order to get a copy of the project and run the app.


### Installing

Download the project or clone via GitHub:

```
git clone https://github.com/drupalio/weather.git
```

Inside weather directory, you can build the project executing maven 'package' command

```
mvn clean package
```

Run the app executing maven 'spring-boot:run' command

```
mvn spring-boot:run
```

## Running the tests

Execute Unit tests with maven command

```
mvn clean test
```

## Deployment

Run the app executing maven 'spring-boot:run' command

```
mvn spring-boot:run
```

The application will start in the embedded spring-boot server at localhost on 8080 port, so you can go to the app by this url:

```
http://localhost:8080/
```


## Built With

* [SpringBoot](https://spring.io/projects/spring-boot) - The web framework used
* [Maven](https://maven.apache.org/) - Dependency Management
* [Junit](https://junit.org/junit5/) - Unit Test framework


## Authors

* **Ricardo Morales**

ricardo.morales@globant.com
