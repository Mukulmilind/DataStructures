import lists.Employee;
import lists.EmployeeNode;

class SinglyLinkedList {
    private EmployeeNode head;
    private int size;

    public void addFront(Employee employee) {
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public EmployeeNode removeFrontNode() {
        if (isEmpty()) {
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        // Clean up all the references for better performance.
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
public class EmployeeLinkedList {
    public static void main(String [] args) {
        Employee mukul = new Employee("Mukul", "Mishra", 1);
        Employee pratibha = new Employee("Pratibha", "Mishra", 2);
        Employee aparna = new Employee("Aparna", "Mishra", 3);
        Employee uday = new Employee("Uday", "Mishra", 4);

        SinglyLinkedList empList = new SinglyLinkedList();

        System.out.println(empList.isEmpty());

        empList.addFront(mukul);
        empList.addFront(pratibha);
        empList.addFront(aparna);
        empList.addFront(uday);

        System.out.println("Current Size of Linked List is : " + empList.getSize());

        empList.removeFrontNode();

        System.out.println("Current Size of Linked List is : " + empList.getSize());

        empList.printList();
    }
}