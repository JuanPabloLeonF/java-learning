package primitivesarrays.streams;

import java.util.List;

public class StreamsList {

    public static void createScream() {
        List<Integer> integerList = List.of(1,2,3,4,5,6,7,8,9);

        integerList.stream()
                .filter(integer -> integer % 2 != 0)
                .forEach(System.out::println);
    }
}
