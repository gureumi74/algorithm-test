import java.util.Arrays;

class Solution {
    public int[] solution(int[] arr) {
        int length = arr.length;

        int n = 1;
        while (n < length) {
            n = n << 1;
        }

        int[] answer = Arrays.copyOfRange(arr, 0, arr.length + n - length);
        return answer;
    }
}