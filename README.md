# University Student Record and Campus Route Management System

Name - W.A.Duneesha Nethmi
Student ID - 22UG3-0580

## 1. Project Title

**University Student Record and Campus Route Management System**

---

## 2. Project Overview

This project is a Java-based console application developed to manage university student records, student service requests, and campus locations.

The system demonstrates different Data Structures and Algorithms concepts such as:

- Singly Linked List
- Stack
- Queue
- Binary Search Tree (BST)
- Hash Table
- Graph using Adjacency List
- Breadth-First Search (BFS)

The system provides a menu-driven interface where users can add, update, delete, search, and display student records. It also manages service requests and campus locations and connections.

---

## 3. Objectives

The main objectives of this project are:

- To manage university student records efficiently.
- To demonstrate the use of different data structures.
- To implement student record operations such as adding, updating, deleting, searching, and displaying.
- To manage student service requests using a Queue.
- To maintain recent system actions using a Stack.
- To search and organize students using a Binary Search Tree.
- To perform fast student ID searching using a Hash Table.
- To represent campus locations and roads using a Graph.
- To traverse connected campus locations using Breadth-First Search (BFS).
- To provide input validation and handle invalid user inputs.

---

## 4. Data Structures Used

### 4.1 Singly Linked List

The Singly Linked List is used to store student records.

It supports:

- Adding student records
- Finding student records
- Deleting student records
- Checking whether the list is empty
- Displaying all student records

The linked list stores the main student records in the system.

---

### 4.2 Stack

A Stack is used to store recent actions performed in the system.

The Stack follows the **LIFO (Last In, First Out)** principle.

For example, when a new action is performed, it is pushed into the Stack. The most recent action can be viewed first.

Operations include:

- Push
- Pop
- Display recent actions

---

### 4.3 Queue

A Queue is used to manage student service requests.

The Queue follows the **FIFO (First In, First Out)** principle.

The first service request added to the queue is processed first.

Operations include:

- Add a service request
- Process the next request
- Display pending requests

---

### 4.4 Binary Search Tree (BST)

A Binary Search Tree is used to organize student records according to Student ID.

The BST supports:

- Insert student
- Search student
- Delete student
- In-order traversal

The Student ID is used as the key for the BST.

---

### 4.5 Hash Table

A Hash Table is used for searching students by Student ID.

The implementation uses:

- Hash function
- Linear probing
- Table size of 101
- Collision handling
- Delete operation with cluster rehashing

This allows student records to be searched efficiently using the Student ID.

---

### 4.6 Graph

A Graph is used to represent campus locations and connections between them.

The graph is implemented using an **Adjacency List**.

Campus locations are represented as vertices, while roads or connections between locations are represented as edges.

The system supports:

- Adding campus locations
- Removing campus locations
- Adding campus connections
- Removing campus connections
- Displaying campus connections
- Displaying connected locations

---

### 4.7 Breadth-First Search (BFS)

Breadth-First Search is used to traverse connected campus locations.

BFS starts from a selected campus location and visits connected locations level by level.

A Queue is used during the BFS traversal.

---

## 5. Main System Features

The system provides the following main features:

1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Student Records
5. Add Service Request
6. Process Next Service Request
7. Display Pending Service Requests
8. Display Recent Actions
9. Display Students using BST
10. Search Student using Hashing
11. Add Campus Location
12. Remove Campus Location
13. Add Campus Connection/Road
14. Remove Campus Connection/Road
15. Display Campus Connections
16. Display Connected Locations
17. Traverse Campus using BFS
18. Exit the System

---

## 6. Student Record Management

The system stores the following student information:

- Student ID
- Student Name
- Programme
- Marks

Users can:

- Add a new student
- Update an existing student
- Delete a student
- Display all students
- Search students using hashing
- Display students using the BST

---

## 7. Service Request Management

Students can submit service requests through the system.

Each service request contains:

- Student ID
- Request description
- Request time

The Queue processes requests according to the FIFO principle.

The system can:

- Add a new service request
- Process the next service request
- Display all pending service requests

---

## 8. Campus Route Management

The system represents the university campus using a Graph.

The sample campus contains the following locations:

- Main Gate
- Administration Building
- Faculty of Computing
- Library
- Student Center
- ICT Laboratory

Sample connections include:

- Main Gate → Administration Building
- Administration Building → Faculty of Computing
- Administration Building → Library
- Faculty of Computing → ICT Laboratory
- Faculty of Computing → Student Center
- Library → Student Center

The user can add or remove campus locations and connections.

---

## 9. Campus Traversal Using BFS

The system provides a BFS traversal option.

The user can select a starting campus location and the system visits connected locations using Breadth-First Search.

For example:

**Starting Location: Main Gate**

The BFS can visit:

`Main Gate → Administration Building → Faculty of Computing → Library → ICT Laboratory → Student Center`

The exact traversal order depends on the connections stored in the adjacency list.

---

## 10. Input Validation

Input validation is included to make the system safer and easier to use.

The system checks:

