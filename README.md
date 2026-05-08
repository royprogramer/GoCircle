# GoCircle

GoCircle is a desktop application built with Java, Maven, and JavaFX, featuring JFoenix for Material Design UI components. It uses a MySQL database backend and supports secure, environment-specific configurations.

---

## 🚀 Features

- **Modern Desktop UI** — Built with JavaFX and styled using Material Design components via JFoenix.
- **Maven Wrapper Included** — Build and run the project without installing Maven globally.
- **Secure Environment Configurations** — Uses a `.env` file to keep sensitive credentials out of source control.
- **MySQL Integration** — Persistent storage for application data.
- **Cross-Platform Build Support** — Works on Windows, Linux, and macOS.

---

## 📁 Repository Structure

```text
GoCircle/
├── src/main/          # Java source code and FXML assets
├── .env               # Local environment variables
├── pom.xml            # Maven dependencies and project configuration
├── mvnw               # Maven Wrapper for Linux/macOS
├── mvnw.cmd           # Maven Wrapper for Windows
└── temp/              # Temporary files and build outputs
```

---

## 🛠️ Prerequisites

Before running the application, make sure the following are installed:

- **Java Development Kit (JDK)** — Version 11 or higher
- **MySQL Server** — Running locally or remotely
- **Git** — For cloning the repository

---

## ⚙️ Installation & Setup

### 1. Clone the Repository

```bash
git clone https://github.com/royprogramer/GoCircle.git
cd GoCircle
```

---

### 2. Configure Environment Variables

Create a `.env` file in the project root directory and add the following:

```env
DB_HOST=localhost
DB_PORT=3306
DB_NAME=gocircle_db
DB_USER=your_database_username
DB_PASSWORD=your_database_password
```

---

### 3. Create the Database

Open MySQL and create the required database:

```sql
CREATE DATABASE gocircle_db;
```

---

### 4. Build the Project

Use the included Maven Wrapper to download dependencies and compile the application.

#### Linux/macOS

```bash
./mvnw clean install
```

#### Windows

```cmd
mvnw.cmd clean install
```

---

### 5. Run the Application

Execute the JavaFX application using Maven.

#### Linux/macOS

```bash
./mvnw exec:java -Dexec.mainClass="your.package.Main"
```

#### Windows

```cmd
mvnw.cmd exec:java -Dexec.mainClass="your.package.Main"
```

Replace `your.package.Main` with the actual fully qualified main class name.

Example:

```bash
./mvnw exec:java -Dexec.mainClass="com.gocircle.Main"
```

---

## 📦 Dependencies

Key technologies used in the project:

- JavaFX
- JFoenix
- Maven
- MySQL Connector/J
- dotenv-java (or equivalent environment loader)

---

## 🔒 Security Notes

- Never commit the `.env` file to version control.
- Add `.env` to `.gitignore`.
- Use strong database passwords.

Example `.gitignore` entry:

```gitignore
.env
```

---

## 🧪 Development Tips

### Clean and Rebuild

```bash
./mvnw clean package
```

### Skip Tests During Build

```bash
./mvnw clean install -DskipTests
```

---

## 🐞 Troubleshooting

### JavaFX Runtime Components Missing

Make sure JavaFX dependencies are properly configured in `pom.xml`.

### Database Connection Failed

Verify:

- MySQL server is running
- `.env` credentials are correct
- The database exists
- Port `3306` is accessible

### Maven Wrapper Permission Error (Linux/macOS)

Grant execute permission:

```bash
chmod +x mvnw
```

