package LongestCommmonsPrefix;

public class Solution {

    public static void main(String[] arg) {
        String[] strs = new String[]{"flower", "flow", "flowa"};
        System.out.println(longestCommonPrefixBruteForceSolution(strs));
        System.out.println(longestCommonPrefixOptimumSolution(strs));
    }

    public static String longestCommonPrefixBruteForceSolution(String[] strs) {
        if (strs.length == 1)
            return strs[0];

        StringBuilder output = new StringBuilder();
        String first = strs[0];

        for (int k = 0; k < first.length(); k++) {
            for (int i = 1; i < strs.length; i++) {
                String word = strs[i];
                if (k == word.length()) {
                    return output.toString();
                }

                if (first.charAt(k) == word.charAt(k)) {
                    if (i == strs.length - 1)
                        output.append(word.charAt(k));
                } else {
                    return output.toString();
                }
            }
        }
        return output.toString();
    }

    public static String longestCommonPrefixOptimumSolution(String[] strs) {
        if (strs.length == 0)
            return "";

        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }

        return prefix;
    }

}
