package Leetcode150.String.SlidingWindow.medium;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        int longest = 0;
        int left = 0;
        int right = 0;
        if (s.isEmpty()) return 0;
        Set<Character> characterSet = new HashSet<>();
        while (right < s.length()) {
            if (characterSet.contains(s.charAt(right))) {
                characterSet.remove(s.charAt(left++));
            } else {
                characterSet.add(s.charAt(right++));
            }
            longest = Math.max(longest, right - left + 1);

        }
        return longest - 1;

    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        String s2 = "bbbbb";
        String s3 = "pwwkew";
        System.out.println(lengthOfLongestSubstring(s1));
        System.out.println(lengthOfLongestSubstring(s2));
        System.out.println(lengthOfLongestSubstring(s3));

    }
}
