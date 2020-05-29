package com.java.z_exam.algorithm.sort.sort_with_design;

import java.util.Arrays;

/**
 * @Author: Lei
 * @E-mail: 843291011@qq.com
 * @Date: 2020-05-29 9:16
 * @Version: 1.0
 * @Modified By:
 * @Description:
 */

/*
希尔排序
    希尔排序是插入排序的一种，又称“缩小增量排序”，是插入排序算法的一种更高效的改进版本。

前面学习插入排序的时候，我们会发现一个很不友好的事儿，如果已排序的分组元素为{2,5,7,9,10}，未排序的分组
元素为{1,8}，那么下一个待插入元素为1，我们需要拿着1从后往前，依次和10,9,7,5,2进行交换位置，才能完成真
正的插入，每次交换只能和相邻的元素交换位置。那如果我们要提高效率，直观的想法就是一次交换，能把1放到
更前面的位置，比如一次交换就能把1插到2和5之间，这样一次交换1就向前走了5个位置，可以减少交换的次数，
这样的需求如何实现呢？接下来我们来看看希尔排序的原理。



需求：
    排序前：{9,1,2,5,7,4,8,6,3,5}
    排序后：{1,2,3,4,5,5,6,7,8,9}
    排序原理：
     1.选定一个增长量h，按照增长量h作为数据分组的依据，对数据进行分组；
     2.对分好组的每一组数据完成插入排序；
     3.减小增长量，最小减为1，重复第二步操作。

增长量h的确定：增长量h的值每一固定的规则，我们这里采用以下规则：

int h=1
while(h<5){
    h=2h+1；//3,7
}
//循环结束后我们就可以确定h的最大值；
h的减小规则为：
h=h/2

希尔排序的API设计：
    类名 Shell
    构造方法 Shell()：创建Shell对象
    成员方法
    1.public static void sort(Comparable[] a)：对数组内的元素进行排序
    2.private static boolean greater(Comparable v,Comparable w):判断v是否大于w
    3.private static void exch(Comparable[] a,int i,int j)：交换a数组中，索引i和索引j处的值

在希尔排序中，增长量h并没有固定的规则，有很多论文研究了各种不同的递增序列，但都无法证明某个序列是最
好的，对于希尔排序的时间复杂度分析，已经超出了我们课程设计的范畴，所以在这里就不做分析了。
我们可以使用事后分析法对希尔排序和插入排序做性能比较。

通过测试发现，在处理大批量数据时，希尔排序的性能确实高于插入排序。
 */
public class T04_Shell {
    public static void main(String[] args) {
        //Integer[] a = {9, 1, 2, 5, 7, 4, 8, 6, 3, 5};
        //Integer[] a = {9, 1, 5};
        Integer[] a = {9, 1, 10, 6, 7};
        T04_Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /*
        示例：
        第一轮：间隔为4插入排序
        [9],6,11,3,[5],12,8,7,[10],15,14,4,[1],13,2
        [1],6,11,3,[5],12,8,7,[9],15,14,4,[10],13,2

        1,[6],11,3,5,[12],8,7,9,[15],14,4,10,[13],2
        1,[6],11,3,5,[12],8,7,9,[13],14,4,10,[15],2

        1,6,[11],3,5,12,[8],7,9,13,[14],4,10,15,[2]
        1,6,[2],3,5,12,[8],7,9,13,[11],4,10,15,[14]

        第二轮：间隔为2插入排序
        [1],6,[2],3,[5],12,[8],7,[9],13,[11],4,[10],15,[14]
        [1],6,[2],3,[5],12,[8],7,[9],13,[10],4,[11],15,[14]

        1,[6],2,[3],5,[12],8,[7],9,[13],10,[4],11,[15],14
        1,[3],2,[6],5,[4],8,[7],9,[12],10,[13],11,[15],14

        1,3,[2],6,[5],4,[8],7,[9],12,[10],13,[11],15,[14]
        1,3,[2],6,[5],4,[8],7,[9],12,[10],13,[11],15,[14]

        第三轮：间隔为1插入排序
     */
    public static void sort(Comparable[] arr) {
        int h = 1;
        while (h <= arr.length / 3) {
            h = h * 3 + 1;
        }

        for (int gap = h; gap > 0; gap = (gap - 1) / 3) {
            for (int startPos = gap; startPos < arr.length; startPos++) {
                for (int i = startPos; i >= gap; i = i - gap) {
                    if (greater(arr[i - gap], arr[i])) {
                        exch(arr, i, i - gap);
                    } else {
                        break;
                    }
                }
            }

        }


    }

    private static boolean greater(Comparable v, Comparable w) {
        return v.compareTo(w) > 0;
    }

    private static void exch(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
