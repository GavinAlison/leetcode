package com.alison;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author alison
 * @Date 2019/8/6  0:05
 * @Version 1.0
 * @Description
 */
public class StackDemo {

    public boolean isValid(String s) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(']', '[');
        mapping.put('}', '{');
        mapping.put(')', '(');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            // ( ) { } [ ]
            // 判断当前字符是否在map.key中
            if (mapping.containsKey(c)) {
                // 取出stack的topelement| topChar
                Character topChar = stack.isEmpty() ? '#' : stack.pop();
                if (!topChar.equals(mapping.get(c)))
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[](){";
        StackDemo stackDemo = new StackDemo();
        System.out.println(stackDemo.isValid(s));
    }
}
