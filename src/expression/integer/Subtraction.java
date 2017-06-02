package expression.integer;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import types.IntegerType;
import values.IntegerValue;

public class Subtraction extends ExpressionTwoOp<IntegerType, IntegerType, IntegerType> {
    static final Operator<IntegerType, IntegerType, IntegerType> operator = new IntegerOperator() {
        @Override
        public int apply(int left, int right) {
            return left - right;
        }
    };

    public Subtraction(IExpression<IntegerType> left, IExpression<IntegerType> right) {
        super(left, right, operator, "-");
    }

    public static Subtraction random() {
        IntegerValue left = IntegerValue.random();
        IntegerValue right = IntegerValue.random();
        return new Subtraction(new IntegerConstant(left), new IntegerConstant(right));
    }

    public static Subtraction random(int value) {
        IntegerValue right = IntegerValue.random();
        int left = value + right.getValue().intValue();
        return new Subtraction(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
    }
    
    @Override
    public String toString() {
        String left = getLeft().toString();
        String right = getRight().toString();
        
        if (getLeft() instanceof Subtraction) {
            left = "(" + left + ")";
        }
        
        if (getRight() instanceof Subtraction) {
            right = "(" + right + ")";
        }
        return left + " - " + right;
    }
}
