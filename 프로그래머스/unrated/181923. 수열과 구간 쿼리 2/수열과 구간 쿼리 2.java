class Solution {
    public int[] solution(int[] arr, int[][] queries) {
        int[] answer = new int[queries.length];
        for(int i = 0; i < queries.length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = queries[i][0]; j <= queries[i][1]; j++) {
                if(queries[i][2] < arr[j]) {
                    min = min < arr[j] ? min : arr[j];
                }
            }
            if (min == Integer.MAX_VALUE) {
                min = -1;
            }
            answer[i] = min;
        }
        return answer;
    }
}