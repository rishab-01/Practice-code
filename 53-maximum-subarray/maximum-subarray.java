class Solution {
    public int maxSubArray(int[] nums) {
         
         int n = nums.length;
         int sum=0;
         int max =  Integer.MIN_VALUE;
         for(int val:nums){
            sum+=val;
            max=Math.max(max,sum);
            if(sum<0){
                sum =0;
            }
         }
         return max;
    }
}