import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

public class SecondLambda {

	public static void main(String[] args) {
		List<User> users = Arrays.asList(
						new User("tom", 30),
						new User("aun",29),
						new User("yuot",28),
						new User("ari", 56),
						new User("eric", 25),
						new User("dim", 25)
				);

		//List<String> userNames = users.stream().map(u->u.name).collect(Collectors.toList());
		//userNames.forEach(s -> System.out.println(s));

		Function<User, String> toName = u -> u.getName();
		List<String> userNames = new ArrayList<>();
		for(User user: users)
			userNames.add(toName.apply(user));
		users.forEach(u -> System.out.println(u));
		userNames.forEach( un -> System.out.println(un));
		System.out.println("------------------------------------------");
		Comparator<User> compareByAge = Comparator.comparingInt(User::getAge);
				//(u1, u2) -> Integer.compare(u1.getAge(), u2.getAge());

		Comparator<User> compareByName = Comparator.comparing(User::getName).reversed();
				//(u1,u2) -> u1.getName().compareTo(u2.getName());

		users.stream().sorted(compareByAge).forEach(u-> System.out.println(u));
		System.out.println("---------------------------------------");
		users.stream().sorted(compareByName).forEach(u-> System.out.println(u));
		System.out.println("---------------------------------------");
		users.stream().sorted(compareByAge.thenComparing(compareByName)).forEach(u -> System.out.println(u));
	}
}
