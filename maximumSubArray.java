
public class maximumSubArray {

	public static void main(String[] args) {
		
		int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
		System.out.println(maxSubArray(arr));

	}
	
	public static int maxSubArray(int[] nums) {
        int sum = nums[0];
        int globalSum = nums[0];
        for(int  i = 1; i<nums.length; i++){
            if(sum + nums[i] > nums[i])
                sum+=nums[i];
            else
                sum = nums[i];
            if(sum > globalSum)
            	globalSum = sum;
        }
        return globalSum;
    }

}
