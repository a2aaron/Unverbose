package expression.integer;

import expression.IExpression;
import types.IntegerType;
import values.IntegerValue;

public interface IntegerExpression extends IExpression<IntegerType> {
    public IntegerExpression complicate();
    public IntegerExpression evaluate();
    public IntegerValue getValue();
}
