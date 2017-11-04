package prob006.zigzag.conversion;

public class Solution {
    public String convert(String s, int numRows) {

        StringBuilder[] writers = new StringBuilder[numRows];

        if( numRows < 2) return s;

        for(int i = 0; i < numRows; i ++){
            writers[i] = new StringBuilder();
        }

        boolean flip = false;
        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);

            if(i % (numRows - 1) == 0){
                flip = ! flip;
            }
            if(flip){
                writers[i % (numRows - 1)].append(c);
            } else {
                writers[ (numRows - 1) - ( i % (numRows - 1)) ].append(c);
            }
        }

        StringBuilder result = new StringBuilder();
        for(StringBuilder sb: writers){
            result.append(sb.toString());
        }
        return result.toString();
    }
}