package array;

// Java program to illustrate creating an array of integers,  puts some values in the array, 
// and prints each value to standard output. 

class Array {
	public static void main(String [] args) {
		// The elements in the array allocated by new will automatically be initialized to 
		// zero (for numeric types), 
		// false (for boolean)
		// null (for reference types)

		int intArray [] = new int[10];

		// 2-D array 
		int arr[][] =  {{1,2,3}, {4,5,6}, {7,8,9}};

		for (int i=0; i < intArray.length; i++)
			intArray[i]=i+1;

		// Using normal for loop
		System.out.println("Displaying array using normal for loop - ");
		for (int i=0; i < intArray.length; i++)
			System.out.println("Value at index " + i + " : " + intArray[i]);

		// Using foreach loop
		System.out.println("Displaying array using for-each loop [Introduced in Java 8] - ");
		for (int i : intArray){
			System.out.print(i + " ");
		}

		//Printing the 2-D array
		System.out.println("Displaying array using for-each loop [Introduced in Java 8] - ");
		for (int i=0; i < 3; i++) {
			for (int j=0; j < 3; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}

	}
}