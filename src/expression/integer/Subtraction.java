package expression.integer;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import types.IntegerType;

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
        IntegerType left = IntegerType.random();
        IntegerType right = IntegerType.random();
        return new Subtraction(new IntegerConstant(left), new IntegerConstant(right));
    }

    public static Subtraction random(int value) {
        IntegerType left = IntegerType.random();
        int right = value + left.getValue().intValue();
        return new Subtraction(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right));
    }
}
