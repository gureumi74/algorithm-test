import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] alp = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String input = br.readLine();
        for(int i = 0; i < alp.length; i++) {
            input = input.replaceAll(alp[i], " ");
        }

        System.out.println(input.length());
    }
}
