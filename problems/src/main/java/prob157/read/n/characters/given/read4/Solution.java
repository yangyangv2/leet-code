package prob157.read.n.characters.given.read4;

/**
 * Created by yanya04 on 1/14/2018.
 * Modified by yanya04 on 5/20/2018.
 */
public class Solution extends Reader4
{
    public int read4(char[] buf){
        return 1;
    }

    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    public int read(char[] buf, int n) {
        int count = 0, total = 0;

        char[] b = new char[4];

        while(true){
            count = read4(b);
            for(int i = 0; i < count; i ++){
                buf[total + i] = b[i];
            }

            total += Math.min(n, count);
            n -= count;
            if(n <= 0 || count != 4) break;

        }
        return total;
    }
}
