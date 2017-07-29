package by.epam.makarevich.entity;


import by.epam.makarevich.type.TypeOfPosition;


public class Analyst extends Employee {
    private int experience;

    public Analyst(String name, TypeOfPosition position, int payment, int hour, int experience) {
        super(name, position, payment, hour);
        this.experience = experience;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Analyst)) return false;
        if (!super.equals(o)) return false;
        Analyst analyst = (Analyst) o;
        return Double.compare(analyst.experience, experience) == 0;
    }

    @Override
    public int hashCode() {
        int result = super.hashCode();
        long temp;
        temp = Double.doubleToLongBits(experience);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
