class Solution {
    public boolean isHappy(int n) {
        Set<Integer> seen = new HashSet<>();

        while (!seen.contains(n)) {
            seen.add(n);
            n = sumOfSquares(n);
            if (n == 1) {
                return true;
            }
        }

        return false;
    }

    private int sumOfSquares(int n) {
        int out = 0;
        while (n > 0) {
            int dgt = n % 10;
            dgt = dgt * dgt;
            out += dgt;
            n /= 10;
        }
        return out;
    }
}
