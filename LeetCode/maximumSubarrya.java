package LeetCode;

public class maximumSubarrya {

    public static int maxSubArray(int[] nums) {
        int cs = nums[0];
        int ms = nums[0];

        for(int i = 0 ; i< nums.length ; i++ ) {
            cs = Math.max(nums[i], cs + nums[i]);
            ms = Math.max(ms, cs);
        }

        return ms;
    }
    
    public static void main(String[] args) {
        int nums[] = {-1,0};
        System.out.println(maxSubArray(nums));

    }
}
