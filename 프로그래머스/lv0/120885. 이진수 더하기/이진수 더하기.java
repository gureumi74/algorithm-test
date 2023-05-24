class Solution {
    public String solution(String bin1, String bin2) {
        int bin = Integer.parseInt(bin1, 2) + Integer.parseInt(bin2, 2);
        return Integer.toBinaryString(bin);
    }
}