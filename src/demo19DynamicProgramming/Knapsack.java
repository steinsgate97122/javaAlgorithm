package demo19DynamicProgramming;

public class Knapsack {
    public static void main(String[] args) {
        int[] w = {1, 4, 3};
        int[] value = {1500, 3000, 2000};
        int m = 4; //背包容量
        int n = value.length;
        int[][] v = new int[n + 1][m + 1]; //二维数组，v[i][j]记录了j容量下，前i种商品的最大价值
        int[][] path = new int[n + 1][m + 1]; //记录商品是否放进了背包
        //本身v的第0行第0列就为0，不必再初始化
        for (int i = 1; i < v.length; i++) { //i代表不同物品
            for (int j = 1; j < v[0].length; j++) {  //j代表不同容量
                if (w[i - 1] > j) { //物品容量大于背包容量
                    v[i][j] = v[i - 1][j];
                } else { //物品容量小于等于背包容量，比较放入新物品的最优策略与之前的最优策略
                    //v[i][j] = Math.max(v[i-1][j],value[i-1] + v[i-1][j-w[i-1]]);
                    if (v[i - 1][j] < value[i - 1] + v[i - 1][j - w[i - 1]]) {
                        v[i][j] = value[i - 1] + v[i - 1][j - w[i - 1]];
                        path[i][j] = 1;
                    } else {
                        v[i][j] = v[i - 1][j];
                    }
                }
            }
        }

        //输出v数组
        System.out.println("v数组为：");
        for (int i = 0; i < v.length; i++) {
            for (int j = 0; j < v[0].length; j++) {
                System.out.print(v[i][j] + "   ");
            }
            System.out.println();
        }

        //从后往前匹配，判断要放入什么物品
        int i = path.length - 1;
        int j = path[0].length - 1;
        while (i > 0 && j > 0) {
            if (path[i][j] == 1) {
                System.out.println("第" + i + "件物品放入背包");
                j -= w[i - 1];
            }
            i--;
        }
    }
}
