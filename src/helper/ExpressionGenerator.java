package helper;

import java.util.ArrayList;

import expression.IExpression;
import expression.bool.BooleanConstant;
import expression.integer.IntegerConstant;
import types.BooleanType;
import types.IType;
import types.IntegerType;
import variables.Variable;

public class ExpressionGenerator {
    public static <T extends IType<?>> IExpression<T> random(Class<T> clazz) {
        IExpression<T> expression = null;
        if (clazz.equals(BooleanType.class)) {
            expression = (IExpression<T>) BooleanConstant.random();
        } else if (clazz.equals(IntegerType.class)) {
            expression = (IExpression<T>) IntegerConstant.random();
        } else {
            throw new RuntimeException("Unreachable!");
        }
        for (int i = 0; i < Helper.randomInt(0, 100); i++) {
            expression = expression.complicate();
        }
        return expression;
    }
}
