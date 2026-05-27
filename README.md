# Expense Tracker System

## Overview

Expense Tracker System is a Java console-based backend project built using PostgreSQL and JDBC. It allows users to manage expenses through CRUD operations and also provides a monthly expense summary feature.

This project was built to practice backend development concepts such as database connectivity, SQL queries, JDBC, project structure, and Git/GitHub workflow.

---

## Technologies Used

* Java
* PostgreSQL
* JDBC
* VS Code
* Git & GitHub

---

## Features

* Add Expense
* View All Expenses
* Update Expense
* Delete Expense
* Monthly Expense Summary
* Menu-Driven Console Application

---

## Project Structure

```text
expense-tracker-system/
│
├── src/
│   ├── Main.java
│   ├── DatabaseConnection.java
│   ├── Expense.java
│   └── ExpenseService.java
│
├── lib/
│   └── PostgreSQL JDBC Driver
│
├── database/
│   └── schema.sql
│
├── README.md
└── .gitignore
```

---

## Database Table

```
CREATE TABLE expenses (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100),
    amount NUMERIC(10,2),
    category VARCHAR(50),
    expense_date DATE
);
```

---

## Concepts Practiced

* JDBC Connection
* PreparedStatement
* ResultSet
* SQL CRUD Operations
* Aggregate SQL Function (`SUM`)
* Menu-Driven Application Flow
* Exception Handling
* Git Workflow

---

## How to Run

### 1. Create Database

```
CREATE DATABASE expense_tracker;
```

---

### 2. Create Table

Run the SQL from:

```text
database/schema.sql
```

---

### 3. Compile Project

```
javac -cp "lib/postgresql-42.7.11.jar;src" src/*.java
```

---

### 4. Run Project

```
java -cp "lib/postgresql-42.7.11.jar;src" Main
```

---

## Menu Options

```text
1. Add Expense
2. View Expenses
3. Delete Expense
4. Update Expense
5. Monthly Expense Summary
6. Exit
```

---

## Future Improvements

* Expense filters by category
* Date range reports
* Spring Boot REST API version
* Frontend integration
* Charts and analytics

---

## Author

Vandit Sharma
    