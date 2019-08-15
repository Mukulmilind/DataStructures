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