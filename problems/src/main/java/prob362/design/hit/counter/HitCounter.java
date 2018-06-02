package prob362.design.hit.counter;

/**
 *  Created by yanya04 on 6/1/2018.
 */
public class HitCounter {

    private final static int N = 300;

    private int[] cnts;
    private int[] ts;

    /** Initialize your data structure here. */
    public HitCounter() {
        cnts = new int[N];
        ts = new int[N];
    }

    /** Record a hit.
     @param timestamp - The current timestamp (in seconds granularity). */
    public void hit(int timestamp) {
        int pos = timestamp % N;
        if(ts[pos] != timestamp){
            ts[pos] = timestamp;
            cnts[pos] = 0;
        }
        cnts[pos] ++;
    }

    /** Return the number of hits in the past 5 minutes.
     @param timestamp - The current timestamp (in seconds granularity). */
    public int getHits(int timestamp) {
        int sum = 0;
        for(int i = 0; i < N; i ++){
            if(timestamp - ts[i] < N){
                sum += cnts[i];
            }
        }
        return sum;
    }
}

/**
 * Your HitCounter object will be instantiated and called as such:
 * HitCounter obj = new HitCounter();
 * obj.hit(timestamp);
 * int param_2 = obj.getHits(timestamp);
 */