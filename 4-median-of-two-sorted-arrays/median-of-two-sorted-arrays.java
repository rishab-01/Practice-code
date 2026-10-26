class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] A = nums1;
        int[] B = nums2;

        if (A.length > B.length) {
            int[] temp = A;
            A = B;
            B = temp;
        }

        int m = A.length;
        int n = B.length;

        int low = 0, high = m;
        int half = (m + n + 1) / 2;

        while (low <= high) {
            int i = (low + high) / 2;
            int j = half - i;

            int leftA = (i == 0) ? Integer.MIN_VALUE : A[i - 1];
            int rightA = (i == m) ? Integer.MAX_VALUE : A[i];

            int leftB = (j == 0) ? Integer.MIN_VALUE : B[j - 1];
            int rightB = (j == n) ? Integer.MAX_VALUE : B[j];

            if (leftA <= rightB && leftB <= rightA) {
                if ((m + n) % 2 == 1) {
                    return Math.max(leftA, leftB);
                }

                return ((double) Math.max(leftA, leftB)
                        + Math.min(rightA, rightB)) / 2.0;
            } else if (leftA > rightB) {
                high = i - 1;
            } else {
                low = i + 1;
            }
        }

        return 0.0;
    }
}