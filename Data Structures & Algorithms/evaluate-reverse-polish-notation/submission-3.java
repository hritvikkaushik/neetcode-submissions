class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(var token: tokens) {
            if (token.equals("+")) {
                var a = stack.pop();
                var b = stack.pop();
                stack.push(a + b);
            } else if (token.equals("*")) {
                var a = stack.pop();
                var b = stack.pop();
                stack.push(a * b);
            } else if (token.equals("-")) {
                var b = stack.pop();
                var a = stack.pop();
                stack.push(a - b);
            } else if (token.equals("/")) {
                var b = stack.pop();
                var a = stack.pop();
                stack.push(a / b);
            } else {
                var n = Integer.parseInt(token);
                stack.push(n);
            }
        }
        return stack.pop();
    }
}
