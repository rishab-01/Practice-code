import java.util.*;

class Solution {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<List<Integer>> diagonalGroups = new ArrayList<>();
        
        
        for (int r = nums.size() - 1; r >= 0; r--) {
            for (int c = 0; c < nums.get(r).size(); c++) {
                int sum = r + c;
                
               
                while (diagonalGroups.size() <= sum) {
                    diagonalGroups.add(new ArrayList<>());
                }
                
                
                diagonalGroups.get(sum).add(nums.get(r).get(c));
            }
        }
        
        
        int totalElements = 0;
        for (List<Integer> group : diagonalGroups) {
            totalElements += group.size();
        }
        
        int[] result = new int[totalElements];
        int idx = 0;
        for (List<Integer> group : diagonalGroups) {
            for (int val : group) {
                result[idx++] = val;
            }
        }
        
        return result;
    }
}