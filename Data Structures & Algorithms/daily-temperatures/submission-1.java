class Solution {

    public int[] dailyTemperatures(int[] t) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> res = new ArrayDeque<>();
        int n = t.length;
        for (int i = n-1; i >= 0; i--) {
            while (!stack.isEmpty() && t[stack.peek()] <= t[i]) {
                stack.pop();
            }
            res.addFirst(stack.isEmpty() ? 0 : stack.peek()-i);
            stack.push(i);
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}
