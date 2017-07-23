package prob204.count.primes;

/**
 * Created by yanya04 on 7/23/2017.
 */
public class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(6));
    }

    public int countPrimes(int n) {
        int counter = 0;
        boolean[] noprimes = new boolean[n];
        for(int i = 2; i < n; i ++){
            if(noprimes[i] == true) continue;
            else counter ++;
            for(int j = 2; i * j < n; j ++){
                noprimes[i * j] = true;
            }
        }
        return counter;
    }
}
