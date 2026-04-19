class TimeMap {

    public record Pair(int t, String v) {};

    Map<String, List<Pair>> store;

    public TimeMap() {
        store = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        store.computeIfAbsent(key, k -> new ArrayList<>()).add(new Pair(timestamp, value));
    }
    
    public String get(String key, int timestamp) {
        var values = store.getOrDefault(key, new ArrayList<>());
        int left = 0, right = values.size() - 1;
        String result = "";

        while (left <= right) {
            int mid = left + (right - left)/2;
            if (values.get(mid).t <= timestamp) {
                result = values.get(mid).v;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }        

        return result;
    }
}
