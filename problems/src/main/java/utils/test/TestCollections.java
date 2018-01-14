package utils.test;

import java.util.*;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class TestCollections
{
    public static void main(String[] args)
    {

        LinkedList<String> list = new LinkedList<>();
        list.add("15");
        list.remove("15");

        System.out.println(list);

        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        map.put("15", "15");
        map.put("a", "a");
        map.put("A", "A");

        System.out.println(map.keySet());
        map.remove("15");
        map.put("15", "15");
        System.out.println(map);


        Set<Integer> set = new LinkedHashSet<>();
        set.add(1);
        set.add(2);
        System.out.println(set);
        set.remove(1);
        set.add(1);
        System.out.println(set);
    }
}
