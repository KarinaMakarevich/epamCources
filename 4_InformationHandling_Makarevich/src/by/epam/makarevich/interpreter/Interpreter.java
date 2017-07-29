package by.epam.makarevich.interpreter;

import by.epam.makarevich.util.TextParserRegex;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Interpreter {
    private static final Logger LOG = Logger.getLogger(Interpreter.class);
    private static final Pattern BRACKET_PATTERN = Pattern.compile(TextParserRegex.BRACKET_REGEX);
    private static final Pattern OPERAND_PATTERN = Pattern.compile(TextParserRegex.OPERAND_REGEX);

    public double calculateMathExpression(String expression) {
        ArrayList<MathExpression> expressions = new ArrayList<MathExpression>();
        Matcher matcher = BRACKET_PATTERN.matcher(expression);
        while (matcher.find()) {
            String bracketExpression = matcher.group();
            bracketExpression = bracketExpression.substring(1, bracketExpression.length() - 1);
            double interimAnswer = calculateMathExpression(bracketExpression);
            expression = expression.replace(bracketExpression, String.valueOf(interimAnswer));
        }
        boolean isLast = false;
        matcher = OPERAND_PATTERN.matcher(expression);
        final int NUMERIC_GROUP = 1;
        final int MULTIPLICATION_GROUP = 2;
        final int DIVISION_GROUP = 3;
        while (matcher.find()) {
            if (matcher.group(NUMERIC_GROUP) != null) {
                if (isLast) {
                    expressions.add(new NumbersPlus());
                }
                double interimAnswer = Double.parseDouble(matcher.group(NUMERIC_GROUP));
                expressions.add(new SimpleNumber(interimAnswer));
                isLast = true;

            } else if (matcher.group(MULTIPLICATION_GROUP) != null) {
                expressions.add(new NumbersMultiply());
                isLast = false;
            } else if (matcher.group(DIVISION_GROUP) != null) {
                expressions.add(new NumbersDivide());
                isLast = false;
            }
        }

        return calculateInternalExpression(expressions);
    }

    private double calculateInternalExpression(ArrayList<MathExpression> expressionList) {
        final int MIN_EXPRESSION_LIST_SIZE = 3;
        while (MIN_EXPRESSION_LIST_SIZE <= expressionList.size()) {
            int index = priorityPlace(expressionList);
            if (index != -1) {
                MathExpression firstOperand = expressionList.get(index - 1);
                MathExpression operation = expressionList.remove(index);
                MathExpression secondOperand = expressionList.remove(index);
                if (SimpleNumber.class.equals(firstOperand.getClass()) && SimpleNumber.class.equals(secondOperand.getClass())) {
                    double firstNumber = ((SimpleNumber) firstOperand).getValue();
                    double secondNumber = ((SimpleNumber) secondOperand).getValue();
                    double internalAnswer = operation.interpret(firstNumber, secondNumber);
                    LOG.info("Do " + operation.toString() + " with " + firstNumber + " and " + secondNumber);
                    ((SimpleNumber) firstOperand).setValue(internalAnswer);
                } else {
                    LOG.fatal("Wrong operands");
                    throw new RuntimeException();
                }
            } else {
                LOG.fatal("Wrong priority");
                throw new RuntimeException();
            }
        }
        if (expressionList.size() == 1) {
            return ((SimpleNumber) expressionList.get(0)).getValue();
        } else {
            LOG.fatal("Size is " + expressionList.size());
            throw new RuntimeException();
        }
    }

    private int priorityPlace(ArrayList<MathExpression> expressionList) {
        if (!expressionList.isEmpty()) {
            int maxPriorityIndex = 0;
            for (int i = 1; i < expressionList.size(); i++) {
                if (expressionList.get(i).getPriority() >= expressionList.get(maxPriorityIndex).getPriority()) {
                    maxPriorityIndex = i;
                }
            }
            return maxPriorityIndex;
        }
        return -1;
    }
}
