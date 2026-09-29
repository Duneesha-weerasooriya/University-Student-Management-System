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

/* =========================================================
   STACK - Recent Actions / History
   ========================================================= */

class ActionStack {
    private Stack<String> stack;

    public ActionStack() {
        stack = new Stack<>();
    }

    public void push(String action) {
        stack.push(action);
    }

    public String pop() {
        if (stack.isEmpty()) {
            return null;
        }

        return stack.pop();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void display() {
        System.out.println("\n=== Recent Actions - Stack (LIFO) ===");

        if (stack.isEmpty()) {
            System.out.println("No recent actions.");
            return;
        }

        for (int i = stack.size() - 1, position = 1; i >= 0; i--, position++) {
            System.out.println(position + ". " + stack.get(i));
        }
    }
}

/* =========================================================
   QUEUE - Student Service Requests
   ========================================================= */

class ServiceRequest {
    private String studentId;
    private String request;
    private String requestTime;

    public ServiceRequest(String studentId, String request) {
        this.studentId = studentId;
        this.request = request;
        this.requestTime = new Date().toString();
    }

    public String getStudentId() {
        return studentId;
    }

    @Override
    public String toString() {
        return "Student ID: " + studentId
                + ", Request: " + request
                + ", Time: " + requestTime;
    }
}

class ServiceRequestQueue {
    private Queue<ServiceRequest> queue;

    public ServiceRequestQueue() {
        queue = new LinkedList<>();
    }

    public void enqueue(ServiceRequest request) {
        queue.offer(request);
    }

    public ServiceRequest dequeue() {
        return queue.poll();
    }

    public boolean isEmpty() {
        return queue.isEmpty();
    }

    public void display() {
        System.out.println("\n=== Student Service Requests - Queue (FIFO) ===");

        if (queue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        int position = 1;

        for (ServiceRequest request : queue) {
            System.out.println(position + ". " + request);
            position++;
        }
    }
}

/* =========================================================
   BST - Student Records by Student ID
   ========================================================= */

class StudentBSTNode {
    Student student;
    StudentBSTNode left;
    StudentBSTNode right;

    public StudentBSTNode(Student student) {
        this.student = student;
    }
}

class StudentBST {
    private StudentBSTNode root;

    public boolean insert(Student student) {
        if (search(student.getStudentId()) != null) {
            return false;
        }

        root = insertRecursive(root, student);
        return true;
    }

    private StudentBSTNode insertRecursive(StudentBSTNode node, Student student) {
        if (node == null) {
            return new StudentBSTNode(student);
        }

        int comparison = student.getStudentId()
                .compareToIgnoreCase(node.student.getStudentId());

        if (comparison < 0) {
            node.left = insertRecursive(node.left, student);
        } else if (comparison > 0) {
            node.right = insertRecursive(node.right, student);
        }

        return node;
    }

    public Student search(String studentId) {
        return searchRecursive(root, studentId);
    }

    private Student searchRecursive(StudentBSTNode node, String studentId) {
        if (node == null) {
            return null;
        }

        int comparison = studentId.compareToIgnoreCase(node.student.getStudentId());

        if (comparison == 0) {
            return node.student;
        }

        if (comparison < 0) {
            return searchRecursive(node.left, studentId);
        }

        return searchRecursive(node.right, studentId);
    }

    public boolean delete(String studentId) {
        if (search(studentId) == null) {
            return false;
        }

        root = deleteRecursive(root, studentId);
        return true;
    }

    private StudentBSTNode deleteRecursive(StudentBSTNode node, String studentId) {
        if (node == null) {
            return null;
        }

        int comparison = studentId.compareToIgnoreCase(node.student.getStudentId());

        if (comparison < 0) {
            node.left = deleteRecursive(node.left, studentId);
        } else if (comparison > 0) {
            node.right = deleteRecursive(node.right, studentId);
        } else {
            if (node.left == null) {
                return node.right;
            }

            if (node.right == null) {
                return node.left;
            }

            StudentBSTNode successor = findMinimum(node.right);
            node.student = successor.student;
            node.right = deleteRecursive(
                    node.right,
                    successor.student.getStudentId()
            );
        }

        return node;
    }

    private StudentBSTNode findMinimum(StudentBSTNode node) {
        StudentBSTNode current = node;

        while (current.left != null) {
            current = current.left;
        }

        return current;
    }

