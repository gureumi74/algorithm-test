import java.util.ArrayList;
class Solution {
    public String[] solution(String[] strArr) {
        ArrayList<String> arr = new ArrayList<String>();
        
        for(int i = 0; i < strArr.length; i++) {
            if(strArr[i].indexOf("ad") == -1) {
                arr.add(strArr[i]);
            }
        }
        
        String[] answer = arr.toArray(new String[arr.size()]);
        return answer;
    }
}