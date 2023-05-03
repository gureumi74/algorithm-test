class Solution {
    public String[] solution(String my_str, int n) {
        int length = my_str.length() % n == 0 ? my_str.length() / n : my_str.length() / n + 1;
        String[] answer = new String[length];
        int start = 0;
        for(int i = 0; i < length; i++) {
            if(i == length - 1) {
                answer[i] = my_str.substring(start);
            } else {
                answer[i] = my_str.substring(start, start + n);
                start += n;
            }
            System.out.println(answer[i]);
        }
        return answer;
    }
}