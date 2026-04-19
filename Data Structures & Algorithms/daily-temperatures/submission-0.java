class Solution {
    public int[] dailyTemperatures(int[] t) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> res = new ArrayDeque<>();
        int n = t.length;
        for (int i = n-1; i >= 0; i--) {
            int temp = t[i];
            if (stack.isEmpty()) {
                res.addFirst(0);
            } else {
                while (!stack.isEmpty() && t[stack.peek()] <= temp) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res.addFirst(0);
                } else {
                    var next = stack.peek();
                    res.addFirst(next - i);
                }
            }
            stack.push(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}