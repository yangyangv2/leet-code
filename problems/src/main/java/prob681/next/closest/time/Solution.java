package prob681.next.closest.time;

import java.util.TreeSet;

/**
 * Created by yanya04 on 5/25/2018.
 */
public class Solution {
    public String nextClosestTime(String time) {

        time = time.replaceAll(":", "");
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < time.length(); i ++){
            set.add(time.charAt(i) - '0');
        }


        int min = set.first();

        int digit = 0;
        StringBuilder sb = new StringBuilder();
        boolean found = false;
        for(int i = time.length() - 1; i >= 0; i --){
            digit = time.charAt(i) - '0';
            Integer higher = set.higher(digit);

            if(higher == null) continue;
            if(i == 2 && higher > 5) continue;
            if(i == 0 && higher > 2) continue;
            if(i == 1 && time.charAt(0) == '2' && higher > 3) continue;

            sb.append(time.substring(0, i)).append(higher);
            for(int j = i + 1; j < time.length(); j ++){
                sb.append(min);
            }
            found = true;
            break;
        }

        if(!found){
            for(int i = 0; i < time.length(); i ++)
                sb.append(min);
        }

        time = sb.toString();
        time = time.substring(0, 2) + ":" + time.substring(2);

        return time;
    }
}
