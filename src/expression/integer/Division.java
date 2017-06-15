package expression.integer;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import helper.Helper;
import types.IntegerType;
import values.IntegerValue;

public class Division extends IntegerTwoOp {
    public Division(IExpression<IntegerType> left, IExpression<IntegerType> right) {
        super(left, right, IntegerOperators.DIVIDE);
    }

    public Division(int left, int right) {
        this(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
    }

    public static Division random() {
        IntegerValue left = IntegerValue.random();
        IntegerValue right = IntegerValue.random();
        return new Division(new IntegerConstant(left), new IntegerConstant(right));
    }

    public static Division random(int value) {
        if (value == 0) {
            IntegerConstant random = IntegerConstant.random();
            while ((int) random.getValue().getValue() == 0) {
                random = IntegerConstant.random();
            }
            return new Division(IntegerHelper.toExpression(0), random);
        }
        boolean isNegative = value < 0; 
        
        int right = Helper.randomFactor(Math.abs(value));
        int left = Math.abs(value * right);
        
        if (isNegative) {
            if (Helper.random.nextBoolean()) {
                left *= -1;
            } else {
                right *= -1;
            }
        }    
        return new Division(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
    }
    
    @Override
    public String toString() {
        String left = getLeft().toString();
        String right = getRight().toString();
        
        if (!(getLeft() instanceof Multiplication || getLeft() instanceof IntegerConstant)) {
            left = "(" + left + ")";
        }
        
        if (!(getRight() instanceof IntegerConstant)) {
            right = "(" + right + ")";
        }
        return left + " / " + right;
    }
}
