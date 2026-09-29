# University Student Record and Campus Route Management System

## CIT300 – Data Structures and Algorithms

**Graded Practical Assignment 1 – Week 10**

Name - W.A. DUNEESHA NETHMI
Student ID - 22UG3-0580
---

## 1. Project Overview

The **University Student Record and Campus Route Management System** is a Java-based console application developed for managing university student records and representing connections between campus locations.

The system demonstrates the practical use of different data structures, including:

- Singly Linked List
- Stack
- Queue
- Binary Search Tree (BST)
- Hash Table
- Graph using Adjacency List
- Breadth-First Search (BFS)

The application provides a menu-driven interface that allows users to manage student records, process student service requests, search students efficiently, and manage campus locations and connections.

---

## 2. Student Information

| Field | Details |
|---|---|
| Student Name | W. A. Duneesha Nethmi |
| Student ID | 22UG3-0580 |
| Project Type | Individual Project |
| Module | CIT300 – Data Structures and Algorithms |

---

## 3. Project Objective

The main objective of this project is to develop a Java console application that demonstrates the practical implementation of important data structures.

The system is designed to:

- Store and manage student records.
- Use a linked list for student records.
- Use a stack to maintain recent actions and history.
- Use a queue to manage student service requests.
- Use a Binary Search Tree to organize students by Student ID.
- Use hashing for efficient Student ID searching.
- Represent campus locations and roads using a graph.
- Use an adjacency list to represent the graph.
- Use BFS to traverse campus locations.
- Provide a menu-driven console interface.
- Validate user inputs and handle invalid operations.

---

## 4. Data Structures Used

### 4.1 Singly Linked List

The Singly Linked List is used to store and manage student records.

Each student is stored inside a `StudentNode`.

The linked list supports:

- Add student
- Find student
- Check whether a student exists
- Delete student
- Display all students

### 4.2 Stack

The Stack is used to store recent actions performed by the user.

Examples of stored actions include:

- Adding a student
- Updating a student
- Deleting a student
- Adding a service request
- Processing a service request
- Adding or removing campus locations
- Adding or removing campus connections
- Performing BFS traversal

The Stack follows the **LIFO (Last In, First Out)** principle.

### 4.3 Queue

The Queue is used to manage student service requests.

Service requests are processed according to their arrival order.

The Queue follows the **FIFO (First In, First Out)** principle.

The Queue supports:

- Enqueue
- Dequeue
- Check whether the queue is empty
- Display pending requests

### 4.4 Binary Search Tree

The Binary Search Tree (BST) is used to organize student records according to Student ID.

The BST supports:

- Insert student
- Search student
- Delete student
- Display students using in-order traversal

The in-order traversal displays students in sorted Student ID order.

### 4.5 Hash Table

The Hash Table is used for efficient Student ID searching.

The implementation uses:

- Table size of 101
- Hash function
- Linear probing for collision handling
- Search operation
- Insert operation
- Delete operation
- Cluster rehashing after deletion

### 4.6 Graph

The Graph represents the university campus.

In the graph:

- Campus locations are vertices.
- Roads or direct connections are edges.

The graph is implemented using an **Adjacency List**.

The graph supports:

- Add campus location
- Remove campus location
- Add campus connection
- Remove campus connection
- Display campus connections
- Display connected locations
- BFS traversal

### 4.7 Breadth-First Search (BFS)

BFS is used to traverse the campus graph starting from a selected campus location.

A Queue is used during the BFS traversal to visit connected locations level by level.

---

## 5. System Features

The system provides the following main features:

### Student Management

- Add Student Record
- Update Student Record
- Delete Student Record
- Display All Student Records
- Search Student using Hashing
- Display Students using BST

### Student Service Requests

- Add a service request
- Process the next service request
- Display pending service requests

### Recent Actions

- Store recent actions using Stack
- Display recent actions in LIFO order

### Campus Management

- Add campus location
- Remove campus location
- Add campus connection/road
- Remove campus connection/road
- Display campus network
- Display connected locations
- Traverse campus using BFS

---

