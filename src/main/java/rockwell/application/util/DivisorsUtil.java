package rockwell.application.util;

import java.util.ArrayList;
import java.util.List;

public class DivisorsUtil {
    private DivisorsUtil() {
        throw new IllegalStateException();
    }

    public static List<Integer> getAllDivsors(Integer nr) {
        List<Integer> list = new ArrayList<>();
        for (int j = 1; j <= nr / 2; j++) {
            if (nr % j == 0) {
                list.add(j);
            }
        }
        list.add(nr);
        return list;
    }
}
