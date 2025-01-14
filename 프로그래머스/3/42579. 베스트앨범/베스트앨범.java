import java.util.*;
class Solution {
    static class Music implements Comparable<Music>{
        int i; // 고유번호
        int play; // 재생횟수

        public Music(int i, int play) {
            this.i = i;
            this.play = play;
        }

        @Override
        public int compareTo(Music music) {
            if(this.play == music.play) {
                return this.i - music.i;
            } else {
                return music.play - this.play;
            }
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, ArrayList<Music>> map = new HashMap<>();
        HashMap<String, Integer> playMap = new HashMap<>();

        for (int i = 0; i < genres.length; i++) {
            if (!map.containsKey(genres[i])) {
                map.put(genres[i], new ArrayList<>());
            }

            map.get(genres[i]).add(new Music(i, plays[i]));
            playMap.put(genres[i], playMap.getOrDefault(genres[i], 0) + plays[i]);
        }

        ArrayList<Map.Entry<String, Integer>> playList = new ArrayList<>(playMap.entrySet());
        Collections.sort(playList, (x, y) -> y.getValue() - x.getValue());

        ArrayList<Integer> answer = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : playList) {
            ArrayList<Music> list = map.get(entry.getKey());
            Collections.sort(list);

            for (int i = 0; i < Math.min(2, list.size()); i++) {
                answer.add(list.get(i).i);
            }
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}