class Solution {
    public int solution(String[] babbling) {
        int answer = 0;

//        통과는 하는데 한번씩만 지워야 하는 경우, yeye 같은 중복을 처리하지 못함
//        for(int i = 0; i < babbling.length; i++) {
//            String[] s = babbling[i].split("aya|ye|woo|ma");
//            if(s.length == 0) answer++;
//        }

        for(int i = 0; i < babbling.length; i++) {
            babbling[i] = babbling[i].replaceFirst("aya", "0");
            babbling[i] = babbling[i].replaceFirst("ye", "0");
            babbling[i] = babbling[i].replaceFirst("woo", "0");
            babbling[i] = babbling[i].replaceFirst("ma", "0");
            babbling[i] = babbling[i].replaceAll("0", "");
            System.out.println(babbling[i]);
            if(babbling[i].isEmpty()) answer++;
        }

        return answer;
    }
}