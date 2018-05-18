package prob373.find.k.pairs.with.smallest.sums;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 *  Created by yanya04 on 5/15/2018.
 */
public class Solution {
    public List<int[]> kSmallestPairs(int[] nums1, int[] nums2, int k) {

        List<int[]> res = new ArrayList<>();
        if(nums1 == null || nums2 == null || nums1.length == 0 || nums2.length == 0){
            return res;
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> (a[0] + a[1]) - (b[0] + b[1]));

        int m = nums1.length, n = nums2.length;

        for(int i = 0; i < m; i ++){
            pq.offer(new int[]{nums1[i], nums2[0], i, 0});
        }

        for(int i = 0; i < Math.min(k, m * n); i ++){
            int[] cur = pq.poll();
            res.add(new int[]{cur[0], cur[1]});

            int x = cur[2], y = cur[3];

            if(y + 1 < n){
                pq.offer(new int[]{ nums1[x], nums2[y + 1], x, y + 1});
            }
        }

        return res;
    }
}