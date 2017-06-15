package expression.integer;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.integer.IntegerTwoOp.IntegerOperators;
import helper.Helper;
import types.IntegerType;
import values.IntegerValue;

public class Modulo extends IntegerTwoOp {
    public Modulo(IExpression<IntegerType> left, IExpression<IntegerType> right) {
        super(left, right, IntegerOperators.MODULO);
    }

    public static Modulo random() {
        IntegerValue left = IntegerValue.random();
        IntegerValue right = IntegerValue.randomNonZero();
        return new Modulo(new IntegerConstant(left), new IntegerConstant(right));
    }

    public static Modulo random(int value) {
        if (value == 0) {
            int left = 0;
            IntegerValue right = IntegerValue.randomNonZero();
            return new Modulo(IntegerHelper.toExpression(left), new IntegerConstant(right));
        }
        int right = Helper.randomInt(Math.abs(value) + 1, (Math.abs(value) + 1) * 2);
        int left = value > 0 ? 1 : -1;
        left *= Math.abs(value) + right * Helper.randomInt(0, 5);
        return new Modulo(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
    }
    
    @Override
    public String toString() {
        String left = getLeft().toString();
        String right = getRight().toString();
        if (!(getLeft() instanceof IntegerConstant)) {
            left = "(" + left + ")";
        }
        
        if (!(getRight() instanceof IntegerConstant)) {
            right = "(" + right + ")";
        }
        return left + " % " + right;
    }
}
