package com.alison;

import java.util.*;

/**
 * @Author alison
 * @Date 2019/8/3  21:56
 * @Version 1.0
 * @Description
 */
public class ArrayDemo {
    //  实现两个有序数组合并为一个有序数组
    public static int[] mergeArray(int[] a1, int[] a2) {
        int[] result = new int[a1.length + a2.length];
        int aIndex = 0, bIndex = 0;
        for (int i = 0; i < result.length; i++) {
            if (aIndex < a1.length & bIndex < a2.length) {
                if (a1[aIndex] <= a2[bIndex]) {
                    result[i] = a1[aIndex++];
                } else {
                    result[i] = a2[bIndex++];
                }
            } else if (aIndex < a1.length) {
                result[i] = a1[aIndex++];
            } else if (bIndex < a2.length) {
                result[i] = a2[bIndex++];
            }
        }
        return result;
    }


    //    leetcode上的两数之和
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum!");
    }

    // happy sum
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        int m = 0;
        while (true) {
            while (n != 0) {
                m += Math.pow(n % 10, 2);
                n /= 10;
            }
            if (m == 1)
                return true;
            if (set.contains(m))
                return false;
            else {
                set.add(m);
                n = m;
                m = 0;
            }
        }
    }


    public static void main(String[] args) {
        int[] a1 = {1, 3, 4, 8, 10};
        int[] a2 = {2, 3, 6, 9, 10};
        int[] result = mergeArray(a1, a2);
        System.out.println(Arrays.toString(result));
    }

}
