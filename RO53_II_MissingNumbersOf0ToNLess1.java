package find;
public class RO53_II_MissingNumbersOf0ToNLess1 {
	public static void main(String[] args) {
		int[] nums={0,1,3};
		int res= missingNumber(nums);
		System.out.println(res);
	}
	public static int missingNumber(int[] nums){
		 if(nums.length<=1){
	            if(nums[0]==0){return 1;}
	            if(nums[0]==1){return 0;}
	        }
			for(int i=0;i<nums.length;i++){
				if(nums[i]!=i){
					return i;
				}
	          
			}
			return nums.length;
	    }
}
