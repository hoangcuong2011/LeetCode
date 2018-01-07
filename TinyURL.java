#the problem: https://leetcode.com/problems/encode-and-decode-tinyurl/description/
public class TinyURL {

    List<String> urls = new ArrayList<String>();
    public String encode(String longUrl) {
        urls.add(longUrl);
        return ""+(urls.size()-1);
    }

    public String decode(String shortUrl) {
        int index = Integer.valueOf(shortUrl);
        if(index<urls.size()) {
          return urls.get(index);
        }
        else {
          return "";
        }
        
    }
}
