class Solution {
    public List<String> generateParenthesis(int n) {
        int open = n, close = n;
        List<String> res = new ArrayList<>();
        getParantheses(res, open, close, "");
        return res;
    }

    void getParantheses(List<String> res, int open, int close, String cur) {
        if (open == 0 && close == 0) {
            res.add(cur);
            return;
        }
        if (open > 0) {
            getParantheses(res, open - 1, close, cur + "(");
        }
        if (close > 0 && close > open) {
            getParantheses(res, open, close - 1, cur + ")");
        }
    }
}
