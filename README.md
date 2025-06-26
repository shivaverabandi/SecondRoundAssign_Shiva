# Second Round Java Intern Assignment - Shiva Verabandi

This project is a Spring Boot application developed for a Java backend intern assignment. It demonstrates how to design and implement a relational data model with `Product`, `GTIN`, and `Batch` entities using Spring Data JPA and exposes RESTful APIs to populate and retrieve data.

---

## 🧱 Technologies Used

- Java 17+
- Spring Boot
- Spring Data JPA
- H2 (or MySQL/PostgreSQL as needed)
- Hibernate
- Lombok
- Maven

---

## 📦 Database Model

### Entity Relationships

- **Product** (1) ⟶ (Many) **GTIN**
- **GTIN** (1) ⟶ (Many) **Batch**

### Tables

1. **Product**
   - `productId` (Primary Key)
   - `productName`
   - `createdOn`

2. **GTIN**
   - `id` (Primary Key)
   - `gtin` (String)
   - `productId` (Foreign Key)

3. **Batch**
   - `batchId` (Primary Key)
   - `mrp`, `sp`, `purchasePrice`
   - `availableQuantity`
   - `inwardedOn`
   - `gtinId` (Foreign Key)

---

## ✅ Features Implemented

### 1. **Data Insertion via POST APIs**
- `POST /products`: Create a new Product
- `POST /gtins`: Create a GTIN associated with a Product
- `POST /batches`: Create a Batch associated with a GTIN

> These APIs accept Entity objects directly (without DTOs) and persist them into the database.

### 2. **Simple Retrieval APIs (GET)**
- `GET /gtins`: Fetch all GTINs
- `GET /gtins/{id}`: Fetch a single GTIN by ID, with its product and all batches
- `GET /batches/by-gtin/{gtinId}`: Fetch all batches for a GTIN

### 3. **Advanced Conditional API**
- `GET /gtins/filter-batches`:  
  For each GTIN, returns:
  - All batches with `availableQuantity > 0`
  - **Only the most recent** batch where `availableQuantity <= 0`

---

## 🧪 Sample JSON Payloads

### Create Product
```json
{
  "productName": "Paracetamol",
  "createdOn": "2025-06-26"
}
