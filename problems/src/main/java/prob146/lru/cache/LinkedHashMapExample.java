package prob146.lru.cache;

import java.util.LinkedHashMap;
import java.util.Map;

public class LinkedHashMapExample {

    public static void main(String[] args) {


        Map<Integer, Integer> map = new LinkedHashMap<>(16, 0.75f, true);


        map.put(5, 5);
        map.put(2, 2);
        map.put(3, 3);

        System.out.println(map.keySet());
        map.get(3);
        System.out.println(map.keySet());
        map.get(5);
        System.out.println(map.keySet());

    }
}
