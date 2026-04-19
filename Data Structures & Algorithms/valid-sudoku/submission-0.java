class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<Character>[] rows = new HashSet[9];
        Set<Character>[] cols = new HashSet[9];
        Set<Character>[] boxes = new HashSet[9];
        for (int i=0; i<9; i++) {
            rows[i] = new HashSet<>();
            cols[i] = new HashSet<>();
            boxes[i] = new HashSet<>();
        }

        for (int i=0; i<9; i++) {
            for (int j=0; j<9; j++) {
                if (board[i][j]=='.') continue;
                if (!rows[i].add(board[i][j])) {
                    return false;
                }
                if (!cols[j].add(board[i][j])) {
                    return false;
                }
                if (!boxes[boxNumber(i, j)].add(board[i][j])) {
                    return false;
                }
            }
        }

        return true;
    }

    private int boxNumber (int r, int c) {
        return ((r/3) * 3) + c/3;
    }
}
