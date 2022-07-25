package LeetCode;
import java.util.Scanner;

/**
 * @author IntelliYJC
 * @create 2022/5/18 19:22
 */
public class Main2 {
    public static void reverse(int[][] arr, int i, int st, int ed, int type)
    {
        if (type == 1) {
            for(; st < ed; st++, ed--)
            {
                int temp = arr[i][st];
                arr[i][st] = arr[i][ed];
                arr[i][ed] = temp;
            }
        } else {
            for (; st < ed; st++, ed--) {
                int temp = arr[st][i];
                arr[st][i] = arr[ed][i];
                arr[ed][i] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), q = sc.nextInt();
        int[][] a = new int[n][n];

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                a[i][j] = sc.nextInt();

        for (int i = 0; i < q; i++) {
            int t = sc.nextInt(), x = sc.nextInt();
            if (t == 1) {
                reverse(a, x - 1, 0, n - 2, 1);
                reverse(a, x - 1, 0, n - 1, 1);
            } else {
                reverse(a, x - 1, 1, n - 1, 2);
                reverse(a, x - 1, 0, n - 1, 2);
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (j != n - 1) System.out.print(a[i][j] + " ");
                else System.out.print(a[i][j]);
            }
            System.out.println("");
        }
    }
}




