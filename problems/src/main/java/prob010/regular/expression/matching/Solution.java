package prob010.regular.expression.matching;

public class Solution {

    /*
                    string
                0   1   2   3
                _   a   a   b
            0 _ T   F   F   F
            1 c
    pattern 2 *
            3 a
            4 *
            5 b

    */
    public boolean isMatch(String s, String p) {

        int sl = s.length();
        int pl = p.length();

        boolean[][] m = new boolean[sl + 1][pl + 1];

        // init: with 0 length str, 0 length pattern, match is true;
        m[0][0] = true;

        // init: with an empty str
        for(int pi = 1; pi <= pl; pi ++){
            if(p.charAt(pi - 1) == '*'){
                m[0][pi] = m[0][pi - 2];
            }
        }

        // generalization
        for(int si = 1; si <= sl; si ++){
            for(int pi = 1; pi <= pl; pi ++){
                if(s.charAt(si - 1) == p.charAt(pi - 1) || p.charAt(pi - 1) == '.'){
                    m[si][pi] = m[si - 1][pi - 1];
                } else if(p.charAt(pi - 1) == '*'){
                    if(p.charAt(pi - 2) == s.charAt(si - 1) || p.charAt(pi - 2) == '.'){
                        m[si][pi] = m[si][pi - 2] || m[si - 1][pi];
                    } else {
                        m[si][pi] = m[si][pi - 2];
                    }
                }

            }
        }

        return m[sl][pl];
    }
}