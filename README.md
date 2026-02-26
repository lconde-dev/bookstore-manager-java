# Bookstore Management System (Java)

A comprehensive desktop application designed for managing a bookstore's core operations, including inventory control, sales processing, and entity management. This project was developed as part of the **Programming 2** course at **ORT University Uruguay**.

## 🚀 Features

- **Inventory Management:** Full CRUD for Books, Authors, Genres, and Editorials.
- **Sales System:** Process sales with automatic stock updates and an option to cancel/revert transactions.
- **Data Persistence:** Utilizes Java **Serialization** to save and load the entire system state from binary files.
- **Advanced Search:** Multi-criteria filtering for books (by title, genre, author, etc.).
- **Statistics & Ranking:** Visualizes sales data and inventory status.

## 🛠️ Tech Stack & Concepts

- **Language:** Java SE
- **Architecture:** Object-Oriented Programming (OOP)
- **Data Structures:** Extensive use of `HashMap` and `ArrayList` for optimized data management.
- **Persistence:** Java `Serializable` interface.
- **Design:** UML-based class architecture (Diagram included in documentation).

## 📂 Project Structure

The project follows a modular package structure:
- `Interfaz`: GUI components and user interaction logic.
- `Modelo`: Core business logic and entity classes (Book, Author, etc.).
- `LecturaYGrabacion`: Handles file I/O and serialization.
- `Obligatorio2`: Main entry point of the application.

## 🔧 How to Run

1. Clone the repository:
   ```bash
   git clone https://github.com/lconde-dev/java-bookstore-management-system.git
```
2. Open the project: Launch your preferred IDE (NetBeans, IntelliJ, or Eclipse) and import the root folder.

3. Run: Execute the OblProg2.java file to start the application.

Developed by Lucas Conde as part of the Systems Engineering degree at ORT Uruguay.