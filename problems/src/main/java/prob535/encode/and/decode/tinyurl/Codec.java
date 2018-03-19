package prob535.encode.and.decode.tinyurl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yanya04 on 3/18/2018.
 */
public class Codec {

    private List<String> list = new ArrayList<>();
    private Map<String, Integer> map = new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        String str = longUrl.intern();

        Integer key = map.get(str);
        if(key == null){
            list.add(str);
            map.put(str, list.size());
            key = list.size();
        }
        return "http://tinyurl.com/" + String.valueOf(key);
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        Integer index = Integer.parseInt(shortUrl.substring(shortUrl.lastIndexOf("/") + 1));
        return list.get(index - 1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));
