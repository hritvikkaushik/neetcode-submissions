class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        char[] sSorted = s.toCharArray();
        Arrays.sort(sSorted);
        char[] tSorted = t.toCharArray();
        Arrays.sort(tSorted);
        return Arrays.equals(sSorted, tSorted);
    }
}
