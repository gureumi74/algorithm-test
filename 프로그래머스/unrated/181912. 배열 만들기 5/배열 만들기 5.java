import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public int[] solution(String[] intStrs, int k, int s, int l) {
        int[] answer = {};
        List list = new ArrayList();
        for(int i = 0; i < intStrs.length; i++) {
            String subStringStr = intStrs[i].substring(s, s + l);
            if(Integer.parseInt(subStringStr) > k) {
                list.add(Integer.parseInt(subStringStr));
            }
        }
        answer = list.stream().mapToInt(x -> (int) x).toArray();
        return answer;
    }
}