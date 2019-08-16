import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;
/**
 * @author Mukul Milind Mishra [mukulmilind23@gmail.com]
 * java Program to check if a given string is palindrome of not. Should ignore punctuation mark and case.
 * e.g. I did, did I? is a pallindrome
 */

public class Challenge1 {
    public static void main(String [] args) {
        System.out.println(checkPalindrome("abccba"));
        System.out.println(checkPalindrome("I did, did I ?"));
        System.out.println(checkPalindrome("hello"));
        System.out.println(checkPalindrome("Don't nod"));
    }

    public static boolean checkPalindrome(String string) {
        LinkedList<Character> stack = new LinkedList<>();
        LinkedList<Character> queue = new LinkedList<>();
        String lowerCase = string.toLowerCase();

        for(int i = 0; i < lowerCase.length(); i++) {
            char c = lowerCase.charAt(i);
            if (c >= 'a' && c <= 'z') {
                queue.addLast(c);
                stack.push(c);
            }
        }
        
        while(!stack.isEmpty()) {
            if (!stack.pop().equals(queue.removeFirst())) {
                return false;
            }
        }

        return true;
    }
}