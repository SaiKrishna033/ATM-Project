# ATM Simulation System (Java)

## 📌 Overview
This project is a **console-based ATM simulation system** built in **Java** using Object-Oriented Programming (OOP) concepts.  
It allows multiple users to log in with a **User ID** and **PIN** and perform common banking operations such as balance check, deposit, withdrawal, and PIN change.  

The program ensures **input validation** and applies **deposit/withdrawal rules** to simulate real-world ATM behavior.

---

## ✨ Features
- 🔑 **Login Authentication** (User ID + 4-digit PIN)
- 👤 **Multiple Users Support** (Savings & Current Accounts)
- 💰 **Check Balance**
- ➕ **Deposit** with rules:
  - Amount must be **less than ₹50,000**
  - Amount must be in **multiples of 100**
- ➖ **Withdraw** with rules:
  - Maximum withdrawal: **₹25,000**
  - Amount must be in **multiples of 100**
  - Must maintain **minimum balance** (Savings: ₹1000, Current: ₹5000)
- 🔄 **Change PIN** (with validation)
- 🔒 **Forgot PIN recovery**
- ⚠ **Input validation & error handling**

---

## 🛠️ Tech Stack
- **Language:** Java (OOP concepts)
- **IDE:** Eclipse
- **Version Control:** Git & GitHub

---

## 📂 Project Structure
ATM-Project/
│── src/
│ ├── Main.java
│ ├── ATM.java
│ ├── Bank.java
│ ├── User.java
│ ├── Account.java
│ ├── SavingsAccount.java
│ ├── CurrentAccount.java
│
│── README.md

---

## 🚀 How to Run
1. Clone the repository:
   ```bash
   git clone https://github.com/SaiKrishnaKona/ATM-Project.git

2. Open in Eclipse (or any IDE).

3. Run the Main.java file.

4. Follow on-screen instructions.

===== Welcome to ATM =====
1. Login
2. Forgot PIN
3. Exit
Choose: 1
Enter User ID: 101
Enter 4-digit PIN: 1234
Welcome Alice (Savings Account)

===== ATM Menu =====
1. Check Balance
2. Deposit
3. Withdraw
4. Change PIN
5. Logout
Choose: 2
Enter amount to deposit: 4900
Deposited ₹4900 successfully.


