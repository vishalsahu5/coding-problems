import java.util.StringTokenizer;
class Solution {
    public List<String> printVertically(String s) {
        StringTokenizer tokens = new StringTokenizer(s, " ");
        ArrayList<String> words = new ArrayList<>();
        int n = 0;
        while (tokens.hasMoreTokens()) {
            String token = tokens.nextToken();
            words.add(token);
            n = Math.max(token.length(), n);
        }
        ArrayList<String> result = new ArrayList<>();
        for (int i=0; i<n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j=0; j < words.size(); j++) {
                String word = words.get(j);
                if (i < word.length())
                    sb.append(word.charAt(i));
                else
                    sb.append(" ");
            }
            result.add(sb.toString().stripTrailing());
        }
        return result;
    }
}