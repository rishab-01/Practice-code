class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        int mid = n / 2;
        int vowelCount = 0;
        
       
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            
            
            if (isVowel(c)) {
                if (i < mid) {
                    vowelCount++;
                } else {
                    vowelCount--;
                }
            }
        }
        
       
        return vowelCount == 0;
    }
    
    
    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ||
               c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}