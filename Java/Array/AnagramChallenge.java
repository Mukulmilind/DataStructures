/**
 * @author Mukul Milind Mishra 
 * Challenge: Anagram Program
 */

import java.util.Arrays;

public class AnagramChallenge {
    public static void main(String [] args) {
        char[] a = {'h', 'e', 'l', 'l', 'o'};
        char[] b = {'e', 'h', 'l', 'o', 'l'};
        checkAnagram(a, b);
    }
    public static boolean checkAnagram(char[] a, char[] b) {
        if (a.length != b.length) return false;

        // This is bottleneck as this sorting operation, runtime is O(nlogn)
        Arrays.sort(a);
        Arrays.sort(b);

        // Runtime linear: O(n)
        for (int i = 0; i < a.length; i++) {
            if (a[i] != b[i]) {
                return false;
            }
        }

        return true;
    }
}