package expression.bool;

import expression.IExpression;
import types.BooleanType;
import values.BooleanValue;
import expression.ExpressionTwoOp;

public class BooleanExpressionTwoOp extends ExpressionTwoOp<BooleanType, BooleanType, BooleanType> {
    @Deprecated
    public BooleanExpressionTwoOp(IExpression<BooleanType> left, IExpression<BooleanType> right, BooleanOperator operator, String symbol) {
        super(left, right, operator, symbol);
    }
    
    public BooleanExpressionTwoOp(boolean left, boolean right, BooleanOperator operator, String symbol) {
        super(new BooleanConstant(left), new BooleanConstant(right), operator, symbol);
    }
}
