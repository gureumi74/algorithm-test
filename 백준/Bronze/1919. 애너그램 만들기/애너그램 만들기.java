import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] str1 = sc.nextLine().toCharArray();
        char[] str2 = sc.nextLine().toCharArray();
        int[] alp = new int[26];

        for (int i = 0; i < str1.length; i++) {
            alp[str1[i] - 'a']++;
        }

        int result = str1.length;

        for (int i = 0; i < str2.length; i++) {
            if (alp[str2[i] - 'a'] == 0) {
                result++;
            } else {
                alp[str2[i] - 'a']--;
                result--;
            }
        }

        System.out.println(result);
    }
}
