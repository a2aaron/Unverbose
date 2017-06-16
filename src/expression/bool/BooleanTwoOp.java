package expression.bool;

import expression.ExpressionTwoOp;
import expression.integer.IntegerExpression;
import types.BooleanType;
import values.BooleanValue;
import values.IntegerValue;

public abstract class BooleanTwoOp extends ExpressionTwoOp<BooleanType, BooleanType, BooleanType> implements BooleanExpression {
    public BooleanTwoOp(boolean left, boolean right, BooleanOperator operator, String symbol) {
        super(new BooleanConstant(left), new BooleanConstant(right), operator, symbol);
    }
    
    @Override
    public BooleanExpression evaluate() {
        return (BooleanExpression) super.evaluate();
    }
    
    @Override
    public BooleanValue getValue() {
        return (BooleanValue) super.getValue();
    }
}
