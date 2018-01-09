package prob717.one.bit.and.two.bit.characters;

/**
 * Created by yanya04 on 1/6/2018.
 */
public class Solution {
    public boolean isOneBitCharacter(int[] bits) {

        int i = 0;
        for(; i < bits.length - 1; )
            if(bits[i] == 1)
                i += 2;
            else
                i ++;

        return i == bits.length - 1 && bits[i] == 0;
    }
}