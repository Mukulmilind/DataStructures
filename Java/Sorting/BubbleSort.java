package sorting;
import java.util.Scanner;

// Write a java program to sort a given array using bubble sort in ascending order
// This program is creating two logical partitions, the left one being sorted and the right one unsorted
// each time the i counter is incremented towards unsorted part leaving sorted array on the left
// Runtime for this program is O(n^2)

public class BubbleSort {
    public static void main (String [] args) {
        int [] arr;
        int n;

        Scanner s = new Scanner(System.in);
        System.out.print("Enter the number of elements: ");
        n = s.nextInt();
        arr = new int[n];

        System.out.println();
        System.out.println("Enter the elements: "); 
        for (int i=0; i<n; i++) {
            arr[i] = s.nextInt();
        }       
        s.close();

        System.out.print("Unsorted array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
        
        for (int i=0; i < arr.length; i++) {
            for (int j=i; j < arr.length-1; j++) {
                if (arr[i]>arr[j+1]) {
                    int temp = arr[i];
                    arr[i] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.print("Sorted array is: ");
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    } 
}