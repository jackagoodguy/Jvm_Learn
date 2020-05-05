package com.java.z_exam.suanfa;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @'dddddddddddddddddddDate: Created in 3:16 下午 2020/5/5
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */
public class T_0003_DataChecker {

    static int[] generateRandomArray() {
        Random r = new Random();
        int[] arr = new int[10000];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(10000);
        }

        return arr;
    }

    static void check(){
        int[] arr = generateRandomArray();
        int[] arr2 = new int[arr.length];
        System.arraycopy(arr, 0, arr2, 0, arr.length);

        Arrays.sort(arr);
        T_0002_SelectionSort.sort(arr2);

        boolean same = true;
        for (int i = 0; i < arr2.length; i++) {
            if (arr[i] != arr2[i]) same = false;
        }

        System.out.println(same == true ? "right": "wroing");
    }

    public static void main(String[] args) {
        check();
    }
}
