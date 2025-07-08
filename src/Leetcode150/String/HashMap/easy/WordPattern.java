/*
Given a pattern and a string s, find if s follows the same pattern.

Here follow means a full match, such that there is a bijection between a letter in pattern and a non-empty word in s. Specifically:

Each letter in pattern maps to exactly one unique word in s.
Each unique word in s maps to exactly one letter in pattern.
No two letters map to the same word, and no two words map to the same letter.


Example 1:

Input: pattern = "abba", s = "dog cat cat dog"

Output: true

Explanation:

The bijection can be established as:

'a' maps to "dog".
'b' maps to "cat".
Example 2:

Input: pattern = "abba", s = "dog cat cat fish"

Output: false

Example 3:

Input: pattern = "aaaa", s = "dog cat cat dog"

Output: false



Constraints:

1 <= pattern.length <= 300
pattern contains only lower-case English letters.
1 <= s.length <= 3000
s contains only lowercase English letters and spaces ' '.
s does not contain any leading or trailing spaces.
All the words in s are separated by a single space.
 */
package Leetcode150.String.HashMap.easy;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public static boolean wordPattern(String pattern, String s) {
        Map<Character, String> patternMap = new HashMap<>();
        Map<String, Character> sMap = new HashMap<>();
        String[] sArr = s.split(" ");
        if (pattern.length() != sArr.length) return false;
        int i = 0;
        while (i < pattern.length()) {
            if (patternMap.containsKey(pattern.charAt(i))) {
                if (!patternMap.get(pattern.charAt(i)).equals(sArr[i]))
                    return false;
            } else if (sMap.containsKey(sArr[i])) {
                if (!sMap.get(sArr[i]).equals(pattern.charAt(i)))
                    return false;
            } else {
                patternMap.put(pattern.charAt(i), sArr[i]);
                sMap.put(sArr[i], pattern.charAt(i));
            }
            i++;
        }
        return true;
    }

    public static void main(String[] args) {
        String pattern1 = "abba";
        String s1 = "dog cat cat dog";
        String pattern2 = "abba";
        String s2 = "dog cat cat fish";
        String pattern3 = "aaaa";
        String s3 = "dog cat cat dog";
        System.out.println(wordPattern(pattern1, s1));
        System.out.println(wordPattern(pattern2, s2));
        System.out.println(wordPattern(pattern3, s3));
    }
}
