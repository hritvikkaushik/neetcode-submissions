class Solution {
    List<List<String>> res = new ArrayList<>();

    public List<List<String>> partition(String s) {
        search(s, 0, new ArrayList<>());
        return res;
    }

    private void search(String s, int start, List<String> cur) {
        if (start == s.length()) {
            res.add(new ArrayList<>(cur));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String sub = s.substring(start, end + 1);
            if (isPalindrome(sub)) {
                cur.add(sub);
                search(s, end + 1, cur);
                cur.removeLast();
            }
        }
    }

    private boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
