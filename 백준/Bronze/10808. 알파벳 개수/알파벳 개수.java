import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();

        int[] alphabet = new int[26];

        for(int i = 0; i < input.length(); i++) {
            int idx = input.charAt(i) - 'a';
            alphabet[idx]++;
        }

        for(int i = 0; i < alphabet.length; i++) {
            System.out.printf("%d ", alphabet[i]);
        }
    }
}