package Sort;

import java.util.Arrays;

public class RI1616_SubSortLcci {
	public static void main(String[] args) {
		int[] array={1,2,4,7,10,11,7,12,6,7,16,18,19};
		int[] res=subSort(array);
		System.out.println(Arrays.toString(res));
	}
	 public static int[] subSort(int[] array) {
	        if(array == null || array.length == 0){
	        	return new int[]{-1, -1};
	        }
	        int start = -1, end = -1;
	        int lastmin = Integer.MAX_VALUE;
	        int lastmax = Integer.MIN_VALUE;
	        for(int i = 0,j=array.length-1;i<array.length;i++,j--){
	            if(array[i] < lastmax)
	                end = i;
	            else
	                lastmax = array[i];
	            
	            if(array[j] > lastmin)
	                start = j;
	            else
	                lastmin = array[j];
	        }
	        return new int[]{start ,end};
	 }
}
