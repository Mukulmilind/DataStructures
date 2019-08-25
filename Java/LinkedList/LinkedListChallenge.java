/**
 * @author Mukul Milind Mishra
 * Linked List Challenge: Find the middle of the linked list using all approaches.
 */
class Node {
    private int data;
    private Node nextNode;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.nextNode = null;
    }

    // Getter and Setter
    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }
}

class LinkedList {
    private Node head;

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.setNextNode(null);
        } else {
            newNode.setNextNode(head);
            head = newNode;
        }
    }

    public void printList() {
        if (head == null) {
            return;
        }
        Node current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current.getData() + " -> ");
            current = current.getNextNode();
        }
        System.out.println(" null");
    }

    // O(n)
    public Node findMiddleNode() {  
        // Check if linked list is empty.
        if (head == null) {
            return head;
        }

        // Two pointers one would iterate one node at a time and the second one would jump two
        // nodes at a time.
        Node current = head;
        Node jumpingCurrent = head;

        // In case of odd number of nodes in the list
        while (jumpingCurrent.getNextNode() != null) {
            current = current.getNextNode();
            jumpingCurrent = jumpingCurrent.getNextNode();

            // If the number of nodes are even we need to return either n/2the element 
            // or the (n/2+1)th element.
            if (jumpingCurrent.getNextNode() != null) {
                jumpingCurrent = jumpingCurrent.getNextNode();
            } else {
                return current;
            }
        }
        return current;
    }

    // O(n): Reverse the linked list in place
    public void reverseLinkedList() {
        Node current = head;
        Node previous = null;
        Node next = null;

        // Next node would point to current's next node, current node would point to previous
        // node, and current node would point to next node. This process is repeated untill 
        // current reaches end of the linked list
        while (current != null) {
            next = current.getNextNode();
            current.setNextNode(previous);
            previous = current;
            current = next;
        }
        // Finally head would point to previous which is pointing to the last element if the 
        // linked list, which is the first element of the new reversed linked list.
        head = previous;
    }
}
public class LinkedListChallenge {
    public static void main (String [] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);
        list.insert(60);

        list.printList();
        System.out.println("The middle of the linked list is: " + list.findMiddleNode().getData());

        list.reverseLinkedList();
        list.printList();
    }
}