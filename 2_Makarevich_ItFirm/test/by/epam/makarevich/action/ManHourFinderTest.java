package by.epam.makarevich.action;

import by.epam.makarevich.creator.AnalystCreator;
import by.epam.makarevich.creator.ProgrammerCreator;
import by.epam.makarevich.creator.TesterCreator;
import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.entity.EmployeeTeam;
import by.epam.makarevich.type.TypeOfPosition;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static by.epam.makarevich.action.ManHourFinder.findManHour;
import static org.junit.Assert.assertEquals;

public class ManHourFinderTest {
    private EmployeeTeam employeeTeam;
    private ArrayList<Employee> team;

    @Before
    public void initialize() throws Exception {
        Employee analyst = new AnalystCreator().create("Grigorii", TypeOfPosition.ANALYST, 400, 8, 2);
        Employee programmer = new ProgrammerCreator().create("Feofan Feofanovich", TypeOfPosition.PROGRAMMER, 250, 4, "ios");
        Employee tester = new TesterCreator().create("Sasha", TypeOfPosition.TESTER, 300, 4, "e2e");
        team = new ArrayList<Employee>();
        team.add(analyst);
        team.add(programmer);
        team.add(tester);
        employeeTeam = new EmployeeTeam(team);
    }

    @Test
    public void countManHour() throws Exception {
        assertEquals(findManHour(employeeTeam), 108000);
    }

    @Test
    public void findPayment() {
        assertEquals(ManHourFinder.findPayment(270, 500, employeeTeam).size(), 2);
    }
}