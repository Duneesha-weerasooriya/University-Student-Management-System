import java.util.*;

/*
 * University Student Management System
 *
 * Data structures used:
 * 1. Singly Linked List  - stores student records
 * 2. Stack               - stores recent actions / history
 * 3. Queue               - stores student service requests
 * 4. Binary Search Tree  - organizes students by Student ID
 * 5. Hash Table          - provides fast Student ID searching
 * 6. Graph (Adjacency List) - represents campus locations and roads
 */

class Student {
    private String studentId;
    private String name;
    private String programme;
    private double marks;

    public Student(String studentId, String name, String programme, double marks) {
        this.studentId = studentId;
        this.name = name;
        this.programme = programme;
        this.marks = marks;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getName() {
        return name;
    }

    public String getProgramme() {
        return programme;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProgramme(String programme) {
        this.programme = programme;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public Student copy() {
        return new Student(studentId, name, programme, marks);
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Name: " + name
                + ", Programme: " + programme
                + ", Marks: " + String.format("%.2f", marks);
    }
}

/* =========================================================
   LINKED LIST - Student Records
   ========================================================= */

class StudentNode {
    Student student;
    StudentNode next;

    public StudentNode(Student student) {
        this.student = student;
        this.next = null;
    }
}

class StudentLinkedList {
    private StudentNode head;

    public boolean contains(String studentId) {
        return find(studentId) != null;
    }

    public Student find(String studentId) {
        StudentNode current = head;

        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {
                return current.student;
            }
            current = current.next;
        }

        return null;
    }

    public boolean add(Student student) {
        if (contains(student.getStudentId())) {
            return false;
        }

        StudentNode newNode = new StudentNode(student);

        if (head == null) {
            head = newNode;
        } else {
            StudentNode current = head;

            while (current.next != null) {
                current = current.next;
            }

            current.next = newNode;
        }

        return true;
    }

    public Student delete(String studentId) {
        StudentNode current = head;
        StudentNode previous = null;

        while (current != null) {
            if (current.student.getStudentId().equalsIgnoreCase(studentId)) {

                if (previous == null) {
                    head = current.next;
                } else {
                    previous.next = current.next;
                }

                return current.student;
            }

            previous = current;
            current = current.next;
        }

        return null;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void display() {
        System.out.println("\n=== Student Records - Linked List ===");

        if (head == null) {
            System.out.println("No student records available.");
            return;
        }

        StudentNode current = head;
        int count = 1;

        while (current != null) {
            System.out.println(count + ". " + current.student);
            current = current.next;
            count++;
        }
    }
}