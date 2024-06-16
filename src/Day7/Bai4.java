package Day7;

public class Bai4 {
    public boolean isSubsequence(String s, String t) {
        int len1 = s.length();
        int len2 = t.length();

        int j = 0;

        for (int i = 0; i < len2; i++) {
            if (j < len1 && t.charAt(i) == s.charAt(j)) {
                j++;
            }
        }

        return j == len1;
    }
}
