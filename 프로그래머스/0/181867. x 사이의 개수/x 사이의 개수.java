class Solution {
    public int[] solution(String myString) {
        String[] strArr = myString.split("x");
        int check = 0;
        
        if(myString.charAt(myString.length() - 1) == 'x') {
            check = 1;
        }
        
        int[] answer = new int[strArr.length + check];
        for(int i = 0; i < strArr.length; i++) {
            answer[i] = strArr[i].length();
        }
        
        return answer;
    }
}