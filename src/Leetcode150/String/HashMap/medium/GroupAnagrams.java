package Leetcode150.String.HashMap.medium;

import java.util.*;

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.



Example 1:

Input: strs = ["eat","tea","tan","ate","nat","bat"]

Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Explanation:

There is no string in strs that can be rearranged to form "bat".
The strings "nat" and "tan" are anagrams as they can be rearranged to form each other.
The strings "ate", "eat", and "tea" are anagrams as they can be rearranged to form each other.
Example 2:

Input: strs = [""]

Output: [[""]]

Example 3:

Input: strs = ["a"]

Output: [["a"]]



Constraints:

1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */
public class GroupAnagrams {
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagrams = new HashMap<>();
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> stringsList;
            if (anagrams.containsKey(key)) {
                stringsList = anagrams.get(key);
            } else {
                stringsList = new ArrayList<>();
            }
            stringsList.add(str);
            anagrams.put(key, stringsList);
        }
        return new ArrayList<>(anagrams.values());
    }

    public static void main(String[] args) {
        String[] strs1 = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        String[] strs2 = new String[]{""};
        String[] strs3 = new String[]{"a"};
        System.out.println(groupAnagrams(strs1));
        System.out.println(groupAnagrams(strs2));
        System.out.println(groupAnagrams(strs3));

    }

}
