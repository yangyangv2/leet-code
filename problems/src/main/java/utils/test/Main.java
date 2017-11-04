package utils.test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        ArrayList<ArrayList<Integer>> array = new ArrayList<>();

        Map<String, Object> map = new HashMap<>();

        System.out.println(map.putIfAbsent("A", "A"));
        System.out.println(map.putIfAbsent("A", "B"));

        System.out.println(map.computeIfAbsent("C", k -> "C"));
        System.out.println(map.computeIfAbsent("C", k -> "D"));

        Integer i = 14 + 4;

        System.out.println("A".compareTo("B"));
    }
}
