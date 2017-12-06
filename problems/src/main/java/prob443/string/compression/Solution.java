package prob443.string.compression;

public class Solution {
    public int compress(char[] chars) {

        char pre = (char) 0, cur = (char) 0;
        int count = 0;

        int index = 0;
        for(int i = 0; i < chars.length; i ++){
            cur = chars[i];
            if(pre == 0 || pre == cur){
                count ++;
            } else {
                chars[index] = pre;
                index ++;
                if(count > 1){
                    String num = String.valueOf(count);
                    for(int j = 0; j < num.length(); j ++){
                        chars[index++] = num.charAt(j);
                    }
                }
                count = 1;
            }
            pre = cur;
        }

        if(count > 0 && pre != 0){
            chars[index] = pre;
            index ++;
            if(count > 1){
                String num = String.valueOf(count);
                for(int j = 0; j < num.length(); j ++){
                    chars[index++] = num.charAt(j);
                }
            }
        }

        return index;
    }
}
