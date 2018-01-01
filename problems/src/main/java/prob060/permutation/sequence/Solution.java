package prob060.permutation.sequence;

import java.util.ArrayList;
import java.util.List;

public class Solution {
/*
    4! = 4 * 3 * 2 * 1;

    [1,2,3,4]

    1 * [2, 3, 4]   3!
      * [2, 4, 3]
      * [3, 2, 4]
      * [3, 4, 2]
      * [4, 2, 3]
      * [4, 3, 2]

    2 * [1, 3, 4]   3!
      * [1, 4, 3]
    ...

    4 * [1, 2, 3]   3!  2!  1!
      * [1, 3, 2]
    ...
*/

    public String getPermutation(int n, int k) {

        int[] fac = new int[n];
        fac[0] = 1;
        for(int i = 1; i < n; i ++){
            fac[i] = fac[i - 1] * i;
        }

        List<Integer> numbers = new ArrayList<>();
        for(int i = 1; i <= n; i ++){
            numbers.add(i);
        }

        StringBuilder sb = new StringBuilder();

        k--;
        for(int i = n - 1; i >= 0; i --){
            int index = k / fac[i];
            int number = numbers.get(index);
            sb.append(number);
            numbers.remove(index);
            k %= fac[i];
        }
        return sb.toString();
    }


}