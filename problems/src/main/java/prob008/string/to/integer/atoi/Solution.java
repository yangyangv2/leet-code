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

        int index = 0, sign = 1;
        long value = 0;

        boolean start = false;

        // remove starting/closing spaces
        str = str.trim();

        if(str.length() == 0) return 0;

        int startIndex = 0;
        // handle sign as the first character
        if(str.charAt(0) == '-') {sign = -1; startIndex = 1;}
        else if(str.charAt(0) == '+') {sign = 1; startIndex = 1; }
        else if(!Character.isDigit(str.charAt(0))) return 0;

        // starting from here, take the next valid digits
        for(int i = startIndex; i < str.length(); i ++){
            char c = str.charAt(i);
            if(Character.isDigit(c)){
                value = value * 10 + (c - '0');
                if(value > 1L + Integer.MAX_VALUE) break;
            } else {
                break;
            }
        }

        value = sign * value;

        // check overflow
        if(value >= Integer.MAX_VALUE) return Integer.MAX_VALUE;
        else if(value <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)value;
    }
}