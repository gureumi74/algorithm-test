import java.util.*;
class Test {
    int no;
    int rank;


    public Test(int no, int rank) {
        this.no = no;
        this.rank = rank;
    }
}
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        ArrayList<Test> list = new ArrayList<>();

        for(int i = 0; i < rank.length; i++) {
            if(attendance[i]) {
                list.add(new Test(i, rank[i]));
            }
        }

        Collections.sort(list, new Comparator<Test>() {
            @Override
            public int compare(Test o1, Test o2) {
                return o1.rank - o2.rank;
            }
        });

        int answer = list.get(0).no * 10000 + list.get(1).no * 100 + list.get(2).no;
        return answer;
    }
}