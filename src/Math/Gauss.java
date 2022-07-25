package Math;

/**
 * @author IntelliYJC
 * @create 2022/4/22 12:33
 * 高斯消元
 */
public class Gauss {

    private static int n;
    private static double[][] a;
    public static int gauss() {
        int c, r; // 行、列
        for(c = 0, r = 0; c < n; c++) {
            int t = r;
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][c]) > Math.abs(a[t][c])) {
                    t = i;
                }
            }

            if (a[t][c] == 0) continue;

            // 交换到首行
            for (int i = c; i <= n; i++) {
                double tem = a[r][i];
                a[r][i] = a[t][i];
                a[t][i] = tem;
            }

            for (int i = n; i >= c; i--) a[r][i] /= a[r][c];
            for (int i = r + 1; i < n; i++) {
                if(Math.abs(a[i][c]) != 0) {
                    for (int j = n; j >= c; j--) {
                        a[i][j] -= a[r][j] * a[i][c];
                    }
                }
            }
            r++;
        }

        if(r < n) {
            for (int i = r; i < n; i++) {
                if (Math.abs(a[i][n]) > 0) {
                    return 2; // 无解
                }
            }
            return 1; // 无穷多解
        }

        // 有唯一解
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                a[i][n] -= a[i][j] * a[j][n];
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        n = 3;
        a = new double[n][n + 1];
        a[0][0] = 1; a[0][1] = 2; a[0][2] = -1; a[0][3] = -6;
        a[1][0] = 2; a[1][1] = 1; a[1][2] = -3; a[1][3] = -9;
        a[2][0] = -1; a[2][1] = -1; a[2][2] = 2; a[2][3] = 7;

        int res = gauss();

        if(res == 0) {
            for(int i = 0; i < n; i++) {
                System.out.println(a[i][n]);
            }
        }else if(res == 1) System.out.println("Infinite group solutions");
        else System.out.println("No solution");
    }
}
