import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine()); // 꽃들의 개수
        Pair[] flower = new Pair[n];

        // MMDD 형태로 넣어줌
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int sm = Integer.parseInt(st.nextToken());
            int sd = Integer.parseInt(st.nextToken());
            int em = Integer.parseInt(st.nextToken());
            int ed = Integer.parseInt(st.nextToken());
            flower[i] = new Pair(sm * 100 + sd, em * 100 + ed);
        }

        // 정렬
        Arrays.sort(flower, new Comparator<Pair>() {
            @Override
            public int compare(Pair a, Pair b) {
                if(a.x == b.x) {
                    return b.y - a.y; // 피는 날짜가 같으면 늦게 지는 날짜순으로 정렬
                }
                return a.x - b.x;
            }
        });

        int count = 0;
        int index = 0;
        int today = 301; // 3월 1일을 처음 날짜로 지정

        // 3월 1일 부터 11월 30일까지 매일 꽃이 필라면 (12월 1일까지)
        while (today <= 1130) {
            int maxEnd = 0; // 최대 지는 날짜
            boolean found = false; // 꽃을 찾았는지 여부

            while (index < n && flower[index].x <= today) {
                maxEnd = Math.max(maxEnd, flower[index].y);
                // 현재 날짜보다 일찍 피는 꽃을 찾았으면 index 업데이트
                index++;
                found = true;
            }

            // 꽃을 못찾았거나 다 돌았는데도 최대 지는 날짜가 today보다 적을 때 0 출력
            if (!found || maxEnd <= today) {
                System.out.println(0);
                return;
            }

            count++;
            // 오늘 날짜를 지는 날짜로 업데이트
            today = maxEnd;
        }

        System.out.println(count);
    }
    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

