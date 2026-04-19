class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() < 2) return s.length();
        int l = 0, r = 0;
        int max = 0;
        Set<Character> seen = new HashSet<>();
        var str = s.toCharArray();
        while(r < str.length) {
            while (r < str.length && seen.add(str[r])) {
                r++;
                max = Math.max(max, r - l);
            }
            while (r < str.length && seen.contains(str[r]) && l < r) {
                seen.remove(str[l]);
                l++;
            }
        }
        return max;
    }
}
