package prob038.count.and.say;




public class Solution {

    private String read(String input){

        char cur = '#', pre = '#';
        int count = 0;

        StringBuilder output = new StringBuilder();
        for(char c : input.toCharArray()){

            cur = c;
            if(pre == '#' || pre == cur) {
                count ++;
            } else {
                output.append(count).append(pre);
                count = 1;
            }
            pre = cur;
        }

        if(count != 0){
            output.append(count).append(pre);
        }

        return output.toString();
    }


    public String countAndSay(int n) {


        if(n == 0) return "0";
        if(n == 1) return "1";
        int count = 1;
        String str = "1";
        while(count++ < n){
            str = read(str);
        }
        return str;
    }
}
