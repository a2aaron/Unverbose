package helper;

import java.util.ArrayList;

import expression.Expression;
import expression.bool.BooleanConstant;
import expression.integer.IntegerConstant;
import types.BooleanType;
import types.IType;
import types.IntegerType;
import variables.Variable;

public class ExpressionGenerator {
    public static <T extends IType<?>> Expression<T> random(Class<T> clazz) {
        Expression<T> expression = null;
        if (clazz.equals(BooleanType.class)) {
            expression = (Expression<T>) BooleanConstant.random();
        } else if (clazz.equals(IntegerType.class)) {
            expression = (Expression<T>) IntegerConstant.random();
        } else {
            throw new RuntimeException("Unreachable!");
        }
        for (int i = 0; i < Helper.randomInt(0, 100); i++) {
            expression = expression.complicate();
        }
        return expression;
    }
}
