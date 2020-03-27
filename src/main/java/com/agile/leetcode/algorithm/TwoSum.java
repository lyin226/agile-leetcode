package com.agile.leetcode.algorithm;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author liuyi
 * @since 2020/3/24
 *
 * 求两数之和，返回两数下标
 * 两种方式，一种暴力循环计算；第二种利用map；
 */
public class TwoSum {

    public static void main(String[] args) {
        int[] array = {1,7,11,15};
        int target = 9;
        int[] result = twoSum(array, target);
        if (result != null) {
            Arrays.stream(result).forEach(System.out::println);
        }
    }

    /**
     * 利用map计算
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum(int[] array, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i< array.length; i++) {
            if (map.containsKey(array[i])) {
                result[0] = i;
                result[1] = map.get(array[i]);
                return result;
            }
            map.put(target - array[i], i);
        }
        return null;
    }

    /**
     * 暴力计算
     * @param array
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] array, int target) {
        int[] result = new int[2];
        for (int i=0; i< array.length; i++) {
            for (int j= i+1; j<array.length; j++) {
                int temp = array[i] + array[j];
                if (temp == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return null;
    }

}
