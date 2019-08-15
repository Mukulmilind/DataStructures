import java.util.EmptyStackException;

/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * 
 *         Implementation of stacks using Array Stacks are also called as LIFO
 *         [Last in First out] Can be thought of as a pile of plates, the last
 *         plate on the top of the pile is the one which is picked first. Hence
 *         the first plate would be picked last. There is no random access
 *         allowed. Only top of stack is accessbile to operate.
 */

class ArrayStack {
    private int[] stack;
    private int top;

    public ArrayStack(int capacity){
        stack = new int[capacity];
    }

    public void push(int element) {
        if(top == stack.length) {
            // need to resize the backing array, this is O(n).
            int[] newStack = new int[2 * stack.length];
            System.arraycopy(stack, 0, stack, 0, stack.length);
            stack = newStack;
        }
        stack[top++] = element;
    }

    public int pop() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        int popedItem = stack[--top];
        return popedItem;
    }

    public int peek() {
        if(isEmpty()) {
            throw new EmptyStackException();
        }
        // We dont want to decrement top here as we are not poping anything.
        return stack[top -1];
    }
    public int size() {
        return top;
    }
    public void printStack() {
        for(int i = top - 1; i >= 0; i--) {
            System.out.print(stack[i] + " ");
        }
        System.out.println("");
    }
    public boolean isEmpty() {
        return top == 0;
    }
}
class StacksArray {
     public static void main(String [] args) {
        ArrayStack stack = new ArrayStack(5);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        stack.printStack();
     }
 }