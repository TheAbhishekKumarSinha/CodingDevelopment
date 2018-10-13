package java8.tutorials;

import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * @author Abhishek Kumar Sinha
 *
 */
public class JavaStream {
    public static void main(String[] args) {

        Stream<String> stream = Stream.of("one", "two", "three", "four");
        stream.filter(Predicate.isEqual("two").or(Predicate.isEqual("three"))).forEach(System.out::println);

        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, 5);
        Optional<Integer> abhi = integerStream.min((i1, i2) -> (i1 < i2 ? i1 : i2));
        if (abhi.isPresent()) {
            System.out.println(abhi.get());
        }

    }
}
