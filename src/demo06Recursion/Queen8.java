package demo06Recursion;

public class Queen8 {
    //构造方法就不写了，直接定义在里面
    private int max = 8;
    private int[] arr = new int[max];
    private int count = 0;

    public static void main(String[] args) {
        Queen8 queen8 = new Queen8();
        queen8.check(0);
        System.out.printf("总共有%d种摆法。\n",queen8.count);
    }

    //把第n行的棋子塞进棋盘
    private void check(int n) {
        //结束条件
        if (n == max) {
            print();
            return;
        }
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            if (judge(n)) {
                check(n + 1);
            }
        }
    }

    //当前第n行与前面n-1行是否有冲突，写个方法判断一下
    private boolean judge(int n) {
        for (int i = 0; i < n; i++) {
            if (arr[i] == arr[n] || Math.abs(i - n) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }

    private void print() {
        count++;
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println("");
    }
}
