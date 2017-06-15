package expression.integer;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import types.IntegerType;
import values.IntegerValue;

public class Subtraction extends IntegerTwoOp {
    public Subtraction(IExpression<IntegerType> left, IExpression<IntegerType> right) {
        super(left, right, IntegerOperators.SUBTRACT);
    }

    public Subtraction(int left, int right) {
        this(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
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
        
        if (getLeft() instanceof Subtraction || getLeft() instanceof Addition) {
            left = "(" + left + ")";
        }
        
        if (getRight() instanceof Subtraction || getRight() instanceof Addition) {
            right = "(" + right + ")";
        }
        return left + " - " + right;
    }
}
