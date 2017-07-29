package by.epam.makarevich.interpreter;

import org.apache.log4j.Logger;

public class NumbersDivide extends MathExpression {
    private static final Logger LOG = Logger.getLogger(NumbersDivide.class);

    public NumbersDivide() {
        setPriority(1);
    }

    @Override
    public double interpret(double firstNumber, double secondNumber) {
        double answer;
        if (secondNumber != 0) {
            LOG.info("Can divide " + firstNumber + " into " + secondNumber);
            answer = firstNumber / secondNumber;
        } else {
            LOG.error("Division by zero");
            answer = Double.POSITIVE_INFINITY;
        }
        return answer;
    }
}
