package prob434.number.of.segments.in.a.string;

/**
 * Created by yanya04 on 3/16/2018.
 */
public class Solution {
    public int countSegments(String s) {
        if(s == null) return 0;
        s = s.trim();
        if(s.length() == 0) return 0;
        return s.split("\\s+").length;

    }
}
