# Task Manager REST API

[![Maven CI](https://github.com/DanielYaruta/REST-CI-CD/actions/workflows/maven-ci.yml/badge.svg)](https://github.com/DanielYaruta/REST-CI-CD/actions/workflows/maven-ci.yml)
[![Checkstyle](https://github.com/DanielYaruta/REST-CI-CD/actions/workflows/checkstyle.yml/badge.svg)](https://github.com/DanielYaruta/REST-CI-CD/actions/workflows/checkstyle.yml)
[![SpotBugs](https://github.com/DanielYaruta/REST-CI-CD/actions/workflows/spotbugs.yml/badge.svg)](https://github.com/DanielYaruta/REST-CI-CD/actions/workflows/spotbugs.yml)
[![Java](https://img.shields.io/badge/Java-17-blue?logo=openjdk)](https://adoptium.net/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.2.5-brightgreen?logo=springboot)](https://spring.io/projects/spring-boot)

Простой REST-сервис для управления списком задач на Spring Boot с настроенным CI/CD через GitHub Actions.

## Стек

- **Java 17**
- **Spring Boot 3.2.5** (Spring Web, Spring Boot Test)
- **Maven 3.6+**
- **GitHub Actions** — Maven CI, Checkstyle, SpotBugs

## Быстрый старт

```bash
# Сборка и тесты
mvn verify

# Запуск
mvn spring-boot:run
```

Сервис запустится на `http://localhost:8080`.

## API

### GET /api/tasks

Возвращает список всех задач.

```bash
curl http://localhost:8080/api/tasks
```

```json
[
  { "id": 1, "title": "Buy groceries",  "description": "Milk, eggs, bread",         "completed": false },
  { "id": 2, "title": "Read book",      "description": "Finish reading Clean Code",  "completed": false },
  { "id": 3, "title": "Exercise",       "description": "30 minutes cardio",          "completed": false }
]
```

## CI/CD

| Workflow | Триггер | Что делает |
|---|---|---|
| **Maven CI** | push / PR | `mvn verify` — сборка и все тесты |
| **Checkstyle** | push / PR | Проверка стиля кода, аннотации в PR |
| **SpotBugs** | push / PR | Поиск потенциальных ошибок, HTML-отчёт как артефакт |

### Проверки локально

```bash
mvn checkstyle:check          # стиль кода
mvn compile spotbugs:check    # статический анализ
```
