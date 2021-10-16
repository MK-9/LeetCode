package RomanToInteger;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static void main(String[] args) {
        System.out.println(romanToInts("III"));
        System.out.println(romanToInts("IV"));
        System.out.println(romanToInts("LVIII"));
        System.out.println(romanToInts("IX"));
        System.out.println(romanToInts("MCMXCIV"));
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
        long temp;

        for (int i = 0; i < s.length(); i++) {
            char character = s.charAt(i);

            if (i == 0) {
                newDigit = romans.get(character);
                oldDigit = newDigit;
                if (s.length() == 1) output = newDigit;
                continue;
            }

            newDigit = romans.get(character);

            if (oldDigit >= newDigit) {
                output += oldDigit;
                oldDigit = newDigit;
            } else if (oldDigit != 0) {
                temp = newDigit - oldDigit;
                output += temp;
                oldDigit = 0;
            } else {
                oldDigit = newDigit;
            }
        }

        return (int) output;
    }

    public static int romanToInts(String s) {
        Map<Character, Integer> m = new HashMap<>();
        m.put('I', 1);
        m.put('V', 5);
        m.put('X', 10);
        m.put('L', 50);
        m.put('C', 100);
        m.put('D', 500);
        m.put('M', 1000);
        int res = m.get(s.charAt(s.length()-1));
        for(int i =s.length()-2; i>=0; i--)
        {
            if(m.get(s.charAt(i))<m.get(s.charAt(i+1)))
                res -= m.get(s.charAt(i));
            else
                res += m.get(s.charAt(i));
        }
        return res;
    }
}
