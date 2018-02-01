package prob273.integer.to.english.words;

/**
 * Created by yanya04 on 2/1/2018.
 */
public class Solution {

    String[] first19 = new String[]{ "",
            "One", "Two", "Three", "Four", "Five",
            "Six", "Seven", "Eight", "Nine", "Ten",
            "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen" };

    String[] tens = new String[]{ "",
            "Twenty", "Thirty", "Forty", "Fifty", "Sixty",
            "Seventy", "Eighty", "Ninety" };

    //  100 hundred
    //  1,000 thousand
    //  1,000,000 million
    //  1,000,000,000 billion
    //  1,000,000,000,000 trillion

    String[] thousands = new String[] { "",
            "Thousand", "Million", "Billion", "Trillion"
    };


    //  1 234 567 -> "One | Million | Two Hundred Thirty Four | Thousand | Five Hundred Sixty Seven"

    public String numberToWords(int num) {

        if(num == 0) return "Zero";

        String res = "";
        int count = 0;
        while(num > 0){
            int hundreds = num % 1000;
            if(hundreds != 0){
                res = eval(hundreds) + thousands[count] + " " + res;
            }
            num = num / 1000;
            count ++;
        }

        return res.trim();
    }

    /**
     *   evalute less than 1000 number formatting
     */
    private String eval(int num){
        if(num == 0) return "";

        if(num < 20) return first19[num] + " ";

        else if(num < 100) return tens[num / 10 - 1] + " " + eval(num % 10);

        else return first19[num / 100] + " Hundred " + eval(num % 100);
    }


}