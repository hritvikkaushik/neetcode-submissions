class Solution {
    public int lengthOfLongestSubstring(String s) {
        var seen = new HashSet<Character>();
        int i=0, j=0;
        int max = 0;

        while(j < s.length()) {
            while (seen.contains(s.charAt(j))) {
                seen.remove(s.charAt(i));
                i++;
            }
            seen.add(s.charAt(j));
            max = Math.max(max, j-i+1);
            j++;
        }
        return max;
    }
}
