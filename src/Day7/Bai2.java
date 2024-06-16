package Day7;

import java.util.ArrayList;
import java.util.List;

public class Bai2 {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            row = new ArrayList<>();
            for (int j = 1; j <= i; j++) {
                if (i == 1 || i == 2 || j == 1 || j == i) {
                    row.add(1);
                } else {
                    int value = res.get(i - 2).get(j - 2) + res.get(i - 2).get(j - 1);
                    row.add(value);
                }
            }
            res.add(row);
        }

        return res;
    }
}
