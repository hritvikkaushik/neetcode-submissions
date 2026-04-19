class Solution {
    public int largestRectangleArea(int[] heights) {
        var nsl = nextSmallerLeft(heights);
        var nsr = nextSmallerRight(heights);
        int maxArea = -1;
        int n = heights.length;
        for (int i = 0; i < n; i++) {
            var area = (nsr[i] - nsl[i] - 1) * heights[i];
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }

    int[] nextSmallerLeft (int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] res = new int[heights.length];
        for (int i = 0; i < heights.length; i++) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }
        // System.out.println("NSL: ");
        // for (int n: res) System.out.print(n + " ");
        return res;
    }

    int[] nextSmallerRight (int[] heights) {
        Deque<Integer> stack = new ArrayDeque<>();
        Deque<Integer> res = new ArrayDeque<>();
        for (int i = heights.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            res.addFirst(stack.isEmpty() ? heights.length : stack.peek());
            stack.push(i);
        }
        var out = res.stream().mapToInt(Integer::intValue).toArray();
        // System.out.println("NSR: ");
        // for (int n: out) System.out.print(n + " ");
        return out;
    }
}
