package prob422.valid.word.square;

import java.util.List;

/**
 *  Created by yanya04 on 5/27/2018.
 */
public class Solution {

    public boolean validWordSquare(List<String> words) {

        char c1 = 0, c2 = 0;
        String word1 = null, word2 = null;
        for(int i = 0; i < words.size(); i ++){
            word1 = words.get(i);
            for(int j = 0; j < word1.length() ; j++){

                c1 = word1.charAt(j);
                if(words.size() < j + 1)
                    return false;

                word2 = words.get(j);

                if(word2.length() < i + 1)
                    return false;

                c2 = word2.charAt(i);

                if(c1 != c2)
                    return false;
            }
        }

        return true;
    }
}