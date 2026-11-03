class Solution {
    public int minMoves(int[] nums) {
        int maxVal = nums[0];
        for (int num : nums) {
            if (num > maxVal) {
                maxVal = num;
            }
        }
        
        int moves = 0;
        for (int num : nums) {
            moves += (maxVal - num);
        }
        
        return moves;
    }
}