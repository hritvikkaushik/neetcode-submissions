class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        return row >= 0 ? search(matrix[row], target) : false;
    }

    private int findRow(int[][] arr, int q) {
        int R = arr.length, C = arr[0].length;
        int t = 0, b = R - 1;
        while (t <= b) {
            int m = (t + b)/2;
            if (arr[m][0] <= q && q <= arr[m][C-1]) {
                return m;
            } else if (arr[m][0] > q) {
                b = m - 1;
            } else {
                t = m + 1;
            }
        }
        return -1;
    }

    private boolean search(int[] arr, int q) {
        int l = 0, r = arr.length - 1;
        while (l <= r) {
            int m = (l + r)/2;
            if (arr[m] == q) {
                return true;
            } else if (arr[m] > q) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return false;
    }
}
