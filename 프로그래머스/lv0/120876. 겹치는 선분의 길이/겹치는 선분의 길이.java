import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Solution {
    public int solution(int[][] lines) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(lines, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[0], o2[0]);
            }
        });

        int count = lines[0][0];
        
        int result = 0;
        int check = 0;

        while (check != 3) {
            for(int i = 0; i < lines.length; i++) {
                if(lines[i][0] == count) {
                    list.add(lines[i][0]);
                } else if (lines[i][1] == count) {
                    list.remove(Integer.valueOf(lines[i][0]));
                    check++;
                }

            }
            if(list.size() > 1) {
                result++;
            }
            count++;
        }

        return result;
    }
}