## 6. Student Record Details

Each student record contains the following information:

- Student ID
- Student Name
- Programme
- Marks

The `Student` class contains getter and setter methods to access and update student information.

The system also validates marks to ensure that they are between **0 and 100**.

---

## 7. Sample Student Data

The system initializes with the following sample student records:

| Student ID | Name | Programme | Marks |
|---|---|---|---:|
| S001 | Ashen Shanuka | Applied IT | 78.50 |
| S002 | Nimal Perera | Computer Science | 82.00 |
| S003 | Kamal Silva | Cyber Security | 74.50 |

---

## 8. Sample Campus Data

The system initializes with the following campus locations:

- Main Gate
- Administration Building
- Faculty of Computing
- Library
- Student Center
- ICT Laboratory

The initial campus connections include:

```text
Main Gate
    |
Administration Building
    |---------------- Faculty of Computing
    |                       |------------ ICT Laboratory
    |                       |
    |                       |------------ Student Center
    |
    |---------------- Library
                            |
                            |------------ Student Center
```

---

## 9. Main Menu

The application provides the following menu:

```text
======================================================
       UNIVERSITY STUDENT MANAGEMENT SYSTEM
======================================================
1.  Add Student Record
2.  Update Student Record
3.  Delete Student Record
4.  Display All Records using Linked List
5.  Add Service Request to Queue
6.  Process Next Service Request
7.  Display Pending Service Requests
8.  Display Recent Actions using Stack
9.  Display Students using BST
10. Search Student using Hashing
11. Add Campus Location
12. Remove Campus Location
13. Add Campus Connection/Road
14. Remove Campus Connection/Road
15. Display Campus Connections
16. Display Connected Locations
17. Traverse Campus using BFS
0.  Exit
======================================================
```

---

## 10. Input Validation

The system includes input validation to prevent invalid data and operations.

The application handles:

- Empty input
- Invalid menu choices
- Non-numeric menu input
- Invalid marks
- Marks outside the range 0–100
- Duplicate Student IDs
- Missing student records
- Missing campus locations
- Duplicate campus connections
- Invalid campus connections
- Empty service requests

For example, when entering marks, only values between 0 and 100 are accepted.

---

## 11. Classes Used in the Project

The main classes used in the system are:

### Student Classes

```text
Student
StudentNode
StudentLinkedList
```

### Stack

```text
ActionStack
```

### Queue

```text
ServiceRequest
ServiceRequestQueue
```

### Binary Search Tree

```text
StudentBSTNode
StudentBST
```

### Hash Table

```text
StudentHashTable
```

### Graph

```text
CampusGraph
```

### Main System

```text
UniversityStudentManagementSystem
```

---

## 12. Project Structure

The project is implemented as a Java console application.

The main Java file is:

```text
UniversityStudentManagementSystem.java
```

The application contains the required data structure classes and the main management system in the same Java source file.

---

## 13. How to Run the Project

### Step 1 – Install Java

Install the Java Development Kit (JDK) on the computer.

### Step 2 – Open the Project

Open the project using a Java-supported IDE such as:

- IntelliJ IDEA
- Eclipse
- NetBeans
- Visual Studio Code

### Step 3 – Compile the Program

Use:

```bash
javac UniversityStudentManagementSystem.java
```

### Step 4 – Run the Program

Use:

```bash
java UniversityStudentManagementSystem
```

### Step 5 – Use the Menu

After running the program, the main menu will be displayed.

Enter the required menu number and follow the instructions.

---

## 14. Example Operations

### Add Student

The user can enter:

```text
Student ID
Student Name
Programme
Marks
```

The student is then stored in:

- Linked List
- Binary Search Tree
- Hash Table

---

### Update Student

The user enters an existing Student ID and provides the new:

- Name
- Programme
- Marks

The student record is updated and the previous record is stored in the recent action history.

---

### Delete Student

The user enters the Student ID.

The student is removed from:

- Linked List
- BST
- Hash Table

The deletion is also recorded in the Stack.

---

### Service Request

A valid student can create a service request.

