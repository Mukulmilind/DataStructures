/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Challenge: Reverse the given array in-place with O(n), linear time complexity.
*/

public class ArrayChallenge {
    public static void main (String [] args) {
        int [] array = {1, 2, 3, 4, 5};

        System.out.println(" ");
        System.out.print("Input Array is : ");
        for (int i: array) {
            System.out.print(i + " ");
        }

        reverseArray(array);

        System.out.println(" ");
        System.out.print("Reversed Array is : ");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println(" ");
    }
    public static void reverseArray(int[] input) {
        int start = 0;
        int end = input.length - 1;

        while(start < end) {
            swap(input, start, end);
            
            start++;
            end--;
        }
    }

    private static void swap(int [] input, int start, int end) {
        int temp = input[start];
        input[start] = input[end];
        input[end] = temp;
    }
}