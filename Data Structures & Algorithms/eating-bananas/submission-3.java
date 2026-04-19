class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0; // size of largest pile, which is maximum possible speed
        for (int pile: piles) {
            max = Math.max(max, pile);
        }

        // we need min speed in [1, max] so that pile can be finished in <=h time
        int minSpeed = max;
        int min = 1;
        while (min <= max) {
            int speed = min + (max - min)/2;
            int t = timeTaken(piles, speed);
            // System.out.println("Speed: " + speed + ", time: " + t);
            if (t <= h) {
                minSpeed = Math.min(speed, minSpeed);
                max = speed - 1;
            } else {
                min = speed + 1;
            }
        }
        return minSpeed;
    }

    int timeTaken(int[] piles, int speed) {
        int t = 0;
        for (int p: piles) {
            t += Math.ceil((double)p / speed);
        }
        return t;
    }
}
