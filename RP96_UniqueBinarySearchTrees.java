package Lecode.test;

public class RP96_UniqueBinarySearchTrees {
    public static void main(String[] args) {
        int n = 3;
        int res = numTrees(n);
        System.out.println("res:"+res);
    }
    public static int numTrees(int n) {
        int G[] = new int[n+1];
        int res;
        G[0]=1;
        G[1]=1;
        for (int i=2;i<=n;i++){
            for (int j=1;j<=i;j++){
                G[i] += G[j-1] * G[i-j];
            }
        }
        res = G[n];
        return res;
    }
}
