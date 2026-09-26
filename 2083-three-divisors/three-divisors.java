class Solution {
    public boolean isThree(int n) {
        int root = (int) Math.sqrt(n);
        if(root*root !=n||n<=3){
            return false;
        }
        return isPrime(root);
        
    }
    private boolean isPrime(int val) {
        if (val < 2) return false;
        for (int i = 2; i * i <= val; i++) {
            if (val % i == 0) return false;
        }
        return true;
    }
}