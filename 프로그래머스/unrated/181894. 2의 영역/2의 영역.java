import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr) {
        int[] answer = {};
        int start = -1;
        int end = -1;
        boolean check = false;
        for(int i = 0; i < arr.length; i++) {
            if(!check && arr[i] == 2) {
                start = i;
                check = true;
            }
            else if(check && arr[i] == 2) {
                end = i;
            }
        }

        if(start == -1) answer = new int[]{-1};
        else if(end == -1) answer = new int[]{2};
        else answer = Arrays.copyOfRange(arr, start, end + 1);
        return answer;
    }
}