package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author IntelliYJC
 * @create 2022/9/9 13:27
 */
public class LeetCode179 {
    public static void main(String[] args) {
        Solution179 ss = new Solution179();
        String res = ss.largestNumber(new int[]{3, 4, 43, 34, 1, 19, 91, 9});
        System.out.println(res);
    }
}

class Solution179 {
    public String largestNumber(int[] nums) {
        String[] arr = Arrays.stream(nums).mapToObj(String::valueOf).toArray(String[]::new);

        Arrays.sort(arr, (o1, o2) -> {
            String a = o1 + o2, b = o2 + o1;
            return b.compareTo(a);
        });

        StringBuilder sb = new StringBuilder();

        for (String s : arr) {
            sb.append(s);
        }

        if (sb.length() > 0 && sb.charAt(0) == '0')
            return "0";

        return sb.toString();
    }
}