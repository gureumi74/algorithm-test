import java.util.HashMap;
class Solution {
    public int solution(String[] strArr) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < strArr.length; i++) {
            int n = strArr[i].length();
            if (!map.containsKey(n)) {
                map.put(n, 1);
            } else {
                map.put(n, map.get(n) + 1);
            }
            answer = answer < map.get(n) ? map.get(n) : answer;
        }
        return answer;
    }
}