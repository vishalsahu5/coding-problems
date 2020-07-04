class Solution {
public:
    string frequencySort(string s) {
        unordered_map<char, int> m;
        for(auto item : s){
            m[item]++;
        }
        priority_queue<pair<int,int>> pq;
        for(auto a : m){
            pq.push({a.second, a.first});
        }
        string ans = "";
        while(!pq.empty()){
            auto temp = pq.top(); pq.pop();
            int count = temp.first;
            while(count--){
                ans += temp.second;
            }
        }
        return ans;
    }
};