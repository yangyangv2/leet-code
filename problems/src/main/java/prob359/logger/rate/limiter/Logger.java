package prob359.logger.rate.limiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *  Created by yanya04 on 5/9/2018.
 *  Modified by yanya04 on 6/1/2018.
 */
public class Logger {

    class Pair{
        String msg;
        long ts;
        Pair(String msg, long ts){
            this.msg = msg;
            this.ts = ts;
        }
    }

    private Queue<Pair> queue;
    private Map<String, Integer> map;

    /** Initialize your data structure here. */
    public Logger() {
        queue = new LinkedList<>();
        map = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
     If this method returns false, the message will not be printed.
     The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {

        while(!queue.isEmpty() && queue.peek().ts <= timestamp - 10){
            Pair pair = queue.poll();
            if(map.get(pair.msg) == pair.ts)
                map.remove(pair.msg);
        }

        if(map.containsKey(message)) return false;
        map.put(message, timestamp);
        queue.offer(new Pair(message, timestamp));
        return true;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */