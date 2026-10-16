# Warehouse Inventory & Reorder System

## Project Title
Warehouse Inventory & Reorder System

## Course
Problem Solving Using Programming – Java

## Team No
KLH/PSPJAVA/S14/T30

## Supervisor
Dr. Madhavi Karumudi

## Team Members
1. 2620030061 - K.Sai Kiran
2. 2620040105 - Naman 
3. 2620040039 - Naruna Nirbhay

---

## Abstract

The Warehouse Inventory & Reorder System is a Java-based application designed to manage and monitor stock quantities in a warehouse.

The system allows users to add stock, remove stock, view current inventory, identify low-stock items, and generate a reorder report.

The project demonstrates the practical use of fundamental Java programming concepts and control statements. A `switch` statement is used to select different inventory operations, a `while` loop keeps the system running, `for` loops are used to process inventory items, and `if-else` statements are used to check stock conditions.

This project demonstrates how basic programming concepts can be applied to a real-world warehouse inventory management problem.

---

## Objectives

- Maintain stock quantities of warehouse items.
- Add new stock to existing inventory.
- Remove stock when items are sold or used.
- Identify items below their reorder level.
- Generate a reorder report.
- Demonstrate Java control statements in a real-world application.

---

## Main Features

- Add Stock
- Remove Stock
- Display Inventory
- Low Stock Alert
- Reorder Report
- Menu-driven operation

---

## Java Concepts Used

| Concept | Application |
|---|---|
| `if-else` | Checks low stock and validates stock removal |
| `for` loop | Iterates through warehouse items |
| `while` loop | Keeps the program running |
| `switch` | Selects inventory operations |
| Arrays | Stores item names, stock and reorder levels |
| Scanner | Takes user input |

---

## System Workflow

```text
START
  |
  v
Initialize Inventory
  |
  v
Display Menu
  |
  v
User Selects Operation
  |
  v
Switch Statement
  |
  +---- Add Stock
  |
  +---- Remove Stock
  |
  +---- Check Low Stock
  |
  +---- Reorder Report
  |
  +---- Display Inventory
  |
  +---- Exit
  |
  v
Display Result
  |
  v
Return to Menu
  |
  v
EXIT
