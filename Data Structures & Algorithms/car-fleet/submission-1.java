class Solution {

    public record Car(int start, int speed){};

    public int carFleet(int target, int[] start, int[] speed) {
        List<Car> cars = new ArrayList<>();
        int n = start.length;
        for (int i = 0; i < n; i++) {
            cars.add(new Car(start[i], speed[i]));
        }
        cars.sort((a, b) -> Integer.compare(b.start, a.start)); // Sort in descending order
        // System.out.println(cars);

        Deque<Double> stack = new ArrayDeque<>();
        for (Car car: cars) {
            double time = (target - car.start) / (double) car.speed; // Make sure to perform floating point division

            if (!stack.isEmpty() && time <= stack.peek()) {
                // System.out.println("Skip: " + time + " " + car);
                continue;
            } else {
                stack.push(time);
                // System.out.println("Push: " + time + " " + car);
            }
        }
        return stack.size();
    }
}