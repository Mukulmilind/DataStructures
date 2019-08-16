import java.util.NoSuchElementException;

/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com] 
 * Queue is FIFO - First in First out. It is similar to a usual {@link ArrayQueue} Java
 * program to implement queue using array.
 */
class ArrayQueue {
    private int [] queue;
    private int front;
    private int back;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        back = 0;
    }

    public void enqueue(int newItem) {
        if (back == queue.length) {
            int [] newQueue = new int[2 * queue.length];
            System.arraycopy(queue, 0, newQueue, 0, queue.length);
            queue = newQueue;
        }
        // Back always points to next available position.
        queue[back] = newItem;
        back++;
    }

    public int dequeue() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        int removedItem = queue[front];
        front++;
        if (size() == 0){
            front = 0;
            back = 0;
        }
        return removedItem;    
    }

    public int peek() {
        if (size() == 0) {
            throw new NoSuchElementException();
        }
        return queue[front];
    }

    public int size() {
        return back - front;
    }

    public void printQueue() {
        for (int i = front; i < back; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println("");
    }
}
public class QueueArray{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(10);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);
        queue.enqueue(50);

        queue.printQueue();

        queue.dequeue();

        queue.printQueue();

        System.out.println(queue.peek());
    }
}