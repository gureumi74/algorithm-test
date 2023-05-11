import java.util.*;
class Solution {
    public int solution(String[] spell, String[] dic) {
        for(int i = 0; i < dic.length; i++) {
            List<String> list = new ArrayList<>(Arrays.asList(spell));
            for(int j = 0; j < dic[i].length(); j++) {
                if(list.contains(String.valueOf(dic[i].charAt(j)))) {
                    list.remove(String.valueOf(dic[i].charAt(j)));
                }
            }
            if(list.size() == 0) {
                return 1;
            }
        }
        return 2;
    }
}