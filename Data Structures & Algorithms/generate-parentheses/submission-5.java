class Solution {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(n, n, new StringBuilder(2 * n));
        return res;
    }

    private void generate(int open, int close, StringBuilder current) {
        if (open == 0 && close == 0) {
            res.add(current.toString());
            return;
        }
        if (open > 0) {
            current.append('(');
            generate(open - 1, close, current);
            current.setLength(current.length() - 1);
        }

        if (close > open) {
            current.append(')');
            generate(open, close - 1, current);
            current.setLength(current.length() - 1);
        }
    }
}
