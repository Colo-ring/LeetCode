package test;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author IntelliYJC
 * @create 2022/4/24 21:14
 */
public class Ruige {
    public static ArrayList<ArrayList<Integer>> threeSum(int[] num) {
        Arrays.sort(num);
        int n = num.length;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (i == 0 || num[i] != num[i - 1]) {
                int l = i + 1, r = n - 1;
                while (l < r) {
                    while(l < r && num[i] + num[l] + num[r] > 0) r--;
                    if (l < r && num[i] + num[l] + num[r] == 0) {
                        int pre = num[l];
                        res.add(new ArrayList(Arrays.asList(num[i], num[l], num[r])));
                        while (l < r && num[l] == pre) l++;
                    } else l++;
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] arr = {-2,0,1,1,2};
        ArrayList<ArrayList<Integer>> arrayLists = threeSum(arr);
        for (ArrayList<Integer> arrayList: arrayLists) {
            for (int i : arrayList) {
                System.out.println(i);
            }
        }
    }
}
