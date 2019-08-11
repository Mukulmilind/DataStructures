/*
    Author: Mukul Milind Mishra [mukulmilind23@gmail.com]

    - Quick Sort is also divide and conquer approach
    - Uses a pivot to recursively divide the array logically
    - Elements to the left of the pivot are smaller and elements to the right are larger, hence the
      the pivot is automatically at its correct sorted position. But the left and right subarrays 
      may not be sorted
    - Hence the same step is applied on left and right sub-array recursively to sort entire process.
    - Every element would be chosen as a pivot
    - This is an in-place sorting, space complexity is less.
    - Runtime is O(n.log n) - base 2 as we are repeatedly diving the array in half.
*/

class QuickSort {
    public static void main (String [] args) {
        int [] array = {20, 35, -15, 7, 55, 1, -22};
        
        quickSort(array, 0, array.length);

        System.out.print("Sorted Array is : ");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void quickSort(int [] input, int start, int end) {
        // Base Case as we are dealing with one element array, hence return.
        if (end - start < 2) return;

        // This call would put the pivot element in its right sorted position
        int pivotIndex = partition(input, start, end);

        // Recursively sort the left sub-array and the right sub-array
        quickSort(input, start, pivotIndex);
        quickSort(input, pivotIndex + 1, end);

    }

    public static int partition(int [] input, int start, int end) {
        // This is using first element as the pivot
        int pivot = input[start];
        int i = start;
        int j = end;

        while (i < j) {
            // NOTE: This is empty loop to find the first element from the left less than pivot
            // We are pre-decrementing the j value as last index is one less than length of array.
            while (i < j && input[--j] >= pivot);
            if (i < j){
                input[i] = input[j];
            }

            // NOTE: This is empty loop to find the first element from the right greater than pivot
            // We are pre-incrementing the i value as we have already taken care of the ith element.
            while (i < j && input[++i] <= pivot);
            if (i < j){
                input[j] = input[i];
            }
        }
        // Now the index of j would be used to insert the pivot
        input[j] = pivot;

        return j;
    }
}