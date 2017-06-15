package expression.bool;

import expression.ExpressionTwoOp;
import types.BooleanType;

public class BooleanTwoOp extends ExpressionTwoOp<BooleanType, BooleanType, BooleanType> {
    public BooleanTwoOp(boolean left, boolean right, BooleanOperator operator, String symbol) {
        super(new BooleanConstant(left), new BooleanConstant(right), operator, symbol);
    }
}
