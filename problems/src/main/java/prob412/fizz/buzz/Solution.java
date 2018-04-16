package prob412.fizz.buzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> res = new ArrayList<>();
        boolean three = false, five = false;

        int fizz = 0, buzz = 0;

        for(int i = 1; i <= n; i ++){

            fizz ++;
            buzz ++;


            three = fizz == 3;
            five  = buzz == 5;
            if(three & five){
                res.add("FizzBuzz");
                fizz = 0;
                buzz = 0;
            } else if(three){
                res.add("Fizz");
                fizz = 0;
            } else if(five){
                res.add("Buzz");
                buzz = 0;
            } else {
                res.add(String.valueOf(i));
            }
        }
        return res;
    }
}