package prob223.rectangle.area;

import static java.lang.Math.*;

public class Solution {

    /*
        1. calculate area1 and area2
        2. calculate overlap
        3. sum of area1 and area2 - overlap

        assumption C > A, D > B, G > E, H > F)

    */
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {

        int area1 = (D - B) * (C - A);
        int area2 = (H - F) * (G - E);

        int overlap = 0;

        int left = max(A, E);
        int right = min(C, G);

        int top = min(D, H);
        int bottom = max(B, F);


        if(left < right && top > bottom){
            // has overlap
            overlap = (top - bottom) * (right - left);
        }



        return area1 + area2 - overlap;
    }
}