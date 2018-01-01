package prob067.add.binary;

public class Solution {

    /*
        1
    +   1
    ------
       10

       11
    +   1
    ------
      100


       11
    +  11
    ------
      110


    */
    public String addBinary(String a, String b) {

        int i = a.length() - 1, j = b.length() - 1;

        int carry = 0;

        StringBuilder sb = new StringBuilder();

        while(j >= 0 || i >= 0){

            int sum = carry;

            if(j >= 0 ) sum += (b.charAt(j--) - '0');
            if(i >= 0 ) sum += (a.charAt(i--) - '0');

            sb.append(sum % 2);
            carry = sum / 2;
        }

        if(carry > 0) sb.append(carry);

        return sb.reverse().toString();

    }
}