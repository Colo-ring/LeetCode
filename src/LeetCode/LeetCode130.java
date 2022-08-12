package LeetCode;

public class LeetCode130 {

    static int[] h, e, ne;
    static int idx, res = 0;

    public static void main(String[] args) {
        Solution s= new Solution();
        char[][] a = new char[4][4];
        a[0] = new char[] {'X','X','X','X'};
        a[1] = new char[] {'X','O','O','X'};
        a[2] = new char[] {'X','X','O','X'};
        a[3] = new char[] {'X','O','X','X'};
        s.solve(a);
        int cc = 1;
    }
}

class Solution {

    int[] f = new int[40010];
    int[] dx = {-1, 1, 0, 0}, dy = {0, 0, -1, 1};

    int find(int x) {
        if (x != f[x]) {
            f[x] = find(f[x]);
        }
        return f[x];
    }

    void merge(int x, int y) {
        int a = find(x), b = find(y);
        if (a != b) {
            f[b] = a;
        }
    }

    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                f[idx] = idx;
            }

        f[40009] = 40009;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                    dfs(board, i, j);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int idx = i * m + j;
                if (find(idx) == idx && board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (!check(board, i, j)) return;

        int idx = i * board[0].length + j;
        if (find(idx) != idx || board[i][j] != 'O') return;
        merge(40009, idx);

        for (int k = 0; k < 4; k++) {
            dfs(board, i + dx[k], j + dy[k]);
        }
    }

    boolean check(char[][] board, int i, int j) {
        return i >= 0 && i < board.length && j >=0 && j < board[0].length;
    }
}