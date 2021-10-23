package ValidParentheses;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Solution {

    public static void main(String[] arg) {
        System.out.println(isValid("{}[]()"));
        System.out.println(isValid("{([])}"));
        System.out.println(isValid("(){}}{"));
        System.out.println(isValid("(([]){})"));
    }

    public static boolean isValid(String s) {
        if (s.length() == 0 || s.length() % 2 != 0)
            return false;

        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');

        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (Character c : s.toCharArray()) {
            s1.push(c);
        }

        while (!s1.isEmpty()) {
            s2.push(s1.pop());
            while (!s1.isEmpty() && s1.peek() == map.get(s2.peek())) {
                s1.pop();
                s2.pop();

                if (s1.isEmpty() || s2.isEmpty()) {
                    break;
                }
            }
        }

        if (!s2.isEmpty()) {
            return false;
        }

        return true;
    }

 }
