import java.util.*;
class Solution {
    public int[] solution(int[][] score) {
        int[] answer = new int[score.length];
        float[] average = new float[score.length];
        List<Float> list = new ArrayList<>();
        for(int i = 0; i < score.length; i++) {
            average[i] = (float) (score[i][0] + score[i][1]) / 2;
            list.add(average[i]);
        }

        Collections.sort(list, Collections.reverseOrder());

        for(int i = 0; i < score.length; i++) {
            answer[i] = list.indexOf(average[i]) + 1;
        }

        return answer;
    }
}