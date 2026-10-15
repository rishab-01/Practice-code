class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer>map=new HashMap<>();
        int n=nums.length;
        for(int i=0; i<n;i++){
            int curr=nums[i];
            int left=target-curr;
            if(map.containsKey(left)){
                return new int[]{map.get(left),i};
            }
            map.put(curr,i);
        }
        return new int[]{-1,-1};
    }
}