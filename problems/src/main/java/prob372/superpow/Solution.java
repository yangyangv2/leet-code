package prob372.superpow;

/**
 * Created by yanya04 on 8/16/2017.
 */
public class Solution {

    /*
        1. A * B mod N = ((A mod N) * (B mod N)) mod N
        2. (A + B) mod N = ((A mod N) + (B mod N)) mod N
        3. [12345] = 5 * 10^0 + 4 * 10^1 + 3 * 10^2 + 2 * 10^3..
        4. a ^ (5 * 10^0) * a ^ (4 * 10^1) * a (3 * 10^2) ...

    */
    public int superPow(int a, int[] b) {
        if(b == null || b.length == 0) return 1;
        if(a == 0) return 0;
        if(a == 1) return 1;
        int m = 1337;
        int result = 1;
        int p = 0;
        for (int i : b) p = (p * 10 + i) % 1140;
        if (p == 0) p += 1140;

        result = superPow(a, p, m);
        return result;
    }


    private int superPow(int a, int b, int m){
        if(b == 0) return 1;
        int result = a;

        int c = 1;

        while(c < b){
            int i = 1;
            int v = a;
            while(c + i * 2 < b){
                v = ((v % m) * (v % m)) % m;
                i *= 2;
            }
            c += i;
            result = ((result % m) * ( v % m )) %m;
        }
        return result % m;
    }

}