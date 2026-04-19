class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = findRow(matrix, target);
        if (row == -1) return false;
        // System.out.println("row: " + row);
        int m = matrix[0].length;
        int start = 0, end = m - 1;
        while (start <= end) {
            int mid = start + (end - start)/2;
            if (matrix[row][mid] == target) {
                return true;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    int findRow(int[][] arr, int target) {
        int n = arr.length, m = arr[0].length;
        int start = 0, end = n-1, mid = -1;
        System.out.println("n: " + n + ", m: " + m);
        if (target < arr[0][0] || arr[n-1][m-1] < target) {
            return -1;
        }
        while (start <= end) {
            mid = start + (end - start)/2;
            // System.out.println("start: " + start + ", mid: " + mid + ", end: " + end);
            if (arr[mid][0] <= target && target <= arr[mid][m-1]) {
                return mid;
            } else if (target < arr[mid][0]) {
                end = mid - 1;
            } else if (arr[mid][m-1] < target) {
                start = mid + 1;
            }
        }
        return -1;
    }
}
