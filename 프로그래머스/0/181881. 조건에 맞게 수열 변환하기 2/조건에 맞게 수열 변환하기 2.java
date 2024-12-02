import java.util.Arrays;
class Solution {
    public int solution(int[] arr) {
        int[] copyArr = new int[arr.length];

        int answer = -1;
        while (!Arrays.equals(arr, copyArr)) {
            copyArr = Arrays.copyOf(arr, arr.length);
            answer++;
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] >= 50 && arr[i] % 2 == 0) {
                    arr[i] /= 2;
                } else if (arr[i] < 50 && arr[i] % 2 == 1) {
                    arr[i] = arr[i] * 2 + 1;
                }
            }
        }
        return answer;
    }
}