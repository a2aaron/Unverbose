package expression.bool;

import expression.ExpressionTwoOp;
import types.BooleanType;

public class BooleanExpressionTwoOp extends ExpressionTwoOp<BooleanType, BooleanType, BooleanType> {
    public BooleanExpressionTwoOp(boolean left, boolean right, BooleanOperator operator, String symbol) {
        super(new BooleanConstant(left), new BooleanConstant(right), operator, symbol);
    }
}
