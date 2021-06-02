package demo06Recursion;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class Maze {
    public static void main(String[] args) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int index = 1; index <= 8; index++) {
            //先创建迷宫
            int[][] map = new int[8][7];
            //首尾两行置为1
            for (int i = 0; i < 7; i++) {
                map[0][i] = 1;
                map[7][i] = 1;
            }
            //前后两列置为1
            for (int i = 0; i < 8; i++) {
                map[i][0] = 1;
                map[i][6] = 1;
            }

            map[3][1] = 1;
            map[3][2] = 1;
            map[2][4] = 1;

//            //显示一下
//            for (int i = 0; i < 8; i++) {
//                for (int j = 0; j < 7; j++) {
//                    System.out.print(map[i][j] + " ");
//                }
//                System.out.println();
//            }
            if (index == 1) {
                setWay1(map, 1, 1);
                System.out.println();
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 2) {
                setWay2(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 3) {
                setWay3(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 4) {
                setWay4(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 5) {
                setWay5(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 6) {
                setWay6(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 7) {
                setWay7(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            if (index == 8) {
                setWay8(map, 1, 1);
                int i = countArr(map);
                hashMap.put(index, i);
            }
            System.out.printf("第%d次找到的路径为：\n", index);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 7; j++) {
                    System.out.print(map[i][j] + " ");
                }
                System.out.println();
            }
        }
        Collection<Integer> values = hashMap.values();
        System.out.println("最短路径为" + Collections.min(values));

//        System.out.println("找到路径了：");
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 7; j++) {
//                System.out.print(map[i][j] + " ");
//            }
//            System.out.println();
//        }
    }

    //用来计算路径长度
    public static int countArr(int[][] map) {
        int num = 0;
        for (int[] row : map) {
            for (int item : row) {
                if (item == 2) {
                    num++;
                }
            }
        }
        return num - 1;
    }

    // 下右上左
    public static boolean setWay1(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            // 下右上左
            if (setWay1(map, i + 1, j)) {
                System.out.printf("(%d,%d) ",i+1,j);
                return true;
            } else if (setWay1(map, i, j + 1)) {
                System.out.printf("(%d,%d) ",i,j+1);
                return true;
            } else if (setWay1(map, i - 1, j)) {
                System.out.printf("(%d,%d) ",i-1,j);
                return true;
            } else if (setWay1(map, i, j - 1)) {
                System.out.printf("(%d,%d) ",i,j-1);
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 右上左下
    public static boolean setWay2(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay2(map, i, j + 1)) {
                return true;
            } else if (setWay2(map, i - 1, j)) {
                return true;
            } else if (setWay2(map, i, j - 1)) {
                return true;
            } else if (setWay2(map, i + 1, j)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 上左下右
    public static boolean setWay3(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay3(map, i - 1, j)) {
                return true;
            } else if (setWay3(map, i, j - 1)) {
                return true;
            } else if (setWay3(map, i + 1, j)) {
                return true;
            } else if (setWay3(map, i, j + 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 左下右上
    public static boolean setWay4(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay4(map, i, j - 1)) {
                return true;
            } else if (setWay4(map, i + 1, j)) {
                return true;
            } else if (setWay4(map, i, j + 1)) {
                return true;
            } else if (setWay4(map, i - 1, j)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 下左上右
    public static boolean setWay5(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay5(map, i + 1, j)) {
                return true;
            } else if (setWay5(map, i, j - 1)) {
                return true;
            } else if (setWay5(map, i - 1, j)) {
                return true;
            } else if (setWay5(map, i, j + 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 左上右下
    public static boolean setWay6(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay6(map, i, j - 1)) {
                return true;
            } else if (setWay6(map, i - 1, j)) {
                return true;
            } else if (setWay6(map, i, j + 1)) {
                return true;
            } else if (setWay6(map, i + 1, j)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 上右下左
    public static boolean setWay7(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay7(map, i - 1, j)) {
                return true;
            } else if (setWay7(map, i, j + 1)) {
                return true;
            } else if (setWay7(map, i + 1, j)) {
                return true;
            } else if (setWay7(map, i, j - 1)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }

    // 右下左上
    public static boolean setWay8(int[][] map, int i, int j) {
        if (map[6][5] == 2) {
            return true;
        }
        if (map[i][j] == 0) {
            map[i][j] = 2;
            if (setWay8(map, i, j + 1)) {
                return true;
            } else if (setWay8(map, i + 1, j)) {
                return true;
            } else if (setWay8(map, i, j - 1)) {
                return true;
            } else if (setWay8(map, i - 1, j)) {
                return true;
            } else {
                map[i][j] = 3;
                return false;
            }
        } else {
            return false;
        }
    }
}
