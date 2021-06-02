package demo07Sort;

public class SelectSort {
    public static void main(String[] args) {
//        int[] arr = {101,34,119,1};
//        selectSort(arr);
        //用一个80000数据的arr测试一下冒泡排序的时间
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来3s左右
        long t1 = System.currentTimeMillis();
        selectSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%ds", (t2 - t1) / 1000);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int min = arr[i];
            int index = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (min > arr[j]) {
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i) {
                arr[index] = arr[i];
                arr[i] = min;
            }
//            System.out.printf("第%d次的选择排序结果为：%s\n", (i + 1), Arrays.toString(arr));
        }
    }
}
