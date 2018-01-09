package prob089.gray.code;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yanya04 on 1/6/2018.
 */
public class Solution {

    /*

        G(i) = i ^ (i / 2)

        n = 1   ...     0   0
                        1   1

        n = 2   ...     0   00          00 ^ 00 = 00    i = 0
                        1   01          01 ^ 00 = 01    i = 1
                        3   11          10 ^ 01 = 11    i = 2
                        2   10          11 ^ 01 = 10    i = 3

        n = 3   ...     0   000
                        1   001
                        3   011
                        2   010
                        6   110
                        4   100
                        5   101
                        7   111

    */
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i < 1 << n; i ++){
            result.add(i ^ (i / 2));
        }
        return result;
    }


}