package by.epam.makarevich.interpreter;

public class SimpleNumber extends MathExpression {
    private double number;

    public SimpleNumber(double number) {
        this.number = number;
        setPriority(-1);
    }

    public double getValue() {
        return this.number;
    }

    public void setValue(double number) {
        this.number = number;
    }

    @Override
    public double interpret(double firstNumber, double secondNumber) {
        throw new UnsupportedOperationException(this.getClass().toString());
    }
}
