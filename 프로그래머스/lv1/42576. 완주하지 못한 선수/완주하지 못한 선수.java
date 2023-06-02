import java.util.*;
class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String, Integer> map = new HashMap<>();
        for(String s : participant) map.put(s, map.getOrDefault(s, 0) + 1);
        for(String s : completion) map.put(s, map.get(s) - 1);

        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(entry.getValue() != 0) return entry.getKey();
        }

        return "";
    }
}