package Sorting;

/*
    Author: Mukul Milind Mishra [mukulmilind23@gamil.com]
    The selection sort algorithm selects the highest element and swaps it with the last element in the
    array. Hence creating sorted logical partition at the right and unsorted logical partition at the
    left of the array.

    Runtime is same O(n^2) which is highly inefficient, but better than bubble sort as swapping is less. 
    This is a stable sort algorithms as it preserves the postition of the duplicate elements.
*/
class SelectionSort {
    public static void main(String[] args) {
        int [] array = {-22, 5, 4, 1, 8, -10};


        for (int lastUnsortedIndex = array.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            int largest = 0;
            for (int i=1; i <= lastUnsortedIndex; i++) {
                if (array[i] > array[largest]) ;
                    largest = i;
            }
            swap(array, largest, lastUnsortedIndex);
        }
        for (int i : array) {
            System.out.println(i);
        }
        
    }

    // Swap the elements
    public static void swap(int[] array, int i, int j) {
        if (i == j) {
            return;
        }
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
}