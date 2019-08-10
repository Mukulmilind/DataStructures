/*
    Author: Mukul Milind Mishra [mukulmilind23@gamil.com]
    The Insertion Sort algorithm picks each element in the array and inserts them in the right position
    of the sorted logical partition. Once this operation is applied on each element in the array the 
    entire array is sorted.
    
    Runtime is same O(n^2) which is highly inefficient, but better than bubble sort as swapping is less. 
    This is a stable sort algorithms as it preserves the postition of the duplicate elements.
*/
class InsertionSort {
    public static void main(String[] args) {
        int [] array = {22, 5, 4, 1, -22, 8, -10};

        for (int firstUnsortedIndex = 1; firstUnsortedIndex < array.length; firstUnsortedIndex++) {
            int newElement = array[firstUnsortedIndex];

            int i;
            for (i = firstUnsortedIndex; i > 0 && array[i-1] > newElement; i--) {
                array[i] = array[i-1];
            }
            array[i] = newElement;
        }

        // Display the sorted array
        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}