import java.util.*;
class Test {
    int no;
    int rank;
    boolean isAttedance;


    public Test(int no, int rank, boolean isAttedance) {
        this.no = no;
        this.rank = rank;
        this.isAttedance = isAttedance;
    }
}
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Test> list = new ArrayList<>();

        for(int i = 0; i < rank.length; i++) {
            list.add(new Test(i, rank[i], attendance[i]));
        }

        Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.rank - o2.rank;
            }
        });

        int cnt = 1;
        int idx = 0;
        int mul = 10000;
        int answer = 0;

        while (cnt <= 3) {
            if (list.get(idx).isAttedance) {
                answer += list.get(idx++).no * mul;
                mul /= 100;
                cnt++;
            } else {
                idx++;
            }
        }
        return answer;
    }
}