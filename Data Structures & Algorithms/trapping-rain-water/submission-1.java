class Solution {
    public int trap(int[] arr) {
        int n = arr.length;

        int[] left = new int[n]; // left[i] = largest value in arr[0...i] -> [0, 2, 2, 3, 3, 3, 3, 3, 3, 3]
        left[0] = arr[0];

        int[] right = new int[n]; // right[i] = largest value in arr[i...n] -> [3, 3, 3, 3, 3, 3, 3, 3, 2, 1]
        right[n-1] = arr[n-1];

        for(int i=1; i<n; i++) {
            left[i] = Math.max(left[i-1], arr[i]);
            right[n-i-1] = Math.max(right[n-i], arr[n-i-1]);
        }

        int stored = 0;
        for (int i=0; i<n; i++) {
            stored += Math.min(left[i], right[i]) - arr[i];
        }

        return stored;
    }
}
