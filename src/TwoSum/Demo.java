package TwoSum;

import java.util.Arrays;
import java.util.HashMap;

public class Demo {

    public static void main(String[] arg) {
        System.out.println(Arrays.toString(twoSumOptimumSolution(new int[]{1, 3, 4, 2}, 6)));
    }

    /**
     * Brute Force Solution
     */
    public static int[] twoSum(int[] nums, int target) {

        int[] output = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    output[0] = i;
                    output[1] = j;
                    break;
                }
            }
        }

        return output;
    }

    public static int[] twoSumOptimumSolution(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                int index = map.get(rem);
                if (index == i)
                    continue;
                return new int[]{i, index};
            }
        }

        return new int[]{};
    }
}
