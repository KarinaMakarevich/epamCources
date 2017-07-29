package by.epam.makarevich.action;

import by.epam.makarevich.entity.Employee;
import by.epam.makarevich.entity.EmployeeTeam;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.stream.Collectors;

public class ManHourFinder {
    private static final Logger LOG = Logger.getLogger(ManHourFinder.class);
    private static final int WORKING_DAYS_COUNT = 20;

    public static int findManHour(EmployeeTeam employeeTeam) {
        int manHour = 0;
        for (int i = 0; i < employeeTeam.getTeam().size(); i++) {
            manHour += WORKING_DAYS_COUNT * employeeTeam.getTeam().get(i).getHour()
                    * employeeTeam.getTeam().get(i).getPayment();
        }
        LOG.info("Find Man-Hours for employees team, Man-Hour = " + manHour);
        return manHour;
    }

    public static ArrayList<Employee> findPayment(int min, int max, EmployeeTeam employeeTeam) {
        ArrayList<Employee> list = employeeTeam.getTeam().stream().filter(team ->
                team.getPayment() >= min && team.getPayment() <= max).collect(Collectors.toCollection(ArrayList::new));
        LOG.info("Find employees with payment between " + min + " " + max);
        return list;
    }
}
