# Online School System

**Spring Boot Coding Challenge — Candidate Starter Pack**

| Attribute | Detail |
|---|---|
| Difficulty | Medium |
| Recommended duration | 90–120 minutes |
| Stack | Java 17, Spring Boot 3.5.7, Spring Data JPA, H2 |
| Testing | JUnit 4.13.2 through JUnit Vintage |
| Build | Maven and Gradle |
| Candidate task | Complete missing annotations, mappings, endpoints, exception handling, and methods |

> **ASSESSMENT NOTE:** Starter code is intentionally incomplete. Failing tests are expected. Do not delete, disable, rename, or weaken supplied tests or public APIs.

## Document Guide

| Part | Contents |
|---|---|
| I | Problem statement, API/data contract, instructions, acceptance criteria |
| II | Project structure and production starter code |
| III | JUnit 4 service, controller, and JPA integration tests |
| IV | Maven/Gradle configurations and execution instructions |
| V | Timing, rubric, and submission checklist |

## Candidate Quick Start

- Review the complete contract before coding.
- Run all tests to establish a baseline.
- Complete annotations and TODO methods only.
- Keep entities, DTOs, repositories, services, controllers, and exception handling layered.
- Run the full suite before submission.

## Project Layout

```
README.md
build.gradle
pom.xml
settings.gradle
src/main/java/com/company/onlineschool/OnlineSchoolApplication.java
src/main/java/com/company/onlineschool/controller/CourseController.java
src/main/java/com/company/onlineschool/controller/StudentController.java
src/main/java/com/company/onlineschool/dto/CourseRequest.java
src/main/java/com/company/onlineschool/dto/CourseResponse.java
src/main/java/com/company/onlineschool/dto/StudentRequest.java
src/main/java/com/company/onlineschool/entity/Course.java
src/main/java/com/company/onlineschool/entity/Student.java
src/main/java/com/company/onlineschool/exception/ApiError.java
src/main/java/com/company/onlineschool/exception/DuplicateEmailException.java
src/main/java/com/company/onlineschool/exception/GlobalExceptionHandler.java
src/main/java/com/company/onlineschool/exception/ResourceNotFoundException.java
src/main/java/com/company/onlineschool/repository/CourseRepository.java
src/main/java/com/company/onlineschool/repository/StudentRepository.java
src/main/java/com/company/onlineschool/service/SchoolService.java
src/main/java/com/company/onlineschool/service/SchoolServiceImpl.java
src/main/resources/application.properties
src/test/java/com/company/onlineschool/ControllerContractTest.java
src/test/java/com/company/onlineschool/JpaMappingTest.java
src/test/java/com/company/onlineschool/SchoolServiceTest.java
```

---

# Part I: Candidate Brief

## 1. Problem Statement

Build a simplified Online School System as a Spring Boot REST application. Multiple students may enroll in one course, while each student must belong to exactly one course. Use Spring Data JPA to persist the relationship, validation for request contracts, service-layer business logic, and REST endpoints for course creation, student creation, and student retrieval.

## 2. Functional Requirements

- Course entity: ID, name, description, credits, and students.
- Student entity: ID, first name, last name, email, and one mandatory course.
- `POST /courses` accepts `CourseRequest` and returns `CourseResponse` with HTTP 201.
- `POST /students/{courseId}` accepts `StudentRequest` and returns Student with course details and HTTP 201.
- `GET /students/{studentId}` returns Student with course details and HTTP 200.
- Invalid request data returns 400; missing resources return 404; duplicate email returns 409.

## 3. API Contract

| Method / Path | Success | Failure Contract |
|---|---|---|
| `POST /courses` | 201 `CourseResponse` | 400 invalid body |
| `POST /students/{courseId}` | 201 Student including course | 400 invalid body; 404 course missing; 409 duplicate email |
| `GET /students/{studentId}` | 200 Student including course | 404 student missing |

## 4. Validation Contract

