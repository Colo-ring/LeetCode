package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author IntelliYJC
 * @create 2022/9/12 13:09
 */
public class LeetCode49 {
    public static void main(String[] args) {
        Solution49 ss = new Solution49();
        List<List<String>> res = ss.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        int a = 0;

    }
}

class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {
        return new ArrayList<>(Arrays.stream(strs).collect(Collectors.groupingBy(
                str -> {
                    int[] arr = new int[26];
                    for (int i = 0; i < str.length(); i++) {
                        arr[str.charAt(i) - 'a']++;
                    }
                    StringBuilder sb = new StringBuilder();
                    for (int i = 0; i < arr.length; i++) {
                        if (arr[i] != 0) {
                            sb.append((char)(i + 'a'));
                            sb.append(arr[i]);
                        }
                    }
                    return sb.toString();
                })).values());
    }
}
