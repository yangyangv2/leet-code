package utils.test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) {


        ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();

        arrayDeque.add(15);
        arrayDeque.remove(15);

        System.out.println(arrayDeque);
    }
}
