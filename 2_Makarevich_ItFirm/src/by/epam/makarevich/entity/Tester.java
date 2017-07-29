package by.epam.makarevich.entity;

import by.epam.makarevich.type.TypeOfPosition;

public class Tester extends Employee {
    private String testAutomationTechnologies;

    public Tester(String name, TypeOfPosition position, int payment, int hour, String testAutomationTechnologies) {
        super(name, position, payment, hour);
        this.testAutomationTechnologies = testAutomationTechnologies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tester)) return false;
        if (!super.equals(o)) return false;

        Tester tester = (Tester) o;

        return testAutomationTechnologies != null ? testAutomationTechnologies.equals(tester.testAutomationTechnologies) : tester.testAutomationTechnologies == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (testAutomationTechnologies != null ? testAutomationTechnologies.hashCode() : 0);
        return result;
    }
}
