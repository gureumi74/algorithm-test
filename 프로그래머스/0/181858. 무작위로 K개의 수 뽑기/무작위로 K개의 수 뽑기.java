import java.util.ArrayList;
import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        for(int i = 0; i < arr.length; i++) {
            if(!list.contains(arr[i]) && list.size() < k) {
                list.add(arr[i]);
            }
        }

        int size = list.size();

        if(list.size() < k) {
            for(int i = 0; i < k - size; i++) {
                list.add(-1);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}