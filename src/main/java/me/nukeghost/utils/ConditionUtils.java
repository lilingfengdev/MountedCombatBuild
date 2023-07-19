package me.nukeghost.utils;

import com.ezylang.evalex.Expression;

import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public class ConditionUtils {
    public static boolean evaluateBooleanExpression(String expressionString) {
        Expression expression = new Expression(expressionString);

        boolean result = false;
        try {
            result = expression.evaluate().getBooleanValue();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public void checkBool() {
        System.out.println("Starting Condition Test");
        boolean trueBool = evaluateBooleanExpression("55 < 88 && (3-2) == 1");
        System.out.println("True: " + trueBool);
        assertTrue(trueBool);

        boolean falseBool = evaluateBooleanExpression("55 > 88");
        System.out.println("False: " + falseBool);
        assertFalse (falseBool);
        System.out.println("Finished Condition Test");

    }
}
