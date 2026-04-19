class Solution {
    public String minWindow(String s, String t) {
        Map<Character, Integer> cnt1 = new HashMap<>();
        for (var c : t.toCharArray()) {
            cnt1.put(c, cnt1.getOrDefault(c, 0) + 1);
        }

        int i = 0, j = 0;
        int min = Integer.MAX_VALUE;
        String res = "";
        Map<Character, Integer> cnt2 = new HashMap<>();
        int N = s.length();

        while (j <= N) {
            if (check(cnt1, cnt2)) {
                int len = j - i;
                if (len < min) {
                    min = len;
                    res = s.substring(i, j);
                }

                char c = s.charAt(i);
                if (cnt1.containsKey(c)) {
                    cnt2.put(c, cnt2.get(c) - 1);
                }
                i++;
            } else {
                if (j == N) break;
                char r = s.charAt(j++);
                if (cnt1.containsKey(r)) {
                    cnt2.put(r, cnt2.getOrDefault(r, 0) + 1);
                }
            }
        }
        return res;
    }

    private boolean check(Map<Character, Integer> cnt1, Map<Character, Integer> cnt2) {
        for (var entry : cnt1.entrySet()) {
            if (cnt2.getOrDefault(entry.getKey(), 0) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }
}
