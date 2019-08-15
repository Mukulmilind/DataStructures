package Sorting;
/*
    Author: Mukul Milind Mishra [mukulmilind23@gamil.com]
    The Insertion Sort algorithm using recursion.
*/
class InsertionSort {
    public static void main(String[] args) {
        int [] array = {22, 5, 4, 1, -22, 8, -10};

        insertionSort(array, array.length);

        // Display the sorted array
        System.out.print("Sorted Arrays is: ");
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void insertionSort (int [] input, int numItems) {
        // Base Case
        if (numItems < 2) return;

        // Recursive call, sort the total number of items - 1 array before sorting the entire array
        // untill the count reached base case
        insertionSort(input, numItems - 1);

        int newElement = input[numItems - 1];

        int i;
        for (i = numItems - 1; i > 0 && input[i-1] > newElement; i--) {
            input[i] = input[i-1];
        }
        input[i] = newElement;

        System.out.println("Result of call when numItems is : " + numItems);
        for(int j : input) {
            System.out.print(j + " ");
        }
        System.out.println("");
        System.out.println("-----------------------------------");
    }
}