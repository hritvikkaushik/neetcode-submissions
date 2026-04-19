class Solution {
    public void setZeroes(int[][] matrix) {
        int R = matrix.length, C = matrix[0].length;
        var row0 = new boolean[R];
        var col0 = new boolean[C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (matrix[r][c] == 0) {
                    row0[r] = true;
                    col0[c] = true;
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (row0[r] || col0[c]) {
                    matrix[r][c] = 0;
                }
            }
        }
    }
}