- Course name and description are required after trimming.
- Credits must be between 1 and 10 inclusive.
- Student first name and last name are required after trimming.
- Email must be syntactically valid and unique ignoring case.
- A student cannot be persisted without a course.
- `Course.students` is the inverse side; `Student.course` owns the relationship through `course_id`.
- JSON serialization of Student must include Course but must not recurse through `Course.students`.

## 5. Candidate Instructions

- Do not alter public method signatures, package names, DTO fields, or endpoint paths.
- Do not modify, delete, disable, or weaken supplied tests.
- Do not expose repository objects directly outside the service contract except where the requirement explicitly returns Student.
- Use constructor injection.
- Be ready to explain ownership, join columns, status codes, transactions, and test strategy.

---

# Part II: Starter Code

See `src/main/java/com/company/onlineschool/`.

---

# Part III: JUnit 4 Test Suite

The supplied suite contains isolated service tests with Mockito, standalone MockMvc controller contract tests, and `@DataJpaTest` persistence tests with H2. JUnit 4 tests are run through the Vintage engine.

See `src/test/java/com/company/onlineschool/`.

---

# Part IV: Build and Run

## Commands

| Purpose | Maven | Gradle |
|---|---|---|
| Compile | `mvn clean compile` | `gradle clean compileJava` |
| Run tests | `mvn clean test` | `gradle clean test` |
| Run application | `mvn spring-boot:run` | `gradle bootRun` |
| Run service tests | `mvn -Dtest=SchoolServiceTest test` | `gradle test --tests SchoolServiceTest` |
| Run controller tests | `mvn -Dtest=ControllerContractTest test` | `gradle test --tests ControllerContractTest` |
| Run JPA tests | `mvn -Dtest=JpaMappingTest test` | `gradle test --tests JpaMappingTest` |

---

# Part V: Evaluation and Completion

## Expected Completion-Time Guidelines

| Activity | Guideline | Focus |
|---|---|---|
| Understand project and tests | 15 minutes | Layers, API, relationship ownership |
| JPA entities and repositories | 20–25 minutes | Annotations, join column, recursion |
| Service implementation | 25–30 minutes | Mapping, lookup, duplicate email, transactions |
| Controllers and exception advice | 20–25 minutes | Mappings, validation, status codes |
| Test, fix, and review | 15–25 minutes | Focused and full-suite execution |
| Total | 90–120 minutes | Complete, tested submission |

## Evaluation Rubric

| Area | Weight | Expected Evidence |
|---|---|---|
| Functional correctness | 35% | All endpoints and service behavior satisfy the contract. |
| JPA mapping | 20% | Correct ownership, cardinality, join column, and persistence behavior. |
| REST and error handling | 15% | Correct paths, verbs, status codes, validation, and error bodies. |
| Testing and edge cases | 15% | Supplied JUnit 4 suites pass without weakening tests. |
| Code quality | 10% | Clear layering, constructor injection, readable mapping logic. |
| Explanation and efficiency | 5% | Candidate explains transactions, serialization, and design choices. |

## Submission Checklist

- [ ] Maven and Gradle compile.
- [ ] All JUnit 4 tests pass.
- [ ] Entities have correct Jakarta Persistence annotations.
- [ ] Every student has exactly one persisted course.
- [ ] All three endpoints return the required statuses and bodies.
- [ ] Validation and 404/409 handlers work.
- [ ] No recursive JSON payload is produced.
- [ ] No public API or supplied test was changed.

## Sources and Design Notes

Spring Boot documentation identifies Java 17 as the minimum for current Spring Boot and documents Maven/Gradle build support. Spring Data JPA provides repository support for Jakarta Persistence. Spring Boot documents use of the Vintage engine for JUnit 4 tests and SpringRunner for JUnit 4 Spring integration tests. The pack intentionally uses Spring Boot 3.5.7 to retain a practical JUnit 4 assessment configuration while using Jakarta Persistence APIs.

---

*Candidate Pack | Java 17 | Spring Boot 3.5.7 | JUnit 4*
