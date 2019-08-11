package com.alison.sort;

import java.util.Arrays;

/**
 * @Author alison
 * @Date 2019/8/10  18:43
 * @Version 1.0
 * @Description
 */
public class SortDemo {

    public static void main(String[] args) {
        IArraySort arraySort = new BubbleSort();
        int[] arr = {3, 7, 4, 9, 5, 22, 91};
        System.out.println(Arrays.toString(arr));
        arraySort = new SelectionSort();
        arraySort = new InsertSort();
        arraySort = new ShellSort();
        arraySort = new MergeSort();
        arraySort = new QuickSort();
        arraySort = new HeapSort();
        arraySort = new CountingSort();
        arraySort = new BucketSort();
        arraySort = new CountingSort();
        arraySort = new RadixSort();
        arr = arraySort.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
