package demo17BinarySearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] arr = {2,3,5,7,11,13,17,19,23,29,31,37};
        int target = 13;
        int resIndex = binarySearch(arr, target);
        if(resIndex == -1){
            System.out.println("没有找到");
        }else {
            System.out.println(target + "在arr中的下标为" + resIndex);
        }
    }

    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] > target) { //往左边找
                right = mid - 1;
            } else { // 往右边找
                left = mid + 1;
            }
        }
        return -1; //没找到
    }
}
