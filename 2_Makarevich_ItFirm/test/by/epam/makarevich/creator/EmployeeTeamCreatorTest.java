package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.entity.Programmer;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static by.epam.makarevich.creator.EmployeeTeamCreator.createFirm;
import static org.junit.Assert.assertEquals;

public class EmployeeTeamCreatorTest {
    private ArrayList<Employee> employees;
    private ArrayList<String> lines;
    private ArrayList<ArrayList<String>> list;

    @Before
    public void initialize() {
        list = new ArrayList<ArrayList<String>>();
        lines = new ArrayList<String>();
        lines.add("Programmer");
        lines.add(" Fedotov Dmitryy");
        lines.add("400");
        lines.add("8");
        lines.add("IOS-development");
        list.add(lines);
    }
    @Test
    public void create(){
        employees = createFirm(list);
        assertEquals(employees.get(0).getClass(), Programmer.class);
    }

}