package prob353.design.snake.game;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by yanya04 on 9/5/2017.
 */
public class SnakeGame {

    /** Initialize your data structure here.
     @param width - screen width
     @param height - screen height
     @param food - A list of food positions
     E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */

    private int width;
    private int height;
    private int[][] food;
    private Deque<int[]> pos;
    private int cur;

    public SnakeGame(int width, int height, int[][] food) {
        this.width = width;
        this.height = height;
        this.food = food;
        this.pos = new ArrayDeque<>();

        this.pos.add(new int[]{0, 0});
        this.cur = 0;
    }

    /** Moves the snake.
     @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down
     @return The game's score after the move. Return -1 if game over.
     Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {

        int[] head = pos.peekLast();
        int r = head[0], c = head[1];

        // game over
        switch(direction){
            case "U":   r --; break;
            case "L":   c --; break;
            case "R":   c ++; break;
            case "D":   r ++; break;
            default:    return -1;  // invalid direction
        }

        // hit the boundary
        if(r < 0 || r >= height) return -1;
        if(c < 0 || c >= width) return -1;


        if(cur < food.length && food[cur][0] == r && food[cur][1] == c){
            // bite the food, move cur;
            cur ++;
        } else{
            // if not bite the food, then remove the tail
            pos.pollFirst();
        }
        for(int[] arr: pos){
            if(arr[0] == r && arr[1] == c){
                // bite the body
                return -1;
            }
        }
        pos.add(new int[]{r, c});

        return pos.size() - 1;

    }
}
