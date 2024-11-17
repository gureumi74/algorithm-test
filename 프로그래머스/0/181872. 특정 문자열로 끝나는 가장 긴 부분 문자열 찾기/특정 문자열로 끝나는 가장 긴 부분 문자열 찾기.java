class Solution {
    public String solution(String myString, String pat) {
        int i = myString.length() - 1;
        String check = "";

        StringBuilder sb = new StringBuilder();
        while (true) {
            check = myString.substring(i - pat.length() + 1, i + 1);
            System.out.println(check);

            if(check.equals(pat)) {
                return myString.substring(0, i + 1);
            }
            i--;
        }

    }
}