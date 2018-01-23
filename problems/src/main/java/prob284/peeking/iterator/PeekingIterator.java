package prob284.peeking.iterator;

import java.util.Iterator;

/**
 * Created by yanya04 on 1/22/2018.
 */
public class PeekingIterator implements Iterator<Integer>
{


    private Iterator<Integer> iter;
    private Integer peek;

    public PeekingIterator(Iterator<Integer> iterator) {
        // initialize any member here.
        this.iter = iterator;
    }

    // Returns the next element in the iteration without advancing the iterator.
    public Integer peek() {
        if(peek == null){
            peek = next();
        }
        return peek;
    }

    // hasNext() and next() should behave the same as in the Iterator interface.
    // Override them if needed.
    @Override
    public Integer next() {
        if(peek != null){
            Integer temp = peek;
            peek = null;
            if(hasNext()){
                peek = next();
            }
            return temp;
        }
        return this.iter.next();
    }

    @Override
    public boolean hasNext() {

        if(peek != null) return true;
        return this.iter.hasNext();
    }
}
