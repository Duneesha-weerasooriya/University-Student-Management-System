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