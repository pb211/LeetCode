package Lecode.Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RI1619_PondSizesLcci {
    public static void main(String[] args) {
        int[][] land = {{0, 2, 1, 0}, {0, 1, 0, 1}, {1, 1, 0, 1}, {0, 1, 0, 1},};
        int[] res = pondSizes(land);
        System.out.println("res = " + Arrays.toString(res));
    }
    public static int[] pondSizes(int[][] land) {
        //定义一个ArrayList数组,向其中添加结果集
        List<Integer> list = new ArrayList<>();
        int temp;
        // 遍历矩阵每个元素
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[0].length; j++) {
                temp = findPool(land, i, j);
                if (temp != 0) list.add(temp);
            }
        }
         //List<Integer>转int[]
         int[] res = new int[list.size()];
         for (int i = 0; i < res.length; i++) {
           res[i] = list.get(i);
         }
        Arrays.sort(res);
        return res;
    }
    public static int findPool(int[][] land, int x, int y) {
        int num = 0;
        if (x < 0 || x >= land.length || y < 0 ||y>=land[0].length||land[x][y]!=0) {
            return num;
        }
        num++;
        // 如果为0，就转换为-1，避免重复搜索
        land[x][y] = -1;
        //搜索八个方向
        num += findPool(land, x + 1, y);
        num += findPool(land, x - 1, y);
        num += findPool(land, x, y + 1);
        num += findPool(land, x, y - 1);
        num += findPool(land, x + 1, y + 1);
        num += findPool(land, x + 1, y - 1);
        num += findPool(land, x - 1, y + 1);
        num += findPool(land, x - 1, y - 1);
        return num;
    }
}
