package com.alison;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @Author alison
 * @Date 2019/8/7  22:39
 * @Version 1.0
 * @Description
 */
public class StackDemo {

    public boolean isValid(String s) {
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(']', '[');
        mapping.put(')', '(');
        mapping.put('}', '{');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (mapping.containsKey(c)) {
                char topElement = stack.isEmpty() ? '#' : stack.pop();
                if (mapping.get(c).compareTo(topElement) != 0)
                    return false;
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }


    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    public static void main(String[] args) {
        String s = "[][][][][]";
        StackDemo stackDemo = new StackDemo();
        System.out.println(stackDemo.isValid(s));
    }
}
