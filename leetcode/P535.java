public class Codec {
    
  private HashMap<String, String> urlToId;
  private HashMap<String, String> idToUrl;
  private String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdedfghiklmnopqrstuvwxyz0123456789";
  private Random rnd;
  
  
  public Codec() {
      idToUrl = new HashMap<>();
      rnd = new Random(100000);
  }
  
  private String generateId(int length) {
      StringBuilder sb = new StringBuilder();
      for (int i=0; i<length; i++) {
          sb.append(chars.charAt(rnd.nextInt(chars.length())));
      }
      return sb.toString();
  }
  
  // Encodes a URL to a shortened URL.
  public String encode(String longUrl) {
      String shortUrl = generateId(4);
      idToUrl.put(shortUrl, longUrl);
      return shortUrl;
  }

  // Decodes a shortened URL to its original URL.
  public String decode(String shortUrl) {
      return idToUrl.get(shortUrl);
  }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(url));