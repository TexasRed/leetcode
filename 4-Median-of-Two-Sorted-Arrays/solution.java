public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null || nums1.length == 0) {
            return findMedian(nums2);
        }
        if (nums2 == null || nums2.length == 0) {
            return findMedian(nums1);
        }
        int len = nums1.length + nums2.length;
        if (len % 2 != 0) {
            return (double) findKth(nums1, nums2, 0, 0, len / 2 + 1);
        } else {
          return (findKth(nums1, nums2, 0, 0, len / 2) + findKth(nums1, nums2, 0, 0, len / 2 + 1)) / 2.0;  
        }
    }
    
    private double findMedian(int[] A) {
        if (A == null || A.length == 0) return 0.0;
        if (A.length % 2 == 0)
            return (A[(A.length - 1) / 2] + A[(A.length - 1) / 2 + 1]) / 2.0;
        else
            return (double) A[(A.length - 1) / 2];
    }
    
    private int findKth(int[]A, int[]B, int A_start, int B_start, int k) {
        if (A_start >= A.length) {
          return B[B_start + k - 1];
        }
        if (B_start >= B.length) {
            return A[A_start +  k - 1];
        }
        if (k == 1) {
            return Math.min(A[A_start], B[B_start]);
        }
        int A_key = (A_start + k / 2 <= A.length) ? A[A_start + k / 2 - 1] : Integer.MAX_VALUE;
        int B_key = (B_start + k / 2 <= B.length) ? B[B_start + k / 2 - 1] : Integer.MAX_VALUE;
        if (A_key > B_key) {
            return findKth(A, B, A_start, B_start + k / 2, k - k / 2);
        } else {
            return findKth(A, B, A_start + k / 2, B_start, k - k / 2);
        }
    }
}