import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public String[] solution(String myStr) {
        String[] strArr = myStr.split("a|b|c");
        ArrayList<String> list = new ArrayList<>();
        for(String item: strArr) {
            if(!item.equals("")) 
                list.add(item);
        }
        
        if(list.size() == 0) {
            list.add("EMPTY");
         }
        
        String[] answer = list.toArray(new String[list.size()]);
        return answer;
    }
}