package demo07Sort;

public class RadixSort {
    public static void main(String[] args) {
//        int[] arr = {53, 3, 542, 748, 14, 214};
//        radixSort(arr);
//        System.out.println(Arrays.toString(arr));
        int[] arr = new int[8000000];
        for (int i = 0; i < 8000000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来46ms左右，看起来比快排慢，但800万个数据也只要490ms
        long t1 = System.currentTimeMillis();
        radixSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%dms", (t2 - t1));
    }

    public static void radixSort(int[] arr) {
        //基数排序，先准备10个一维数组
        int[][] bucket = new int[10][arr.length];

        //记录每个一维数组中记录的元素个数
        int[] bucketCount = new int[10];

        //先找到最大元素的位数
        int max = arr[0];
        for (int i : arr) {
            if (max < i) {
                max = i;
            }
        }// 找到max了
        int maxLength = (max + "").length();

        //从个位开始取，一位位拿进对应个一维数组中去
        for (int i = 0, n = 1; i < maxLength; i++, n *= 10) {
            for (int j = 0; j < arr.length; j++) {
                int digitOfEle = (arr[j] / n) % 10; //拿到相应位
                bucket[digitOfEle][bucketCount[digitOfEle]] = arr[j]; //塞进对应数组
                bucketCount[digitOfEle]++;
            }
            // 都塞完以后，再拿出来，遍历10个数组
            int arrIndex = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < bucketCount[j]; k++) {
                    // 遍历到当前数组，把存着的元素放进arr
                    arr[arrIndex] = bucket[j][k];
                    arrIndex++;
                }
                //把count清零一下
                bucketCount[j] = 0;
            }
            // arr更新完毕
        }
    }
}
