package utils.tree;

import java.util.TreeSet;

public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();


        set.add(1);
        set.add(3);
        set.add(5);


        assert set.ceiling(2).equals(3);
        assert set.ceiling(3).equals(3);

        assert set.higher(2).equals(3);
        assert set.higher(3).equals(5);

        assert set.floor(3).equals(3);
        assert set.floor(2).equals(1);


        assert set.lower(3).equals(1);
        assert set.lower(2).equals(1);
    }
}
