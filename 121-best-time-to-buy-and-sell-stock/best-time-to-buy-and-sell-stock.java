class Solution {
    public int maxProfit(int[] prices) {
        int buy=Integer.MAX_VALUE;
        int sell = 0;
        for(int val:prices){
            if(val<buy){
                buy=val;
            }
            sell=Math.max(sell,val-buy);
        }
        return sell;
        
    }
}