package prob302.smallest.rectangle.enclosing.black.pixels;

/**
 * Created by yanya04 on 2/6/2018.
 */
public class Solution {

    /*
        solution using BFS to find the max_x, max_y, min_x, min_y
    */


    private int maxX = 0;
    private int minX = Integer.MAX_VALUE;

    private int maxY = 0;
    private int minY = Integer.MAX_VALUE;

    public int minArea(char[][] image, int x, int y) {
        if(image == null || image.length == 0 || image[0].length == 0)
            return 0;

        int m = image.length, n = image[0].length;
        boolean[][] visited = new boolean[m][n];
        bfs(image, visited, x, y);


        return (maxX - minX + 1) * (maxY - minY + 1);

    }

    private void bfs(char[][] image, boolean[][] visited, int x, int y){
        int m = image.length, n = image[0].length;

        if(x < 0 || y < 0 || x == m || y == n || image[x][y] == '0' || visited[x][y])
            return;

        visited[x][y] = true;

        maxX = Math.max(maxX, x);
        maxY = Math.max(maxY, y);
        minX = Math.min(minX, x);
        minY = Math.min(minY, y);

        bfs(image, visited, x + 1, y);
        bfs(image, visited, x - 1, y);
        bfs(image, visited, x, y + 1);
        bfs(image, visited, x, y - 1);

    }

}
