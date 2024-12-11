import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

class Student implements Comparable<Student> {
    String name;
    int koreanScore;
    int englishScore;
    int mathScore;

    public Student(String name, int koreanScore, int englishScore, int mathScore) {
        this.name = name;
        this.koreanScore = koreanScore;
        this.englishScore = englishScore;
        this.mathScore = mathScore;
    }


    @Override
    public int compareTo(Student o) {
        return this.koreanScore < o.koreanScore ? 1 : -1;
    }
}
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        ArrayList<Student> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] input = br.readLine().split(" ");
            String name = input[0];
            int korean = Integer.parseInt(input[1]);
            int english = Integer.parseInt(input[2]);
            int math = Integer.parseInt(input[3]);
            list.add(new Student(name, korean, english, math));
        }

        list.sort((a, b) -> {
            if (a.koreanScore != b.koreanScore) {
                return b.koreanScore - a.koreanScore;
            } else if (a.englishScore != b.englishScore) {
                return a.englishScore - b.englishScore;
            } else if (a.mathScore != b.mathScore) {
                return b.mathScore - a.mathScore;
            } else {
                return a.name.compareTo(b.name);
            }
        });

        for (int i = 0; i < n; i++) {
            bw.write(list.get(i).name + "\n");
        }

        bw.close();
    }
}
