class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();
        int i = 0, j = n - 1;
        while (i <= j) {
            var l = s.charAt(i);
            var r = s.charAt(j);
            if (!Character.isLetterOrDigit(l)) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(r)) {
                j--;
                continue;
            }
            if (Character.toLowerCase(l) != Character.toLowerCase(r)) {
                return false;
            }
            i++; j--;
        }
        return true;
    }
}
