package prob008.string.to.integer.atoi;

public class Solution {
    /*
        case 1: space       ... " 12 121"  ==> 12
        case 2: sign        ..  "-123" "+123" "--123" ==> 123
        case 3: non digits  ... abc123 => valid?  123abc => valid?
        case 4: fraction    ... 123.123 => 123
        case 5: overflow    ... use long, compare with Integer.MAX_VALUE, Integer.MIN_VALUE
    */
    public int myAtoi(String str) {

        if(str == null) return 0;
        str = str.trim();
        if(str.length() == 0) return 0;

        int startIndex = 0;

        int sign = 1;
        if(str.charAt(startIndex) == '+'){
            startIndex ++;
        } else if(str.charAt(startIndex) == '-'){
            sign = -1;
            startIndex ++;
        }

        long value = 0L;
        while(startIndex < str.length()){
            char c = str.charAt(startIndex);
            if(Character.isDigit(c)){
                value = value * 10 + (c - '0');
                if(value > Integer.MAX_VALUE + 1L) break;
            } else {
                break;
            }
            startIndex ++;
        }

        value = value * sign;

        value = value > Integer.MAX_VALUE? Integer.MAX_VALUE: value;

        value = value < Integer.MIN_VALUE? Integer.MIN_VALUE: value;

        return (int) value;
    }
}