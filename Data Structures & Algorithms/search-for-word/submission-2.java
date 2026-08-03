class Solution {

    char[][] board;
    boolean[][] visited;
    int R, C;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        R = board.length;
        C = board[0].length;
        visited = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (search(word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean search(String word, int queryIndex, int i, int j) {
        if(visited[i][j]) {
            return false;
        }
        if(word.charAt(queryIndex) != board[i][j]) {
            // System.out.println(word.charAt(queryIndex) + " != " + board[i][j]);
            return false;
        }
        if (queryIndex == word.length() - 1) {
            return true;
        }
        visited[i][j] = true;
        if (j > 0) {
            if (search(word, queryIndex + 1, i, j - 1)) return true;
        }
        if (j < C - 1) {
            if (search(word, queryIndex + 1, i, j + 1)) return true;
        }
        if (i > 0) {
            if (search(word, queryIndex + 1, i - 1, j)) return true;
        }
        if (i < R - 1) {
            if (search(word, queryIndex + 1, i + 1, j)) return true;
        }
        visited[i][j] = false;
        return false;
    }
}
