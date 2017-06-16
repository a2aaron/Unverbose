package expression.bool;

import expression.IExpression;
import types.BooleanType;
import types.IntegerType;
import values.BooleanValue;
import values.IntegerValue;

public interface BooleanExpression extends IExpression<BooleanType> {
//    public BooleanExpression complicate(); TODO?
    public BooleanExpression evaluate();
    public BooleanValue getValue();
}
