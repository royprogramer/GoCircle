# GoCircle

GoCircle is a desktop application built with Java, Maven, and JavaFX (featuring JFoenix for Material Design UI components). It utilizes a MySQL database back-end and handles secure, environment-specific configurations.

---

## 🚀 Features

* **Modern Desktop UI:** Built using JavaFX and styled with modern Material Design elements via JFoenix.
* **Maven Wrapper Included:** Ready to build and run instantly without needing a pre-installed global Maven setup.
* **Secure Environment Configurations:** Uses `.env` configuration file support to keep sensitive database credentials out of source control.

---

## 📁 Repository Structure

* `src/main/` — Contains the Java source code and FXML layout assets.
* `.env` — Local environment variables (e.g., database credentials).
* `pom.xml` — Project Object Model file containing project dependencies (including JFoenix).
* `mvnw` / `mvnw.cmd` — Maven Wrapper scripts for hassle-free compilation on Linux/macOS and Windows.
* `temp/` — Temporary workspace and build outputs.

---

## 🛠️ Prerequisites

Make sure you have the following installed on your machine:
* **Java Development Kit (JDK):** Version 11 or higher (recommended for JavaFX compatibility).
* **MySQL Server:** For storing and managing user data.

---

## ⚙️ Installation & Setup

### 1. Clone the Repository
```bash
git clone [https://github.com/royprogramer/GoCircle.git](https://github.com/royprogramer/GoCircle.git)
cd GoCircle
### 2. Configure Environment Variables
Copy the template configuration to setup your local environment. Create/edit the .env file in the root directory:
```bash
DB_HOST=localhost
DB_PORT=3306
DB_NAME=gocircle_db
DB_USER=your_database_username
DB_PASSWORD=your_database_password
