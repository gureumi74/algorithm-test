class Solution {
    public int solution(int[] common) {
        int check1 = common[1] - common[0];
        int check2 = common[2] - common[1];

        if(check1 == check2) {
            return common[common.length - 1] + check1;
        } else {
            return common[common.length - 1] * (check2 / check1);
        }
    }
}