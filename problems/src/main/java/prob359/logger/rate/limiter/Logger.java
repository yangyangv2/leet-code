package prob359.logger.rate.limiter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 *  Created by yanya04 on 5/9/2018.
 */
public class Logger {


    private class Pair{
        String log;
        int time;
        Pair(String log, int time){
            this.log = log;
            this.time = time;
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
        Pair removed = null;
        while(!queue.isEmpty() && queue.peek().time <= timestamp - 10){
            removed = queue.poll();
            if(map.containsKey(removed.log) && map.get(removed.log) == removed.time){
                map.remove(removed.log);
            }
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