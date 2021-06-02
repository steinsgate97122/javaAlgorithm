package demo07Sort;

//归并排序，分而治之
public class MergeSort {
    public static void main(String[] args) {
//        int[] arr = {8,7,6,5,4,3,2,1};
//        int[] temp = new int[arr.length];
//        mergeSort(arr,0,arr.length-1,temp);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[80000];
        int[] temp = new int[arr.length];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来14ms左右，我们归并排序真是太快了！因为他用了temp，本质是空间换时间
        long t1 = System.currentTimeMillis();
        mergeSort(arr, 0, arr.length - 1, temp);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%dms", (t2 - t1));
    }

    public static void mergeSort(int[] arr, int left, int right, int[] temp) {
        //函数功能是将left到right进行归并排序
        if (left < right) { //递归的终止条件
            int mid = (left + right) / 2;
            //对left到mid归并排序
            mergeSort(arr, left, mid, temp);
            //对mid+1到right归并排序
            mergeSort(arr, mid + 1, right, temp);

            //两个子序列已经有序，将其merge起来
            merge(arr, left, right, mid, temp);
        }
    }

    public static void merge(int[] arr, int left, int right, int mid, int[] temp) {
        //已经得到了两个有序的子序列，将其merge起来
        int l = left; //第一个子序列的起始点
        int r = mid + 1; //第二个子序列的起始点
        int t = 0; //temp的起始点
        while (l <= mid && r <= right) {
            //将对应元素放进temp
            if (arr[l] <= arr[r]) {
                temp[t] = arr[l];
                l++;
                t++;
            } else {
                temp[t] = arr[r];
                r++;
                t++;
            }
        }
        //到这里，有一个子序列已经遍历完了
        while (l <= mid) {
            temp[t] = arr[l];
            t++;
            l++;
        }
        while (r <= right) {
            temp[t] = arr[r];
            t++;
            r++;
        }
        //将temp拷贝回原先arr的相应位置，即left到right
        l = left;
        for (int i = 0; i < t; i++) {
            arr[l] = temp[i];
            l++;
        }
    }
}
