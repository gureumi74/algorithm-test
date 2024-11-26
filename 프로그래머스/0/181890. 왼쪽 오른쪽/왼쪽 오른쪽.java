import java.util.ArrayList;
class Solution {
    public String[] solution(String[] str_list) {
        ArrayList<String> list = new ArrayList<>();
        boolean isCheck = false;
        for(String s : str_list) {
            if(!isCheck && s.equals("l")) {
               break;
            } else if (!isCheck && s.equals("r")) {
                isCheck = true;
                list.clear();
            } else {
                list.add(s);
            }
        }
        
        if(list.size() == str_list.length) {
            list.clear();
        }

        return list.toArray(new String[list.size()]);
    }
}