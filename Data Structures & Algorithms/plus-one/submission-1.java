class Solution {
    public int[] plusOne(int[] dgts) {
        int n = dgts.length;
        for (int i = n - 1; i >= 0; i--) {
            if (dgts[i] < 9) {
                dgts[i]++;
                return dgts;
            }
            dgts[i] = 0;
        }
        int[] result = new int[n + 1];
        result[0] = 1;
        return result;
    }
}