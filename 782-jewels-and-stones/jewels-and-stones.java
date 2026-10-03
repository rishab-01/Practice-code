import java.util.HashSet;
import java.util.Set;

class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Set jewelSet = new HashSet<>();
        
       
        for (char c : jewels.toCharArray()) {
            jewelSet.add(c);
        }
        
        int jewelCount = 0;
        
        
        for (char c : stones.toCharArray()) {
            if (jewelSet.contains(c)) {
                jewelCount++;
            }
        }
        
        return jewelCount;
    }
}