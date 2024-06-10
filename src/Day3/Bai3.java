package Day3;

import java.util.ArrayList;
import java.util.List;

public class Bai3 {
    public static List<Integer> matchingStrings(List<String> stringList, List<String> queries) {
        // Write your code here
        int qLength = queries.size();
        int sLength = stringList.size();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < qLength; i++) {
            int count = 0;
            for (int j = 0; j < sLength; j++) {
                if (queries.get(i).equals(stringList.get(j))) {
                    count++;
                }
            }
            result.add(count);
        }
        return result;
    }
}
