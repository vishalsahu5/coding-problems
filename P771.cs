public class Solution {
    public int NumJewelsInStones(string J, string S) {
        HashSet<char> s = new HashSet<char>();
        
        for (int i=0; i<J.Length; i++) {
            s.Add(J[i]);
        }
        
        int count = 0;
        for (int i=0; i<S.Length; i++) {
            if (s.Contains(S[i])) {
                count++;
            }
        }
        return count;
    }
}