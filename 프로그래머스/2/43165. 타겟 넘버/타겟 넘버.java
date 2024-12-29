import java.util.Arrays;
class Solution {
    static int cnt;
    public static void bt(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (target == sum) {
                cnt++;
            }
            return;
        }

        bt(numbers, target, sum + numbers[idx], idx + 1);
        bt(numbers, target, sum - numbers[idx], idx + 1);

    }
    public int solution(int[] numbers, int target) {
        bt(numbers, target, 0, 0);
        return cnt;
    }
}