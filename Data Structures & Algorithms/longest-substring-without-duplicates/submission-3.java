class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        Set<Character> seen = new HashSet<>();
        int l = 0, r = 0;
        int res = 0;
        while (r < s.length()) {
            while (seen.contains(s.charAt(r))) {
                seen.remove(s.charAt(l));
                l++;
            }
            seen.add(s.charAt(r));
            res = Math.max(res, r - l + 1);
            r++;
        }
        return res;
    }
}
