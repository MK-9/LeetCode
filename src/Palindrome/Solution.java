package Palindrome;

public class Solution {

    public static void main(String[] args) {
        System.out.println(isPalindromeBruteForce(1255251));
    }

    public static boolean isPalindromeBruteForce(int x) {
        if (x < 0)
            return false;
        return reverseInteger(x) == x;
    }

    public static int reverseInteger(int x) {
        boolean neg = x < 0;

        if (x == -x) {
            return 0;
        }

        long rem = 0;
        long output = 0;
        do {
            output *= 10L;
            rem = x % 10;
            output += rem;
            x = x / 10;
        } while (x != 0);

        if (output > Integer.MAX_VALUE)
            return 0;

        return neg ? (int) -output : (int) output;
    }
}
