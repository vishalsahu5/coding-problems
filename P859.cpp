class Solution {
   public:
    bool buddyStrings(string A, string B) {
        if (A.size() != B.size()) return false;

        int mismatch = 0;
        int loc1 = -1, loc2 = -1;
        int map1[26] = {0}, map2[26] = {0};

        for (int i = 0; i < A.size(); i++) {
            if (A[i] != B[i]) mismatch++;
            if (mismatch == 1 && loc1 == -1) loc1 = i;
            if (mismatch == 2 && loc2 == -1) loc2 = i;
            if (mismatch > 2) return false;
            map1[A[i] - 'a']++;
            map2[B[i] - 'a']++;
        }
        if (mismatch == 1) return false;

        if (mismatch == 0) {
            for (int i = 0; i < 26; i++) {
                if (map1[i] > 1 && map2[i] > 1) {
                    return true;
                }
            }
        }
        if (mismatch == 0) return false;
        return (A[loc1] == B[loc2]) && (A[loc2] == B[loc1]);
    }
};