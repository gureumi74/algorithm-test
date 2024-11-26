import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr, int[] delete_list) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int n : arr) {
            list.add(n);
        }

        for(int n : delete_list) {
            if(list.contains(n)) {
                list.remove((Integer) n);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }
}