import java.util.Date;
class Solution {
    public int solution(int[] date1, int[] date2) {
        return new Date(date1[0], date1[1], date1[2]).before(new Date(date2[0], date2[1], date2[2])) ? 1 : 0;
    }
}