package by.epam.makarevich.action;


import by.epam.makarevich.composite.TextPart;
import by.epam.makarevich.interpreter.Interpreter;
import by.epam.makarevich.type.ComponentType;
import by.epam.makarevich.util.TextParserRegex;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExpressionCalculator {
    private static final Logger LOG = Logger.getLogger(ExpressionCalculator.class);
    private final Pattern INCREMENT_DECREMENT_PATTERN = Pattern.compile(TextParserRegex.INCREMENT_DECREMENT_REGEX);

    public void calculateExpression(TextPart textPart, int iValue, int jValue) {
        ArrayList<TextPart> list = textPart.getComponentArray();
        replaceIncrementDecrement(list, iValue, jValue);
        Interpreter interpreter = new Interpreter();
        String space = " ";
        String emptyString = "";
        list.stream().filter(component -> ComponentType.MATH_EXPRESSION.equals(component.getTypeOfComponent())).forEach(component -> {
            String expression = component.getValue().replaceAll(space, emptyString);
            double result = interpreter.calculateMathExpression(expression);
            component.setValue(String.valueOf(result));
        });
    }

    private void replaceIncrementDecrement(ArrayList<TextPart> expressionList, int iValue, int jValue) {
        boolean hasLetter = false;
        boolean isLetterI = false;
        boolean isLetterJ = false;
        final int PREFIX_INCREMENT_GROUP = 3;
        final int PREFIX_DECREMENT_GROUP = 4;
        final int I_GROUP = 6;
        final int J_GROUP = 7;
        final int POSTFIX_INCREMENT_GROUP = 9;
        final int POSTFIX_DECREMENT_GROUP = 10;
        int requiredNumber = 0;
        String iLetter = "i";
        String jLetter = "j";
        String increment = "\\+\\+";
        String decrement = "--";
        for (TextPart expression : expressionList) {
            if (ComponentType.MATH_EXPRESSION.equals(expression.getTypeOfComponent())) {
                String value = expression.getValue();
                Matcher matcher = INCREMENT_DECREMENT_PATTERN.matcher(expression.getValue());
                String letter = null;
                while (matcher.find()) {
                    String prefixIncrement = matcher.group(PREFIX_INCREMENT_GROUP);
                    String prefixDecrement = matcher.group(PREFIX_DECREMENT_GROUP);
                    String postfixIncrement = matcher.group(POSTFIX_INCREMENT_GROUP);
                    String postfixDecrement = matcher.group(POSTFIX_DECREMENT_GROUP);
                    hasLetter = true;
                    if (matcher.group(I_GROUP) != null) {
                        letter = iLetter;
                        requiredNumber = iValue;
                        isLetterI = true;
                    } else if (matcher.group(J_GROUP) != null) {
                        letter = jLetter;
                        requiredNumber = jValue;
                        isLetterJ = true;
                    }
                    if (prefixIncrement != null) {
                        value = value.replaceFirst(increment + letter, String.valueOf(++requiredNumber));
                        LOG.info("Replace increment before " + letter);
                    } else if (prefixDecrement != null) {
                        value = value.replaceFirst(decrement + letter, String.valueOf(--requiredNumber));
                        LOG.info("Replace decrement before " + letter);
                    } else if (postfixIncrement != null) {
                        value = value.replaceFirst(letter + increment, String.valueOf(requiredNumber++));
                        LOG.info("Replace increment after " + letter);
                    } else if (postfixDecrement != null) {
                        value = value.replaceFirst(letter + decrement, String.valueOf(requiredNumber--));
                        LOG.info("Replace decrement after " + letter);
                    }
                }
                if (hasLetter) {
                    expression.setValue(value);
                    hasLetter = false;
                }
                if (isLetterI) {
                    iValue = requiredNumber;
                } else if (isLetterJ) {
                    jValue = requiredNumber;
                }
            }
        }
    }
}
