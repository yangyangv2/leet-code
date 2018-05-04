package prob443.string.compression;

public class Solution {
    public int compress(char[] chars) {

        int cur = 0, pre = 0, len = chars.length;
        int count = 0;
        char c = 0;
        while(cur < len){
            c = chars[cur];
            chars[pre] = c;
            cur ++;
            pre ++;
            count = 1;

            while(cur < len && chars[cur] == c){
                count ++;
                cur ++;
            }
            if(count > 1){
                for( char t : Integer.toString(count).toCharArray() )
                    chars[pre++] = t;
            }
        }
        return pre;
    }
}
