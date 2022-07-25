package LeetCode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * @author IntelliYJC
 * @create 2022/5/13 17:04
 */
public class LeetCode20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        if (s == null || s.length() == 0) return false;
        stack.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                if (!stack.empty() && map.get(c) == stack.peek()) stack.pop();
                else return false;
            } else {
                stack.push(c);
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {

        LeetCode20 s = new LeetCode20();
        System.out.println(s.isValid("(){}}{"));
    }
}
