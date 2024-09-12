class Solution {
    public int solution(int n, String control) {
        // int answer = 0;
        // int[] controlCheck = new int[4];
        // for(int i = 0; i < control.length(); i++) {
        //     switch (control.charAt(i)) {
        //         case 'w' -> controlCheck[0]++;
        //         case 's' -> controlCheck[1]++;
        //         case 'd' -> controlCheck[2]++;
        //         case 'a' -> controlCheck[3]++;
        //     }
        // }
        // answer = n + controlCheck[0] - controlCheck[1] + controlCheck[2] * 10 - controlCheck[3] * 10;
        
        for(int i = 0; i < control.length(); i++) {
            switch (control.charAt(i)) {
                case 'w' -> n++;
                case 's' -> n--;
                case 'd' -> n += 10;
                case 'a' -> n -= 10;
            }
        }

        return n;
    }
}