- Empty input
- Invalid menu choices
- Invalid integer values
- Marks outside the range of 0–100
- Duplicate Student IDs
- Student IDs that do not exist
- Duplicate campus locations
- Campus locations that do not exist
- Invalid campus connections
- Connections that are not available

This helps prevent invalid data from being entered into the system.

---

## 11. Sample Student Data

The system contains sample student records for testing.

| Student ID | Name | Programme | Marks |
|---|---|---|---:|
| S001 | Ashen Shanuka | Applied IT | 78.50 |
| S002 | Nimal Perera | Computer Science | 82.00 |
| S003 | Kamal Silva | Cyber Security | 74.50 |

These records are used to demonstrate the functionality of the different data structures.

---

## 12. Technologies Used

- **Programming Language:** Java
- **Application Type:** Console Application
- **Data Structures:** Linked List, Stack, Queue, BST, Hash Table, Graph
- **Graph Representation:** Adjacency List
- **Graph Algorithm:** Breadth-First Search (BFS)
- **Development Environment:** Java-compatible IDE / Command Line

---

## 13. Project Structure

The main Java file contains the following classes:

```text
UniversityStudentManagementSystem
│
├── Student
├── StudentLinkedList
├── ActionStack
├── ServiceRequest
├── ServiceRequestQueue
├── StudentBST
├── StudentHashTable
├── CampusGraph
└── UniversityStudentManagementSystem
```

Each class is responsible for a specific part of the system.

---

## 14. Team Member and Individual Contribution

This assignment was completed individually.

### Student Details

| Name | Student ID | Responsibility | Contribution |
|---|---|---|---|
| W A Duneesha Nethmi | 22UG3-0580 | Complete Project Development | Designed and implemented the complete system including Linked List, Stack, Queue, BST, Hash Table, Graph, BFS, menu system, input validation, testing, and documentation. |

### Individual Contribution

I completed the project individually and was responsible for:

- Designing the overall system
- Implementing the Student class
- Implementing the Singly Linked List
- Implementing the Stack
- Implementing the Queue
- Implementing the Binary Search Tree
- Implementing the Hash Table
- Implementing the Campus Graph
- Implementing BFS traversal
- Implementing the main menu
- Implementing input validation
- Adding sample student data
- Adding sample campus locations and connections
- Testing the system functionality
- Preparing the README documentation

---

## 15. How to Run the Project

### Step 1: Open the Project

Open the Java project using a Java-compatible IDE such as IntelliJ IDEA, Eclipse, NetBeans, or VS Code.

### Step 2: Open the Java File

Open:

```text
UniversityStudentManagementSystem.java
```

### Step 3: Compile the Program

Compile the Java file using the Java compiler.

```bash
javac UniversityStudentManagementSystem.java
```

### Step 4: Run the Program

```bash
java UniversityStudentManagementSystem
```

### Step 5: Use the Menu

The main menu will be displayed.

Select a number from the menu to perform the required operation.

---

## 16. Main Menu

```text
1. Add Student Record
2. Update Student Record
3. Delete Student Record
4. Display All Records using Linked List
5. Add Service Request to Queue
6. Process Next Service Request
7. Display Pending Service Requests
8. Display Recent Actions using Stack
9. Display Students using BST
10. Search Student using Hashing
11. Add Campus Location
12. Remove Campus Location
13. Add Campus Connection/Road
14. Remove Campus Connection/Road
15. Display Campus Connections
16. Display Connected Locations
17. Traverse Campus using BFS
0. Exit
```

---

## 17. Testing

The system can be tested using the following operations:

### Student Testing

- Add a new student
- Try adding a duplicate Student ID
- Update an existing student
- Try updating a non-existing student
- Delete a student
- Display all student records
- Search for a student using Hashing
- Display students using BST

### Queue Testing

- Add service requests
- Display pending requests
- Process the next request
- Confirm that requests are processed in FIFO order

### Stack Testing

- Perform different system actions
- Display recent actions
- Confirm that the latest action is displayed first

### Graph Testing

- Add a new campus location
- Add a connection between locations
- Display campus connections
- Display connected locations
- Remove a connection
- Remove a campus location
- Perform BFS traversal

### Input Validation Testing

Invalid values can be entered to check whether the system correctly handles:

- Empty values
- Invalid menu numbers
- Invalid marks
- Duplicate Student IDs
- Non-existing Student IDs
- Duplicate campus locations
- Invalid campus connections

---

## 18. Data Structure Summary

| Data Structure | Purpose |
|---|---|
| Singly Linked List | Store and manage student records |
| Stack | Store recent system actions |
| Queue | Manage student service requests |
| Binary Search Tree | Organize and search students by Student ID |
| Hash Table | Search students by Student ID |
| Graph | Represent campus locations and roads |
| BFS | Traverse connected campus locations |

---

## 19. Conclusion

The University Student Record and Campus Route Management System demonstrates the practical use of important Data Structures and Algorithms concepts in Java.

The project combines multiple data structures to manage student records, service requests, and campus routes. It also includes input validation and a menu-driven console interface.

The implementation demonstrates how different data structures can be used for different purposes within one complete application.

This project was completed individually by:

**W A Duneesha Nethmi**  
**Student ID: 22UG3-0580**
