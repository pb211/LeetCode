package Lecode.Array;

import java.util.Arrays;

public class RP867_TransposeMatrix {
    public static void main(String[] args) {
        int[][] A = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        int[][] res = transpose(A);
        System.out.println("res = " + Arrays.deepToString(res));
    }
    public static int[][] transpose(int[][] A) {
        //矩阵转置，原来的列是现在的行，原来的行是现在的列
        int[][] res = new int[A[0].length][A.length];
        for (int i=0;i<A[0].length;i++){
            for (int j=0;j<A.length;j++){
                res[i][j]=A[j][i];
            }
        }
        return res;
    }
}
//循环遍历，行列交换即可