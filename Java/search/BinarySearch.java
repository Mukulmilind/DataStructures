/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Binary Search Implementaion using java, conditions and working below:
 * - Array must be sorted
 * - Chooses the element in the middle of the array, if element is equal to value we are done
 * - If value is less, search in the left half of the array
 * - If the value is large than element, search the right half of the array.
 * 
 * Runtime is O(n), as each time we divide the array in half, untill the element is found.
 */

public class BinarySearch {
    public static void main(String [] args) {
        int [] intArray = {-21, -15, 1, 6, 20, 35, 55};

        System.out.println("-15 found at position: " + binarySearch(intArray, -15));
        System.out.println("1 found at position: " + binarySearch(intArray, 1));
        System.out.println("999 found at position: " + binarySearch(intArray, 999));
        System.out.println("55 found at position: " + binarySearch(intArray, 55));
    }

    public static int binarySearch(int [] input, int element) {
        int start = 0;
        int end = input.length;

        while (start < end) {
            int mid = (start + end) / 2;

            if (input[mid] == element) {
                return mid;
            } else if(input[mid] < element) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        
        return -1;
    }
}