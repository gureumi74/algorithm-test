import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    static int[] arr = new int[6], input;
    static boolean check[];
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        // 1~49 6개
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        while (!s.equals("0")) {
            boolean rotto[] = new boolean[50];
            StringTokenizer st = new StringTokenizer(s);
            int size = Integer.parseInt(st.nextToken());
            input = new int[size];
            check = new boolean[size];
            for(int i = 0; i < size; i++) {
                input[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(input);
            solution(0, 0);
            s = br.readLine();
            bw.write("\n");
        }

        bw.close();
    }
    static void solution(int k, int start) throws IOException {
        if(k == 6) {
            StringBuilder sb = new StringBuilder();
            for(int val : arr) {
                bw.write(val + " ");
            }
            bw.write("\n");
            return;
        }

        for(int i = start; i < input.length; i++) {
            if(!check[i]) {
                check[i] = true;
                arr[k] = input[i];
                solution(k + 1, i + 1);
                check[i] = false;
            }
        }
    }

}
