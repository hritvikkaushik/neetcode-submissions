class Solution {
    public int[] plusOne(int[] dgts) {
        int i = 0;
        boolean carry = true;

        for (int j = dgts.length - 1; j >= 0; j--) {
            if (carry) {
                if (dgts[j] == 9) {
                    dgts[j] = 0;
                } else {
                    dgts[j]++;
                    carry = false;
                }
            }
        }

        if (carry) {
            int[] result = new int[dgts.length + 1];
            result[0] = 1;
            System.arraycopy(dgts, 0, result, 1, dgts.length);
            return result;
        }

        return dgts;
    }
}
