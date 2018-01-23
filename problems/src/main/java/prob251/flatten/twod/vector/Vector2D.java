package prob251.flatten.twod.vector;

import java.util.Iterator;
import java.util.List;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class Vector2D implements Iterator<Integer>
{
    private Iterator<List<Integer>> vec2d = null;
    private Iterator<Integer> cur = null;

    public Vector2D(List<List<Integer>> vec2d) {
        this.vec2d = vec2d.iterator();
    }

    @Override
    public Integer next() {
        if(hasNext()){
            return cur.next();
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        while( (cur == null || !cur.hasNext()) && vec2d.hasNext() ) {
            cur = (vec2d.hasNext()) ? vec2d.next().iterator() : null;
        }
        if(cur == null) return false;

        return cur.hasNext();
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */
