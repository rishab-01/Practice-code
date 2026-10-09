class Solution {
    public int minInsertions(String s) {
        int insertions = 0;
        int openNeeded = 0; 

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(') {
               
                openNeeded += 2;

               
                if (openNeeded % 2 != 0) {
                    insertions++; 
                    openNeeded--; 
                }
            } else { 
                openNeeded--;

              
                if (openNeeded < 0) {
                    insertions++; 
                    openNeeded += 2; 
                }
            }
        }

        
        return insertions + openNeeded;
    }
}