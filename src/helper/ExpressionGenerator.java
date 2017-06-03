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
    public static <T extends IType> IExpression<T> random(T type) {
        IExpression<T> expression = null;
        if (type instanceof BooleanType) {
            expression = (IExpression<T>) BooleanConstant.random();
        } else if (type instanceof IntegerType) {
            expression = (IExpression<T>) IntegerConstant.random();
        } else {
            throw new RuntimeException("Unreachable!" + type);
        }
        for (int i = 0; i < Helper.randomInt(0, 100); i++) {
            expression = expression.complicate();
        }
        return expression;
    }
    
    public static <T extends IType> IExpression<T> random(Class<T> clazz, ArrayList<Variable<?>> scope) {
        throw new RuntimeException("TODO");
//        IExpression<T> expression = null;
//        if (clazz.equals(BooleanType.class)) {
//            expression = (IExpression<T>) BooleanConstant.random();
//        } else if (clazz.equals(IntegerType.class)) {
//            expression = (IExpression<T>) IntegerConstant.random();
//        } else {
//            throw new RuntimeException("Unreachable!");
//        }
//        for (int i = 0; i < Helper.randomInt(0, 100); i++) {
//            expression = expression.complicate();
//        }
//        return expression;
    }
}
