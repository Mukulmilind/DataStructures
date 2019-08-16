import java.util.LinkedList;
import java.util.ListIterator;

class LinkedStack {
    private LinkedList<Integer> stack;

    public LinkedStack() {
        stack = new LinkedList<Integer>();
    }

    public void push(Integer data) {
        stack.push(data);
    }
    public Integer pop() {
        return stack.pop();
    }

    public Integer peek() {
        return stack.peek();
    }

    public boolean isEmpty() {
        return stack.isEmpty();
    }

    public void printStack() {
        ListIterator<Integer> iter = stack.listIterator();
        while(iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}

public class StackLinkedList {
    public static void main(String [] args) {
        LinkedStack stack = new LinkedStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);

        stack.printStack();

        System.out.println("Popped element is : " + stack.pop());

        stack.printStack();
    }
}