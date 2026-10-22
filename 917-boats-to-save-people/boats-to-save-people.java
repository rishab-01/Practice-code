class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int ans=0;
        int low=0;
        int high=people.length-1;
        while(low<=high){
            if(people[low]+people[high]<=limit){
                low++;
                high--;
            }else{
                high--;
            }
            ans++;
        }
        return ans;
    }
}