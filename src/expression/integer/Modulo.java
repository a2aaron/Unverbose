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
        IntegerValue right = IntegerValue.random();
        return new Modulo(new IntegerConstant(left), new IntegerConstant(right));
    }

    public static Modulo random(int value) {
        int right = Helper.randomInt(value + 1, 2 * value);
        int left = value + right * Helper.randomInt(0, 5);
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
