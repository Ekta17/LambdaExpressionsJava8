import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FirstLambdas {
	public static void main(String[] args) {

		//Supplier
		Supplier<String> supplier = () -> "This is supplier Hello";
		System.out.println(supplier.get());
		System.out.println("---------------------------------------------");

		//Consumer
		Consumer<String> consumer1 = (String s) -> System.out.println("c1 consumes ::" + s);
		//consumer.accept("This is consumer Hello");
		Consumer<String> consumer2 = s -> System.out.println("c2 consumes ::" + s);
		Consumer<String> consumer3 = consumer2.andThen(consumer1);
		consumer3.accept("Hello");
		System.out.println("---------------------------------------------");

		//Predicate
		List<String> strings = new ArrayList<>(Arrays.asList("one", "two", "three", "four", "five"));
		strings.stream().filter(t -> t.startsWith("t")).forEach(t -> System.out.println(t));

		Predicate<String> isNull = s -> s == null;
		System.out.println("is null?" + isNull.test(null));
		System.out.println("is not null?" + isNull.test(""));

		Predicate<String> isEmpty = s -> s.isEmpty();
		System.out.println("is Empty?" + isEmpty.test(""));
		System.out.println("is not Empty?" + isEmpty.test("Hello"));

		Predicate<String> isNotNullAndNotEmpty = isNull.negate().and(isEmpty.negate());
		System.out.println(" is this not Empty and Null String? " + isNotNullAndNotEmpty.test("Hello"));

	}
}
