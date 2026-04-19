class Solution {
    public int lengthOfLongestSubstring(String s) {
        final int N = s.length();
        if (N < 2) return N;
        int l = 0, r = 0, res = 1;
        Set<Character> seen = new HashSet<>();
        while (r < N) {
            if (seen.add(s.charAt(r))) {
                r++;
                var cur = r - l;
                res = Math.max(res, cur);
            } else {
                seen.remove(s.charAt(l++));
            }
        }
        return res;
    }
}