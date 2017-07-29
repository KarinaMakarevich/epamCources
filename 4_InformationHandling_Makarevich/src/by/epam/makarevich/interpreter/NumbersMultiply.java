package by.epam.makarevich.interpreter;

import org.apache.log4j.Logger;

public class NumbersMultiply extends MathExpression {
    private static final Logger LOG = Logger.getLogger(NumbersMultiply.class);

    public NumbersMultiply() {
        setPriority(1);
    }

    @Override
    public double interpret(double firstNumber, double secondNumber) {
        LOG.info("Do " + firstNumber + " * " + secondNumber);
        return firstNumber * secondNumber;
    }
}
