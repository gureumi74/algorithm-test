import java.util.*;

public class Solution {
    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(arr[0]);
        int lastNum = arr[0];
        for(int i = 1; i < arr.length; i++) {
            if(arr[i] != lastNum) {
                queue.add(arr[i]);
                lastNum = arr[i];
            }
        }
        
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}