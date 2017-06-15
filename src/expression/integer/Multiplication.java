package expression.integer;

import expression.IExpression;
import helper.Helper;
import types.IntegerType;
import values.IntegerValue;

public class Multiplication extends IntegerTwoOp {
    public Multiplication(IExpression<IntegerType> left, IExpression<IntegerType> right) {
        super(left, right, IntegerOperators.MULTIPLY);
    }

    public static Multiplication random() {
        IntegerValue left = IntegerValue.random();
        IntegerValue right = IntegerValue.random();
        return new Multiplication(new IntegerConstant(left), new IntegerConstant(right));
    }

    public static Multiplication random(int value) {
        if (value == 0) {
            IntegerConstant random = IntegerConstant.random();
            if (Helper.random.nextBoolean()) {
                return new Multiplication(IntegerHelper.toExpression(0), random);
            } else {
                return new Multiplication(random, IntegerHelper.toExpression(0));
            }
        }
        boolean isNegative = value < 0; 
        
        int left = Helper.randomFactor(Math.abs(value));
        int right = Math.abs(value / left);
        if (isNegative) {
            if (Helper.random.nextBoolean()) {
                left *= -1;
            } else {
                right *= -1;
            }
        }    
        return new Multiplication(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
    }
    
    @Override
    public String toString() {
        String left = getLeft().toString();
        String right = getRight().toString();
        if (!(getLeft() instanceof Multiplication) && !(getLeft() instanceof IntegerConstant)) {
            left = "(" + left + ")";
        }
        
        if (!(getRight() instanceof Multiplication) && !(getRight() instanceof IntegerConstant)) {
            right = "(" + right + ")";
        }
        return left + " * " + right;
    }
}
