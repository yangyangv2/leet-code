package prob271.encode.and.decode.strings;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by yanya04 on 1/25/2018.
 */
public class Codec {

    /*
        convert chart to byte
        byte b = 256;

        0 byte null is 0 for String separator

    */


    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str: strs){
            char[] chars = str.toCharArray();
            for(int i = 0; i < chars.length; i ++){
                // ascii may convert directly
                chars[i] = (char)(~chars[i] & 0xFFFF);
            }
            sb.append(new String(chars));
            sb.append(new String(new char[]{0}));
        }

        return sb.toString();

    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        char[] chars = s.toCharArray();
        List<String> res = new ArrayList<>();
        int last = 0;
        for(int i = 0; i < chars.length;i ++){
            if(chars[i] == 0 ) {
                char[] word = Arrays.copyOfRange(chars, last, i);
                for(int j = 0; j < word.length; j ++){
                    char b = word[j];
                    chars[j] = ((char)~b);
                }
                last = i + 1;
                res.add(new String(chars));
            }
        }
        return res;
    }


    public static void main(String[] args)
    {
        Codec codec = new Codec();

        String str = codec.encode(new ArrayList<>(Arrays.asList(new String[]{"123"})));


        System.out.println(codec.decode(str));




    }
}
