import java.util.Arrays;
class Solution {
    public long solution(int n, int[] times) {
        long left = 1;
        long right = 1_000_000_000L * 100_000L;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;
            System.out.println(mid);

            long cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += mid / times[i];
            }

            if (cnt >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return answer;

    }
}