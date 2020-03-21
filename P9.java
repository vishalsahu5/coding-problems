class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        int reverse = 0;
        int temp = x;
        while (temp != 0) {
            reverse = (10*reverse) + (temp%10);
            temp = temp/10;
        }
        return x == reverse;
    }
}