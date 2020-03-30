package com.agile.leetcode.algorithm;

import java.util.Arrays;

/**
 * @author liuyi
 * @since 2020/3/27
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
   请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
   你可以假设 nums1 和 nums2 不会同时为空。
 */
public class FindMedianSortedArrays {

    public static final int two = 2;

    public static void main(String[] args) {
        int[] arr1 = {1,3};
        int[] arr2 = {2,4};
        System.out.println(findMedianSortedArrays(arr1, arr2));
    }


    /**
     * 找出中位数
     * @param arr1
     * @param arr2
     * @return
     */
    public static double findMedianSortedArrays(int[] arr1, int[] arr2) {
        int[] result = concat(arr1, arr2);
        Arrays.sort(result);
        int length = result.length;
        if (length % two == 0) {
            return (double)(result[length/two] + result[length/two-1])/two;
        } else {
            return (double)result[length/two];
        }

    }

    /**
     * 数组合并
     * @param first
     * @param second
     * @return
     */
    public static int[] concat(int[] first, int[] second) {
        int[] result = Arrays.copyOf(first, first.length + second.length);
        System.arraycopy(second, 0, result, first.length, second.length);
        return result;
    }
}
