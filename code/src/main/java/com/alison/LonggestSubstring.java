package com.alison;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @Author alison
 * @Date 2019/6/13  22:31
 * @Version 1.0
 */
public class LonggestSubstring {
    // 求无重复字符的最长子串长度
    public int lengthOfLonggestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            Character alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(start, map.get(alpha));
            }
            map.put(alpha, end + 1);
            res = Math.max(res, end - start + 1);
        }
        return res;
    }

    // 求无重复字符的最长子串
    public String longgestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int res = 0;
        int start = 0, end = 0;
        for (; end < s.length(); end++) {
            Character alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(start, map.get(alpha));
            }
            map.put(alpha, end + 1);
            res = Math.max(res, end - start + 1);
        }
        System.out.println(map);
        System.out.println(start + "-" + end);
        return s.substring(start, end);
    }

    // 求最长子序列
    public int lengthOfStr(String str) {
        Set<Character> charSet = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            Character cha = str.charAt(i);
            if (!charSet.contains(cha)) {
                charSet.add(cha);
            }
        }
        System.out.println(charSet);
        return charSet.size();
    }

    public static void main(String[] args) {
        LonggestSubstring l = new LonggestSubstring();
        String str = "abcabcbb";
//        String str = "bbbb";
//        String str = "pwwkew";
//        int res = l.lengthOfLonggestSubstring(str);
//        System.out.println(res);
        System.out.println(l.lengthOfLonggestSubstring(str));
        System.out.println(l.longgestSubstring(str));
    }

}
