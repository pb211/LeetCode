package Lecode.Array;

import java.util.Arrays;

public class RP977_SquaresOfASortedArray {
    public static void main(String[] args) {
        int A[] = {-4,-1,0,3,10};
        int []res = sortedSquares(A);
        System.out.println(Arrays.toString(res));
    }
     //一、直接计算平方后排序
    public static int[] sortedSquares1(int[] A) {
        int []res = new int[A.length];
        for(int i=0;i<A.length;i++){
            res[i]=A[i]*A[i];
        }
        Arrays.sort(res);
        return res;
    }
     //二、双指针从两边顺序寻找最大值插入res
    public static int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int left=0;
        int right=A.length-1;
        int index=A.length-1;
        while(index>=0){
            int AL=A[left]*A[left];
            int AR=A[right]*A[right];
            if(AL>AR){
                res[index]=AL;
                left++;
                index--;
            }else{
                res[index]=AR;
                right--;
                index--;
            }
        }
        return res;
    }
}
