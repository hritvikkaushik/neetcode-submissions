class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length() || t.isEmpty()) return "";

        var count = new HashMap<Character, Integer>();
        for (var c : t.toCharArray()) {
            inc(count, c);
        }

        int countLeft = count.size();
        int l = 0, r = 0, len = s.length() + 1, start = -1;

        while (r < s.length()) {
            // Expand window
            while (countLeft > 0 && r < s.length()) {
                var c = s.charAt(r);
                if (count.containsKey(c)) {
                    dec(count, c);
                    if (count.get(c) == 0) {
                        countLeft--;
                    }
                }
                r++;
            }

            // Shrink window
            while (countLeft == 0) {
                if (r - l < len) {
                    len = r - l; // Update minimum length
                    start = l;
                }
                var c = s.charAt(l);
                if (count.containsKey(c)) {
                    if (count.get(c) == 0) countLeft++;
                    inc(count, c);
                }
                l++;
            }
        }

        return len > s.length() ? "" : s.substring(start, start + len);
    }

    private void inc(Map<Character, Integer> count, Character c) {
        count.put(c, count.getOrDefault(c, 0) + 1);
    }

    private void dec(Map<Character, Integer> count, Character c) {
        count.put(c, count.get(c) - 1);
    }
}
