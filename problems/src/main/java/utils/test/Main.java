package utils.test;

import java.util.ArrayDeque;
import java.util.PriorityQueue;

public class Main {

    public static void main(String[] args) {

        PriorityQueue<Integer> small = new PriorityQueue<>((a, b) -> a - b);
        small.offer(1);
        small.offer(2);
        System.out.println(small.peek());

        PriorityQueue<Integer> large = new PriorityQueue<>((a, b) -> b - a);
        large.offer(1);
        large.offer(2);
        System.out.println(large.peek());
    }
}
