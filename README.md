# Student Management System (Java, JSP, Servlets, Oracle)

A full-stack MVC-based Student Management System built using Java, JSP, Servlets, JDBC, and Oracle Database.  
This project enables CRUD operations on student profiles with proper validations, exception handling, and database optimization.

---

## ✅ Features
- Add, update, delete, and view student records  
- MVC architecture (Servlets → Controller, JSP → View)  
- Server-side form validation  
- Modular service and controller layers  
- Exception handling for stable execution  
- Optimized SQL queries with indexing  
- Oracle database integration  

---

## ✅ Tech Stack
**Languages:** Java, SQL, HTML, CSS  
**Backend Technologies:** Servlets, JSP, JDBC  
**Architecture:** MVC  
**Build Tool:** Maven  
**Database:** Oracle  
**IDE:** Eclipse / IntelliJ  
**Tools:** Git, GitHub, Apache Tomcat  

---

## ✅ Database Schema (Oracle)

```sql
CREATE TABLE STUDENT (
    id NUMBER PRIMARY KEY,
    name VARCHAR2(50),
    age NUMBER
);


```
## ✅ Project Structure
```
StudentManagementSystem/
│
├── src/main/java/school/
│ ├── StudentController/
│ │ ├── RegisterStudent.java
│ │ ├── EditStudent.java
│ │ ├── DeleteStudent.java
│ │ └── ViewStudent.java (optional if added)
│ │
│ ├── entity/
│ │ └── Student.java
│ │
│ └── service/
│ └── StudentService.java
│
├── src/main/webapp/
│ ├── index.jsp
│ ├── register.jsp
│ ├── edit.jsp
│ ├── delete.jsp
│ └── WEB-INF/
│ └── web.xml
│
├── pom.xml
├── .gitignore
└── README.md
```
