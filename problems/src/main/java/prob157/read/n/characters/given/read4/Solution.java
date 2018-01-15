package prob157.read.n.characters.given.read4;

/**
 * Created by yanya04 on 1/14/2018.
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

        char[] tmp = new char[4];
        if(buf.length < n){
            buf = new char[n];
        }

        int index = 0;
        while(true){
            int count = read4(tmp);
            count = Math.min(count, n - index);
            for(int i = 0; i < count; i ++){
                buf[index ++] = tmp[i];
            }
            if(index == n || count < 4)
                break;
        }
        return index;
    }
}
