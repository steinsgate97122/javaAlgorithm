package demo08Search;

public class OrderSearch {
    public static void main(String[] args) {
        int[] arr = {14,55,-5,67,29,4,-99,44};
        int i = orderSearch(arr, -6);
        if(i != -1){
            System.out.printf("索引为：%d",i);
        }else {
            System.out.println("没有查找到");
        }
    }

    public static int orderSearch(int[] arr, int findVal) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == findVal) {
                return i;
            }
        }
        return -1;
    }
}
