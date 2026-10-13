# Day 20: Thymeleaf – Structure & Basic Concepts (Part 1) 🌱

## 📌 Overview

As part of my Java Full Stack Development learning journey, I learned the fundamentals of **Thymeleaf**, a modern server-side Java template engine commonly used with Spring Boot to create dynamic HTML pages.

Thymeleaf allows us to display data from the Spring MVC model directly in HTML templates while keeping the code clean and readable.

## 🎯 What I Learned

- Introduction to Thymeleaf and its use in Spring Boot.
- Spring Boot project structure.
- Adding Thymeleaf dependencies using Maven.
- Configuring Thymeleaf in `application.properties`.
- Understanding basic Thymeleaf attributes.
- Using Thymeleaf expressions to access model data.
- Creating dynamic HTML pages.

## 🛠️ Technologies Used

- Java
- Spring Boot
- Thymeleaf
- Maven
- HTML5

## 📂 Project Structure

```text
myapp/
├── src/
│   └── main/
│       ├── java/
│       │   └── com/sandeep/
│       │       ├── controller/
│       │       ├── model/
│       │       └── service/
│       └── resources/
│           ├── templates/
│           ├── static/
│           └── application.properties
└── pom.xml
```

### Folder Explanation

- **controller/** – Handles incoming web requests.
- **model/** – Contains entities or data classes.
- **service/** – Contains business logic (optional for this basic example).
- **templates/** – Stores Thymeleaf HTML templates.
- **static/** – Stores CSS, JavaScript, and images.
- **application.properties** – Contains application configuration.
- **pom.xml** – Defines Maven dependencies.

## 📦 Maven Dependencies

Add the following dependencies inside the `<dependencies>` section of `pom.xml`:

```xml
<!-- Spring Boot Web -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<!-- Thymeleaf Template Engine -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-thymeleaf</artifactId>
</dependency>

<!-- Optional: Spring Boot DevTools -->
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
    <optional>true</optional>
</dependency>
```

## ⚙️ Thymeleaf Configuration

In `src/main/resources/application.properties`:

```properties
spring.application.name=myapp

spring.thymeleaf.prefix=classpath:/templates/
spring.thymeleaf.suffix=.html

# Disable template caching during development
spring.thymeleaf.cache=false
```

Spring Boot already provides the default Thymeleaf template configuration, so these settings are optional unless you want to customize them.

## 🧠 Basic Thymeleaf Syntax

| Attribute | Purpose |
|---|---|
| `th:text` | Displays text from model data |
| `th:utext` | Renders unescaped HTML |
| `th:href` | Sets a link URL |
| `th:src` | Sets an image source |
| `th:object` | Selects an object for a form |
| `th:field` | Binds a form field to an object property |
| `th:each` | Iterates over a collection |
| `th:if` | Displays an element conditionally |
| `th:unless` | Displays an element when a condition is false |

> **Security Note:** Use `th:text` for ordinary user-provided text. `th:utext` renders HTML without escaping it, so never use it with untrusted input.

## 💡 Thymeleaf Expression Types

### 1. Variable Expression — `${...}`

Used to access data stored in the model.

```html
<p th:text="${user.name}"></p>
<p th:text="${user.age}"></p>
```

### 2. Selection Expression — `*{...}`

Used to access properties of an object selected through `th:object`.

```html
<div th:object="${user}">
    <p th:text="*{name}"></p>
    <p th:text="*{age}"></p>
</div>
```

### 3. URL Expression — `@{...}`

Used to create application URLs.

```html
<a th:href="@{/home}">Home</a>
```

## 📝 Example: Simple Thymeleaf Page

Create `src/main/resources/templates/home.html`:

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
    <h1 th:text="${message}">Welcome Message</h1>
</body>
</html>
```

A Spring MVC controller can supply the `message` attribute:

```java
package com.sandeep.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("message", "Welcome to Thymeleaf!");
        return "home";
    }
}
```

When you open `/home`, Spring Boot renders `home.html` and displays the message provided by the controller.

## ▶️ How to Run

1. Clone or download this repository.
2. Open the project in IntelliJ IDEA, Eclipse, or another Java IDE.
3. Ensure Java and Maven are installed and configured.
4. Run the Spring Boot application.
5. Open `http://localhost:8080/home` in your browser.

## 📚 Key Takeaways

- Thymeleaf integrates naturally with Spring Boot.
- HTML templates can display dynamic model data.
- Thymeleaf attributes make links, forms, conditions, and loops easier to manage.
- The `templates` directory stores HTML views rendered by the template engine.

## 🚀 Learning Journey

**Day 20 of my Java Full Stack Development Journey**

Continuously learning and building my skills in Java, Spring Boot, Thymeleaf, and web development.

More concepts and practical examples coming soon!

#Java #SpringBoot #Thymeleaf #JavaFullStack #WebDevelopment #LearningJourney
