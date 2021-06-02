package demo11HeapSort;

public class HeapSort {
    public static void main(String[] args) {
//        int[] arr = {4, 6, 8, 5, 9};
//        heapSort(arr);
//        System.out.println("排序后：" + Arrays.toString(arr));
        int[] arr = new int[80000];
        for (int i = 0; i < 80000; i++) {
            arr[i] = (int) (Math.random() * 8000000);
        }
        //统计一下时间，用小新跑出来12ms左右，希尔大概要24ms
        long t1 = System.currentTimeMillis();
        heapSort(arr);
        long t2 = System.currentTimeMillis();
        System.out.printf("运算时间为：%dms", (t2 - t1));
    }
  
    /**
     * 用堆排序处理数组
     *
     * @param arr 需要排序的数组
     */
    public static void heapSort(int[] arr) {
        //首先要将数组初始化为一个大顶堆，从第一个非叶子节点开始
        for (int i = arr.length - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        //现在数组已经是一个大顶堆了，将0索引处的元素与最后一个元素交换位置，迭代的调整
        int temp;
        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            //交换完毕后，将从0到i的元素重新调整为大顶堆
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 将以i节点为父节点的树调整为堆
     *
     * @param arr    以数组的形式存储二叉树
     * @param i      表示树的根节点
     * @param length 需要调整的元素个数
     */
    public static void adjustHeap(int[] arr, int i, int length) {
        //首先暂存一下i索引处的值
        int temp = arr[i];
        for (int k = 2 * i + 1; k < length; k = 2 * k + 1) {
            //k初始指向i的左子节点，之后每次循环指向本节点的左子节点
            if (k + 1 < length && arr[k] < arr[k + 1]) { //k指向左右子节点中较大的那个
                k++;
            }
            if (arr[k] > temp) { //子节点大于父节点，将子节点的值放进父节点，然后i指向子节点
                arr[i] = arr[k];
                i = k;
            } else { //父节点大于子节点，不用调整，直接退出循环
                break;
            }
        }
        //退出循环后，将i位置处的值设置为temp
        arr[i] = temp;
    }
}
