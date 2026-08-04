class Solution {

    private static final char[][] MAP = {
        {},                     // 0
        {},                     // 1
        {'a', 'b', 'c'},        // 2
        {'d', 'e', 'f'},        // 3
        {'g', 'h', 'i'},        // 4
        {'j', 'k', 'l'},        // 5
        {'m', 'n', 'o'},        // 6
        {'p', 'q', 'r', 's'},   // 7
        {'t', 'u', 'v'},        // 8
        {'w', 'x', 'y', 'z'}    // 9
    };

    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.length() == 0) {
            return res;
        }

        StringBuilder cur = new StringBuilder();
        search(digits, 0, cur, res);
        return res;
    }

    private void search(String digits, int idx, StringBuilder cur, List<String> res) {
        if (idx == digits.length()) {
            res.add(cur.toString());
            return;
        }

        int digit = digits.charAt(idx) - '0';
        for (char c : MAP[digit]) {
            cur.append(c);
            search(digits, idx + 1, cur, res);
            cur.deleteCharAt(cur.length() - 1);
        }
    }
}