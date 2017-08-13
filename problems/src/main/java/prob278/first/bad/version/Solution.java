package prob278.first.bad.version;

/**
 * Created by yanya04 on 8/13/2017.
 */
public class Solution {
    public int firstBadVersion(int n) {
        return binarysearch(1, n);
    }

    private boolean isBadVersion(int version){
        return true;
    }

    private int binarysearch(int start, int end){
        if(start > end){
            return isBadVersion(start) ? start: Integer.MAX_VALUE;
        }

        int mid = start + (end - start) / 2;

        int badVersion = Integer.MAX_VALUE;
        if(isBadVersion(mid)){
            badVersion = Math.min(binarysearch(start, mid - 1), mid);
        } else {
            badVersion = binarysearch(mid + 1, end);
        }

        return badVersion;

    }
}
