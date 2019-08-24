/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * Challenge: Check if the given array has any duplicate elements in linean runtime - O(n).
 * The integer values are smallers than the total length of the array.
 */

public class DuplicateChallenge{
    public static void main(String [] args) {
        int [] array = {1, 2, 3, 6, 2, 4, 1};

        for (int i : array) {
            System.out.print(i + " ");
        }
        System.out.println();

        String result = checkDuplicate(array) ? "Duplicate Found" : "Not Found";
        System.out.println("Checking Duplicate in above input: " + result);
        
    }

    // Iterate over each element in the array, check for the sign of value at position
    // at current value of ith element e.g. input[abs(input[i])]d. If its positive flip
    // the sign other wise return true : duplicate found.
    public static boolean checkDuplicate(int[] input) {
        for (int i = 0; i < input.length; i++) {
            if (input[Math.abs(input[i])] < 0) {
                return true;  
            } else {
                input[Math.abs(input[i])] = -input[Math.abs(input[i])];
            }
        }
        return false;
    }
}