package other;
import java.io.*;
/**
 * @author IntelliYJC
 * @create 2022/9/7 17:18
 */
public class Test2 {
    public static void main(String[] args) {
        Test2 ss = new Test2();
        ss.printAllSubstrings("abcd");
    }

    private void printAllSubstrings(String s) {
        int n = s.length();
        for (int i = 0; i < n; i++ ) {
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < n; j++) {
                sb.append(s.charAt(j));
                System.out.println(sb);
            }
        }
    }
}