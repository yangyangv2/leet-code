package prob458.poor.pigs;

public class Solution {


    /*
        time =  minToDie * NoOfTests
        NoOfTests = Math.ceiling(Math.sqrt(buckets));

        0   1   2   3
            A   B   AB

        0   1   2   3   4   5   6   7   8   9   10  11  12  13  14  15
            A   B   C   D
                            AB  AC  AD  BC  BD  CD  ABC ABD ACD BCD ABCD

        res = x + y;
    */
    public int poorPigs(int buckets, int minutesToDie, int minutesToTest) {


        return (int)Math.ceil( Math.log(buckets ) / Math.log(1 + (minutesToTest / minutesToDie)));

    }
}
