<p align="center">
  <img src="logo.png" alt="Logo" width="100">

  <p align="center">
    An announcement server powered by Spring Boot
    <br>
    <br>
    <a href="https://github.com/BeaverHouse/announcement-server-java/issues">Bug Report</a>
    |
    <a href="https://github.com/BeaverHouse/announcement-server-java/issues">Request</a>
  </p>

  <p align="center">
    <a href="https://spring.io/projects/spring-boot">
      <img src="https://img.shields.io/badge/Spring%20Boot-6DB33F?style=flat&logo=springboot&logoColor=white" alt="Spring Boot">
    </a>
    <a href="https://www.oracle.com/">
      <img src="https://img.shields.io/badge/Oracle%20Cloud-4479A1?style=flat&logo=oracle&logoColor=white" alt="Oracle Cloud">
    </a>
    <a href="https://gradle.org/">
      <img src="https://img.shields.io/badge/Gradle-02303A?style=flat&logo=gradle&logoColor=white" alt="Gradle">
    </a>
  </p>
</p>

<!-- Content -->

<br>

## Overview

An announcement server built with Spring Boot and JPA.  
Provides RESTful APIs and uses the Oracle Autonomous Database.

<br>

## Prerequisites

1. You need to have Java 17 installed.
2. You need to set environment variables in `application.properties` file.

   ```txt
   spring.datasource.url="jdbc-url"
   spring.datasource.username="username"
   spring.datasource.password="password"
   ```

<br>

## Run in the local environment

**Run the application**

```
./gradlew bootRun
```

**Build the project**

```
./gradlew build
```

<br>

## Swagger UI

After running the server, Swagger UI is available at:

```
http://localhost:8080/swagger-ui.html
```

<br>

## Deploy the project

1. Move the built `.jar` file to the target VM or container.
2. The script is in the `scripts` folder.
3. Run the application and expose it via reverse proxy, for example, NGINX.

<br>

## Contributing

See the [CONTRIBUTING.md](./CONTRIBUTING.md).

<br>
<br>

[Spring Boot]: https://spring.io/projects/spring-boot
[Spring Data JPA]: https://spring.io/projects/spring-data-jpa
[MySQL]: https://www.mysql.com/
[Gradle]: https://gradle.org/
