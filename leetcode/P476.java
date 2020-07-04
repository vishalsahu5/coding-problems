class Solution {
    public int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        StringBuilder sb = new StringBuilder(binary);
        for (int i=0; i<sb.length(); i++) {
            if (sb.charAt(i) == '0') {
                sb.setCharAt(i, '1');
            } else {
                sb.setCharAt(i, '0');
            }
        }
        return Integer.parseInt(sb.toString(), 2);
    }
}