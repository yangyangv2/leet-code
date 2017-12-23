package prob043.multiply.strings;

public class Solution {


    public String multiply(String num1, String num2){
        return multiply2(num1, num2);
    }

    public String multiply2(String num1, String num2){
        if(num1 == null || num2 == null) return "0";
        int len = num1.length() + num2.length();
        int[] result = new int[len];
        for(int i = num1.length() - 1; i >= 0; i-- ){
            for(int j = num2.length() - 1; j >= 0; j --){
                int mul = ( num1.charAt(i) - '0' ) * (num2.charAt(j) - '0') + result[i + j + 1];
                result[i + j + 1] = mul % 10;
                result[i + j] += mul / 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < len; i ++){
            if(sb.length() == 0 && result[i] == 0) continue;
            sb.append(result[i]);
        }
        return sb.length() == 0 ? "0" : sb.toString();
    }




    public String multiply1(String num1, String num2) {

        if(num1 == null || num2 == null) return null;
        if(num1.equals("0") || num2.equals("0")) return "0";

        char[] chars = num2.toCharArray();
        String result = "0";
        int offset = 0;
        for(int i = chars.length - 1; i >= 0 ; i --, offset ++){
            String res = multiply(num1, chars[i]);
            String head = result.substring(0, result.length() - offset);
            String tail = result.substring(result.length() - offset);
            result = add(head, res) + tail;
        }

        return result;
    }

    /*
        add two large string
    */

    private String add(String num1, String num2){

        String lg, sm;
        if(num1.length() > num2.length()){
            lg = num1; sm = num2;
        } else {
            lg = num2; sm = num1;
        }

        int diff = lg.length() - sm.length();
        int[] result = new int[lg.length() + 1];

        int index = 0;
        for(int i = sm.length() - 1; i >= 0; i --, index ++){
            int op1 = sm.charAt(i) - '0';
            int op2 = lg.charAt(i + diff) - '0';
            int res = op1 + op2 + result[index];
            result[index] = res % 10;
            result[index + 1] = res / 10;
        }

        for(int i = diff - 1; i >= 0 ; i --, index ++){
            int op1 = lg.charAt(i) - '0';
            int res = op1 + result[index];
            result[index] = res % 10;
            result[index + 1] = res / 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = result.length - 1; i >= 0; i --){
            if(result[i] == 0 && sb.length() == 0){
                continue;
            }
            sb.append(result[i]);
        }

        return (sb.length() == 0) ? "0" : sb.toString();
    }


    /*
        multiply large string by single digit
    */
    private String multiply(String num, char c){

        char[] chars = num.toCharArray();

        int[] result = new int[num.length() + 1];
        int index = 0;

        for(int i = chars.length - 1; i >= 0; i --, index ++){
            int op1 = chars[i] - '0';
            int op2 = c - '0';
            int res = op1 * op2 + result[index];
            result[index] = res % 10;
            result[index + 1] = res /10;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = result.length - 1; i >= 0; i --){
            if(sb.length() == 0 && result[i] == 0) continue;
            sb.append(result[i]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }
}