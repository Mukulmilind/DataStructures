import java.util.NoSuchElementException;

/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com] 
 * Queue is FIFO - First in First out. It is similar to a usual {@link ArrayQueue} 
 * Java program to implement circular queue using array in order to avoid the problem of increasing size in case of
 * multiple add and remove from the queue.
 */
class ArrayCircularQueue {
    private int [] queue;
    private int front;
    private int back;

    public ArrayCircularQueue(int capacity) {
        queue = new int[capacity];
        front = 0;
        back = 0;
    }

    public void enqueue(int newItem) {
        if (size() == queue.length) {
            int numItems = size();
            int [] newQueue = new int[2 * queue.length];
            System.arraycopy(queue, front, newQueue, 0, queue.length - front);
            System.arraycopy(queue, 0, newQueue, queue.length - front, back);
            queue = newQueue;

            front = 0;
            back = numItems;
        }
        // Back always points to next available position.
        queue[back] = newItem;
        if (back < queue.length -1) {
            back++;
        } else {
            back = 0;
        }
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
        } else if (front == queue.length) {
            front = 0;
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
        if(front <= back) {
            return back - front;
        } else {
            return back - front + queue.length;
        }
        
    }

    public void printQueue() {
        if (front <= back) {
            for (int i = front; i < back; i++) {
                System.out.print(queue[i] + " ");
            }
        } else {
            for(int i = front; i < queue.length; i++) {
                System.out.print(queue[i] + " ");                
            }
            for (int i = 0; i < back; i++) {
                System.out.print(queue[i] + " ");
            }
        }
        System.out.println("");
    }
}
public class CicularQueue{
    public static void main(String[] args) {
        ArrayQueue queue = new ArrayQueue(5);

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        queue.enqueue(40);

        queue.printQueue();

        queue.dequeue();

        queue.enqueue(50);
        queue.enqueue(60);
        queue.enqueue(70);
        queue.enqueue(80);

        queue.printQueue();

        queue.dequeue();

        queue.enqueue(90);

        queue.printQueue();

        System.out.println(queue.peek());
    }
}