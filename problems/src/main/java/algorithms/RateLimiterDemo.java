package algorithms;

import com.google.common.util.concurrent.RateLimiter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by yanya04 on 5/30/2018.
 */
public class RateLimiterDemo
{
    private static class TokenBucket
    {
        private final int capacity;
        private final int tokensPerSeconds;
        private int tokens = 0;
        private long last = System.currentTimeMillis();

        TokenBucket(int tokenPerUnit, TimeUnit timeUnit)
        {
            capacity = tokensPerSeconds = (int) (tokenPerUnit / timeUnit.toSeconds(1L));
        }

        public boolean take()
        {
            long now = System.currentTimeMillis();
            tokens += (now - last) * tokensPerSeconds / 1000 ;
            last = now;
            if(tokens > capacity) tokens = capacity;
            if(tokens < 1) return false;
            tokens --;
            return true;
        }
    }

    public static void main(String[] args) throws InterruptedException
    {
        TokenBucket bucket = new TokenBucket(250, TimeUnit.MINUTES);
        Thread.sleep(1000L);

        for(int i = 0; i < 5; i ++){
            System.out.println(bucket.take());
        }
        Thread.sleep(1000L);
        for(int i = 0; i < 5; i ++){
            System.out.println(bucket.take());
        }

        RateLimiter limiter = RateLimiter.create(4);

        Thread.sleep(1000L);
        for(int i = 0; i < 6; i ++){
            System.out.println(limiter.tryAcquire());
        }
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add("c");
        Collections.shuffle(list);

        System.out.println(list);
    }


}
