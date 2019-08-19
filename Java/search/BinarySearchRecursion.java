/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Recursive version of Binary Search Implementaion using java, conditions and working below:
 * - Array must be sorted
 * - Chooses the element in the middle of the array, if element is equal to value we are done
 * - If value is less, search in the left half of the array
 * - If the value is large than element, search the right half of the array.
 * 
 * Runtime is O(n), as each time we divide the array in half, untill the element is found.
 */

public class BinarySearchRecursion {
    public static void main(String [] args) {
        int [] intArray = {-21, -15, 1, 6, 20, 35, 55};
        int start = 0;
        int end = intArray.length;

        System.out.println("-15 found at position: " + binarySearchRecursion(intArray, -15));
        System.out.println("1 found at position: " + binarySearchRecursion(intArray, 1));
        System.out.println("999 found at position: " + binarySearchRecursion(intArray, 999));
        System.out.println("55 found at position: " + binarySearchRecursion(intArray, 55));
    }

    public static int binarySearchRecursion(int [] input, int value) {
        return binarySearchRecursion(input, value, 0, input.length);
    }

    private static int binarySearchRecursion(int [] input, int value, int start, int end) {
        if (start >= end) {
            return -1;
        }

        int mid = (start + end) / 2;
        // System.out.println("midpoint is: " + mid);

        if(input[mid] == value) {
            return mid;
        } else if (input[mid] < value) {
            return binarySearchRecursion(input, value, mid+1, end);
        } else {
            return binarySearchRecursion(input, value, start, mid);
        }
    }
}
