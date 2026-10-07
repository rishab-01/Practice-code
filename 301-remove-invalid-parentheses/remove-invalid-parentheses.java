import java.util.*;

class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if (s == null) return result;

        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        queue.add(s);
        visited.add(s);

        boolean found = false;

        while (!queue.isEmpty()) {
            int size = queue.size();
            
           
            for (int k = 0; k < size; k++) {
                String current = queue.poll();

                if (isValid(current)) {
                    result.add(current);
                    found = true;
                }

                if (found) continue; 

                for (int i = 0; i < current.length(); i++) {
                    char c = current.charAt(i);
                    if (c != '(' && c != ')') continue;

                    String nextState = current.substring(0, i) + current.substring(i + 1);
                    if (!visited.contains(nextState)) {
                        visited.add(nextState);
                        queue.add(nextState);
                    }
                }
            }

           
            if (found) break;
        }

        return result;
    }

    private boolean isValid(String s) {
        int count = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') count++;
            else if (c == ')') {
                count--;
                if (count < 0) return false;
            }
        }
        return count == 0;
    }
}