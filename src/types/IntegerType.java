package types;

import helper.Helper;

public class IntegerType extends PrimativeType<Integer> {
	public IntegerType(int value) {
		super("int", value);
	}

	@Override
	public Integer getValue() {
		return (Integer) super.getValue();
	}

	public static IntegerType random() {
		return new IntegerType(Helper.random.nextInt(10));
	}
}
