package by.epam.makarevich.creator;

import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.type.TypeOfPosition;

import java.util.ArrayList;

public class EmployeeTeamCreator {
    public static ArrayList<Employee> createFirm(ArrayList<ArrayList<String>> list) {
        ArrayList<Employee> employees = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            EmployeeCreator creator = null;
            if (list.get(i).get(0).equalsIgnoreCase(TypeOfPosition.ANALYST.toString())) {
                creator = new AnalystCreator();
            } else if (list.get(i).get(0).equalsIgnoreCase(TypeOfPosition.PROGRAMMER.toString())) {
                creator = new ProgrammerCreator();
            } else if (list.get(i).get(0).equalsIgnoreCase(TypeOfPosition.TESTER.toString())) {
                creator = new TesterCreator();
            }
            employees.add(creator.create(list.get(i)));
        }
        return employees;
    }
}