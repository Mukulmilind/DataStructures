package Sorting;

// Author : Mukul Milind Mishra [mukulmilind23@gmail.com]
// Java program to find factorial of a number to explain how recursion works

class Recursion {
    public static void main (String [] args) {
        System.out.println(interativeFactorial(4));
        System.out.println(recursiveFactorial(4));
    }
    /*
    1! = 1 * 0! = 1
    2! = 2 * 1 = 2 * 1!
    3! = 3 * 2 * 1 = 3 * 2!
    4! = 4 * 3 * 2 * 1 = 4 * 3! 
    and so on ...
    */ 
    public static int recursiveFactorial (int num) {
        // Base case
        if (num == 0) return 1;
        
        // Recursive call
        else return num * recursiveFactorial(num -1);
    }

    public static int interativeFactorial(int num) {
        if (num == 0)
            return 1;
        
        int factorial = 1;
        for (int i = 1; i <= num; i++) {
            factorial = factorial*i;
        }

        return factorial;
    }
}