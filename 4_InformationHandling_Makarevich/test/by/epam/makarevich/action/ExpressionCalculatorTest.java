package by.epam.makarevich.action;

import by.epam.makarevich.composite.InseparableTextPart;
import by.epam.makarevich.composite.SeparableTextPart;
import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.type.ComponentType;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ExpressionCalculatorTest {
    TextPart textPart = new SeparableTextPart();
    String auxiliaryData;
    double delta;

    @Before
    public void initialize() {
        delta = 0.01;
        textPart.add(new InseparableTextPart("Lorem", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Abra", ComponentType.WORD));
        textPart.add(new InseparableTextPart("haha ", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Karina", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Roma", ComponentType.WORD));
        textPart.add(new InseparableTextPart("13+ i--", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart(" 3+5", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart("(6+9*(3-4)) ", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart(" content ", ComponentType.WORD));
        textPart.add(new InseparableTextPart("established", ComponentType.WORD));
        textPart.add(new InseparableTextPart("Lor", ComponentType.WORD));
        textPart.add(new InseparableTextPart("5*(1*2*(3*(4*(5- --j + 4)-3)-2)-1) ", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart("survived", ComponentType.WORD));
        textPart.add(new InseparableTextPart("remaining", ComponentType.WORD));
        textPart.add(new InseparableTextPart("(71-(2*i--*(3*(2-1/2*2)2)-10/2))*++i ", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart("Lorem", ComponentType.WORD));
        textPart.add(new InseparableTextPart("(-5+1/2*(2+5*2- --j))*1200  ", ComponentType.MATH_EXPRESSION));
        textPart.add(new InseparableTextPart("Bye.", ComponentType.WORD));
    }

    @Test
    public void checkFirstExpression() {
        ExpressionCalculator calculator = new ExpressionCalculator();
        calculator.calculateExpression(textPart, 2, 3);
        assertEquals(Double.parseDouble(textPart.getComponentArray().get(5).getValue()), 15.0, delta);
    }

    @Test
    public void checkSecondExpression() {
        ExpressionCalculator calculator = new ExpressionCalculator();
        calculator.calculateExpression(textPart, 2, 3);
        assertEquals(Double.parseDouble(textPart.getComponentArray().get(16).getValue()), 113996.0, delta);
    }

}