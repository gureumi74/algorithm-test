import java.util.Arrays;
class Solution {
    public int[][] solution(int[][] arr) {
        int[][] answer = {};
        if (arr.length > arr[0].length) {
            answer = new int[arr.length][arr.length];
            for(int i = 0; i < arr.length; i++) {
                answer[i] = Arrays.copyOf(arr[i], arr.length);
            }
            return answer;
        } else if (arr.length < arr[0].length) {
            answer = new int[arr[0].length][arr[0].length];
            for (int i = 0; i < arr.length; i++) {
                answer[i] = Arrays.copyOf(arr[i], arr[i].length);
            }
            return answer;
        }
        return arr;
    }
}