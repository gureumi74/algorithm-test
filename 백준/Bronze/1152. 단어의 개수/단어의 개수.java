import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        Arrays.sort(input);
        int count = 0;
        for(int i = 0; i < input.length; i++) {
            if(input[i].equals("")) {
                count++;
            } else {
                break;
            }
        }
        System.out.println(input.length - count);
    }
}
