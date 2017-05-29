package expression.bool;

import expression.Expression;
import expression.ExpressionTwoOp;
import types.BooleanType;

public class BooleanExpressionTwoOp extends ExpressionTwoOp<BooleanType, BooleanType, BooleanType> {
    @Deprecated
    public BooleanExpressionTwoOp(Expression<BooleanType> left, Expression<BooleanType> right, BooleanOperator operator, String symbol) {
        super(left, right, operator, symbol);
    }
    
    public BooleanExpressionTwoOp(boolean left, boolean right, BooleanOperator operator, String symbol) {
        super(new BooleanConstant(left), new BooleanConstant(right), operator, symbol);
    }
}
