import java.util.PriorityQueue;

/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com] Priority queue is an
 *         ADT which is implemented using max Heap. Implementation using JDK
 *         Priority Queue class [this uses min-heap]
 */

 public class PriorityQueueJDK {
    public static void main(String [] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        pq.add(25);
        pq.add(-22);
        pq.add(1343);
        pq.add(54);
        pq.add(0);
        pq.add(-3492);
        pq.add(429);
        
        System.out.println(pq.peek());

        System.out.println("Removing: " + pq.remove());
        System.out.println(pq.peek());

        // Poll and Remove does the same thing
        System.out.println("Removing: " + pq.poll());
        System.out.println(pq.peek());

        pq.add(-1);
        System.out.println(pq.peek());

        // Testing toArray Method
        System.out.println(" ");
        Object[] ints = pq.toArray();
        for (Object num : ints) {
            System.out.print(num + " ");
        }
        System.out.println(" ");
    }
 }