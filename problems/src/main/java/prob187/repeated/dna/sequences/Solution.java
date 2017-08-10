package prob187.repeated.dna.sequences;

import java.util.*;

/**
 * Created by yanya04 on 8/9/2017.
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findRepeatedDnaSequences("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    /*

        1. naive solution, using HashSet
        2. rolling hash

    */

    private final int PRIME = 7;
    private final int[] code = new int[100];
    {
        code['A'] = 1;
        code['C'] = 2;
        code['G'] = 3;
        code['T'] = 4;
    }

    // rolling hash

    private final int factor = (int) Math.pow(PRIME, 10 - 1);

    private int hash(String s, int index, int length, int last){
        if(index == 0){
            last = 0;
            for(int i = 0; i < length; i ++){
                last += ( code[s.charAt(i + index)]) * (int) Math.pow(PRIME, i);
            }
            return last;
        } else {
            return (last - code[s.charAt(index - 1)]) / PRIME +
                    code[s.charAt(index + 9)] * factor;
        }
    }


    public List<String> findRepeatedDnaSequences(String s) {
        if(s.length() < 10){
            return Collections.emptyList();
        }
        Set<Integer> hash = new HashSet<>();
        Set<String> duplicated = new HashSet<>();
        int last = 0;

        for(int i = 0; i < s.length() - 9; i ++){
            last = hash(s, i, 10, last);
            if(hash.contains(last)){
                duplicated.add(s.substring(i, i + 10));
            } else {
                hash.add(last);
            }
        }

        return new ArrayList<>(duplicated);
    }
}
