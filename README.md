# Programozási Környezetek – Spring Boot Webalkalmazás

Ez a projekt egy egyszerű, oktatási célú Spring Boot webalkalmazás, amely két összekapcsolt entitást kezel: **Student** és **Grade**.  
A rendszer REST API-n keresztül biztosít teljes CRUD funkcionalitást, H2 memóriabeli adatbázissal, JPA-val és automatikus táblagenerálással.

---

## 📌 Funkciók

- Student és Grade entitások kezelése
- Kapcsolat: **One Student → Many Grades**
- Teljes CRUD mindkét entitásra (GET, POST, PUT, DELETE)
- REST API JSON válaszokkal
- H2 memóriabeli adatbázis
- Repository réteg Spring Data JPA-val
- Egységtesztek (JUnit + AssertJ)
- Jacoco támogatás (coverage report)
- GitHub Actions támogatás (build + test) – opcionális
- Docker támogatás – opcionális

---

## 🛠️ Technológiák

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- H2 Database
- Maven
- JUnit 5
- AssertJ
- Jacoco
- GitHub Actions (CI)
- Docker (opcionális)

---

## 🚀 Futtatás

### 1. Projekt indítása

```bash
mvn spring-boot:run
