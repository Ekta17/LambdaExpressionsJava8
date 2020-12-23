import java.util.function.DoubleToIntFunction;
import java.util.function.IntSupplier;

public class ThirdLambda {

	public static void main(String[] args) {

		IntSupplier supplier = () -> 10;
		int i = supplier.getAsInt();
		System.out.println("i="+i);

		DoubleToIntFunction function = (double value) -> (int) Math.floor(value);
		i = function.applyAsInt(12.6);
		System.out.println("i="+i);

	}

}
