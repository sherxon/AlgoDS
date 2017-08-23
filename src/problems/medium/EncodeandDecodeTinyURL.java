package problems.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Sherali Obidov.
 */
public class EncodeandDecodeTinyURL {
    List<String> list= new ArrayList<>();
    Map<String, String> map= new HashMap<>();

    // Encodes a URL to a shortened URL.
    public String encode(String longUrl) {
        if(longUrl == null || longUrl.length()==0) return longUrl;
        if(map.containsKey(longUrl))return map.get(longUrl);

        String su=String.valueOf(list.size());

        map.put(longUrl, su);

        list.add(longUrl);
        return su;
    }

    // Decodes a shortened URL to its original URL.
    public String decode(String shortUrl) {
        if(shortUrl==null || shortUrl.length()==0)
            return shortUrl;
        return list.get(Integer.parseInt(shortUrl));
    }
}
