package prob168.excel.sheet.column.title;

/**
 * Created by yanya04 on 1/15/2018.
 */
public class Solution {

    /*
        1 -> A
        2 -> B
        3 -> C
        ...
        26 -> Z
        27 -> AA
        28 -> AB


    */
    public String convertToTitle(int n) {


        StringBuilder sb = new StringBuilder();
        while(n > 0){
            n --;
            sb.append((char)(n % 26 + 'A'));
            n /= 26;
        }
        return sb.reverse().toString();
    }
}