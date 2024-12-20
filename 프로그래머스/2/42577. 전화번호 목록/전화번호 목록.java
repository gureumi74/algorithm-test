import java.util.Arrays;
import java.util.HashSet;
class Solution {
    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book, (String s1, String s2) -> s2.length() - s1.length());

        HashSet<String> set = new HashSet<>();
        for(int i = 0; i < phone_book.length; i++) {
            if(set.contains(phone_book[i])) {
                return false;
            }
            for(int j = 0; j < phone_book[i].length(); j++) {
                set.add(phone_book[i].substring(0, j + 1));
            }
        }

        return true;
    }
}