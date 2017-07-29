package by.epam.makarevich.action;

import by.epam.makarevich.creator.AnalystCreator;
import by.epam.makarevich.creator.ProgrammerCreator;
import by.epam.makarevich.creator.TesterCreator;
import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.entity.EmployeeTeam;
import by.epam.makarevich.type.TypeOfPosition;
import org.hamcrest.Matchers;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;

public class EmployeeSorterTest {
    private EmployeeTeam employeeTeam;
    private Employee Analyst;
    private Employee Programmer;
    private Employee Tester;
    private ArrayList<Employee> team;

    @Before
    public void initialize() {
        Analyst = new AnalystCreator().create("Zina", TypeOfPosition.ANALYST, 400, 8, 2);
        Programmer = new ProgrammerCreator().create("Feofan Feofanovich", TypeOfPosition.PROGRAMMER, 250, 5, "ios");
        Tester = new TesterCreator().create("Sasha", TypeOfPosition.TESTER, 300, 4, "e2e");
        team = new ArrayList<Employee>();
        team.add(Programmer);
        team.add(Analyst);
        team.add(Tester);
        employeeTeam = new EmployeeTeam(team);
    }

    @After
    public void delete() {
        team.clear();
    }

    @Test
    public void sortByName() {
        EmployeeSorter.sortByName(employeeTeam);
        assertThat(employeeTeam.getTeam(), Matchers.contains(Programmer, Tester, Analyst));
    }

    @Test
    public void sortByHour() {
        EmployeeSorter.sortByHour(employeeTeam);
        assertThat(employeeTeam.getTeam(), Matchers.contains(Tester, Programmer, Analyst));
    }

    @Test
    public void sortByPayment() {
        EmployeeSorter.sortByPayment(employeeTeam);
        assertThat(employeeTeam.getTeam(), Matchers.contains(Programmer, Tester, Analyst));
    }
}