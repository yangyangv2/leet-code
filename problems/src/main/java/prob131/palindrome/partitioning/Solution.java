package prob131.palindrome.partitioning;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/12/2018.
 */
public class Solution {
    /*

    */
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        if(s == null || s.length() == 0) return result;
        backtrack(result, new ArrayList<String>(), s);
        return result;
    }

    private void backtrack(List<List<String>> result, List<String> list, String s){
        if(s.length() == 0){
            result.add(new ArrayList<>(list));
            return;
        }

        for(int i = 0; i < s.length(); i ++){
            String t = s.substring(0, i + 1);
            if(isPalindrome(t)){
                list.add(t);
                backtrack(result, list, s.substring(i + 1));
                list.remove(list.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s){
        for(int i = 0; i < s.length() / 2; i ++){
            if(s.charAt(i) != s.charAt(s.length() - 1 - i))
                return false;
        }
        return true;
    }

    public static void main(String[] args)
    {
        System.out.println("1".substring(1));
        System.out.println(new String("1".toCharArray(), 1, 1));
    }
}