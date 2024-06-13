package Day4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bai3 {
    static public boolean pyramidTransition(String bottom, List<String> allowed) {
        int bottomLength = bottom.length();
        List<String> pattern = new ArrayList<>();
        for (int i = 0; i < bottomLength - 1; i++) {
            pattern.add(bottom.substring(i, i + 1));
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(pyramidTransition("BCD", new ArrayList<>(Arrays.asList("BCC", "CDE", "CEA", "FFF"))));
    }
}
