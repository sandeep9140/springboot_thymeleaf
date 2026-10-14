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





=============================================================================



# 📘 Day 21: Thymeleaf with Spring Boot

Today, I learned important Thymeleaf features used to create dynamic, conditional, and reusable HTML pages in Spring Boot applications.

## 📚 Topics Covered

### 1. Iteration Status — `status.first` and `status.last`

Used with `th:each` to identify the first and last elements while iterating over a collection.

```html
<ul>
    <li th:each="student, status : ${students}">
        <span th:text="${student}"></span>

        <span th:if="${status.first}">
            - First Student
        </span>

        <span th:if="${status.last}">
            - Last Student
        </span>
    </li>
</ul>
```

**Key Learning:**
- `status.first` returns `true` for the first element.
- `status.last` returns `true` for the last element.

### 2. Conditional Rendering — `th:if` and `th:unless`

Used to display HTML elements based on a condition.

```html
<p th:if="${isLoggedIn}">
    Welcome Back!
</p>

<p th:unless="${isLoggedIn}">
    Please Login First.
</p>
```

**Key Learning:**
- `th:if` displays an element when its condition is true.
- `th:unless` displays an element when its condition is false.

### 3. Elvis Operator — `?:`

Used to provide a default value when an expression evaluates to `null`.

```html
<p th:text="${userName} ?: 'Guest'">
    Guest
</p>
```

**Key Learning:** The Elvis operator helps handle missing or null values and display fallback content.

### 4. Switch and Case — `th:switch` and `th:case`

Used to select content based on the value of an expression.

```html
<div th:switch="${role}">
    <p th:case="'ADMIN'">Welcome Admin!</p>
    <p th:case="'USER'">Welcome User!</p>
    <p th:case="*">Unknown Role</p>
</div>
```

**Key Learning:**
- `th:switch` defines the expression to evaluate.
- `th:case` matches a specific value.
- `th:case="*"` acts as the default case.

### 5. Thymeleaf Fragments

Fragments allow us to reuse common HTML components such as headers, navigation bars, and footers across multiple pages.

**`fragments/header.html`**

```html
<header th:fragment="pageHeader">
    <h2>My Spring Boot Application</h2>
</header>
```

**Using `th:replace`**

```html
<div th:replace="~{fragments/header :: pageHeader}"></div>
```

**Key Learning:**

| Attribute | Purpose |
|---|---|
| `th:replace` | Replaces the host element with the fragment |
| `th:insert` | Inserts the fragment inside the host element |
| `th:include` | Legacy attribute; deprecated in modern Thymeleaf |

## 💡 What I Learned Today

- How to detect the first and last elements in a loop.
- How to conditionally display HTML elements.
- How to provide fallback values using the Elvis operator.
- How to implement switch-case logic in templates.
- How to create reusable HTML fragments in Thymeleaf.
- How to write cleaner and more maintainable Spring Boot web pages.

## 🛠️ Technologies Used

- Java
- Spring Boot
- Thymeleaf
- HTML
- Maven

## 🎯 Learning Goal

My goal is to strengthen my Java Full Stack Development skills by learning Spring Boot and Thymeleaf through practical examples and regular coding practice.

**Day 21 Completed ✅**

#Java #SpringBoot #Thymeleaf #JavaFullStack #WebDevelopment #100DaysOfCode #LearningInPublic
