package Leetcode150.Array.HashSet.medium;

import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static int longestConsecutive(int[] nums) {
        int max_streak = 0;
        Set<Integer> numSet = new HashSet();
        for (int num : nums) {
            numSet.add(num);
        }
        if(numSet.size() <=1) return numSet.size();

        for (int num : numSet) {
            if (!numSet.contains(num - 1)) {
                int currentNum = num;
                int currentStreak = 1;
                while (numSet.contains(currentNum + 1)) {
                    currentNum++;
                    currentStreak++;
                }
                max_streak = Math.max(currentStreak, max_streak);
            }
        }

        return max_streak;
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
        System.out.println(longestConsecutive(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}));
        System.out.println(longestConsecutive(new int[]{0}));
        System.out.println(longestConsecutive(new int[]{0, 0}));
        System.out.println(longestConsecutive(new int[]{-6, -1, -1, 9, -8, -6, -6, 4, 4, -3, -8, -1}));
    }
}
