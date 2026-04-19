class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0, maxFreq = 0, maxLength = 0;
        int[] count = new int[26];

        for (int r=0; r<n; r++) {
            count[s.charAt(r) - 'A']++;
            maxFreq = Math.max(maxFreq, count[s.charAt(r) - 'A']);

            if (r-l+1 - maxFreq > k) {
                count[s.charAt(l) - 'A']--;
                l++;
            }

            maxLength = Math.max(maxLength, r-l+1);
        }

        return maxLength;
    }
}
