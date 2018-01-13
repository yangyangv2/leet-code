package prob733.flood.fill;

/**
 * Created by yanya04 on 1/11/2018.
 */
public class Solution {
    /*
        standard BFS
    */
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int orgColor = image[sr][sc];

        if(newColor == orgColor)
            return image;

        bfs(image, sr, sc, newColor, orgColor);
        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int newColor, int orgColor){

        int m = image.length, n = image[0].length;

        if(sr < 0 || sr >= m || sc < 0 || sc >= n || image[sr][sc] != orgColor)
            return;
        image[sr][sc] = newColor;
        bfs(image, sr + 1, sc, newColor, orgColor);
        bfs(image, sr - 1, sc, newColor, orgColor);
        bfs(image, sr, sc + 1, newColor, orgColor);
        bfs(image, sr, sc - 1, newColor, orgColor);
    }
}