package by.epam.makarevich.entity;

import by.epam.makarevich.type.TypeOfPosition;

public class Programmer extends Employee {
    private String developmentArea;

    public Programmer(String name, TypeOfPosition position, int payment, int hour, String developmentArea) {
        super(name, position, payment, hour);
        this.developmentArea = developmentArea;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Programmer)) return false;
        if (!super.equals(o)) return false;

        Programmer that = (Programmer) o;

        return developmentArea != null ? developmentArea.equals(that.developmentArea) : that.developmentArea == null;

    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        result = 31 * result + (developmentArea != null ? developmentArea.hashCode() : 0);
        return result;
    }
}
