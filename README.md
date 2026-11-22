# Student Exam Results — Original Spring Boot Practice (2025)

Early **Java 21 + Spring Boot 3.5.6 + Thymeleaf** practice project for displaying and managing exam scores.

> This is an **older original repository**, separate from the later rebuilt [student-exam-results](https://github.com/Zhenis455/student-exam-results) showcase. The implementations are not identical and should not be counted as two unrelated products without explanation.

## Features implemented

- List students at `/students`.
- Search by name/surname using `?q=...`.
- Add a student at `/students/new` with name, surname and numeric exam result.
- Calculate A (90+), B (75+), C (60+), D (50+), F (below 50).

**Limitations:** Data is stored **in memory** and disappears when the server restarts. The original service does not validate score ranges. Current controller implements listing and creation only, not full edit/delete.

## Requirements

- JDK 21
- Internet on first Gradle run

## Run

On Windows:

```cmd
gradlew.bat bootRun
```

On macOS/Linux:

```bash
chmod +x gradlew
./gradlew bootRun
```

Then open **http://localhost:8080/students**.

## Automated check

CI builds and runs available tests with JDK 21. To check locally:

```cmd
gradlew.bat clean test bootJar
```

## Layout

- `src/main/java/com/example/controller` — MVC controllers
- `src/main/java/com/example/service` — in-memory records and grading
- `src/main/java/com/example/model` — student model
- `src/main/resources/templates` — HTML views
- `narxoz/` — another nested starter present in the historic repository

**Status:** source preserved; automated GitHub build check added in November 2026. No claim of production readiness.
