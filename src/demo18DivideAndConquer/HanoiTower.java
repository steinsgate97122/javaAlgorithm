package demo18DivideAndConquer;

//汉诺塔
public class HanoiTower {
    public static int count = 0;

    public static void main(String[] args) {
        hanoiTower(5,'A','B','C');
        System.out.println("总共移动了 "+count+" 次");
    }

    /**
     * 函数功能：将num层的汉诺塔从a移动到c，借助中间柱子b
     *
     * @param num 汉诺塔的层数
     * @param a   柱子1
     * @param b   柱子2
     * @param c   柱子3
     */
    public static void hanoiTower(int num, char a, char b, char c) {
        if (num == 1) {
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            count++;
        } else {
            hanoiTower(num - 1, a, c, b);
            System.out.println("第" + num + "个盘从 " + a + "->" + c);
            count++;
            hanoiTower(num - 1, b, a, c);
        }
    }
}
