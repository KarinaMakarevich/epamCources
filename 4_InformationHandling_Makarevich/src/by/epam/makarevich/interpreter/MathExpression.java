package by.epam.makarevich.interpreter;

public abstract class MathExpression {
    private int priority;

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public abstract double interpret(double firstNumber, double secondNumber);
}
