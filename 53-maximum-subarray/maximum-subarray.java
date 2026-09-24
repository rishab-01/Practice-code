class Solution {
    public int maxSubArray(int[] nums) {int maxSum = nums[0];
        int currentSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Decide whether to add current element to the existing subarray 
            // or start a new subarray from the current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            
            // Keep track of the overall maximum sum found so far
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }
}
      