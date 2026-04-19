class Solution {

    public record Pair (int freq, int n) {};

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int n: nums) {
            count.put(n, count.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Pair> heap = new PriorityQueue<>((a, b) -> a.freq - b.freq);
        for (var e: count.entrySet()) {
            heap.offer(new Pair(e.getValue(), e.getKey()));
            if (heap.size() > k) heap.poll();
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = heap.poll().n;
        }
        return res;
    }
}
