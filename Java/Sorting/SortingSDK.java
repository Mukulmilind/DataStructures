package sorting;

import java.util.Arrays;
/*
    @author Mukul Milind Mishra
    Sorting using java SDK
*/
class SortingSDK {
    public static void main (String [] args) {
        int [] arr = {-22, 3, 8, 10, 56, -11};

        Arrays.sort(arr);

        System.out.print("Sorted Array is : ");
        for (int i: arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}