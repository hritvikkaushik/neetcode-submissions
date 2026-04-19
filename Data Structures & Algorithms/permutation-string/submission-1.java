class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length() < s1.length()) return false;
        Map<Character, Integer> count1 = new HashMap<>();
        for(char c: s1.toCharArray()) {
            count1.put(c, count1.getOrDefault(c, 0) + 1);
        }
        int i = 0, j = 0;
        int N1 = s1.length(), N2 = s2.length();
        Map<Character, Integer> count2 = new HashMap<>();
        while (j < N1) {
            var r = s2.charAt(j++);
            count2.put(r, count2.getOrDefault(r, 0) + 1);
        }
        while (j < N2) {
            if (count2.equals(count1)) {
                return true;
            }
            var l = s2.charAt(i++);
            count2.put(l, count2.get(l) - 1);
            if (count2.get(l) == 0) count2.remove(l);
            var r = s2.charAt(j++);
            count2.put(r, count2.getOrDefault(r, 0) + 1);
        }
        return count2.equals(count1);
    }
}
