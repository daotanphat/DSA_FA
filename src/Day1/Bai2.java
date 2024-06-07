package Day1;

public class Bai2 {
    public int strStr(String haystack, String needle) {
        if (!haystack.contains(needle)) {
            return -1;
        }

        int stackSize = haystack.length();
        int needleSize = needle.length();
        String result = "";

        for (int i = 0; i < stackSize; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                result = haystack.substring(i, i + needleSize);
                if (result.equals(needle)) {
                    return i;
                }
            }
        }

        return 0;
    }
}
