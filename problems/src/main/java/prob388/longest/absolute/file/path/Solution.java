package prob388.longest.absolute.file.path;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int lengthLongestPath(String input) {

        if(input == null) return 0;

        List<String> dirs = new ArrayList<>();

        String[] files = input.split("\\n");
        int max = 0, index = 0, count = 0;
        for(int i = 0; i < files.length; i ++){
            index = files[i].lastIndexOf("\t");
            if(files[i].indexOf(".") == - 1){
                // directory
                if(dirs.size() == index + 1) dirs.add(files[i].substring(index + 1));
                else dirs.set(index + 1, files[i].substring(index + 1));
            } else {
                // file
                count = 0;
                for(int j = 0; j <= index; j ++){
                    count += dirs.get(j).length();
                    count ++;
                }
                count += files[i].substring(index + 1).length();
                max = Math.max(max, count);
            }
        }
        return max;
    }
}