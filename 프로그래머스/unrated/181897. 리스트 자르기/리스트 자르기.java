import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(int n, int[] slicer, int[] num_list) {
        int start = 0, end = 0, interval = 1;
        switch (n) {
            case 1:
                start = 0;
                end = slicer[1];
                break;
            case 2:
                start = slicer[0];
                end = num_list.length - 1;
                break;
            case 3:
                start = slicer[0];
                end = slicer[1];
                break;
            case 4:
                start = slicer[0];
                end = slicer[1];
                interval = slicer[2];
                break;
        }

        List<Integer> list = new ArrayList<>();

        for(int i = start; i <= end; i+=interval) {
            list.add(num_list[i]);
        }

        int[] answer = new int[list.size()];
        for(int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }
}