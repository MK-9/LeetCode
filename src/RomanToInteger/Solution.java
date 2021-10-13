package RomanToInteger;

import java.util.HashMap;

public class Solution {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("IV"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("IX"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        //create romans number
        HashMap<Character, Integer> romans = new HashMap<>();
        romans.put('I', 1);
        romans.put('V', 5);
        romans.put('X', 10);
        romans.put('L', 50);
        romans.put('C', 100);
        romans.put('D', 500);
        romans.put('M', 1000);

        long output = 0;
        long oldDigit = 0;
        long newDigit;
        long temp = 0;
        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (i == 0) {
                oldDigit = romans.get(character);
                output = oldDigit;
                continue;
            }

            newDigit = romans.get(character);

            if (oldDigit < newDigit) {
                temp =  newDigit - oldDigit;
            } else {
                output = output + newDigit + oldDigit;
            }

        }

        return (int) output;
    }
}
