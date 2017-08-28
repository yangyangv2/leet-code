package prob345.reverse.vowels.of.a.string;

/**
 * Created by yanya04 on 8/27/2017.
 */
public class Solution {

    public String reverseVowels(String s) {
        String vowels = "aeiouAEIOU";
        int i = 0, j = s.length() -1;
        char[] arr = s.toCharArray();
        while(i < j){

            while(vowels.indexOf(arr[i]) < 0 && i < j ){
                i ++;
                continue;
            }

            while(vowels.indexOf(arr[j]) < 0 && i < j){
                j --;
                continue;
            }

            char temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i ++;
            j --;
        }
        return new String(arr);
    }

}