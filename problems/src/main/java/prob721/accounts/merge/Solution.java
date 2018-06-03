package prob721.accounts.merge;

import java.util.*;

/**
 *  Created by yanya04 on 6/2/2018.
 */
public class Solution {

    /*
        acc1:   email1, email2, email3..
        acc2:   email3, email5, email6..
        acc3:   email4, email6

        =>  acc: email1, email2, email3, email4, email5, email6

        p[1] = 1                   p[1] = 1
        p[2] = 2                   p[2] = 1
        p[3] = 3 ==> union ==>     p[3] = 1

        p[3] = 1
        p[5] = 1
        p[6] = 1
    */

    class UF{

        Map<String, String> parents;
        Map<String, String> names;

        UF(List<List<String>> accounts){
            parents = new HashMap<>();
            names = new HashMap<>();
            for(List<String> list: accounts){
                for(int i = 1; i < list.size(); i ++){
                    parents.put(list.get(i), list.get(i));
                    names.putIfAbsent(list.get(i), list.get(0));
                }
            }
        }

        boolean union(String email1, String email2){
            email1 = find(email1);
            email2 = find(email2);

            if(!email1.equals(email2)){
                if(email1.compareTo(email2) < 0){
                    parents.put(email2, email1);
                } else {
                    parents.put(email1, email2);
                }
                return true;
            } else {
                // has the same parent email
                return false;
            }
        }

        String find(String email){
            while(!email.equals(parents.get(email))){
                parents.put(email, parents.get(parents.get(email)));
                email = parents.get(email);
            }
            return email;
        }

        List<List<String>> merge(){
            List<List<String>> res = new ArrayList<>();
            Map<String, TreeSet<String>> merged = new HashMap<>();
            for(String email: parents.keySet()){
                String parent = find(email);
                merged.putIfAbsent(parent, new TreeSet<>());
                merged.get(parent).add(email);
            }
            for(Map.Entry<String, TreeSet<String>> acc: merged.entrySet()){
                List<String> macc = new ArrayList<>();
                macc.add(names.get(acc.getKey()));
                macc.addAll(acc.getValue());
                res.add(macc);
            }
            return res;
        }
    }



    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        UF uf = new UF(accounts);
        for(List<String> acc: accounts){
            for(int i = 2; i < acc.size(); i ++){
                uf.union(acc.get(i), acc.get(i - 1));
            }
        }

        return uf.merge();
    }
}
