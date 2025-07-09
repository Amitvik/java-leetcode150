package Leetcode150.String.HashMap.easy;

import java.util.HashMap;
import java.util.Map;

/*
Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.

Each letter in magazine can only be used once in ransomNote.



Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true


Constraints:

1 <= ransomNote.length, magazine.length <= 105
ransomNote and magazine consist of lowercase English letters.
 */
public class RansomNote {
    public static boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char ch : magazine.toCharArray()) {
            int value = charMap.getOrDefault(ch, 0);
            charMap.put(ch, value + 1);
        }
        for (char ch : ransomNote.toCharArray()) {
            if (charMap.getOrDefault(ch, 0) == 0) {
                return false;
            }
            charMap.put(ch, charMap.get(ch) - 1);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canConstruct(new String("a"), new String("b")));
        System.out.println(canConstruct(new String("aa"), new String("ab")));
        System.out.println(canConstruct(new String("aa"), new String("aab")));
    }
}
