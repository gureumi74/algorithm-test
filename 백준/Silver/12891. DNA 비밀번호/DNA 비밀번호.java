import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    static HashMap<String, Integer> pwCnt = new HashMap<>();
    static HashMap<String, Integer> inputCnt = new HashMap<>();
    static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int s = Integer.parseInt(st.nextToken()); // 문자열의 길이
        int p = Integer.parseInt(st.nextToken()); // 뽑을 문자열의 길이
        String[] pw = br.readLine().split("");

        st = new StringTokenizer(br.readLine());
        inputCnt.put("A", Integer.parseInt(st.nextToken()));
        inputCnt.put("C", Integer.parseInt(st.nextToken()));
        inputCnt.put("G", Integer.parseInt(st.nextToken()));
        inputCnt.put("T", Integer.parseInt(st.nextToken()));

        for (String key : inputCnt.keySet()) {
            pwCnt.put(key, 0);
            if (inputCnt.get(key) == 0) {
                cnt++;
            }
        }

        int result = 0;

        // 초기 문자열 설정
        for (int i = 0; i < p; i++) {
            add(pw[i]);
        }

        // 초기 문자열 확인
        if (cnt == 4) {
            result++;
        }

        int startIdx = 0;
        int endIdx = p;

        while (endIdx < s) {
            add(pw[endIdx]);
            remove(pw[startIdx]);
            if (cnt == 4) {
                result++;
            }

            endIdx++;
            startIdx++;
        }


        bw.write(String.valueOf(result));
        bw.close();
    }

    public static void add(String s) {
        pwCnt.put(s, pwCnt.get(s) + 1);
        if (pwCnt.get(s).equals(inputCnt.get(s))) {
            cnt++;
        }
    }

    public static void remove(String s) {
        if (pwCnt.get(s).equals(inputCnt.get(s))) {
            cnt--;
        }
        pwCnt.put(s, pwCnt.get(s) - 1);
    }
}
