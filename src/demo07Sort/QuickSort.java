package demo07Sort;

public class QuickSort {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3, 1, 2};
//        quickSort(arr, 0, arr.length - 1);
//        System.out.println("arr=" + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来40ms左右，应该比希尔快的，不知道为啥速度比他慢。。
        long t1 = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%dms", (t2 - t1));
    }

    public static void quickSort(int[] arr, int left, int right) {
        int l = left;
        int r = right;
        int temp;
        int pivot = arr[(left + right) / 2]; //中轴值
        while (l < r) {
            //l之前的元素都小于pivot
            while (arr[l] < pivot) {
                l++;
            }
            //r之后的元素都大于pivot
            while (arr[r] > pivot) {
                r--;
            }
            //到这里以后，l的元素大于等于pivot，r的元素小于等于pivot，不过还要判断一下l是不是还比r小
            if (l >= r) {
                break;
            }
            //开始交换
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;
            //考虑到l和r都指着pivot的情况，那种情况下就被锁死了，永远是这两个在换
            if (arr[l] == pivot) {
                r--;
            }
            if (arr[r] == pivot) {
                l++;
            }
        }
        //出while循环之后，已经分割成两部分了，接下来开始递归，防止栈溢出，还要判断一下
        if (l == r) {
            l++;
            r--;
        }
        if (left < r) {
            quickSort(arr, left, r);
        }
        if (right > l) {
            quickSort(arr, l, right);
        }
    }
}
