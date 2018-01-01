package prob065.valid.number;

public class Solution {
    /*
        "0" => true
        " 0.1 " => true
        "abc" => false
        "1 a" => false
        "2e10" => true
    */
    public boolean isNumber(String s) {
        if(s == null) return false;
        s = s.trim();
        s = s.toLowerCase();

        boolean hasNum = false;
        boolean hasE = false;
        boolean hasNumAfterE = true;
        boolean hasDot = false;

        for(int i = 0; i < s.length(); i ++){
            char c = s.charAt(i);
            if(Character.isDigit(c)){
                hasNum = true;
                hasNumAfterE = hasE ? true: hasNumAfterE;
            } else if(c == 'e') {
                if(hasE || ! hasNum ) return false;
                hasE = true;
                hasNumAfterE = false;
            } else if(c == '-' || c == '+'){
                if(i != 0 && s.charAt(i - 1) != 'e') return false;
            } else if(c == '.'){
                if(hasE || hasDot) return false;
                hasDot = true;
            } else {
                return false;
            }
        }
        return hasNum && hasNumAfterE;
    }
}