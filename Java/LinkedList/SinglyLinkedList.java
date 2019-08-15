package linkedlist;

class Node {
    private int data;
    private Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

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

    // @Override
    // public String toString() {
    //     return "Node [data=" + data + "]";
    // }
    
}
class LinkedList {
    private Node head;
    private int size;

    public boolean isEmpty() {
        return head == null;
    }
    public int getSize() {
        return size;
    }

    public void addToFront(int data) {
        Node node = new Node(data);
        node.setNext(head);
        head = node;
        size++;
    }
    public Node removeFromFront() {
        if (isEmpty()) return null;
        size--;
        Node removedNode = head;
        head = head.getNext();
        removedNode.setNext(null);
        return removedNode;
    }
    public void printList() {
        Node current = head;
        System.out.print("HEAD -> ");
        while (current != null) {
            System.out.print(current.getData());
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println(" null ");
    }
}

public class SinglyLinkedList {
    public static void main(String [] args) {
        LinkedList newList = new LinkedList();
        newList.addToFront(1);
        newList.addToFront(2);
        newList.addToFront(3);
        newList.addToFront(4);

        newList.printList();
        System.out.println("Current Size of list is: " + newList.getSize());

        System.out.println("Removed the element from the front: " + newList.removeFromFront().getData());

        newList.printList();
        System.out.println("Current Size of list is: " + newList.getSize());

    }
}