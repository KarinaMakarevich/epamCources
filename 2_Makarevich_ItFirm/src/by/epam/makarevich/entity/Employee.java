package by.epam.makarevich.entity;

import by.epam.makarevich.type.TypeOfPosition;

public abstract class Employee {
    private String name;
    private TypeOfPosition position;
    private int payment;
    private int hour;

    public Employee(String name, TypeOfPosition position, int payment, int hour) {
        this.name = name;
        this.position = position;
        this.payment = payment;
        this.hour = hour;
    }

    public String getName() {
        return name;
    }

    public int getPayment() {
        return payment;
    }

    public int getHour() {
        return hour;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;

        Employee employee = (Employee) o;

        if (payment != employee.payment) return false;
        if (hour != employee.hour) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        return position == employee.position;

    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (position != null ? position.hashCode() : 0);
        result = 31 * result + payment;
        result = 31 * result + hour;
        return result;
    }
}
