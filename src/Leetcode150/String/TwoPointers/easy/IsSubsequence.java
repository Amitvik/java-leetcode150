package Leetcode150.String.TwoPointers.easy;

/*
Given two strings s and t, return true if s is a subsequence of t, or false otherwise.

A subsequence of a string is a new string that is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (i.e., "ace" is a subsequence of "abcde" while "aec" is not).



Example 1:

Input: s = "abc", t = "ahbgdc"
Output: true
Example 2:

Input: s = "axc", t = "ahbgdc"
Output: false


Constraints:

0 <= s.length <= 100
0 <= t.length <= 104
s and t consist only of lowercase English letters.


Follow up: Suppose there are lots of incoming s, say s1, s2, ..., sk where k >= 109, and you want to check one by one to see if t has its subsequence. In this scenario, how would you change your code?
 */
public class IsSubsequence {
    public static boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;

        int sIndex = 0;
        int tIndex = 0;
        while (tIndex < t.length() && sIndex < s.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex))
                sIndex++;
            tIndex++;
        }
        if (sIndex >= s.length())
            return true;
        return false;
    }

    public static void main(String[] args) {
        String s = "abc";
        String t = "ahbgdc";
        System.out.println(isSubsequence(s, t));
        String s1 = "axc";
        String t1 = "ahbgdc";
        System.out.println(isSubsequence(s1, t1));

    }
}
