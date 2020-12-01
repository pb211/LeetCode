package Lecode.DivideAndRule;

import java.util.Arrays;

public class RO40_TheSmallestNumberOfK {
    public static void main(String[] args) {
        int[] arr = {3, 2, 1};
        int k = 2;
        int[] res = getLeastNumbers(arr,k);
        System.out.println(Arrays.toString(res));
    }
    public static int[] getLeastNumbers(int[] arr, int k) {
        Selected(arr, 0, arr.length - 1, k);
        int[] res = new int[k];
        for(int i =0;i<k;i++){
            res[i]=arr[i];
        }
        return res;
    }
    //快速排序，找到前k个小的数，放在数组前面返回即可
    public static void Selected(int[] arr, int l, int r, int k) {
        if (l >= r) {
            return;
        }
        int pos = partition(arr, l, r);
        int num = pos - l + 1;
        if (k == num) {
            return;
        } else if (k < num) {
            Selected(arr, l, pos - 1, k);
        } else {
            Selected(arr, pos + 1, r, k - num);
        }
    }
    public static int partition(int[] nums, int l, int r) {
        int pivot = nums[r];
        int i = l - 1;
        for (int j = l; j <= r - 1; ++j) {
            if (nums[j] <= pivot) {
                i = i + 1;
                int mid1 = nums[i];
                nums[i] = nums[j];
                nums[j] = mid1;
            }
        }
        int mid2 = nums[i+1];
        nums[i+1] = nums[r];
        nums[r] = mid2;
        return i + 1;
    }
}