    public void display() {
        System.out.println("\n=== Students Using BST (Sorted by Student ID) ===");

        if (root == null) {
            System.out.println("No students in BST.");
            return;
        }

        inorder(root);
    }

    private void inorder(StudentBSTNode node) {
        if (node != null) {
            inorder(node.left);
            System.out.println(node.student);
            inorder(node.right);
        }
    }
}

/* =========================================================
   HASH TABLE - Efficient Student ID Searching
   ========================================================= */

class StudentHashTable {
    private static final int TABLE_SIZE = 101;
    private Student[] table;

    public StudentHashTable() {
        table = new Student[TABLE_SIZE];
    }

    private int hash(String studentId) {
        int hashValue = Math.abs(studentId.toUpperCase().hashCode());
        return hashValue % TABLE_SIZE;
    }

    public boolean insert(Student student) {
        int index = hash(student.getStudentId());
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].getStudentId().equalsIgnoreCase(student.getStudentId())) {
                return false;
            }

            index = (index + 1) % TABLE_SIZE;

            if (index == startIndex) {
                return false;
            }
        }

        table[index] = student;
        return true;
    }

    public Student search(String studentId) {
        int index = hash(studentId);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].getStudentId().equalsIgnoreCase(studentId)) {
                return table[index];
            }

            index = (index + 1) % TABLE_SIZE;

            if (index == startIndex) {
                break;
            }
        }

        return null;
    }

    public boolean delete(String studentId) {
        int index = hash(studentId);
        int startIndex = index;

        while (table[index] != null) {
            if (table[index].getStudentId().equalsIgnoreCase(studentId)) {
                table[index] = null;
                rehashCluster(index);
                return true;
            }

            index = (index + 1) % TABLE_SIZE;

            if (index == startIndex) {
                break;
            }
        }

        return false;
    }

    private void rehashCluster(int deletedIndex) {
        int index = (deletedIndex + 1) % TABLE_SIZE;

        while (table[index] != null) {
            Student student = table[index];
            table[index] = null;
            insert(student);
            index = (index + 1) % TABLE_SIZE;
        }
    }
}

/* =========================================================
   GRAPH - Campus Locations and Connections
   Adjacency List + BFS
   ========================================================= */

class CampusGraph {
    private Map<String, List<String>> adjacencyList;

    public CampusGraph() {
        adjacencyList = new LinkedHashMap<>();
    }

    private String normalize(String location) {
        return location.trim();
    }

