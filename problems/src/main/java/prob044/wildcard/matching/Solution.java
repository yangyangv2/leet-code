package prob044.wildcard.matching;

public class Solution {
    public boolean isMatch(String s, String p) {

        int sl = s.length(), pl = p.length();
        boolean[][] m = new boolean[sl + 1][pl + 1];
        m[0][0] = true;

        for(int pi = 1; pi <= pl; pi ++){
            if(p.charAt(pi - 1) == '*'){
                m[0][pi] = m[0][pi - 1];
            }
        }

        for(int si = 1; si <= sl; si ++){
            for(int pi = 1; pi <= pl; pi ++){
                if(s.charAt(si - 1) == p.charAt(pi - 1) || p.charAt(pi - 1) == '?'){
                    m[si][pi] = m[si - 1][pi - 1];
                } else if(p.charAt(pi - 1) == '*'){
                    if(pi == 1) {
                        m[si][pi] = true;
                    } else {
                        m[si][pi] = m[si][pi - 1]  // empty *
                                || m[si - 1][pi]; // all string
                    }
                } else {
                    // false;
                }
            }
        }
        return m[sl][pl];
    }
}