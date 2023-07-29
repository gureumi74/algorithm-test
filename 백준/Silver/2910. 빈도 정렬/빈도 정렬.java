import java.io.*;
import java.lang.reflect.Array;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        HashMap<Integer, Integer> map = new LinkedHashMap<>();
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            int input = Integer.parseInt(st.nextToken());
            if(map.containsKey(input)) {
                map.replace(input, map.get(input) + 1);
            } else map.put(input, 1);
        }

        ArrayList<Integer> list = new ArrayList<>(map.keySet());
        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1,Integer o2) {
                return Integer.compare(map.get(o2), map.get(o1));
            }
        });

        Iterator<Integer> element = list.iterator();
        while (element.hasNext()) {
            Integer tmp = element.next();
            for(int i = 0; i < map.get(tmp); i++) {
                System.out.print(tmp + " ");
            }
        }
    }
}
