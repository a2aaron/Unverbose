package values;

import helper.Helper;
import types.BooleanType;

public class BooleanValue extends Value<BooleanType, Boolean> {
    public BooleanValue(Boolean value) {
        super(new BooleanType(), value);
    }
    
    public static BooleanValue random() {
        return new BooleanValue(Helper.random.nextBoolean());
    }
}
