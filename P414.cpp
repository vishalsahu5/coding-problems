#include <algorithm>
#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

class Solution {
   private:
    long excludedMax(vector<int> nums, vector<long> excluded) {
        long maxval = LONG_MIN;
        for (int i = 0; i < nums.size(); i++) {
            if (find(excluded.begin(), excluded.end(), nums[i]) ==
                excluded.end()) {
                if (maxval < nums[i]) maxval = nums[i];
            }
        }
        return maxval;
    }

   public:
    int thirdMax(vector<int>& nums) {
        if (nums.size() < 3) {
            return *max_element(nums.begin(), nums.end());
        }
        long first = LONG_MIN, second = LONG_MIN, third = LONG_MIN;
        first = *max_element(nums.begin(), nums.end());
        vector<long> excluded;
        excluded.push_back(first);
        second = excludedMax(nums, excluded);
        excluded.push_back(second);
        third = excludedMax(nums, excluded);
        // cout << first << " " << second << " " << third << endl;
        return third == LONG_MIN ? first : third;
    }
};