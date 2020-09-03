package Sort;

import java.util.Arrays;

public class RP_ColorClassify {
	public static void main(String args[]){
		int nums[]={2,0,2,1,1,0};
		sortColors(nums);

        System.out.println("res = " + Arrays.toString(nums));
	}
	public static void sortColors(int[] nums){
		int p1=0;
		int p2=nums.length-1;
		int cur=0;
		//交换的中间变量
		int temp;
		while(p2>=cur){
			if(nums[cur]==0){
				//交换数据
				temp=nums[p1];
				nums[p1]=nums[cur];
				nums[cur]=temp;
				p1++;
				cur++;
			}
			else if(nums[cur]==2){
				temp=nums[p2];
				nums[p2]=nums[cur];
				nums[cur]=temp;
				p2--;
				cur++;
			}
			else{
				cur++;
			}
		}
	}
}
