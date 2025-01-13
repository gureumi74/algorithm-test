import java.util.Arrays;
class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = Arrays.stream(diffs).max().getAsInt();

        int p1 = 1;
        int p2 = answer;
        int level = (p1 + p2) / 2;
        int preLevel = 0;

        while (preLevel != level) {
            long time = 0;
            for (int i = 0; i < diffs.length; i++) {
                if (level >= diffs[i]) {
                    time += times[i];
                } else {
                    int cnt = diffs[i] - level;
                    if (i > 0) {
                        time += (times[i - 1] + times[i]) * cnt + times[i];
                    } else {
                        time += times[i] * cnt;
                    }
                }
            }

            if (time > limit) {
                p1 = level;
            } else {
                answer = level;
                p2 = level;
            }

            preLevel = level;
            level = (p1 + p2) / 2;
        }

        return answer;
    }
}