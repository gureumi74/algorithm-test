import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void quickSort(int[] arr, int left, int right, int K) {
        if (left < right) {
            int pivot = partition(arr, left, right);
            if (pivot == K) {
                return;
            } else if (K < pivot) {
                // 왼쪽만 실행
                quickSort(arr, left, pivot - 1, K);
            } else {
                // 오른쪽만 실행
                quickSort(arr, pivot + 1, right, K);
            }
        }
    }
    public static int partition(int[] arr, int left, int right) {
        // left + 1이 right일 경우 예외 처리
        if (left + 1 == right) {
            if (arr[left] > arr[right]) {
                swap(arr, left, right);
            }
            return right;
        }

        swap(arr, left, (left + right) / 2);
        int pivot = arr[left];
        int i = left + 1;
        int j = right;

        while (i <= j) {
            while (i < arr.length - 1 && arr[i] < pivot) {
                i++;
            }

            while (j > 0 && arr[j] > pivot) {
                j--;
            }

            if(i <= j) {
                swap(arr, i++, j--);
            }
        }

        // pivot 값 제자리에 위치
        arr[left] = arr[j];
        arr[j] = pivot;

        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        quickSort(arr, 0, N - 1, K - 1);
        System.out.println(arr[K - 1]);
    }
}
