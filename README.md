<h1 align="center">✈️ Airline Booking System</h1> <p align="center">A Java AWT + MySQL desktop application for airline ticket booking, user authentication, and billing.</p>

## 📌 Overview

The Airline Booking System is a simple desktop-based application built using Java AWT and MySQL.
It demonstrates core concepts of:

• GUI application development<br>
• JDBC database connectivity<br>
• User authentication<br>
• Ticket booking workflows<br>
• Basic software architecture in Java<br>

This project is ideal for students and beginners exploring Java-based desktop applications.

## 🧩 Features

• User Authentication<br>
• Login and registration system<br>
• Basic form validation<br>
• Ticket Booking<br>
• Passenger detail entry<br>
• Source and destination selection<br>
• Booking date selection<br>
• Ticket Summary<br>
• View generated ticket<br>
• Passenger + flight details<br>
• Billing Module<br>
• Display total fare<br>
• Simple invoice-like UI<br>
• MySQL Integration<br>
• Store user accounts<br>
• Store booking data<br>
• JDBC connectivity using MySQL Connector<br>

## 🛠 Tech Stack

• Programming: Java<br>
• GUI Framework: AWT<br>
• Database: MySQL<br>
• Connectivity: JDBC (MySQL Connector/J)<br>
• Tools: IntelliJ IDEA / VS Code, Git, MySQL Workbench<br>

## ⚙️ Setup Instructions

**1️⃣ Configure MySQL Database**

  • Run the following commands:

CREATE DATABASE airline;

USE airline;

CREATE TABLE users (

  id INT AUTO_INCREMENT PRIMARY KEY,
  
  username VARCHAR(50),
  
  password VARCHAR(50)
);

CREATE TABLE bookings (

  id INT AUTO_INCREMENT PRIMARY KEY,

  passenger VARCHAR(100),
  
  source VARCHAR(50),
  
  destination VARCHAR(50),
  
  date VARCHAR(50)
);

  **• Update database credentials in DBConnection.java:**

String url = "jdbc:mysql://localhost:3306/airline";

String username = "root";

String password = "your_password";

**2️⃣ Compile the Project<br>**
  javac -cp ".;lib/mysql-connector-j-9.3.0.jar" src/*.java

**3️⃣ Run the Application<br>**
  java -cp ".;lib/mysql-connector-j-9.3.0.jar;src" Main

## 🖼️ Screenshots

### 🔐 Login Page
<p align="center">
  <img src="screenshots/Login.png" width="500">
</p>

---

### 📝 Registration Page
<p align="center">
  <img src="screenshots/Registration.png" width="500">
</p>

---

### 🛫 Flight Booking Page
<p align="center">
  <img src="screenshots/FlightBooking.png" width="500">
</p>

---

### 🎫 Ticket Summary
<p align="center">
  <img src="screenshots/Ticket.png" width="500">
</p>

## 📌 Future Improvements

• Admin dashboard<br>
• Flight search + pricing<br>
• PDF ticket generation<br>
• Notification system<br>
• UI modernization
