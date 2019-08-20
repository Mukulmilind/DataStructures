/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * 
 * - Java Program to implement heaps, Heap is a complete binary tree { every level, except posible the last is completely 
 *                                                                   filled, and all nodes are as far left as possible}. 
 * - Max Heap: Every parent is greater than or equal to its children
 * - Min Heap: Evey parent is less than or equal to its children.
 * - Heaps can be stored in array and is traversed in this order: parent -> child [next level] from left to right.
 * - left child: 2i + 1
 * - right child: 2i + 2
 * 
 * - parent = floor((i-1)/2)
 * - Inserting in a heap, add element to the end and then fix its position [heapify]
 *  - Compare the value against its parent and if its less than its parent - swap them.
 *  - Repeat this process till we get right place.
 * 
 * - Runtime for inserting is O(n.logn) and for deleting its O(n) but heapifying is O(logn) hence O(n.logn) again.
 * - Finding the root is constant time O(1).
 */

// Max heap Implementation
class Heap {
    private int [] heap;
    private int size;
    
    // Contructor for initializing heap with user provided capacity
    public Heap(int capacity) {
        heap = new int[capacity];
    }

    // Check if heap is full
    public boolean isFull() {
        return size == heap.length;
    }

    // Check if tree is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Return the parent index of the node at index passed: parent = floor((i-1)/2)
    public int getParent(int index) {
        return (index -1)/2;
    }

    // Return the child node index for the parent node index
    public int getChild(int index, boolean left) {
        return 2 * index + (left ? 1 : 2);
    }

    // Insert the value in the heap
    public void insert(int value) {
        if(isFull()) {
            throw new IndexOutOfBoundsException("Heap is full");
        } 
        heap[size] = value;
        
        // Heapifying the value now
        fixHeapAbove(size);
        size++;
    }

    // Deleting a node from the tree, the replacement value is always the right-most leaf node.
    // After putting the replacement value at position of deleted node we need to heapify the tree up or down.
    public int delete(int index) {
        if(isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is empty!");
        }
        int parent = getParent(index);
        int deletedValue = heap[index];

        heap[index] = heap[size -1];

        if(index == 0 || heap[index] < heap[parent]) {
            fixHeapBelow(index, size - 1);
        } else {
            fixHeapAbove(index);
        }
        
        // Decremented the size as we have deleted one node.
        size--;

        return deletedValue;
    }
    
    // Heapifying implementation
    private void fixHeapAbove(int index) {
        int newValue = heap[index];

        // Here we are just find the right position to insert the new value, meanwhile moving the parents 
        // down if its value is less than new value
        while (index > 0 && newValue > heap[getParent(index)]) {
            heap[index] = heap[getParent(index)];
            index = getParent(index);
        }

        // Once we have found the correct position, we assign the new value to the index
        heap[index] = newValue;
    }

    private void fixHeapBelow(int index, int lastHeapIndex) {
        int childToSwap;
        while (index <= lastHeapIndex) {
            int leftChild = getChild(index, true);      // returns left child index
            int rightChild = getChild(index, false);    // returns right child index

            if (leftChild <= lastHeapIndex) {       // this means this node has a left child
                if (rightChild > lastHeapIndex) {   // this means there is no right child
                    childToSwap = leftChild;
                } else {                            // otherwise there is a right child present
                    childToSwap = (heap[leftChild] > heap[rightChild] ? leftChild : rightChild);
                }

                if(heap[index] < heap[childToSwap]) {
                    // Swap the vlaues.
                    int tmp = heap[index];
                    heap[index] = heap[childToSwap];
                    heap[childToSwap] = tmp;
                } else {
                    break;
                }
                index = childToSwap;
            } else {
                break;
            }
        }
    }

    // Print the heap in order: parent -> child [next level] from left to right
    public void printHeap() {
        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }
        System.out.println(" ");
    }

    // Peek method always returns the root of the heap if its not empty
    public int peek() {
        if (isEmpty()) {
            throw new IndexOutOfBoundsException("Heap is Empty!");
        } else {
            return heap[0];
        }
    }
}

 public class Heaps {
     public static void main(String [] args) {
        Heap heap = new Heap(10);

        heap.insert(80);
        heap.insert(75);
        heap.insert(60);
        heap.insert(68);
        heap.insert(55);
        heap.insert(40);
        heap.insert(52);
        heap.insert(67);

        heap.printHeap();

        heap.delete(5);

        heap.printHeap();
        System.out.println("Peeking on the top of the peak: " + heap.peek()); 

        heap.delete(0);

        heap.printHeap();
        System.out.println("Peeking on the top of the peak: " + heap.peek());         
     }
 }