Requests are stored in the Queue and processed in FIFO order.

---

### Hash Search

The user can enter a Student ID to search for a student using the Hash Table.

---

### BST Display

The system displays students using an in-order traversal of the BST.

This displays the students according to Student ID order.

---

### Campus Graph

The user can:

- Add a location
- Remove a location
- Add a road
- Remove a road
- View campus connections
- View connected locations
- Perform BFS traversal

---

## 15. Individual Contribution

This project was completed individually.

### Developer

**Name:** W. A. Duneesha Nethmi  
**Student ID:** 22UG3-0580

### Individual Responsibilities

I was responsible for the complete development of the project, including:

- Designing the overall system
- Implementing the Student class
- Implementing the Singly Linked List
- Implementing the Stack
- Implementing the Queue
- Implementing the Binary Search Tree
- Implementing the Hash Table
- Implementing the Campus Graph
- Implementing the BFS traversal
- Implementing the main menu
- Implementing student management operations
- Implementing service request operations
- Implementing campus management operations
- Implementing input validation
- Integrating all data structures
- Debugging and improving the program
- Preparing project documentation
- Testing the system
- Managing the project repository and commits

---

## 16. Testing Scenarios

The following scenarios can be used to test the system:

### Student Testing

- Add a new student.
- Try to add a duplicate Student ID.
- Update an existing student.
- Try to update a non-existing student.
- Delete an existing student.
- Try to delete a non-existing student.
- Display all student records.
- Search for an existing Student ID using hashing.
- Search for a non-existing Student ID.

### Queue Testing

- Add a service request.
- Add multiple service requests.
- Display pending requests.
- Process the next request.
- Confirm that requests are processed in FIFO order.
- Try to process a request when the queue is empty.

### Stack Testing

- Perform several operations.
- Display recent actions.
- Confirm that the most recent action appears first.

### BST Testing

- Insert student records.
- Search for a student.
- Delete a student.
- Display students using in-order traversal.

### Hash Table Testing

- Insert student records.
- Search using Student ID.
- Delete a student.
- Search again after deletion.

### Graph Testing

- Add a campus location.
- Remove a campus location.
- Add a campus connection.
- Remove a campus connection.
- Display campus connections.
- Display connected locations.
- Perform BFS from a selected campus location.

### Input Validation Testing

- Enter an empty value.
- Enter an invalid menu value.
- Enter text instead of a number.
- Enter marks below 0.
- Enter marks above 100.
- Enter duplicate Student IDs.
- Enter unavailable campus locations.

---

## 17. Technologies Used

- **Programming Language:** Java
- **Application Type:** Console Application
- **Data Structures:** Linked List, Stack, Queue, BST, Hash Table, Graph
- **Graph Representation:** Adjacency List
- **Graph Traversal:** BFS
- **Version Control:** Git / GitHub

---

## 18. Learning Outcomes

Through this project, the following concepts were practically implemented:

- Linear data structures
- Linked list operations
- Stack operations
- Queue operations
- Tree operations
- Binary Search Tree searching and deletion
- Hashing and collision handling
- Graph representation
- Adjacency lists
- Breadth-First Search
- Input validation
- Object-oriented programming
- Integration of multiple data structures into one application

---

## 19. Conclusion

The University Student Record and Campus Route Management System demonstrates how different data structures can be combined to develop a practical Java console application.

The system manages student records using a Singly Linked List, maintains recent actions using a Stack, processes service requests using a Queue, organizes student records using a Binary Search Tree, provides Student ID searching using a Hash Table, and represents campus locations and connections using a Graph with an Adjacency List.

The system also provides BFS traversal, menu-driven operations, and input validation.

This project provides practical experience in implementing and integrating fundamental Data Structures and Algorithms concepts in Java.

---

## 20. Academic Information

**Module:** CIT300 – Data Structures and Algorithms  
**Assignment:** Graded Practical Assignment 1  
**Project:** University Student Record and Campus Route Management System  
**Student:** W. A. Duneesha Nethmi  
**Student ID:** 22UG3-0580  
**Project Type:** Individual Project
