package linkedlist;

/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Implementation of Linked list using standard JDK functions and then iterating over the elements 
 * using the Iterator, can be done using for-each loop as well.
 */
import java.util.Iterator;
import java.util.LinkedList;

class LinkedListJDK {
    public static void main(String [] args) {
        LinkedList<String> stringList = new LinkedList<>();
        stringList.addFirst("Mukul");
        stringList.addLast("Milind");
        stringList.addLast("Mishra");

        Iterator iter = stringList.iterator();
        System.out.print("HEAD <-> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <-> ");
        }
        System.out.println(" null");

        stringList.removeFirst();

        iter = stringList.iterator();
        System.out.print("HEAD <-> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <-> ");
        }
        System.out.println(" null");

        stringList.removeLast();

        iter = stringList.iterator();
        System.out.print("HEAD <-> ");
        while(iter.hasNext()) {
            System.out.print(iter.next());
            System.out.print(" <-> ");
        }
        System.out.println(" null");

    }
}