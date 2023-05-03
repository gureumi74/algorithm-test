class Solution {
    public String solution(String my_string, int[][] queries) {
        for(int i = 0; i < queries.length; i++) {
            String answer = "";
            int start = queries[i][0];
            int end = queries[i][1];

            answer += my_string.substring(0, start);

            StringBuilder sb = new StringBuilder(my_string.substring(start, end + 1));
            sb.reverse();
            answer += sb.toString();

            answer += my_string.substring(end + 1);
            my_string = answer;
        }

        return my_string;
    }
}