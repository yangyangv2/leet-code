package prob241.different.ways.to.add.parentheses;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    // "2*3-4*5"

    // solution, break the problem, such as
    // 2 * 3  |  -  |   4 * 5

    private Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String input) {

        List<Integer> result = new ArrayList<>();
        if(input == null || input.length() == 0) return result;

        if(map.containsKey(input)) return map.get(input);

        for(int i = 0; i < input.length(); i ++) {
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String substr1 = input.substring(0, i);
                String substr2 = input.substring(i + 1);
                List<Integer> result1 = diffWaysToCompute(substr1);
                List<Integer> result2 = diffWaysToCompute(substr2);

                for(Integer num1: result1)
                    for(Integer num2: result2){
                        if(c == '+') result.add(num1 + num2);
                        else if(c == '-') result.add(num1 - num2);
                        else if(c == '*') result.add(num1 * num2);
                        else ; // not possible, for future expansion
                    }

                map.put(input, result);
            }
        }

        // if result is empty, it means it only contains number
        if(result.isEmpty()) {
            result.add(Integer.parseInt(input));
            map.put(input, result);
        }

        return result;
    }
}