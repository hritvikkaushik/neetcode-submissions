class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] l = new int[n];
        int[] r = new int[n];
        l[0] = arr[0];
        r[n-1] = arr[n-1];

        for (int i = 1; i < n; i++) {
            l[i] = Math.max(l[i-1], arr[i]);
            r[n-i-1] = Math.max(r[n-i], arr[n-i-1]);
        }

        int stored = 0;
        for (int i=0; i<n; i++) {
            stored += Math.min(l[i],r[i]) - arr[i];
        }
        return stored;
    }
}
