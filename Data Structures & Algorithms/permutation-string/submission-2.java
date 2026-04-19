class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;

        int[] count1 = new int[26];
        int[] count2 = new int[26];
        int N1 = s1.length(), N2 = s2.length();

        for (int i = 0; i < N1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        if (matches(count1, count2)) return true;

        for (int i = N1; i < N2; i++) {
            count2[s2.charAt(i) - 'a']++;
            count2[s2.charAt(i - N1) - 'a']--;

            if (matches(count1, count2)) return true;
        }

        return false;
    }

    private boolean matches(int[] a, int[] b) {
        for (int i = 0; i < 26; i++) {
            if (a[i] != b[i]) return false;
        }
        return true;
    }
}
