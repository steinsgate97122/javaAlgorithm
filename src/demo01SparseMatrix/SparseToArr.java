package demo01SparseMatrix;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class SparseToArr {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis= new FileInputStream("algo\\src\\demo01sparse\\array.data");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Object o = ois.readObject();
        int[][] sparseArr = (int[][]) o;
        ois.close();
        fis.close();
        for (int i = 0; i < sparseArr.length; i++) {
            System.out.printf("%d\t%d\t%d\t\n",sparseArr[i][0],sparseArr[i][1],sparseArr[i][2]);
        }
        int[][] chessArr = new int[sparseArr[0][0]][sparseArr[0][1]];
        for (int i = 1; i < sparseArr.length; i++) {
            chessArr[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        for (int[] row : chessArr) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
