/** 
    Author: Mukul Milind Mishra [mukulmilind23@gmail.com]
    - Merge Sort uses divide and conquer approach to sort an array. 
    - First it recursively divides the  array into a single element array logically in place. 
    - Once we have single elements we merge them in sorted order. 
    - The merging is done for each siblings from left to right into a temporary array and its 
      copied back to the orignal array. This process is repeated untill the entire array is sorted

    - This is not an in place algorithm but its stable [position of duplicates are preserved]
    - Runtime is O(n.log n) - base 2 as we are repeatedly diving the array in half.
*/

class MergeSort {
    public static void main(String [] args) {
        int[] array = {20, 35, -15, 7, 55, 1, -22};

        mergeSort(array, 0, array.length);
        System.out.print("Sorted Array is : ");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void mergeSort(int[] input, int start, int end) {
        // Base case : meaning we have only element left.
        if (end - start < 2) return;

        int mid = (end + start)/2;

        mergeSort(input, start, mid);
        mergeSort(input, mid, end);
        merge(input, start, mid, end);
    }

    public static void merge(int[] input, int start, int mid, int end) {
        // If the last elememt in the left sub-array is smaller than first element if 
        // right sub-array, then we are done. The array is sorted hence return.
        if (input[mid -1] < input[mid]) {
            return;
        }

        int i = start;
        int j = mid;
        int tempIndex = 0;

        int[] temp = new int[end - start];
        while (i < mid && j < end){
            // Since we are using <= the relative position of duplicates are preseved.
            temp[tempIndex++] = input[i] <= input[j] ? input[i++] : input[j++];
        }

        // Copy whatever is left over in the left array
        System.arraycopy(input, i, input, start + tempIndex, mid-i);
        // Copy the remaining elements of the temp araay
        System.arraycopy(temp, 0, input, start, tempIndex);
    }
}