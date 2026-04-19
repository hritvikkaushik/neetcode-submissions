class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false; // If s1 is longer, s2 cannot contain its permutation

        int[] count1 = new int[26]; // Frequency array for s1
        int[] count2 = new int[26]; // Frequency array for the current window in s2

        // Build frequency array for s1 and the first window in s2
        for (int i = 0; i < len1; i++) {
            count1[s1.charAt(i) - 'a']++;
            count2[s2.charAt(i) - 'a']++;
        }

        // Check if the first window matches
        if (matches(count1, count2)) return true;

        // Slide the window over s2
        for (int i = len1; i < len2; i++) {
            count2[s2.charAt(i) - 'a']++; // Add the next character in the window
            count2[s2.charAt(i - len1) - 'a']--; // Remove the character that slides out

            // Check if the updated window matches
            if (matches(count1, count2)) return true;
        }

        return false; // No matching window found
    }

    private boolean matches(int[] count1, int[] count2) {
        for (int i = 0; i < 26; i++) {
            if (count1[i] != count2[i]) return false;
        }
        return true;
    }
}
