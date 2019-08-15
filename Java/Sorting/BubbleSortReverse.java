package sorting;
/*
    Author: Mukul Milind Mishra [mukulmilind23@gamil.com]
    This is another version of Bubble sort where the sorting is done from last towards the begining of the
    array. The largest element is swapped at the last position in the array and then the second largest array
    and the same approach is applied to the remaining element of the array

    Runtime is same O(n^2) which is highly inefficient, hence the algorithm degrades very fast.
    This is a stable sort algorithms as it preserves the postition of the duplicate elements.
*/
class BubbleSortReverse {
    public static void main(String[] args) {
        int [] array = {-22, 5, 4, 1, 8, -10};


        for (int lastUnsortedIndex = array.length-1; lastUnsortedIndex > 0; lastUnsortedIndex--) {
            for (int i=0; i < lastUnsortedIndex; i++) {
                if (array[i] > array[i+1]) 
                    swap(array, i, i + 1);
            }
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