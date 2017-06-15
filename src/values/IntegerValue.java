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
    
    public static IntegerValue randomNonZero() {
        int nonZero = 0;
        while (nonZero == 0) {
            nonZero = Helper.randomInt(-10, 10);
        }
        return new IntegerValue(nonZero);
    }
}
