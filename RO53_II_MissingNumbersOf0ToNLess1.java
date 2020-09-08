package find;
public class RO53_II_MissingNumbersOf0ToNLess1 {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums={0,1,3};
		int res= missingNumber(nums);
		System.out.println(res);
		//System.out.println(nums.length);
	}
	public static int missingNumber(int[] nums){
		int a=0;
		for(int i=0;i<nums.length;i++){
			
			if(nums[i]!=i){
				return i;
			}
		}
		return a;
	}
}
