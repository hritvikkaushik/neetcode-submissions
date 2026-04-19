class Solution {

    public record Car(int start, int speed){};

    public int carFleet(int target, int[] start, int[] speed) {
        List<Car> cars = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            cars.add(new Car(start[i], speed[i]));
        }
        cars.sort((a, b) -> b.start - a.start);
        Stack<Double> stack = new Stack<>();
        for (var car: cars) {
            double t = (target - car.start) / (double) car.speed;
            if (!stack.isEmpty() && t <= stack.peek()) {
                continue;
            }
            stack.push(t);
        }
        return stack.size();
    }
}

// list of cars: [1,3], [3,2]
// sorted: [3,2], [1,3]
// stack: 3.5
// [3,2]: time = 7/2 = 3.5
// [1,3]: time = 9/3 = 3
// return 1

// [4,1,0,7]
// [2,2,1,1]
// list of cars: [4,2],[1,2],[0,1],[7,1]
// sorted: [7,1],[4,2],[1,2],[0,1]
// stack: 3 4.5 10 -> return 3
// [7,1]: time = 3/1 = 3
// [4,2]: time = 6/2 = 3
// [1,2]: time = 9/2 = 4.5
// [0,1]: time = 10/1 = 10