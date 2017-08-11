package prob220.contains.duplicate.iii;

import java.util.TreeSet;

/**
 * Created by yanya04 on 8/10/2017.
 */
public class TreeSetDemo {
    public static void main(String[] args) {

        TreeSet<Integer> treeSet = new TreeSet<>();
        for(int i = 0; i < 10; i += 2){
            treeSet.add(i);
        }

        System.out.println(treeSet);

        System.out.println(treeSet.ceiling(3));
        System.out.println(treeSet.floor(3));

        System.out.println(treeSet.ceiling(4));
        System.out.println(treeSet.floor(4));

    }
}

