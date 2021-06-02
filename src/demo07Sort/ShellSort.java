package demo07Sort;

public class ShellSort {
    public static void main(String[] args) {
//        int[] arr = {8, 9, 1, 7, 2, 3, 5, 4, 6, 0};
//        shellSort2(arr);
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来24ms左右
        long t1 = System.currentTimeMillis();
        shellSort2(arr);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%dms", (t2 - t1));
    }

    //用移位法写希尔排序，只要24ms，所以说交换数组元素是很耗费资源的
    private static void shellSort2(int[] arr) {
        int index = 0;
        int value = 0;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                //直接用i来表示要插入的元素，插入排序
                index = i - gap;
                value = arr[i];
                while ((index >= 0) && (value < arr[index])) {
                    //将arr[index]后移
                    arr[index + gap] = arr[index];
                    index = index - gap;
                }
                //出循环时，arr[index] < value了，那么value应该放在arr[index+gap]的位置
                arr[index + gap] = value;
            }
        }
//        System.out.println(Arrays.toString(arr));
    }

    //用交换法写希尔排序，这样交换次数过多，不推荐,大概要跑10多秒
    private static void shellSort1(int[] arr) {
        int temp;
        for (int gap = arr.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < arr.length; i++) {
                for (int j = i; j >= gap; j -= gap) {
                    if (arr[j] < arr[j - gap]) {
                        temp = arr[j];
                        arr[j] = arr[j - gap];
                        arr[j - gap] = temp;
                    }
                }
            }
//            System.out.println(Arrays.toString(arr));
        }
    }


}
