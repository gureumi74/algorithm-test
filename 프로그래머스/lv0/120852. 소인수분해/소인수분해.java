import java.util.*;

class Solution {
    public List<Integer> solution(int n) {
        HashSet<Integer> set = new HashSet<>();
        for(int i = 2; i <= n; i++) {
            while (n % i == 0) {
                set.add(i);
                n /= i;
            }
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.naturalOrder());
        return list;
    }
}