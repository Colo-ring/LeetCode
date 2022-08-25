package everyday;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Weak3_2 {
    static final int INF = 100000000;
    static Deque<Node> q = new ArrayDeque<>();
    static String[] g = new String[110];
    static int[][][] dist;
    static boolean[][][] st;
    static int sx, sy, tx, ty;
    static int m, n, k;

    private static boolean bfs() {
        dist = new int[m][n][4];
        st = new boolean[m][n][4];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int u = 0; u < 4; u++) {
                    dist[i][j][u] = INF;
                    st[i][j][u] = false;
                }

        int[] dx = {-1, 0, 1, 0}, dy = {0, 1, 0, -1};
        for (int i = 0; i < 4; i++) {
            q.addFirst(new Node(sx, sy, i));
            dist[sx][sy][i] = 0;
        }

        while (!q.isEmpty()) {
            Node t = q.pop();
            if (st[t.x][t.y][t.z]) continue;
            int distance = dist[t.x][t.y][t.z];
            if (distance > k) continue;
            if (t.x == tx && t.y == ty) return true;

            // 扩展四个方向
            for (int i = 0; i < 4; i++) {
                int x = t.x + dx[i], y = t.y + dy[i];
                int w = 0;
                if (i != t.z) w = 1;
                if (x >= 0 && x < m && y >= 0 && y < n && g[x].charAt(y) == '.') {
                    if (dist[x][y][i] > distance + w) {
                        dist[x][y][i] = distance + w;
                        if (w == 0) q.addFirst(new Node(x, y, i));
                        else q.addLast(new Node(x, y, i));
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            q.clear();
            m = sc.nextInt(); n = sc.nextInt();
            for (int i = 0; i < m; i++) g[i] = sc.next();
            k = sc.nextInt();
            sy = sc.nextInt() - 1;
            sx = sc.nextInt() - 1;
            ty = sc.nextInt() - 1;
            tx = sc.nextInt() - 1;
            if (bfs()) System.out.println("yes");
            else System.out.println("no");
        }
    }
}

class Node {
    int x, y, z;

    public Node(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }
}