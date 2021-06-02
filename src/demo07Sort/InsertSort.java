package demo07Sort;

public class InsertSort {
    public static void main(String[] args) {
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来1000ms左右
        long t1 = System.currentTimeMillis();
        insertSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%dms", (t2 - t1));
    }

    public static void insertSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int index = i - 1;
            while (index >= 0 && arr[index] > value) {
                arr[index + 1] = arr[index];
                index--;
            }
            arr[index + 1] = value;
//            System.out.printf("第%d次的排序结果为：%s \n", i, Arrays.toString(arr));
        }
    }
}