    public boolean addLocation(String location) {
        location = normalize(location);

        if (location.isEmpty() || adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.put(location, new ArrayList<>());
        return true;
    }

    public boolean removeLocation(String location) {
        location = normalize(location);

        if (!adjacencyList.containsKey(location)) {
            return false;
        }

        adjacencyList.remove(location);

        for (List<String> neighbours : adjacencyList.values()) {
            neighbours.remove(location);
        }

        return true;
    }

    public boolean addConnection(String location1, String location2) {
        location1 = normalize(location1);
        location2 = normalize(location2);

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        if (location1.equalsIgnoreCase(location2)) {
            return false;
        }

        if (containsIgnoreCase(adjacencyList.get(location1), location2)) {
            return false;
        }

        adjacencyList.get(location1).add(location2);
        adjacencyList.get(location2).add(location1);

        return true;
    }

    public boolean removeConnection(String location1, String location2) {
        location1 = normalize(location1);
        location2 = normalize(location2);

        if (!adjacencyList.containsKey(location1)
                || !adjacencyList.containsKey(location2)) {
            return false;
        }

        boolean removed1 = removeIgnoreCase(adjacencyList.get(location1), location2);
        boolean removed2 = removeIgnoreCase(adjacencyList.get(location2), location1);

        return removed1 && removed2;
    }

    private boolean containsIgnoreCase(List<String> list, String value) {
        for (String item : list) {
            if (item.equalsIgnoreCase(value)) {
                return true;
            }
        }

        return false;
    }

    private boolean removeIgnoreCase(List<String> list, String value) {
        Iterator<String> iterator = list.iterator();

        while (iterator.hasNext()) {
            if (iterator.next().equalsIgnoreCase(value)) {
                iterator.remove();
                return true;
            }
        }

        return false;
    }

    public void displayConnections() {
        System.out.println("\n=== Campus Network - Adjacency List ===");

        if (adjacencyList.isEmpty()) {
            System.out.println("No campus locations available.");
            return;
        }

        for (Map.Entry<String, List<String>> entry : adjacencyList.entrySet()) {
            System.out.print(entry.getKey() + " -> ");

            if (entry.getValue().isEmpty()) {
                System.out.println("No direct connections");
            } else {
                System.out.println(String.join(", ", entry.getValue()));
            }
        }
    }

    public void displayNeighbours(String location) {
        location = normalize(location);

        String actualLocation = findLocation(location);

        if (actualLocation == null) {
            System.out.println("Campus location not found: " + location);
            return;
        }

        List<String> neighbours = adjacencyList.get(actualLocation);

        System.out.println("\n=== Connected Locations for " + actualLocation + " ===");

        if (neighbours.isEmpty()) {
            System.out.println("No direct connections.");
            return;
        }

        for (String neighbour : neighbours) {
            System.out.println("- " + neighbour);
        }
    }

    public void bfs(String startLocation) {
        startLocation = normalize(startLocation);
        String actualStart = findLocation(startLocation);

        if (actualStart == null) {
            System.out.println("Campus location not found: " + startLocation);
            return;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new LinkedHashSet<>();

        queue.offer(actualStart);
        visited.add(actualStart);

        System.out.println("\n=== BFS Campus Traversal ===");

        while (!queue.isEmpty()) {
            String current = queue.poll();
            System.out.println("Visited: " + current);

            for (String neighbour : adjacencyList.get(current)) {
                if (!visited.contains(neighbour)) {
                    visited.add(neighbour);
                    queue.offer(neighbour);
                }
            }
        }
    }

    private String findLocation(String location) {
        for (String key : adjacencyList.keySet()) {
            if (key.equalsIgnoreCase(location)) {
                return key;
            }
        }

        return null;
    }

    public boolean isEmpty() {
        return adjacencyList.isEmpty();
    }
}

/* =========================================================
   MAIN UNIVERSITY MANAGEMENT SYSTEM
   ========================================================= */

public class UniversityStudentManagementSystem {

    private StudentLinkedList studentList;
    private ActionStack actionStack;
    private ServiceRequestQueue serviceQueue;
    private StudentBST studentBST;
    private StudentHashTable studentHashTable;
    private CampusGraph campusGraph;
    private Scanner scanner;

    public UniversityStudentManagementSystem() {
        studentList = new StudentLinkedList();
        actionStack = new ActionStack();
        serviceQueue = new ServiceRequestQueue();
        studentBST = new StudentBST();
        studentHashTable = new StudentHashTable();
        campusGraph = new CampusGraph();
        scanner = new Scanner(System.in);

        initializeSampleData();
        initializeCampusData();
    }

    private void initializeSampleData() {
        addStudentSilently(
                new Student("S001", "Ashen Shanuka", "Applied IT", 78.50)
        );

        addStudentSilently(
                new Student("S002", "Nimal Perera", "Computer Science", 82.00)
        );

        addStudentSilently(
                new Student("S003", "Kamal Silva", "Cyber Security", 74.50)
        );
    }

    private void addStudentSilently(Student student) {
        studentList.add(student);
        studentBST.insert(student);
        studentHashTable.insert(student);
    }

    private void initializeCampusData() {
        campusGraph.addLocation("Main Gate");
        campusGraph.addLocation("Administration Building");
        campusGraph.addLocation("Faculty of Computing");
        campusGraph.addLocation("Library");
        campusGraph.addLocation("Student Center");
        campusGraph.addLocation("ICT Laboratory");

        campusGraph.addConnection("Main Gate", "Administration Building");
        campusGraph.addConnection("Administration Building", "Faculty of Computing");
        campusGraph.addConnection("Administration Building", "Library");
        campusGraph.addConnection("Faculty of Computing", "ICT Laboratory");
        campusGraph.addConnection("Faculty of Computing", "Student Center");
        campusGraph.addConnection("Library", "Student Center");
    }

    /* ================= MENU ================= */

    public void displayMenu() {
        System.out.println("\n======================================================");
        System.out.println("       UNIVERSITY STUDENT MANAGEMENT SYSTEM");
        System.out.println("======================================================");
        System.out.println("1.  Add Student Record");
        System.out.println("2.  Update Student Record");
        System.out.println("3.  Delete Student Record");
        System.out.println("4.  Display All Records using Linked List");
        System.out.println("5.  Add Service Request to Queue");
        System.out.println("6.  Process Next Service Request");
        System.out.println("7.  Display Pending Service Requests");
        System.out.println("8.  Display Recent Actions using Stack");
        System.out.println("9.  Display Students using BST");
        System.out.println("10. Search Student using Hashing");
        System.out.println("11. Add Campus Location");
        System.out.println("12. Remove Campus Location");
        System.out.println("13. Add Campus Connection/Road");
        System.out.println("14. Remove Campus Connection/Road");
        System.out.println("15. Display Campus Connections");
        System.out.println("16. Display Connected Locations");
        System.out.println("17. Traverse Campus using BFS");
        System.out.println("0.  Exit");
        System.out.println("======================================================");
    }

    public void run() {
        System.out.println("\nWelcome to the University Student Management System!");

        while (true) {
            displayMenu();

            int choice = readInt("Enter your choice: ", 0, 17);

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    updateStudent();
                    break;
                case 3:
                    deleteStudent();
                    break;
                case 4:
                    studentList.display();
                    break;
                case 5:
                    addServiceRequest();
                    break;
                case 6:
                    processServiceRequest();
                    break;
                case 7:
                    serviceQueue.display();
                    break;
                case 8:
                    actionStack.display();
                    break;
                case 9:
                    studentBST.display();
                    break;
                case 10:
                    searchStudentUsingHashing();
                    break;
                case 11:
                    addCampusLocation();
                    break;
                case 12:
                    removeCampusLocation();
                    break;
                case 13:
                    addCampusConnection();
                    break;
                case 14:
                    removeCampusConnection();
                    break;
                case 15:
                    campusGraph.displayConnections();
                    break;
                case 16:
                    displayConnectedLocations();
                    break;
                case 17:
                    traverseCampusBFS();
                    break;
                case 0:
                    System.out.println("\nThank you for using the University Student Management System.");
                    scanner.close();
                    return;
            }
        }
    }

    /* ================= STUDENT OPERATIONS ================= */

    private void addStudent() {
        System.out.println("\n=== Add Student Record ===");

        String id = readNonEmpty("Enter Student ID: ");

        if (studentList.contains(id)) {
            System.out.println("Duplicate Student ID. Student already exists.");
            return;
        }

        String name = readNonEmpty("Enter Student Name: ");
        String programme = readNonEmpty("Enter Programme: ");
        double marks = readMarks();

        Student student = new Student(id, name, programme, marks);

        studentList.add(student);
        studentBST.insert(student);
        studentHashTable.insert(student);

        actionStack.push("Added student: " + id + " - " + name);

        System.out.println("Student added successfully.");
    }

    private void updateStudent() {
        System.out.println("\n=== Update Student Record ===");

        String id = readNonEmpty("Enter Student ID to update: ");
        Student student = studentList.find(id);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        String oldDetails = student.toString();

        String name = readNonEmpty("Enter new Name: ");
        String programme = readNonEmpty("Enter new Programme: ");
        double marks = readMarks();

        student.setName(name);
        student.setProgramme(programme);
        student.setMarks(marks);

        actionStack.push("Updated student " + id
                + ". Previous record: " + oldDetails);

        System.out.println("Student record updated successfully.");
    }

    private void deleteStudent() {
        System.out.println("\n=== Delete Student Record ===");

        String id = readNonEmpty("Enter Student ID to delete: ");
        Student student = studentList.find(id);

        if (student == null) {
            System.out.println("Student record not found.");
            return;
        }

        Student deletedStudent = studentList.delete(id);

        studentBST.delete(id);
        studentHashTable.delete(id);

        actionStack.push("Deleted student: " + deletedStudent);

        System.out.println("Student record deleted successfully.");
    }

    private void searchStudentUsingHashing() {
        System.out.println("\n=== Search Student Using Hashing ===");

        String id = readNonEmpty("Enter Student ID: ");
        Student student = studentHashTable.search(id);

        if (student != null) {
            System.out.println("Student found using hash table:");
            System.out.println(student);
        } else {
            System.out.println("Student not found with ID: " + id);
        }
    }

    /* ================= QUEUE OPERATIONS ================= */

    private void addServiceRequest() {
        System.out.println("\n=== Add Student Service Request ===");

        String studentId = readNonEmpty("Enter Student ID: ");

        if (studentList.find(studentId) == null) {
            System.out.println("Student record not found. Service request cannot be added.");
            return;
        }

        String request = readNonEmpty("Enter Service Request: ");

        ServiceRequest serviceRequest =
                new ServiceRequest(studentId, request);

        serviceQueue.enqueue(serviceRequest);

        actionStack.push("Added service request for student: " + studentId);

        System.out.println("Service request added to the queue successfully.");
    }

    private void processServiceRequest() {
        System.out.println("\n=== Process Next Service Request ===");

        if (serviceQueue.isEmpty()) {
            System.out.println("No pending service requests.");
            return;
        }

        ServiceRequest request = serviceQueue.dequeue();

        System.out.println("Processing request:");
        System.out.println(request);

        actionStack.push("Processed service request for student: "
                + request.getStudentId());
    }
  /* ================= GRAPH OPERATIONS ================= */

    private void addCampusLocation() {
        System.out.println("\n=== Add Campus Location ===");

        String location = readNonEmpty("Enter new campus location: ");

        if (campusGraph.addLocation(location)) {
            actionStack.push("Added campus location: " + location);
            System.out.println("Campus location added successfully.");
        } else {
            System.out.println(
                    "Location could not be added. It may already exist."
            );
        }
    }

    private void removeCampusLocation() {
        System.out.println("\n=== Remove Campus Location ===");

        String location = readNonEmpty("Enter campus location to remove: ");

        if (campusGraph.removeLocation(location)) {
            actionStack.push("Removed campus location: " + location);
            System.out.println("Campus location removed successfully.");
        } else {
            System.out.println("Campus location not found.");
        }
    }

    private void addCampusConnection() {
        System.out.println("\n=== Add Campus Connection/Road ===");

        String location1 = readNonEmpty("Enter first location: ");
        String location2 = readNonEmpty("Enter second location: ");

        if (campusGraph.addConnection(location1, location2)) {
            actionStack.push("Added campus connection: "
                    + location1 + " <-> " + location2);

            System.out.println("Campus connection added successfully.");
        } else {
            System.out.println(
                    "Connection could not be added. Check that both locations "
                    + "exist and that the connection is not already present."
            );
        }
    }

    private void removeCampusConnection() {
        System.out.println("\n=== Remove Campus Connection/Road ===");

        String location1 = readNonEmpty("Enter first location: ");
        String location2 = readNonEmpty("Enter second location: ");

        if (campusGraph.removeConnection(location1, location2)) {
            actionStack.push("Removed campus connection: "
                    + location1 + " <-> " + location2);

            System.out.println("Campus connection removed successfully.");
        } else {
            System.out.println(
                    "Connection not found or one of the locations does not exist."
            );
        }
    }

    private void displayConnectedLocations() {
        System.out.println("\n=== Display Connected Locations ===");

        String location = readNonEmpty("Enter campus location: ");
        campusGraph.displayNeighbours(location);
    }

    private void traverseCampusBFS() {
        System.out.println("\n=== BFS Campus Traversal ===");

        String startLocation = readNonEmpty(
                "Enter starting campus location: "
        );

        campusGraph.bfs(startLocation);

        actionStack.push("Performed BFS traversal from: " + startLocation);
    }

    /* ================= INPUT VALIDATION ================= */

    private String readNonEmpty(String message) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            if (!input.isEmpty()) {
                return input;
            }

            System.out.println("Input cannot be empty. Please try again.");
        }
    }

    private int readInt(String message, int minimum, int maximum) {
        while (true) {
            System.out.print(message);
            String input = scanner.nextLine().trim();

            try {
                int value = Integer.parseInt(input);

                if (value >= minimum && value <= maximum) {
                    return value;
                }

                System.out.println(
                        "Please enter a number between "
                        + minimum + " and " + maximum + "."
                );

            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }
    }

    private double readMarks() {
        while (true) {
            System.out.print("Enter Marks (0 - 100): ");
            String input = scanner.nextLine().trim();

            try {
                double marks = Double.parseDouble(input);

                if (marks >= 0 && marks <= 100) {
                    return marks;
                }

                System.out.println("Marks must be between 0 and 100.");

            } catch (NumberFormatException e) {
                System.out.println(
                        "Invalid marks. Please enter a numeric value."
                );
            }
        }
    }

    /* ================= MAIN ================= */

    public static void main(String[] args) {
        UniversityStudentManagementSystem system =
                new UniversityStudentManagementSystem();

        system.run();
    }
}
