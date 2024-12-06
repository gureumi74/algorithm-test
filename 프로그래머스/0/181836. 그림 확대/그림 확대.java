class Solution {
    public String[] solution(String[] picture, int k) {
        String[] answer = new String[picture.length * k];
        for (int i = 0; i < picture.length; i++) {
            for (int j = 0; j < k; j++) {
                answer[i * k + j] = picture[i].replaceAll("\\.", "\\.".repeat(k)).replaceAll("x", "x".repeat(k));
            }
        }
        return answer;
    }
}