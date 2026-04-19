class Solution {
    public int trap(int[] arr) {
        int n = arr.length;
        int[] hl = new int[n];
        hl[0] = arr[0];
        int[] hr = new int[n];
        hr[n-1] = arr[n-1];
        for(int i=1; i<n; i++) {
            hl[i] = Math.max(hl[i-1], arr[i]);
            hr[n-i-1] = Math.max(hr[n-i], arr[n-i-1]);
        }

        int stored = 0;
        for (int i=0; i<n; i++) {
            stored += Math.min(hl[i],hr[i]) - arr[i];
        }

        return stored;
    }
}
