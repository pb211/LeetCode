package Lecode.Array;
import java.util.Arrays;

public class RP73_SetMatrixZeroes {
    public static void main(String[] args) {
        int[][] matrix={{0,1,2,0},
                        {3,4,5,2},
                        {1,3,1,5}};
        setZeroes(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }
    public static void setZeroes(int[][] matrix) {
        //记录行数为0的地点，列数为0的地点
        int is[]=new int[matrix.length];
        int js[]=new int[matrix[0].length];
        //遍历数组记录行列
        for(int i=0;i<matrix.length;i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    is[i]=1;
                    js[j]=1;
                }
            }
        }
        //把记录的数对应的行置为0
        for(int i=0;i<is.length;i++){
            if (is[i]==1){
                for (int z=0;z<matrix[0].length;z++){
                    matrix[i][z]=0;
                }
            }
        }
        //把记录的数对应的列记为0
        for(int j=0;j<js.length;j++){
            if (js[j]==1){
                for (int z=0;z<matrix.length;z++){
                    matrix[z][j]=0;
                }
            }
        }
    }
}
