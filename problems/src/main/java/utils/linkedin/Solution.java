package utils.linkedin;

public class Solution {
/**
 * This function determines if the braces ('(' and ')') in a string are properly matched.
 * it ignores non-brace characters.
 * Some examples:. from: 1point3acres
 * "()()()()"   -> true
 * "((45+)*a3)" -> true
 * "(((())())"  -> false
 */
    public boolean matched(String s) {
        // Implementation here
        if(s == null || s.length() == 0) {
            return true;
        }
        int count = 0;
        for(char c : s.toCharArray()) {
            if('(' == c) {
                count++;
            } else if(')' == c) {
                count--;
            }
            if(count < 0) {
                return false;
            }
        }
        return count == 0;
    }
}
