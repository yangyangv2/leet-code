package prob604.design.compressed.string.iterator;

import java.util.Scanner;

/**
 *  Created by yanya04 on 6/1/2018.
 */
public class StringIterator {


    private int index, count;
    private char ch = ' ';
    private String str;

    public StringIterator(String compressedString) {
        str = compressedString;
    }

    public char next() {
        if(!hasNext()) return ' ';

        if(count > 0){
            count --;
        } else {
            ch = str.charAt(index);
            StringBuilder num = new StringBuilder();
            while(index + 1 < str.length() && Character.isDigit(str.charAt(index + 1))){
                num.append(str.charAt(index + 1));
                index ++;
            }
            count = Integer.parseInt(num.toString());
            System.out.println(count);
            count --;
            index ++;
        }
        return ch;

    }

    public boolean hasNext() {
        return str.length() > index || count > 0;
    }
}

/**
 * Your StringIterator object will be instantiated and called as such:
 * StringIterator obj = new StringIterator(compressedString);
 * char param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */