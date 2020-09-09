package find;

public class RP74_SearchA2dMatrix {
	public static void main(String[] args) {
		int[][] matrix={{1,   3,  5,  7},
		                {10, 11, 16, 20},
		                {23, 30, 34, 50}};
		System.out.println(matrix.length);
		System.out.println(matrix[0].length);
		int target=3;
		boolean res= searchMatrix(matrix,target);
		System.out.println(res);
	}
	public static boolean searchMatrix(int[][] matrix, int target) {
	    if (matrix.length < 1) return false;
	    int row = getRow(matrix, target);
	    return find(matrix[row], target);
	 }
	//二分查找行
	 public static int getRow(int[][] matrix, int target) {
	    int top = 0, bottom = matrix.length - 1;
	    int col = matrix[0].length - 1;
	    while (top < bottom) {
	    	int mid = (top + bottom) / 2;
	    	if (matrix[mid][col] < target){
	    		top = mid + 1;
	    	}
	    	else{
	        	bottom = mid;
	    	}
	    }
	        return top;
	 }
	//二分查找列
	 public static boolean find(int[] data, int target) {
	 	int l = 0, r = data.length - 1;
	 	while (l <= r) {
	 		int mid = (l + r) / 2;
	    	if (data[mid] == target){
	        	return true;
	    	}
	    	else if (data[mid] < target){
	        	l = mid + 1;
	    	}
	        else{
	        	r = mid - 1;
	        }
	    }
	 	return false;
	}
}
