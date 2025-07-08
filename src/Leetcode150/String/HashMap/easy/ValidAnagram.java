package Leetcode150.String.HashMap.easy;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.



Example 1:

Input: s = "anagram", t = "nagaram"

Output: true

Example 2:

Input: s = "rat", t = "car"

Output: false



Constraints:

1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.


Follow up: What if the inputs contain Unicode characters? How would you adapt your solution to such a case?
 */
public class ValidAnagram {
    public static boolean isAnagram(String s, String t) {
        Map<Character, Integer> sMap = new HashMap<>();

        int i = 0;
        if (s.length() != t.length())
            return false;
        while (i < s.length()) {
            Character sChar = s.charAt(i);
            Character tChar = t.charAt(i);
            sMap.put(sChar, sMap.getOrDefault(sChar, 0) + 1);
            sMap.put(tChar, sMap.getOrDefault(tChar, 0) - 1);
            i++;
        }
        for (int val : sMap.values()) {
            if (val != 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }
}
