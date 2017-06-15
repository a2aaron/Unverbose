package expression.integer;

import expression.ExpressionTwoOp;
import expression.IExpression;
import expression.Operator;
import helper.Helper;
import types.IntegerType;

public abstract class IntegerTwoOp extends ExpressionTwoOp<IntegerType, IntegerType, IntegerType> {
    public enum IntegerOperators {
        ADD("+", (int left, int right)  -> left + right),
        SUBTRACT("-", (int left, int right)  -> left - right),
        MULTIPLY("*", (int left, int right)  -> left * right),
        DIVIDE("/", (int left, int right)  -> left / right),
        MODULO("%", (int left, int right)  -> left % right);
        
        String symbol;
        IntegerOperator operator;
        
        IntegerOperators(String symbol, IntegerOperator operator) {
            this.symbol = symbol;
            this.operator = operator;
        }
        
        public String getSymbol() {
            return symbol;
        }
        
        public IntegerOperator getOperator() {
            return operator;
        }
        
        public int apply(int left, int right) {
            return operator.apply(left, right);
        }
    }
    
    IntegerOperators operationType;
    
    public IntegerTwoOp(IExpression<IntegerType> left, IExpression<IntegerType> right,
            IntegerOperators operator) {
        super(left, right, operator.getOperator(), operator.getSymbol());
        this.operationType = operator;
    }

    public IntegerTwoOp(int left, int right,
            IntegerOperators operator) {
        this(IntegerHelper.toExpression(left), IntegerHelper.toExpression(right), operator);
    }
    
    @Override
    public IExpression<IntegerType> complicate() {
        switch (Helper.randomInt(0, 1)) {
        case 0: {
            IExpression<IntegerType> newLeft = getLeft();
            IExpression<IntegerType> newRight = getRight();
            if (Helper.random.nextBoolean()) {
                newLeft = newLeft.complicate();
            }

            if (Helper.random.nextBoolean()) {
                newRight = newRight.complicate();
            }
            return integerTwoOpFactory(newLeft, newRight, getOperationType());
        }
        case 1:
            return this.evaluate();
        case 2:
            return this;
        default:
            throw new RuntimeException("Unreachable!");
        }
    }
    
    private IntegerOperators getOperationType() {
        return operationType;
    }

    public static IExpression<IntegerType> integerTwoOpFactory(IExpression<IntegerType> left, IExpression<IntegerType> right, IntegerOperators operator) {
        switch(operator) {
        case ADD:
            return new Addition(left, right);
        case DIVIDE:
            return new Division(left, right);
        case MODULO:
            return new Modulo(left, right);
        case MULTIPLY:
            return new Multiplication(left, right);
        case SUBTRACT:
            return new Subtraction(left, right);
        default:
            throw new RuntimeException("Unreachable!");
        }
    }
}
// (1 * 1 / 1) * (3 - -2) * ((1 / 1) / ((-5 - -10) % (-1 - -3))) * (((-13 - 5 % 4) / (9 + -8)) + ((-3 + 0 + (80 - -4)) / (9 / (0 - -1)))) * (( -15   -    -9)    +    1    + (14 % (  2   *     2   ))) * (   (0   / (1 * -5) - 9 * 1) + ((-6 + 26) / (8 + -6)))
// (1 * 1 / 1) * (3 - -2) * ((1 / 1) / ((-5 - -10) % (-1 - -3))) * (((-13 - 5 % 4) / (9 + -8)) + ((-3 + 0 + (80 - -4)) / (9 / (0 - -1)))) * ((-3 * 5 - (-2 - 7)) + (9 % 2) + (14 % (2 * 1 * (10 % 2)))) * ((-6 * 0 / (1 * -5) - 9 * 1) + ((-6 + 26) / (8 + -6)))