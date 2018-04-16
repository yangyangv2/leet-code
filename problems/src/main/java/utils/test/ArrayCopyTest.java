package utils.test;

import utils.io.Print;

public class ArrayCopyTest {

    public static void main(String[] args) {

        int[] src = new int[]{};
        int[] dest = new int[0];

        System.arraycopy(src, 0, dest, 0, 0);

        System.arraycopy(src, 0, dest, 0, 0);

        src = new int[]{1, 2};
        dest = new int[5];

        System.arraycopy(src, 0, dest, 3, 2);


        Print.intArray(src);
        Print.intArray(dest);
    }
}
