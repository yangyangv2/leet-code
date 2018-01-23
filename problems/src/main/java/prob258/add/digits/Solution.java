package prob258.add.digits;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class Solution {

    /*
        a + b:

              after
        1       1
        2       2
        3       3
        4       4
        5       5
        6       6
        7       7
        8       8
        9       9
        10      1
        11      2
        12      3
        13      4
        14      5
        15      6
        16      7
        17      8
        18      9

        27 => 2 + 9 = 9

        (27 - 1) % 9 + 1 = 9

        (1 - 1) % 9 + 1 = 1

        (16 - 1) % 9 + 1 = 7



    */
    public int addDigits(int num) {


        /*

        char[] chars = String.valueOf(num).toCharArray();
        int res = 0;
        for(char c: chars){
            res += (c - '0');
            if(res > 9) {
                res = res % 10 + 1;
            }
        }
        return res;*/

        return 1 + (num - 1) % 9;

    }
}
