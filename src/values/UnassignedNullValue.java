package values;

public class UnassignedNullValue extends NullValue {
	public UnassignedNullValue() {
		super();
	}

	@Override
	public String toString() {
		return "unassigned null";
	}
}
