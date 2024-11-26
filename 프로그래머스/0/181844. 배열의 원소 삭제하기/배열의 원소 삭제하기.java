import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int n : arr) {
            list.add(n);
        }

        for(int i = 0 ; i < delete_list.length; i++) {
            if(list.contains(delete_list[i])) {
                int idx = list.indexOf(delete_list[i]);
                list.remove(idx);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}