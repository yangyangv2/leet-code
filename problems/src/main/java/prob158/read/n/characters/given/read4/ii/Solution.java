package prob158.read.n.characters.given.read4.ii;

/**
 * Created by yanya04 on 1/14/2018.
 */
public class Solution extends Reader4
{
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */

    private char[] temp = new char[4];

    private int pointer = 0;
    private int counter = 0;

    public int read(char[] buf, int n) {

        if(buf.length < n)
            buf = new char[n];
        int index = 0;
        while(index < n){

            if(pointer == 0)
                counter = read4(temp);

            if(counter == 0) break;

            while(pointer < counter && index < n){
                buf[index ++] = temp[pointer++];
            }

            if(pointer == counter) pointer = 0;
        }
        return index;
    }

    @Override
    public int read4(char[] buf)
    {
        return 0;
    }
}
