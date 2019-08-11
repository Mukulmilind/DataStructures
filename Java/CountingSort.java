/*
    Author: Mukul Milind Mishra [mukulmilind23@gmail.com]
    - Counting array is used for sorting array with less number of elements and the range of values
      are usually equal to the length of the array
    - First count the number of occurence of each element in the array and then use this new array
      to place the elements accordingly

    - Runtime is O(n) as the algorithm is based on assumption.
    - This is not an in place algorithm.
*/
class CountingSort {
    public static void main(String [] args) {
        int [] array = {2, 3, 7, 8, 9, 10, 8, 2, 6, 5};

        countingSort(array, 1, 10);

        System.out.print("Sorted Array is : ");
        for (int i: array) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void countingSort(int [] input, int min, int max) {
        int [] countArray = new int [(max - min) + 1];

        for (int i = 0; i < input.length; i++) {
            countArray[input[i] - min]++;
        }

        int j = 0;
        for(int i = min; i <= max; i++) {
            while (countArray[i - min] > 0) {
                input[j++] = i;
                countArray[i - min]--;
            }
        }
    }
}