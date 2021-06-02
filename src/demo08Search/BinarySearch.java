package demo08Search;

import java.util.ArrayList;
import java.util.List;

// 二分查找
public class BinarySearch {
    public static void main(String[] args) {
//        int[] arr = {1, 3, 5, 7, 11, 13, 17, 19, 23};
//        int i = binarySearch1(arr, 0, arr.length - 1, 13);
//        if (i != -1) {
//            System.out.printf("索引为：%d", i);
//        } else {
//            System.out.println("没有查找到");
//        }

        int[] arr = {1, 3, 5, 7, 11, 13, 13, 13, 13, 13, 17, 19, 23};
        List<Integer> list = binarySearch2(arr, 0, arr.length - 1, 13);
        if (list.size() != 0) {
            System.out.printf("索引为：%s", list);
        } else {
            System.out.println("没有查找到");
        }
    }

    /**
     * @param arr     需要查找的数组
     * @param left    起始索引
     * @param right   终止索引
     * @param findVal 查找的元素
     * @return 返回找到的索引
     */
    public static int binarySearch1(int[] arr, int left, int right, int findVal) {
        if (left > right) { //递归先写终止条件
            return -1;
        }
        int mid = (left + right) / 2;
        //判断mid处的值与findVar的大小关系
        if (arr[mid] < findVal) {
            //findVar的索引大于mid，向右递归
            return binarySearch1(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            //要找的值在mid左边，向左递归
            return binarySearch1(arr, left, mid, findVal);
        } else {
            //mid处的值等于findVar
            return mid;
        }
    }

    //上面写的二分查找只找到一个索引就返回，现在希望拓展为找到所有的索引
    public static List<Integer> binarySearch2(int[] arr, int left, int right, int findVal) {
        if (left > right) { //递归先写终止条件
            return new ArrayList<Integer>();
        }
        int mid = (left + right) / 2;
        //判断mid处的值与findVar的大小关系
        if (arr[mid] < findVal) {
            //findVar的索引大于mid，向右递归
            return binarySearch2(arr, mid + 1, right, findVal);
        } else if (arr[mid] > findVal) {
            //要找的值在mid左边，向左递归
            return binarySearch2(arr, left, mid, findVal);
        } else {
            //找到了
            //mid处的值等于findVar，不要直接返回mid索引，在mid的左右两边再看看有没有符合条件的
            List<Integer> list = new ArrayList<>();
            int temp = mid - 1;
            while (true) {
                //在这个循环中找到mid左边符合条件的索引
                if (temp < 0 || arr[temp] != findVal) {
                    break;
                }
                //当前的temp符合条件，加入集合
                list.add(temp);
                temp--;
            }
            // 将mid加入集合
            list.add(mid);
            temp = mid + 1;
            while (true) {
                //在这个循环中找到mid右边符合条件的索引
                if (temp > right || arr[temp] != findVal) {
                    break;
                }
                //当前的temp符合条件，加入集合
                list.add(temp);
                temp++;
            }
            //全部加入以后，返回集合
            return list;
        }
    }
}
