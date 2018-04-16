package utils.io;

public class Print {

    public static void intArray(int[] arr){
            /* Prints the array */
            int n = arr.length;
            for (int i=0; i<n; ++i)
                System.out.print(arr[i] + " ");
            System.out.println();
    }
}
