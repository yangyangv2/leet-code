package prob355.design.twitter;

import java.util.*;

/**
 * Created by yanya04 on 3/19/2018.
 */
public class Twitter {

    /*
        implement a PULL based design
        1. users keep their own twitts
        2. users keep their own follows
        3. during query, find all twitts from followers (including theirselves)
    */

    private static class User {
        private Twitt twittHead;
        private Set<Integer> followees;
        private int id;
        public User(int userId){
            this.id = userId;
            this.followees = new HashSet<>();
            // add the user him/her self in
            this.follow(userId);
        }

        public void post(int twittId){
            Twitt twitt = new Twitt(twittId);
            if(twittHead == null){
                twittHead = twitt;
            } else {
                twitt.next = twittHead;
                twittHead = twitt;
            }
        }

        public void follow(int followeeId){
            this.followees.add(followeeId);
        }

        public void unfollow(int followeeId){
            if(followeeId == id) return;

            this.followees.remove(followeeId);
        }

        public List<Integer> getNewTwitts(Twitter twitter){

            //  priority queue, keep the smallest on the top
            PriorityQueue<Twitt> pq = new PriorityQueue<>(
                    (t1, t2) -> { return t2.timestamp - t1.timestamp; }
            );

            for(int userId: followees){
                User user = twitter.getOrCreateUser(userId);
                if(user.twittHead != null){
                    pq.offer(user.twittHead);
                }
            }

            int n = 0;
            List<Integer> res = new ArrayList<>();
            while(!pq.isEmpty() && n < 10){
                Twitt twitt = pq.poll();
                res.add(twitt.id);
                n ++;
                if(twitt.next != null){
                    pq.offer(twitt.next);
                }
            }

            return res;
        }
    }

    private static class Twitt{
        int id;
        int timestamp;
        Twitt next;
        static int global = 0;
        public Twitt(int id){
            this.id = id;
            this.timestamp = global ++;
        }
    }


    private Map<Integer, User> userMap;
    /** Initialize your data structure here. */
    public Twitter() {
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        getOrCreateUser(userId).post(tweetId);
    }

    /** get user by ID or create a default one */
    private User getOrCreateUser(int userId){
        User user = userMap.get(userId);
        if(user == null){
            user = new User(userId);
            userMap.put(userId, user);
        }
        return user;
    }


    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        return getOrCreateUser(userId).getNewTwitts(this);
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        getOrCreateUser(followerId).follow(followeeId);
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        getOrCreateUser(followerId).unfollow(followeeId);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
