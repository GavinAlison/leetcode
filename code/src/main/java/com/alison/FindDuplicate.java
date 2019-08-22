package com.alison;

public class FindDuplicate {
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        int left = 1;
        int right = len - 1;
        while (left < right) {
            // int mid = left + (right - left + 1) / 2;
            int mid = (left + right + 1) >>> 1;
            int counter = 0;
            for (int num : nums) {
                if (num < mid) {
                    counter += 1;
                }
            }
            if (counter >= mid) {
                // 如果小于 4 的个数等于 4 或者更多
                // 那么重复的数一定位于 1、2、3
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        if (nums[len - 1] < target) {
            return len;
        }
        int left = 0;
        int right = len - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            // 等于的情况最简单，我们应该放在第 1 个分支进行判断
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                // 题目要我们返回大于或者等于目标值的第 1 个数的索引
                // 此时 mid 一定不是所求的左边界，
                left = mid + 1;
            } else {
                // 既然不会等于，此时 nums[mid] > target
                // mid 也一定不是所求的右边界
                right = mid - 1;
            }
        }
        return left;
    }


    public static void main(String[] args) {
        int[] nums = {1, 3, 4, 2, 2};
        nums = new int[]{3, 1, 3, 4, 2, 5};
        int[] numss = {1, 3, 4, 5, 7, 8, 9, 10};
        FindDuplicate findDuplicate = new FindDuplicate();
//        int res = findDuplicate.findDuplicate(nums);
//        System.out.println(res);
        findDuplicate.searchInsert(numss, 6);


    }

}
