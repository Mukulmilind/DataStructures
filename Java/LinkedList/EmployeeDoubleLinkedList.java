/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Java Program to implement double linked list
 * 
 */

import lists.Employee;
import lists.EmployeeNodeDoubly;

class DoublyLinkedList {
    private EmployeeNodeDoubly head;
    private EmployeeNodeDoubly tail;
    private int size;

    // Add element to the begining of the list
    public void addToFront(Employee employee) {
        EmployeeNodeDoubly node = new EmployeeNodeDoubly(employee);
        node.setNext(head);

        // If the list is empty.
        if (head == null) {
            tail = node;
        } else {
            head.setPrevious(node);
        }
        // The new node becomes the head node now.
        head = node;
        size++;
    }

    // Add element to the end of the list
    public void addToEnd(Employee employee) {
        EmployeeNodeDoubly node = new EmployeeNodeDoubly(employee);
        if (tail == null) {
            head = node;
        } else {
            node.setPrevious(tail);
            tail.setNext(node);
        }
        tail = node;
    }

    // Remove element from the begining of the list
    public EmployeeNodeDoubly removeFromFront() {
        if (isEmply()) return null;

        EmployeeNodeDoubly removedNode = head;

        if (head.getNext() == null) {
            tail = null;
        } else {
            head = head.getNext();
            head.setPrevious(null);
        }
        removedNode.setNext(null);
        size--;
        return removedNode;
    }

    // Remove element from the end of the list
    public EmployeeNodeDoubly removeFromEnd() {
        if(isEmply()) return null;

        EmployeeNodeDoubly removedNode = tail;

        if(tail.getPrevious() == null) {
            tail = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        removedNode.setPrevious(null);
        size--;
        return removedNode;
    }

    public int getSize() {
        return size;
    }
    public boolean isEmply() {
        return head == null;
    }
    public void printList() {
        EmployeeNodeDoubly current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println(" null");
    }
}
public class EmployeeDoubleLinkedList {
    public static void main (String [] args) {
        Employee mukul = new Employee("Mukul", "Mishra", 1);
        Employee pratibha = new Employee("Pratibha", "Mishra", 2);
        Employee aparna = new Employee("Aparna", "Mishra", 3);
        Employee uday = new Employee("Uday", "Mishra", 4);
        Employee poonam = new Employee("Poonam", "Mishra", 5);

        DoublyLinkedList empList = new DoublyLinkedList();
        
        System.out.println("Is the list empty: " + empList.isEmply());

        empList.addToFront(mukul);
        empList.addToFront(pratibha);
        empList.addToFront(aparna);
        empList.addToFront(uday);
        empList.addToEnd(poonam);

        System.out.println("Current Size of list is: " + empList.getSize());
        
        empList.printList();

        empList.removeFromFront();

        System.out.println("Current Size of list is: " + empList.getSize());

        empList.printList();

        empList.removeFromEnd();

        System.out.println("Current Size of list is: " + empList.getSize());

        empList.printList();
    }
}