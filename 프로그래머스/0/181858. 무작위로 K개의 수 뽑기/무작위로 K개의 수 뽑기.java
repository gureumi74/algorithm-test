import java.util.Arrays;
class Solution {
    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];
        Arrays.fill(answer, -1);
        int[] num = new int[100001];
        int check = 0;
    

        for(int i = 0; i < arr.length; i++) {
            System.out.println(i);
            if(num[arr[i]] == 0 && check < k) {
                answer[check] = arr[i];
                check++;
                num[arr[i]]++;
            }
        }
        return answer;
    }
}