package by.epam.makarevich.entity;

import java.util.ArrayList;

public class EmployeeTeam {
    private ArrayList<Employee> team;

    public EmployeeTeam(ArrayList<Employee> team) {
        this.team = team;
    }

    public ArrayList<Employee> getTeam() {
        return this.team;
    }

    @Override
    public String toString() {
        return "EmployeeTeam{" +
                "team=" + team +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EmployeeTeam)) return false;

        EmployeeTeam that = (EmployeeTeam) o;

        return getTeam() != null ? getTeam().equals(that.getTeam()) : that.getTeam() == null;

    }

    @Override
    public int hashCode() {
        return getTeam() != null ? getTeam().hashCode() : 0;
    }
}
