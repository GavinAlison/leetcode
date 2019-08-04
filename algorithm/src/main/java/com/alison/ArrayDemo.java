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
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i]))
                return new int[]{map.get(target - nums[i]), i};
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum!");
    }

    // happy sum
    public static boolean isHappy(int n) {
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

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        Arrays.sort(nums);
        int len = nums.length;
        if (nums == null || len < 3) return ans;
        for (int i = 0; i < len; i++) {
            if (nums[i] > 0) break;
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    L++;
                    R--;
                } else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }

    public static int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;
        for (int num : nums) {
            if (count == 0)
                candidate = num;
            count += (num == candidate) ? 1 : -1;
        }
        return candidate;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 4, 8, 10};
        int[] a2 = {2, 3, 6, 9, 10};
        System.out.println(Arrays.toString(a1));
        int[] result = mergeArray(a1, a2);
        System.out.println(Arrays.toString(result));
        result = twoSum(a1, 7);
        System.out.println(Arrays.toString(result));
        System.out.println(isHappy(19));
        List<List<Integer>> ans = threeSum(a1);
        for (List<Integer> foo : ans) {
            System.out.println(foo);
        }
    }

}
