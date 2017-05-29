package types;

import helper.Helper;

public class BooleanType extends PrimativeType<Boolean> {
	public BooleanType(boolean value) {
		super("boolean", value);
	}

	@Override
	public Boolean getValue() {
		return (Boolean) super.getValue();
	}

	public static BooleanType random() {
		return new BooleanType(Helper.random.nextBoolean());
	}
}
