/*
at most k substitutions => length of string - count of most frequent character in the string <= k
*/
class Solution {
    public int characterReplacement(String s, int k) {
        int i = 0, j = 0;
        Map<Character, Integer> count = new HashMap<>();
        int maxF = 0;
        int N = s.length();
        int res = 0;
        while (j < N) {
            var r = s.charAt(j);
            count.put(r, count.getOrDefault(r, 0) + 1);
            maxF = Math.max(maxF, count.get(r));
            
            // We do not update maxF in the below loop, because it does not affect our result.
            // For a new result, we need maxF to increase
            while ((j - i + 1) - maxF > k) {
                var l = s.charAt(i);
                count.put(l, count.get(l) - 1);
                i++;
            }       
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
