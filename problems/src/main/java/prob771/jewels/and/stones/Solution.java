package prob771.jewels.and.stones;

public class Solution {
    public int numJewelsInStones(String J, String S) {

        if(J == null || J.length() == 0 || S == null || S.length() == 0)
            return 0;

        boolean[] jewels = new boolean[128];
        for(int i = 0; i < J.length(); i ++){
            jewels[(int) J.charAt(i)] = true;
        }
        int count = 0;
        for(int i = 0; i < S.length(); i ++){
            if(jewels[(int) S.charAt(i)]){
                count ++;
            }
        }
        return count;
    }
}