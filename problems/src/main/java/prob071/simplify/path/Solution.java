package prob071.simplify.path;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution {
    public String simplifyPath(String path) {

        Deque<String> list = new ArrayDeque<>();
        list.add("");

        String[] tokens = path.split("/");

        for(String token: tokens){
            if(token.length() == 0 || token.equals("."))
                continue;

            if(token.equals("..") ) {
                if(list.size() > 1)
                    list.pollLast();
                continue;
            }

            list.add(token);
        }

        return list.size() == 1 ? "/" : String.join("/", list);
    }
}