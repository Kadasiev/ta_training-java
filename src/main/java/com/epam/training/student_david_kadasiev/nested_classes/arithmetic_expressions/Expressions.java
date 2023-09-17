package com.epam.training.student_david_kadasiev.nested_classes.arithmetic_expressions;

import java.util.StringJoiner;

public class Expressions {
    public static Variable var(String name, int value) {
        return new Variable(name, value);
    }

    public static Expression val(int value) {
        return new Expression() {
            @Override
            public int evaluate() {
                return value;
            }

            @Override
            public String toExpressionString() {
                if(value >= 0){
                    return Integer.toString(value);
                }else{
                    return "(" + value + ")";
                }
            }
        };
    }

    public static Expression sum(Expression... members){
        return new Expression() {
            @Override
            public int evaluate() {
                int sum = 0;
                for(Expression member : members){
                    sum += member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringJoiner stringOfValues = new StringJoiner(" + ", "(", ")");
                for(Expression member : members){
                    stringOfValues.add(member.toExpressionString());
                }
                return stringOfValues.toString();
            }
        };
    }

    public static Expression product(Expression... members){
        return new Expression() {
            @Override
            public int evaluate() {
                int sum = 1;
                for(Expression member : members){
                    sum *= member.evaluate();
                }
                return sum;
            }

            @Override
            public String toExpressionString() {
                StringJoiner stringOfValues = new StringJoiner(" * ", "(", ")");
                for(Expression member : members){
                    stringOfValues.add(member.toExpressionString());
                }
                return stringOfValues.toString();
            }
        };
    }

    public static Expression difference(Expression minuend, Expression subtrahend){
        return new Expression() {
            @Override
            public int evaluate() {
                return minuend.evaluate() - subtrahend.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + minuend.toExpressionString() + " - "
                        + subtrahend.toExpressionString() + ")";
            }
        };
    }

    public static Expression fraction(Expression dividend, Expression divisor){
        return new Expression() {
            @Override
            public int evaluate() {
                return dividend.evaluate() / divisor.evaluate();
            }

            @Override
            public String toExpressionString() {
                return "(" + dividend.toExpressionString() + " / "
                        + divisor.toExpressionString() + ")";
            }
        };
    }

}
