package Leetcode150.Array.HashSet.medium;

import java.util.HashSet;
import java.util.Set;
/*
Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

You must write an algorithm that runs in O(n) time.



Example 1:

Input: nums = [100,4,200,1,3,2]
Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:

Input: nums = [0,3,7,2,5,8,4,6,0,1]
Output: 9
Example 3:

Input: nums = [1,0,1,2]
Output: 3


Constraints:

0 <= nums.length <= 105
-109 <= nums[i] <= 109
 */
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
