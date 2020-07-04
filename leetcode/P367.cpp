class Solution {
public:
    bool isPerfectSquare(int num) {
        long long int l = 0, r = num;
        while(l <= r){
            long long int mid = (l+r)/2;
            // cout << l << " " << r << " " << mid << endl;
            if(mid*mid == num){
                return true;
            }else if(mid*mid > num){
                r = mid-1;
            }else if(mid*mid < num){
                l = mid+1;
            }
        }
        return false;
    }
};