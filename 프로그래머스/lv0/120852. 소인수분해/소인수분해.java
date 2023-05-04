import java.util.*;

class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n];
        int count = 0;
        // 소인수 분해는 소수들로 나누어 떨어질 때까지 구하는 것이기 때문에 i * i < n 까지 돌면 15의 경우
        // 기존 아래 for문은 2~3까지밖에 동작하지 않음 i < n으로 수정
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                answer[count++] = i;
            }
        }
        // count = 0 일 경우 자기 자신을 리턴하면 되므로 return n;
        if (count == 0) {
            answer = new int[1];
            answer[0] = n;
            return answer;
        }

        int isPrime = 0;

        int[] result = new int [count];

        for (int i = 0; i < count; i++) {
            if(getInts(answer[i])){
                result[isPrime++] = answer[i];
            }
        }

        return Arrays.copyOf(result, isPrime);
    }
    private static boolean getInts(int num) {
        for (int j = 2; j < num ; j++) {
            if (num % j == 0) {
                return false;
            }
        }
        return true;
    }
}