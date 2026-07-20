class Solution {

    List<String> res;

    public List<String> generateParenthesis(int n) {
        res = new ArrayList<>();
        generate(n, n, "");
        return res;
    }

    private void generate(int open, int close, String current) {
        // System.out.println("open: " + open + ", close: " + close + ", current: " + current);
        if (close < open || open < 0 || close < 0) {
            return;
        }
        if (open == 0 && close == 0) {
            res.add(current);
            return;
        }
        generate(open - 1, close, current + "(");
        generate(open, close - 1, current + ")");
    }
}
