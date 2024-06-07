package Day1;

public class Bai5 {
    public void reverseString(char[] s) {
        int size = s.length;
        for (int i = 0; i < size / 2; i++) {
            char left = s[i];
            s[i] = s[size - i - 1];
            s[size - i - 1] = left;
        }
    }
}
