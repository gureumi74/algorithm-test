import java.util.ArrayList;
class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> list = new ArrayList<>();

        for(int i = 0; i < arr.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) != arr[i]) {
                list.add(arr[i]);
            } else {
                list.remove(list.size() - 1);
            }
        }

        if(list.isEmpty()) {
            list.add(-1);
        }

        return list.stream().mapToInt(x -> x).toArray();
    }
}