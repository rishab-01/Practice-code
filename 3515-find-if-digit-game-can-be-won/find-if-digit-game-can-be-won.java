class Solution {
    public boolean canAliceWin(int[] nums) {
        int alice=0;
        int bob=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<10){
                alice+=nums[i];
            }
            else{
                bob+=nums[i];

            }
        }
        return alice != bob;
        
    }
}