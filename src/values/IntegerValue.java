package values;

import helper.Helper;
import types.IntegerType;

public class IntegerValue extends Value<IntegerType, Integer> {
    public IntegerValue(Integer value) {
        super(new IntegerType(), value);
    }
    
    public static IntegerValue random() {
        return new IntegerValue(Helper.randomInt(-10, 10));
    }
}
