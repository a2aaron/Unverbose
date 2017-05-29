package values;

public class NullValue extends Value<Object> {
	public NullValue() {
		super(null);
	}

	@Override
	public String toString() {
		return "null";
	}
}
