/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Java Program to implement linear seach algorithm,
 * Runtime is O(n)
 */

public class LinearSearch {
    public static void main(String [] args) {
        int [] intArray = {20, 35, -15, 6, 55, 1, -21};
        System.out.println("-15 found at position: " + linearSearch(intArray, -15));
        System.out.println("1 found at position: " + linearSearch(intArray, 1));
        System.out.println("999 found at position: " + linearSearch(intArray, 999));
        System.out.println("55 found at position: " + linearSearch(intArray, 55));
    }

    public static int linearSearch(int [] input, int value) {
        for (int i = 0; i < input.length; i++) {
            if (input[i] == value) {
                return i;
            }
        }
        return -1;
    }
}