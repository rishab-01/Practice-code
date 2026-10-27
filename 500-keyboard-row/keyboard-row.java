import java.util.*;

class Solution {
    public String[] findWords(String[] words) {
       
        String[] rows = {
            "qwertyuiop",
            "asdfghjkl", 
            "zxcvbnm"   
        };
        
       
        Map<Character, Integer> charRowMap = new HashMap<>();
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                charRowMap.put(c, i);
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            
            String lowerWord = word.toLowerCase();
            
            
            int targetRow = charRowMap.get(lowerWord.charAt(0));
            boolean isValid = true;
            
           
            for (int i = 1; i < lowerWord.length(); i++) {
                if (charRowMap.get(lowerWord.charAt(i)) != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
           
            if (isValid) {
                result.add(word);
            }
        }
        
        
        return result.toArray(new String[0]);
    }
}