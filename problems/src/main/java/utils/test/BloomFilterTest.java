package utils.test;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

import java.nio.charset.Charset;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class BloomFilterTest {
    public static void main(String[] args) {


        int numEls = 500000;

        BloomFilter<String> filter = BloomFilter.create(
                Funnels.stringFunnel(Charset.defaultCharset()),
                numEls, 0.01 );

        Set<String> set = new HashSet<>();

        List<String> gen = new ArrayList<>();
        for(int i = 0; i < numEls; i ++){
            String uuid = UUID.randomUUID().toString();
            gen.add(uuid);
            filter.put(uuid);
            set.add(uuid);
        }

        System.out.println(filter.mightContain(gen.get(0)));

        Instant instant = Instant.now();
        int fpcount = 0;
        for(int i = 0; i < numEls; i ++){
            String uuid = UUID.randomUUID().toString();
            if(filter.mightContain(uuid)){
                if(!set.contains(uuid)) fpcount ++;
            }
        }

        System.out.println(Duration.between(instant, Instant.now()));
        System.out.println("false positive count: " + fpcount + "/" + numEls);
    }
}
