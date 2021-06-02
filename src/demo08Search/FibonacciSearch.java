package demo08Search;

import java.util.Arrays;

public class FibonacciSearch {
    public static int maxSize = 20;

    public static void main(String[] args) {
        int[] arr = {1,8,10,89,555,721,888,901,1000,1234,2222};
        int result = fibonacciSearch(arr, 1);
        System.out.println(result);
    }

    //斐波那契查找法
    public static int fibonacciSearch(int[] arr, int key) {
        //找到数组arr中值为key的元素，首先将数组变为f[k]-1的长度
        int left = 0;
        int right = arr.length - 1;
        int[] f = fib();
        //mid之后扩充数组以后再算
        int k = 0;
        while (arr.length > (f[k] - 1)) {
            k++;
        }
        //出循环的时候，arr.length <= f[k]-1
        //temp数组的长度为f[k]-1，前arr.length与arr相同，后面都是0
        int[] temp = Arrays.copyOf(arr, f[k] - 1);
        //要把temp扩充的值赋为right处的值
        for (int i = right + 1; i < temp.length; i++) {
            temp[i] = arr[right];
        }
        //准备工作完成，接下来进行斐波那契查找
        while (left <= right) {
            int mid = left + f[k - 1] - 1;
            if (temp[mid] > key) {
                //key的索引在mid前面
                right = mid - 1;
                k--;
            } else if (temp[mid] < key) {
                //key的索引在mid后面
                left = mid + 1;
                k = k - 2;
            } else {
                //mid处的值等于key，还要判断一下，这个索引是不是扩充出来的
                if (mid < arr.length) {
                    return mid;
                } else {
                    return right;
                }
            }
        }
        //出了while循环还没找到，就是不存在，返回-1
        return -1;
    }

    //先写一个方法，用来生成斐波那契数列
    public static int[] fib() {
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2; i < maxSize; i++) {
            f[i] = f[i - 1] + f[i - 2];
        }
        return f;
    }
}
