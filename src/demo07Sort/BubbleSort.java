package demo07Sort;

public class BubbleSort {
    public static void main(String[] args) {
//        int[] arr = {4,-1,2,1,5};
//        bubbleSort(arr);
        //用一个80000数据的arr测试一下冒泡排序的时间
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，就用System.millis那个，用小新跑出来15s左右
        long t1 = System.currentTimeMillis();
        bubbleSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%ds", (t2 - t1) / 1000);
    }

    public static void bubbleSort(int[] arr) {
        int temp = 0; //临时变量，交换的时候用
        boolean flag = false; //代表有没有进行过交换
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            //一趟排序完毕，判断一下要不要中止
            if (flag) { //交换过了
                flag = false;
            } else { //没换过，就可以终止了
                break;
            }
//            System.out.printf("第%d趟的结果：%s \n", i + 1, Arrays.toString(arr));
        }
    }
}
