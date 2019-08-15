class Node {
    private int data;
    private Node next;
    private Node previous;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
        this.previous = null;
    }

    // Getter and Setter
    public int getData() {
        return data;
    }
    public void setData(int data) {
        this.data = data;
    }
    public Node getNext() {
        return next;
    }
    public void setNext(Node next) {
        this.next = next;
    }
    public Node getPrevious() {
        return previous;
    }
    public void setPrevious(Node previous) {
        this.previous = previous;
    }
}
class LinkedList {
    private Node head;
    private Node tail;
    private int size;

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return head == null;
    }

    public void addFront(int data) {
        Node node = new Node(data);
        node.setNext(head);

        if (head == null) {
            tail = node;
        }else {
            head.setPrevious(node);
        }
        head = node;
        size++;
    }
    public void addRear(int data) {
        Node node = new Node(data);
        node.setPrevious(tail);

        if (tail == null) {
            head = node;
        } else {
            tail.setNext(node);
        }
        tail = node;
        size++;
    }

    public Node removeFront() {
        if (isEmpty()) return null;

        Node removedNode = head;

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

    public Node removeRear() {
        if (isEmpty()) return null;

        Node removeNode = tail;
        if (tail.getPrevious() == null) {
            head = null;
        } else {
            tail = tail.getPrevious();
            tail.setNext(null);
        }
        removeNode.setPrevious(null);
        size--;
        return removeNode;
    }

    public void printList() {
        Node current = head;
        System.out.print("HEAD <-> ");
        while (current != null) {
            System.out.print(current.getData());
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }

}
public class DoublyLinkedList {
    public static void main(String [] args) {
        LinkedList newList = new LinkedList();

        newList.addFront(1);
        newList.addFront(2);
        newList.addRear(3);
        newList.addRear(4);

        newList.printList();
        System.out.println("Current Size of list is: " + newList.getSize());

        System.out.println("Removed the element from the front: " + newList.removeFront().getData());

        newList.printList();
        System.out.println("Current Size of list is: " + newList.getSize());

        System.out.println("Removed the element from the rear: " + newList.removeRear().getData());

        newList.printList();
        System.out.println("Current Size of list is: " + newList.getSize());


    }
}