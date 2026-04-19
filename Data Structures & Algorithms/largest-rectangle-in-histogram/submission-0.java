class Solution {
    public int largestRectangleArea(int[] h) {
        var right = nextSmallerRight(h);
        var left = nextSmallerLeft(h);
        int maxArea = 0;
        for (int i = 0; i < h.length; i++) {
            int area = h[i] * (right.get(i) - left.get(i) - 1);
            maxArea = Math.max(maxArea, area);
        }
        return maxArea;
    }

    private List<Integer> nextSmallerRight (int[] h) {
        int n = h.length;
        Deque<Integer> res = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=n-1; i>=0; i--) {
            if (stack.isEmpty()) {
                res.addFirst(n);
            } else {
                while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res.addFirst(n);
                } else {
                    res.addFirst(stack.peek());
                }
            }
            stack.push(i);
        }
        return new ArrayList(res);
    }

    private List<Integer> nextSmallerLeft (int[] h) {
        int n = h.length;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();
        for(int i=0; i < n; i++) {
            if (stack.isEmpty()) {
                res.add(-1);
            } else {
                while (!stack.isEmpty() && h[stack.peek()] >= h[i]) {
                    stack.pop();
                }
                if (stack.isEmpty()) {
                    res.add(-1);
                } else {
                    res.add(stack.peek());
                }
            }
            stack.push(i);
        }
        return res;
    }
}