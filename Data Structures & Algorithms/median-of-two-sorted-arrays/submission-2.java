class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        var a = nums1; // a will hold the longer array
        var b = nums2; // b will hold the shorter
        if (nums2.length > nums1.length) {
            a = nums2;
            b = nums1;
        }
        int total = a.length + b.length;
        int half = (total + 1)/2;

        int l = 0, r = b.length;
        while (l <= r) {
            int bMid = (l+r)/2; // take middle element of b
            int aMid = half - bMid; // corresponding element of a so that length of subarray on each side is equal
            
            int aLeft = aMid > 0 ? a[aMid-1] : Integer.MIN_VALUE;
            int aRight = aMid < a.length ? a[aMid] : Integer.MAX_VALUE;
            int bLeft = bMid > 0 ? b[bMid-1] : Integer.MIN_VALUE;
            int bRight = bMid < b.length ? b[bMid] : Integer.MAX_VALUE;

            if (aLeft <= bRight && bLeft <= aRight) { // correct median
                if (total % 2 != 0) return Math.max(aLeft, bLeft);
                return (Math.max(aLeft, bLeft) + Math.min(aRight, bRight)) / 2.0;
            } else if (aLeft > bRight) {
                l = bMid + 1;
            } else {
                r = bMid - 1;
            }
        }
        return -1;
    }
}
