package by.epam.makarevich.interpreter;

import org.apache.log4j.Logger;

public class NumbersPlus extends MathExpression {
    private static final Logger LOG = Logger.getLogger(NumbersPlus.class);

    public NumbersPlus() {
        setPriority(0);
    }

    @Override
    public double interpret(double firstNumber, double secondNumber) {
        LOG.info("Do: " + firstNumber + " + " + secondNumber);
        return firstNumber + secondNumber;
    }
}
