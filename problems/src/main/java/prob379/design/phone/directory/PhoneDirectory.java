package prob379.design.phone.directory;

import java.util.Arrays;

/**
 * Created by yanya04 on 8/8/2017.
 */
public class PhoneDirectory {


    private boolean[] avail;
    private int last = 0;


    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public PhoneDirectory(int maxNumbers) {
        avail = new boolean[maxNumbers];
        Arrays.fill(avail, true);
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        for(int i = last; i < avail.length; i ++){
            if(avail[i]){
                avail[i] = false;
                last = i + 1;
                return i;
            }
        }

        for(int i = 0; i < last; i ++){
            if(avail[i]){
                avail[i] = false;
                return i;
            }
        }
        return -1;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if(number >= 0 && number < avail.length){
            return avail[number];
        } else {
            return false;
        }
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if(number >= 0 && number < avail.length){
            avail[number] = true;
        }
    }
}